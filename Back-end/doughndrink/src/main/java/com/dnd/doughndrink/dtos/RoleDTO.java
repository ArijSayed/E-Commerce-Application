package com.dnd.doughndrink.dtos;



import lombok.Data;

@Data
public class RoleDTO {
    
    public RoleDTO() {
    }
    private Integer roleId;
    private String roleName;
    public RoleDTO(String roleName) {
        this.roleName = roleName;
    }

   

    
}
