package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.AnnouncementMapper;
import com.unihubcrew.unihub.model.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;

    public Announcement getAnnouncementById(Long id) {
        return announcementMapper.getAnnouncementById(id);
    }

    public List<Announcement> getAllAnnouncements(String type,String publisher) {
        return announcementMapper.getAllAnnouncements(type,publisher);
    }

    public Long addAnnouncement(Announcement announcement) {
        announcementMapper.addAnnouncement(announcement);
        return announcement.getAnnouncementId();
    }

    public void updateAnnouncement(Announcement announcement) {
        announcementMapper.updateAnnouncement(announcement);
    }

    public void deleteAnnouncement(Long id) {
        announcementMapper.deleteAnnouncement(id);
    }
}
