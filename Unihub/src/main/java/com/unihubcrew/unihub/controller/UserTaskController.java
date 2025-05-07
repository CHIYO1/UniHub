package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.dto.UserTasksListData;
import com.unihubcrew.unihub.dto.UsersListData;
import com.unihubcrew.unihub.service.UserTaskService;
import com.unihubcrew.unihub.model.UserTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/userTask")
public class UserTaskController {

    @Autowired
    private UserTaskService userTaskService;

    @GetMapping("/id/{id}")
    public UserTask getUserTaskById(@PathVariable Long id) {
        return userTaskService.getUserTaskById(id);
    }

    @GetMapping("/all")
    public List<UserTask> getAllUserTasks() {
        return userTaskService.getAllUserTasks();
    }

    @GetMapping("/list")
    public ApiResponse<UserTasksListData> getUserTaskByUserId(String userId) {
        try{
            List<UserTask> userTasks = userTaskService.getUserTaskByUserId(userId);
            UserTasksListData userTasksListData=new UserTasksListData(userTasks.size(),userTasks);

            return ApiResponse.success("获取用户任务列表成功",userTasksListData);
        } catch (Exception e) {
            return ApiResponse.failed("获取用户任务列表失败:"+e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<Map<String,Long>> addUserTask(@RequestBody UserTask userTask) {
        try{
            Long id=userTaskService.addUserTask(userTask);
            Map<String,Long> map=new HashMap<>();
            map.put("task_record_id",id);

            return ApiResponse.success("领取任务成功",map);
        } catch (Exception e) {
            return ApiResponse.failed("领取任务失败："+e.getMessage());
        }
    }

    @PatchMapping("/update")
    public ApiResponse<Void> updateUserTask(
            @RequestParam Long taskRecordId,
            @RequestParam String taskStatus,
            @RequestParam LocalDateTime statusUpdateTime
    ) {
        try{
            userTaskService.updateUserTask(taskRecordId,taskStatus,statusUpdateTime);
            return ApiResponse.success("任务状态更新成功",null);
        }catch (Exception e) {
            return ApiResponse.failed("任务状态更新失败:"+e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserTask(@PathVariable Long id) {
        userTaskService.deleteUserTask(id);
    }
}
