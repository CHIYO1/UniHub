package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.CartItem;
import java.util.List;

public class CartItemsListData {
    private int total_count;
    private List<CartItem> cartItem;

    public CartItemsListData(int total_count, List<CartItem> cartItem) {
        this.total_count = total_count;
        this.cartItem = cartItem;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public String toString() {
        return "CartItemsListData{" +
                "total_count=" + total_count +
                ", cartItem=" + cartItem +
                '}';
    }
}
