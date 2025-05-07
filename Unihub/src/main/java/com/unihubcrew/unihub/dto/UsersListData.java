package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.User;
import java.util.List;

public class UsersListData {
    private int total_count;
    private List<User> users;

    public UsersListData(int total_count, List<User> users) {
        this.total_count = total_count;
        this.users = users;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UsersListData{" +
                "total_count=" + total_count +
                ", users=" + users +
                '}';
    }
}
