package com.unihubcrew.unihub.model;

import java.time.LocalDateTime;

public class UserTask {
    private Long taskRecordId;
    private String userId;
    private String taskId;
    private String taskStatus;
    private LocalDateTime statusUpdateTime;

    public Long getTaskRecordId() {
        return taskRecordId;
    }

    public void setTaskRecordId(Long taskRecordId) {
        this.taskRecordId = taskRecordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDateTime getStatusUpdateTime() {
        return statusUpdateTime;
    }

    public void setStatusUpdateTime(LocalDateTime statusUpdateTime) {
        this.statusUpdateTime = statusUpdateTime;
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "id=" + taskRecordId +
                ", userId='" + userId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", statusUpdateTime=" + statusUpdateTime +
                '}';
    }
}
