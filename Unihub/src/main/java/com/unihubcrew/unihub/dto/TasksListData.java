package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.Task;
import java.util.List;

public class TasksListData {
    private int total_count;
    private List<Task> tasks;

    public TasksListData(int total_count, List<Task> tasks) {
        this.total_count = total_count;
        this.tasks = tasks;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "TasksListData{" +
                "total_count=" + total_count +
                ", tasks=" + tasks +
                '}';
    }
}
