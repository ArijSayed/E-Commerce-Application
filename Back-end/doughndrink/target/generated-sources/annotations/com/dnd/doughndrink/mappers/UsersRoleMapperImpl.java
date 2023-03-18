package com.dnd.doughndrink.mappers;

import com.dnd.doughndrink.dtos.RoleDTO;
import com.dnd.doughndrink.dtos.UsersRoleDTO;
import com.dnd.doughndrink.models.Roles;
import com.dnd.doughndrink.models.User;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-18T14:15:41+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class UsersRoleMapperImpl implements UsersRoleMapper {

    @Override
    public UsersRoleDTO map(User user) {
        if ( user == null ) {
            return null;
        }

        UsersRoleDTO usersRoleDTO = new UsersRoleDTO();

        if ( user.getFname() != null ) {
            usersRoleDTO.setFname( user.getFname() );
        }
        if ( user.getLname() != null ) {
            usersRoleDTO.setLname( user.getLname() );
        }
        Set<RoleDTO> set = rolesSetToRoleDTOSet( user.getRoleses() );
        if ( set != null ) {
            usersRoleDTO.setRoleses( set );
        }
        usersRoleDTO.setUserId( user.getUserId() );

        return usersRoleDTO;
    }

    @Override
    public List<UsersRoleDTO> map(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UsersRoleDTO> list = new ArrayList<UsersRoleDTO>( user.size() );
        for ( User user1 : user ) {
            list.add( map( user1 ) );
        }

        return list;
    }

    protected RoleDTO rolesToRoleDTO(Roles roles) {
        if ( roles == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        if ( roles.getRoleId() != null ) {
            roleDTO.setRoleId( roles.getRoleId() );
        }
        if ( roles.getRoleName() != null ) {
            roleDTO.setRoleName( roles.getRoleName() );
        }

        return roleDTO;
    }

    protected Set<RoleDTO> rolesSetToRoleDTOSet(Set<Roles> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleDTO> set1 = new LinkedHashSet<RoleDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Roles roles : set ) {
            set1.add( rolesToRoleDTO( roles ) );
        }

        return set1;
    }
}
