package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.AnnouncementsListData;
import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.model.Announcement;
import com.unihubcrew.unihub.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping("/id")
    public ApiResponse<Announcement> getAnnouncementById(@RequestParam Long announcementId) {
        try{
            Announcement announcement=announcementService.getAnnouncementById(announcementId);

            return ApiResponse.success("获取公告详情成功", announcement);
        }catch (Exception e){
            return ApiResponse.failed("获取公告详情失败："+e.getMessage());
        }
    }

    @GetMapping("/all")
    public ApiResponse<AnnouncementsListData> getAllAnnouncements(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "publisher", required = false) String publisher
    ) {
        try{
            List<Announcement> announcements = announcementService.getAllAnnouncements(type, publisher);
            AnnouncementsListData announcementsListData=new AnnouncementsListData(announcements.size(),announcements);

            return ApiResponse.success("获取公告列表成功",announcementsListData);
        }catch (Exception e){
            return ApiResponse.failed("获取公告列表失败："+e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<Map<String,Long>> addAnnouncement(@RequestBody Announcement announcement) {
        try{
            Long id = announcementService.addAnnouncement(announcement);
            Map<String,Long> map = new HashMap<>();
            map.put("announcement_id", id);

            return ApiResponse.success("发布公告成功",map);
        } catch (Exception e) {
            return ApiResponse.failed("发布公告失败："+e.getMessage());
        }
    }

    @PostMapping("/update")
    public void updateAnnouncement(@RequestBody Announcement announcement) {
        announcementService.updateAnnouncement(announcement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
    }
}
