package com.dnd.doughndrink.models;
// Generated Mar 3, 2023, 7:32:16 PM by Hibernate Tools 6.0.0.Alpha2


import java.util.HashSet;
import java.util.Set; 
import static javax.persistence.GenerationType.IDENTITY; 
 
import javax.persistence.*; 
/**
 * Roles generated by hbm2java
 */
@Entity
@Table(name="roles"
    ,catalog="doughndrink"
    , uniqueConstraints = @UniqueConstraint(columnNames="role_name") 
)
public class Roles  implements java.io.Serializable {


     private Integer roleId;
     private String roleName;
     private Set<User> users = new HashSet<User>(0);

    public Roles() {
    }

	
    public Roles(String roleName) {
        this.roleName = roleName;
    }
    public Roles(String roleName, Set<User> users) {
       this.roleName = roleName;
       this.users = users;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="role_id", unique=true, nullable=false)
    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    
    @Column(name="role_name", unique=true, nullable=false, length=45)
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="roleses")
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }




}


