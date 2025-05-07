package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.dto.FavoritesListData;
import com.unihubcrew.unihub.model.Favorite;
import com.unihubcrew.unihub.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/id/{id}")
    public Favorite getFavoriteById(@PathVariable Long id) {
        return favoriteService.getFavoriteById(id);
    }

    @GetMapping("/all")
    public ApiResponse<FavoritesListData> getAllFavorites(
            @RequestParam("userId")String userId
    ) {
        try{
            List<Favorite> favorites=favoriteService.getAllFavorites(userId);
            FavoritesListData favoritesListData=new FavoritesListData(favorites.size(),favorites);

            return ApiResponse.success("获取收藏列表成功",favoritesListData);
        } catch (Exception e) {
            return ApiResponse.failed("获取收藏列表失败："+e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<Map<String,Long>> addFavorite(@RequestBody Favorite favorite) {
        try{
            Long id=favoriteService.addFavorite(favorite);
            Map<String,Long> map=new HashMap<>();
            map.put("favorite_id",id);
            return ApiResponse.success("收藏成功",map);
        }catch (Exception e) {
            return ApiResponse.failed("收藏失败："+e.getMessage());
        }

    }

    @PostMapping("/update")
    public void updateFavorite(@RequestBody Favorite favorite) {
        favoriteService.updateFavorite(favorite);
    }

    @DeleteMapping("/delete")
    public ApiResponse<Void> deleteFavorite(@RequestParam Long id) {
        try{
            favoriteService.deleteFavorite(id);
            return ApiResponse.success("取消收藏成功",null);
        } catch (Exception e) {
            return ApiResponse.failed("取消收藏失败："+e.getMessage());
        }
    }
}
