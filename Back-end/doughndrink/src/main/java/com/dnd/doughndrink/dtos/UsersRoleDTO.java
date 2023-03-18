package com.dnd.doughndrink.dtos;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data 
public class UsersRoleDTO {
   
    
    private int userId;
    private String fname;
    private String lname;

    private Set<RoleDTO> roleses = new HashSet<RoleDTO>(0);
   
}
