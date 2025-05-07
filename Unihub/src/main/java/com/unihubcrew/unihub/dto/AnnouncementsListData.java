package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.Announcement;
import java.util.List;

public class AnnouncementsListData {
    private int total_count;
    private List<Announcement> announcements;

    public AnnouncementsListData(int total_count, List<Announcement> announcements) {
        this.total_count = total_count;
        this.announcements = announcements;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    @Override
    public String toString() {
        return "AnnouncementsListData{" +
                "total_count=" + total_count +
                ", announcements=" + announcements +
                '}';
    }
}
