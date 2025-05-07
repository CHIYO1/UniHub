package com.unihubcrew.unihub.model;

import java.time.LocalDateTime;

public class CartItem {
    private Long cartId;
    private String userId;
    private Long resourceId;
    private LocalDateTime addedTime;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
    }

    @Override
    public String toString() {
        return "Cart_item{" +
                "cart_id=" + cartId +
                ", user_id='" + userId + '\'' +
                ", resource_id=" + resourceId +
                ", added_time=" + addedTime +
                '}';
    }
}
