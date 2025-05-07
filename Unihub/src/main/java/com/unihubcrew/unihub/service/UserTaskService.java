package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.UserTaskMapper;
import com.unihubcrew.unihub.model.UserTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserTaskService {
    @Autowired
    private UserTaskMapper userTaskMapper;

    public UserTask getUserTaskById(Long id) {
        return userTaskMapper.getUserTaskById(id);
    }

    public List<UserTask> getAllUserTasks() {
        return userTaskMapper.getAllUserTasks();
    }

    public List<UserTask> getUserTaskByUserId(String userId) {
        return userTaskMapper.getUserTaskByUserId(userId);
    }

    public Long addUserTask(UserTask userTask) {
        userTaskMapper.addUserTask(userTask);
        return userTask.getTaskRecordId();
    }

    public void updateUserTask(Long taskRecordId, String taskStatus, LocalDateTime taskStatusUpdateTime) {
        userTaskMapper.updateUserTask(taskRecordId,taskStatus,taskStatusUpdateTime);
    }

    public void deleteUserTask(Long id) {
        userTaskMapper.deleteUserTask(id);
    }
}
