package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.CartItemMapper;
import com.unihubcrew.unihub.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemMapper cartitemMapper;

    public CartItem getCartItemById(Long id) {
        return cartitemMapper.getCartItemById(id);
    }

    public List<CartItem> getAllCartItems() {
        return cartitemMapper.getAllCartItems();
    }

    public List<CartItem> getCartItemsByUserId(String userId) {
        return cartitemMapper.getCartItemsByUserId(userId);
    }

    public Long addCartItem(CartItem cartItem) {
        cartitemMapper.addCartItem(cartItem);
        return cartItem.getCartId();
    }

    public void updateCartItem(CartItem cartItem) {
        cartitemMapper.updateCartItem(cartItem);
    }

    public void deleteCartItem(Long id) {
        cartitemMapper.deleteCartItem(id);
    }
}
