package com.dnd.doughndrink.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.doughndrink.dtos.UserDTO;
import com.dnd.doughndrink.exceptions.UserNotFoundException;
// import com.dnd.doughndrink.models.ERole;
import com.dnd.doughndrink.models.Roles;
import com.dnd.doughndrink.models.User;
import com.dnd.doughndrink.payload.request.LoginRequest;
import com.dnd.doughndrink.payload.request.SignupRequest;
import com.dnd.doughndrink.payload.response.JwtResponse;
import com.dnd.doughndrink.payload.response.MessageResponse;


import com.dnd.doughndrink.repositories.RoleRepository;
import com.dnd.doughndrink.repositories.UserRepository;
import com.dnd.doughndrink.security.jwt.JwtUtils;
import com.dnd.doughndrink.security.services.UserDetailsImpl;
import com.dnd.doughndrink.services.UserService;

// @CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
    private UserService userService;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

    if(!authentication.isAuthenticated()){
        throw new UserNotFoundException("Email or password not found");
    }
          
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                
                         roles));
     
      
    
  }



// @PostMapping("signup")
//    public void  signUp( @RequestBody UserDTO userDTO) {
  
//     userService.save(userDTO);
//    }








  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      throw new UserNotFoundException("Error: Email is already in use!");
    
    }

    // Create new user's account
    User user = new User(
      signUpRequest.getFname(),
      signUpRequest.getLname(),
     
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()),
              signUpRequest.getPhone(),
               signUpRequest.getAddress(),
                "ROLE_USER"
               );


                 userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));


  }
    
}


