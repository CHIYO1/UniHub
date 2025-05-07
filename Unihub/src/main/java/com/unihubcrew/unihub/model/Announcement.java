package com.unihubcrew.unihub.model;

import java.time.LocalDateTime;

public class Announcement {
    private Long announcementId;
    private String type;
    private LocalDateTime publishTime;
    private int duration;
    private String publisher;

    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getpublisher() {
        return publisher;
    }

    public void setpublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcement_id=" + announcementId +
                ", type='" + type + '\'' +
                ", publish_time=" + publishTime +
                ", duration=" + duration +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
