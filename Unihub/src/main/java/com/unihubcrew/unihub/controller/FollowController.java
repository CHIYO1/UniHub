package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.dto.FollowsListData;
import com.unihubcrew.unihub.model.Follow;
import com.unihubcrew.unihub.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping("/id/{id}")
    public Follow getFollowById(@PathVariable Long id) {
        return followService.getFollowById(id);
    }

    @GetMapping("/all")
    public ApiResponse<FollowsListData> getAllFollows(
            @RequestParam(value = "followerId", required = false) String followerId,
            @RequestParam(value = "followedId", required = false) String followedId
    ) {
        try{
            List<Follow> follows=followService.getAllFollows(followerId, followedId);
            FollowsListData followsListData=new FollowsListData(follows.size(),follows);

            return ApiResponse.success("获取关注列表成功",followsListData);
        } catch (Exception e) {
            return ApiResponse.failed("获取关注列表失败："+e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<Map<String,Long>> addFollow(@RequestBody Follow follow) {
        try{
            Long id = followService.addFollow(follow);
            Map<String,Long> map = new HashMap<>();
            map.put("follow_id", id);

            return ApiResponse.success("关注用户成功",map);
        } catch (Exception e) {
            return ApiResponse.failed("关注用户失败："+e.getMessage());
        }
    }

    @PostMapping("/update")
    public void updateFollow(@RequestBody Follow follow) {
        followService.updateFollow(follow);
    }

    @DeleteMapping("/delete")
    public ApiResponse<Void> deleteFollow(@RequestParam Long id) {
        try{
            followService.deleteFollow(id);

            return ApiResponse.success("取消关注成功",null);
        }catch (Exception e) {
            return ApiResponse.failed("取消关注失败"+e.getMessage());
        }
    }
}
