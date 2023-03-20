package com.dnd.doughndrink.mappers;

import com.dnd.doughndrink.dtos.RoleDTO;
import com.dnd.doughndrink.models.Roles;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-20T03:42:31+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Roles map(RoleDTO role) {
        if ( role == null ) {
            return null;
        }

        Roles roles = new Roles();

        if ( role.getRoleId() != null ) {
            roles.setRoleId( role.getRoleId() );
        }
        if ( role.getRoleName() != null ) {
            roles.setRoleName( role.getRoleName() );
        }

        return roles;
    }

    @Override
    public RoleDTO map(Roles role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        if ( role.getRoleId() != null ) {
            roleDTO.setRoleId( role.getRoleId() );
        }
        if ( role.getRoleName() != null ) {
            roleDTO.setRoleName( role.getRoleName() );
        }

        return roleDTO;
    }

    @Override
    public List<RoleDTO> map(List<Roles> role) {
        if ( role == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( role.size() );
        for ( Roles roles : role ) {
            list.add( map( roles ) );
        }

        return list;
    }

    @Override
    public Set<Roles> map(Set<RoleDTO> role) {
        if ( role == null ) {
            return null;
        }

        Set<Roles> set = new LinkedHashSet<Roles>( Math.max( (int) ( role.size() / .75f ) + 1, 16 ) );
        for ( RoleDTO roleDTO : role ) {
            set.add( map( roleDTO ) );
        }

        return set;
    }
}
