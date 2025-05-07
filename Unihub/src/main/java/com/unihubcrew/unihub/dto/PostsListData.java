package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.Post;

import java.util.List;

public class PostsListData {
    private int total_count;
    private List<Post> posts;

    public PostsListData(int total_count, List<Post> posts) {
        this.total_count = total_count;
        this.posts = posts;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "PostsListData{" +
                "total_count=" + total_count +
                ", posts=" + posts +
                '}';
    }
}
