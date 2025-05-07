package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.Footprint;
import java.util.List;

public class FootprintsListData {
    private int total_count;
    private List<Footprint> footprint;

    public FootprintsListData(int total_count, List<Footprint> footprint) {
        this.total_count = total_count;
        this.footprint = footprint;
    }

    public List<Footprint> getFootprint() {
        return footprint;
    }

    public void setFootprint(List<Footprint> footprint) {
        this.footprint = footprint;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    @Override
    public String toString() {
        return "FootprintsListData{" +
                "total_count=" + total_count +
                ", footprint=" + footprint +
                '}';
    }
}
