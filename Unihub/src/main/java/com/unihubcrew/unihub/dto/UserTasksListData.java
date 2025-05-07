package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.UserTask;
import java.util.List;

public class UserTasksListData {
    private int total_count;
    private List<UserTask> userTask;

    public UserTasksListData(int total_count, List<UserTask> userTask) {
        this.total_count = total_count;
        this.userTask = userTask;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<UserTask> getUserTask() {
        return userTask;
    }

    public void setUserTask(List<UserTask> userTask) {
        this.userTask = userTask;
    }

    @Override
    public String toString() {
        return "UserTasksListData{" +
                "total_count=" + total_count +
                ", userTask=" + userTask +
                '}';
    }
}
