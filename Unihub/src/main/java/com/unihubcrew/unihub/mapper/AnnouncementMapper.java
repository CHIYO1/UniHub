package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.Announcement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnnouncementMapper {
    @Select("SELECT * FROM announcements WHERE announcement_id= #{announcementId} ")
    Announcement getAnnouncementById(Long id);

    List<Announcement> getAllAnnouncements(
            @Param("type") String type,
            @Param("publisher") String publisher
    );

    @Insert("INSERT INTO announcements(announcement_id, type, publish_time, duration, publisher)"+
    "VALUES(#{announcementId},#{type},#{publishTime},#{duration},#{publisher})")
    @Options(useGeneratedKeys = true,keyProperty = "announcementId")
    void addAnnouncement(Announcement announcement);

    @Insert("UPDATE announcements SET type=#{type},publish_time=#{publishTime},duration=#{duration},"+
            "publisher=#{publisher} WHERE announcement_id=#{announcementId}")
    void updateAnnouncement(Announcement announcement);

    @Delete("DELETE FROM announcements WHERE announcement_id=#{announcementId}")
    void deleteAnnouncement(Long id);
}
