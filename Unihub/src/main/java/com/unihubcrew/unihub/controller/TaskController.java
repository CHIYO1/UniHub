package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.dto.TasksListData;
import com.unihubcrew.unihub.service.TaskService;
import com.unihubcrew.unihub.model.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/id/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/all")
    public ApiResponse<TasksListData> getAllTasks(
            @Param("id") Long id,
            @Param("targetScope") String targetScope,
            @Param("content") String content
    ) {
        try{
            List<Task> tasks = taskService.getAllTasks(id,targetScope,content);
            TasksListData tasksListData=new TasksListData(tasks.size(),tasks);

            return ApiResponse.success("获取任务列表成功",tasksListData);
        } catch (Exception e) {
            return ApiResponse.failed("获取任务列表失败："+e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<Map<String,Long>> addTask(@RequestBody Task task) {
        try{
            Long id = taskService.addTask(task);
            Map<String,Long> map = new HashMap<>();
            map.put("task_id", id);

            return ApiResponse.success("发布任务成功",map);
        }catch (Exception e) {
            return ApiResponse.failed("发布任务失败："+e.getMessage());
        }
    }

    @PostMapping("/update")
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
