package com.dnd.doughndrink.mappers;

import com.dnd.doughndrink.dtos.OrderContainsProductDTO;
import com.dnd.doughndrink.dtos.OrdersDTO;
import com.dnd.doughndrink.dtos.ProductDTO;
import com.dnd.doughndrink.dtos.SubCategoryDTO;
import com.dnd.doughndrink.dtos.UserDTO;
import com.dnd.doughndrink.models.OrderContainsProduct;
import com.dnd.doughndrink.models.Orders;
import com.dnd.doughndrink.models.Product;
import com.dnd.doughndrink.models.SubCategory;
import com.dnd.doughndrink.models.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-18T14:15:42+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class OrderContainsProductMapperImpl implements OrderContainsProductMapper {

    @Override
    public OrderContainsProduct map(OrderContainsProductDTO orderContainsProduct) {
        if ( orderContainsProduct == null ) {
            return null;
        }

        OrderContainsProduct orderContainsProduct1 = new OrderContainsProduct();

        if ( orderContainsProduct.getId() != null ) {
            orderContainsProduct1.setId( orderContainsProduct.getId() );
        }
        if ( orderContainsProduct.getOrders() != null ) {
            orderContainsProduct1.setOrders( ordersDTOToOrders( orderContainsProduct.getOrders() ) );
        }
        if ( orderContainsProduct.getProduct() != null ) {
            orderContainsProduct1.setProduct( productDTOToProduct( orderContainsProduct.getProduct() ) );
        }
        orderContainsProduct1.setQuntity( orderContainsProduct.getQuntity() );

        return orderContainsProduct1;
    }

    @Override
    public OrderContainsProductDTO map(OrderContainsProduct orderContainsProduct) {
        if ( orderContainsProduct == null ) {
            return null;
        }

        OrderContainsProductDTO orderContainsProductDTO = new OrderContainsProductDTO();

        if ( orderContainsProduct.getId() != null ) {
            orderContainsProductDTO.setId( orderContainsProduct.getId() );
        }
        if ( orderContainsProduct.getOrders() != null ) {
            orderContainsProductDTO.setOrders( ordersToOrdersDTO( orderContainsProduct.getOrders() ) );
        }
        if ( orderContainsProduct.getProduct() != null ) {
            orderContainsProductDTO.setProduct( productToProductDTO( orderContainsProduct.getProduct() ) );
        }
        orderContainsProductDTO.setQuntity( orderContainsProduct.getQuntity() );

        return orderContainsProductDTO;
    }

    @Override
    public List<OrderContainsProductDTO> map(List<OrderContainsProduct> orderContainsProduct) {
        if ( orderContainsProduct == null ) {
            return null;
        }

        List<OrderContainsProductDTO> list = new ArrayList<OrderContainsProductDTO>( orderContainsProduct.size() );
        for ( OrderContainsProduct orderContainsProduct1 : orderContainsProduct ) {
            list.add( map( orderContainsProduct1 ) );
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

    protected Orders ordersDTOToOrders(OrdersDTO ordersDTO) {
        if ( ordersDTO == null ) {
            return null;
        }

        Orders orders = new Orders();

        if ( ordersDTO.getOrderId() != null ) {
            orders.setOrderId( ordersDTO.getOrderId() );
        }
        if ( ordersDTO.getUser() != null ) {
            orders.setUser( userDTOToUser( ordersDTO.getUser() ) );
        }
        if ( ordersDTO.getPaymentType() != null ) {
            orders.setPaymentType( ordersDTO.getPaymentType() );
        }
        if ( ordersDTO.getShippingDate() != null ) {
            orders.setShippingDate( ordersDTO.getShippingDate() );
        }
        if ( ordersDTO.getTotalPrice() != null ) {
            orders.setTotalPrice( ordersDTO.getTotalPrice() );
        }
        if ( ordersDTO.getOrderDate() != null ) {
            orders.setOrderDate( ordersDTO.getOrderDate() );
        }

        return orders;
    }

    protected SubCategory subCategoryDTOToSubCategory(SubCategoryDTO subCategoryDTO) {
        if ( subCategoryDTO == null ) {
            return null;
        }

        SubCategory subCategory = new SubCategory();

        if ( subCategoryDTO.getSubCategoryId() != null ) {
            subCategory.setSubCategoryId( subCategoryDTO.getSubCategoryId() );
        }
        if ( subCategoryDTO.getSubCtgName() != null ) {
            subCategory.setSubCtgName( subCategoryDTO.getSubCtgName() );
        }

        return subCategory;
    }

    protected Product productDTOToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        if ( productDTO.getProductId() != null ) {
            product.setProductId( productDTO.getProductId() );
        }
        if ( productDTO.getSubCategory() != null ) {
            product.setSubCategory( subCategoryDTOToSubCategory( productDTO.getSubCategory() ) );
        }
        if ( productDTO.getName() != null ) {
            product.setName( productDTO.getName() );
        }
        if ( productDTO.getSize() != null ) {
            product.setSize( productDTO.getSize() );
        }
        product.setPrice( productDTO.getPrice() );
        if ( productDTO.getStock() != null ) {
            product.setStock( productDTO.getStock() );
        }
        if ( productDTO.getDescription() != null ) {
            product.setDescription( productDTO.getDescription() );
        }
        byte[] image = productDTO.getImage();
        if ( image != null ) {
            product.setImage( Arrays.copyOf( image, image.length ) );
        }

        return product;
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

    protected OrdersDTO ordersToOrdersDTO(Orders orders) {
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

    protected SubCategoryDTO subCategoryToSubCategoryDTO(SubCategory subCategory) {
        if ( subCategory == null ) {
            return null;
        }

        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();

        if ( subCategory.getSubCategoryId() != null ) {
            subCategoryDTO.setSubCategoryId( subCategory.getSubCategoryId() );
        }
        if ( subCategory.getSubCtgName() != null ) {
            subCategoryDTO.setSubCtgName( subCategory.getSubCtgName() );
        }

        return subCategoryDTO;
    }

    protected ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        if ( product.getDescription() != null ) {
            productDTO.setDescription( product.getDescription() );
        }
        byte[] image = product.getImage();
        if ( image != null ) {
            productDTO.setImage( Arrays.copyOf( image, image.length ) );
        }
        if ( product.getName() != null ) {
            productDTO.setName( product.getName() );
        }
        productDTO.setPrice( product.getPrice() );
        if ( product.getProductId() != null ) {
            productDTO.setProductId( product.getProductId() );
        }
        if ( product.getSize() != null ) {
            productDTO.setSize( product.getSize() );
        }
        if ( product.getStock() != null ) {
            productDTO.setStock( product.getStock() );
        }
        if ( product.getSubCategory() != null ) {
            productDTO.setSubCategory( subCategoryToSubCategoryDTO( product.getSubCategory() ) );
        }

        return productDTO;
    }
}
