package com.unihubcrew.unihub.model;

import java.time.LocalDateTime;

public class Follow {
    private Long id;
    private String followerId;
    private String followedId;
    private LocalDateTime followedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    public String getFollowedId() {
        return followedId;
    }

    public void setFollowedId(String followedId) {
        this.followedId = followedId;
    }

    public LocalDateTime getFollowedTime() {
        return followedTime;
    }

    public void setFollowedTime(LocalDateTime followedTime) {
        this.followedTime = followedTime;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", follower_id='" + followerId + '\'' +
                ", followed_id='" + followedId + '\'' +
                ", followed_time=" + followedTime +
                '}';
    }
}
