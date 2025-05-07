package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.dto.CartItemsListData;
import com.unihubcrew.unihub.model.CartItem;
import com.unihubcrew.unihub.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartItems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/id/{id}")
    public CartItem getCartItemById(@PathVariable Long id) {
        return cartItemService.getCartItemById(id);
    }

    @GetMapping("/all")
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("/list")
    public ApiResponse<CartItemsListData> getCartItemsByUserId(String userId) {
        try{
            List<CartItem> cartItems = cartItemService.getCartItemsByUserId(userId);
            CartItemsListData cartItemsListData=new CartItemsListData(cartItems.size(),cartItems);

            return ApiResponse.success("获取购物车列表成功",cartItemsListData);
        }catch (Exception e){
            return ApiResponse.failed("获取购物车列表失败："+e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<CartItem> addCartItem(@RequestBody CartItem cartItem) {
        try{
            Long cartId = cartItemService.addCartItem(cartItem);
            cartItem.setCartId(cartId);
            return ApiResponse.success("加入购物车成功",cartItem);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.failed("加入购物车失败:"+e.getMessage());
        }
    }

    @PostMapping("/update")
    public void updateCartItem(@RequestBody CartItem cartItem) {
        cartItemService.updateCartItem(cartItem);
    }

    @DeleteMapping("/delete")
    public ApiResponse<Void> deleteCartItem(@RequestParam Long cartId) {
        try{
            cartItemService.deleteCartItem(cartId);

            return ApiResponse.success("从购物车移除成功",null);
        } catch (Exception e) {
            return ApiResponse.failed("从购物车移除失败："+e.getMessage());
        }
    }
}
