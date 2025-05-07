package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.CartItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartItemMapper {
    @Select("SELECT * FROM cart_items WHERE cart_id= #{id} ")
    CartItem getCartItemById(Long id);

    @Select("SELECT  * FROM cart_items")
    List<CartItem> getAllCartItems();

    @Select("SELECT * FROM cart_items WHERE user_id=#{userId}")
    List<CartItem> getCartItemsByUserId(String userId);

    @Insert("INSERT INTO cart_items(cart_id, user_id, resource_id, added_time)"+
            "VALUES(#{cartId},#{userId},#{resourceId},#{addedTime})")
    @Options(useGeneratedKeys = true, keyProperty = "cartId")
    void addCartItem(CartItem cartitem);

    @Insert("UPDATE cart_items SET user_id=#{userId},resource_id=#{resourceId},added_time=#{addedTime} "+
            "WHERE cart_id=#{id}")
    void updateCartItem(CartItem cartitem);

    @Delete("DELETE FROM cart_items WHERE cart_id=#{id}")
    void deleteCartItem(Long id);
}
