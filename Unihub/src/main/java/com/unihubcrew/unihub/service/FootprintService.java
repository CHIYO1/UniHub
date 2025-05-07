package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.FootprintMapper;
import com.unihubcrew.unihub.model.Footprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintService {
    @Autowired
    private FootprintMapper footPrintMapper;

    public Footprint getFootprintById(Long id) {
        return footPrintMapper.getFootprintById(id);
    }

    public List<Footprint> getAllFootprints() {
        return footPrintMapper.getAllFootprints();
    }

    public List<Footprint> getFootprintByUserId(String userId) {
        return footPrintMapper.getFootprintByUserId(userId);
    }

    public Long addFootprint(Footprint footprint) {
        footPrintMapper.addFootprint(footprint);
        return footprint.getId();
    }

    public void updateFootprint(Footprint footprint) {
        footPrintMapper.updateFootprint(footprint);
    }

    public void deleteFootprint(Long id) {
        footPrintMapper.deleteFootprint(id);
    }
}
