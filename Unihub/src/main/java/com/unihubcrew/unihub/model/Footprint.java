package com.unihubcrew.unihub.model;

import java.time.LocalDateTime;

public class Footprint {
    private Long id;
    private String userId;
    private Long resourceId;
    private LocalDateTime viewTime;

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

    public LocalDateTime getViewTime() {
        return viewTime;
    }

    public void setViewTime(LocalDateTime viewTime) {
        this.viewTime = viewTime;
    }

    @Override
    public String toString() {
        return "Footprint{" +
                "id=" + id +
                ", user_id='" + userId + '\'' +
                ", resource_id=" + resourceId +
                ", view_time=" + viewTime +
                '}';
    }
}
