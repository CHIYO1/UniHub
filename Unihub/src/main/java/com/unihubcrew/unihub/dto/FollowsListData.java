package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.Follow;
import java.util.List;

public class FollowsListData {
    private int total_count;
    private List<Follow> follows;

    public FollowsListData(int total_count, List<Follow> follows) {
        this.total_count = total_count;
        this.follows = follows;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<Follow> getFollows() {
        return follows;
    }

    public void setFollows(List<Follow> follows) {
        this.follows = follows;
    }

    @Override
    public String toString() {
        return "FollowsListData{" +
                "total_count=" + total_count +
                ", follows=" + follows +
                '}';
    }
}
