package com.unihubcrew.unihub.model;

import java.time.LocalDateTime;

public class Task {
    private Long taskId;
    private LocalDateTime startTime;
    private int duration;
    private String targetScope;
    private String content;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTargetScope() {
        return targetScope;
    }

    public void setTargetScope(String targetScope) {
        this.targetScope = targetScope;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + taskId +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", targetScope='" + targetScope + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
