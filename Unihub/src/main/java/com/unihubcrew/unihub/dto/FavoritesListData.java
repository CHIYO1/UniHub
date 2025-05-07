package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.Favorite;
import java.util.List;

public class FavoritesListData {
    private int total_count;
    private List<Favorite> favorite;

    public FavoritesListData(int total_count, List<Favorite> favorite) {
        this.total_count = total_count;
        this.favorite = favorite;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<Favorite> getFavorite() {
        return favorite;
    }

    public void setFavorite(List<Favorite> favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "FavoritesListData{" +
                "total_count=" + total_count +
                ", favorite=" + favorite +
                '}';
    }
}
