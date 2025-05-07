package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.Resource;
import java.util.List;

public class ResourceListData {
    private int total_count;
    private List<Resource> resources;

    public ResourceListData() {
    }

    public ResourceListData(int total_count, List<Resource> resources) {
        this.total_count = total_count;
        this.resources = resources;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
