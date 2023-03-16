package com.dnd.doughndrink.payload.request;

import java.util.*;   

import javax.management.relation.Role;
import javax.validation.constraints.*;

public class SignupRequest {
  private String fname;
  private String lname;
  private String email;
  private String password;
  private String phone;
  private String address;
  private String role;
  // private Set<String> role = new HashSet<String>();
    


  

     public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

    public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

   

  

//   @NotBlank
//   @Size(min = 6, max = 40)
//   private String password;
// private String address;

  public String getAddress() {
  return address;
}

public void setAddress(String address) {
  this.address = address;
}




  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }



}
