package com.dnd.doughndrink.mappers;

import com.dnd.doughndrink.dtos.OrdersDTO;
import com.dnd.doughndrink.dtos.UserDTO;
import com.dnd.doughndrink.models.Orders;
import com.dnd.doughndrink.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-18T14:15:42+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class OrdersMapperImpl implements OrdersMapper {

    @Override
    public Orders map(OrdersDTO orders) {
        if ( orders == null ) {
            return null;
        }

        Orders orders1 = new Orders();

        if ( orders.getOrderId() != null ) {
            orders1.setOrderId( orders.getOrderId() );
        }
        if ( orders.getUser() != null ) {
            orders1.setUser( userDTOToUser( orders.getUser() ) );
        }
        if ( orders.getPaymentType() != null ) {
            orders1.setPaymentType( orders.getPaymentType() );
        }
        if ( orders.getShippingDate() != null ) {
            orders1.setShippingDate( orders.getShippingDate() );
        }
        if ( orders.getTotalPrice() != null ) {
            orders1.setTotalPrice( orders.getTotalPrice() );
        }
        if ( orders.getOrderDate() != null ) {
            orders1.setOrderDate( orders.getOrderDate() );
        }

        return orders1;
    }

    @Override
    public OrdersDTO map(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDTO ordersDTO = new OrdersDTO();

        if ( orders.getOrderDate() != null ) {
            ordersDTO.setOrderDate( orders.getOrderDate() );
        }
        if ( orders.getOrderId() != null ) {
            ordersDTO.setOrderId( orders.getOrderId() );
        }
        if ( orders.getPaymentType() != null ) {
            ordersDTO.setPaymentType( orders.getPaymentType() );
        }
        if ( orders.getShippingDate() != null ) {
            ordersDTO.setShippingDate( orders.getShippingDate() );
        }
        if ( orders.getTotalPrice() != null ) {
            ordersDTO.setTotalPrice( orders.getTotalPrice() );
        }
        if ( orders.getUser() != null ) {
            ordersDTO.setUser( userToUserDTO( orders.getUser() ) );
        }

        return ordersDTO;
    }

    @Override
    public List<OrdersDTO> map(List<Orders> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrdersDTO> list = new ArrayList<OrdersDTO>( orders.size() );
        for ( Orders orders1 : orders ) {
            list.add( map( orders1 ) );
        }

        return list;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDTO.getUserId() );
        if ( userDTO.getFname() != null ) {
            user.setFname( userDTO.getFname() );
        }
        if ( userDTO.getLname() != null ) {
            user.setLname( userDTO.getLname() );
        }
        if ( userDTO.getEmail() != null ) {
            user.setEmail( userDTO.getEmail() );
        }
        if ( userDTO.getPhone() != null ) {
            user.setPhone( userDTO.getPhone() );
        }
        if ( userDTO.getAddress() != null ) {
            user.setAddress( userDTO.getAddress() );
        }
        if ( userDTO.getRole() != null ) {
            user.setRole( userDTO.getRole() );
        }

        return user;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( user.getAddress() != null ) {
            userDTO.setAddress( user.getAddress() );
        }
        if ( user.getEmail() != null ) {
            userDTO.setEmail( user.getEmail() );
        }
        if ( user.getFname() != null ) {
            userDTO.setFname( user.getFname() );
        }
        if ( user.getLname() != null ) {
            userDTO.setLname( user.getLname() );
        }
        if ( user.getPhone() != null ) {
            userDTO.setPhone( user.getPhone() );
        }
        if ( user.getRole() != null ) {
            userDTO.setRole( user.getRole() );
        }
        userDTO.setUserId( user.getUserId() );

        return userDTO;
    }
}
