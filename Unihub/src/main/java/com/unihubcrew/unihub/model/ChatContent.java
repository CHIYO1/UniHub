package com.unihubcrew.unihub.model;

import java.time.LocalDateTime;

public class ChatContent {
    private Long id;
    private LocalDateTime timestamp;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Chat_content{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }
}
