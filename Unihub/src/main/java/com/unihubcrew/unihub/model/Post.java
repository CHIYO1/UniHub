package com.unihubcrew.unihub.model;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private String title;
    private String authorId;
    private LocalDateTime createdAt;
    private String content;
    private String tag;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorId='" + authorId + '\'' +
                ", createdAt=" + createdAt +
                ", content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
