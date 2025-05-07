package com.unihubcrew.unihub.model;

public class ChatSession {
    private Long id;
    private String user_a_id;
    private String user_b_id;
    private Long contentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_a_id() {
        return user_a_id;
    }

    public void setUser_a_id(String user_a_id) {
        this.user_a_id = user_a_id;
    }

    public String getUser_b_id() {
        return user_b_id;
    }

    public void setUser_b_id(String user_b_id) {
        this.user_b_id = user_b_id;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    @Override
    public String toString() {
        return "Chat_session{" +
                "id=" + id +
                ", user_a_id='" + user_a_id + '\'' +
                ", user_b_id='" + user_b_id + '\'' +
                ", content_id=" + contentId +
                '}';
    }
}
