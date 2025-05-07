package com.unihubcrew.unihub.model;

import java.time.LocalDateTime;

public class Favorite {
    private Long id;
    private String userId;
    private Long resourceId;
    private LocalDateTime favoriteTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getFavoriteTime() {
        return favoriteTime;
    }

    public void setFavoriteTime(LocalDateTime favoriteTime) {
        this.favoriteTime = favoriteTime;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", user_id='" + userId + '\'' +
                ", resource_id=" + resourceId +
                ", favorite_time=" + favoriteTime +
                '}';
    }
}
