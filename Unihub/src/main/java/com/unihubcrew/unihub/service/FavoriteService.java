package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.FavoriteMapper;
import com.unihubcrew.unihub.model.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;

    public Favorite getFavoriteById(Long id) {
        return favoriteMapper.getFavoriteById(id);
    }

    public List<Favorite> getAllFavorites(String userId) {
        return favoriteMapper.getAllFavorites(userId);
    }

    public Long addFavorite(Favorite favorite) {
        favoriteMapper.addFavorite(favorite);
        return favorite.getId();
    }

    public void updateFavorite(Favorite favorite) {
        favoriteMapper.updateFavorite(favorite);
    }

    public void deleteFavorite(Long id) {
        favoriteMapper.deleteFavorite(id);
    }
}
