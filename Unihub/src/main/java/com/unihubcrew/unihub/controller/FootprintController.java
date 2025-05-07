package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.dto.FootprintsListData;
import com.unihubcrew.unihub.model.Footprint;
import com.unihubcrew.unihub.service.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/footprint")
public class FootprintController {

    @Autowired
    private FootprintService footprintService;

    @GetMapping("/id/{id}")
    public Footprint getFootprintById(@PathVariable Long id) {
        return footprintService.getFootprintById(id);
    }

    @GetMapping("/all")
    public List<Footprint> getAllFootprints() {
        return footprintService.getAllFootprints();
    }

    @GetMapping("/list")
    public ApiResponse<FootprintsListData> getFootprintsByUserId(String userId) {
        try{
            List<Footprint> footprints = footprintService.getFootprintByUserId(userId);
            FootprintsListData footprintsListData=new FootprintsListData(footprints.size(),footprints);

            return ApiResponse.success("获取足迹列表成功",footprintsListData);
        }catch (Exception e){
            return ApiResponse.failed("获取足迹列表失败："+e.getMessage());
        }
    }


    @PostMapping("/add")
    public ApiResponse<Footprint> addFootprint(@RequestBody Footprint footprint) {
        try{
            Long id=footprintService.addFootprint(footprint);
            footprint.setId(id);

            return ApiResponse.success("新增足迹成功",footprint);
        }catch (Exception e){
            return ApiResponse.failed("新增足迹失败："+e.getMessage());
        }
    }

    @PostMapping("/update")
    public void updateFootprint(@RequestBody Footprint footprint) {
        footprintService.updateFootprint(footprint);
    }

    @DeleteMapping("/delete")
    public ApiResponse<Void> deleteFootprint(@RequestParam Long footprintId) {
        try{
            footprintService.deleteFootprint(footprintId);

            return ApiResponse.success("删除足迹成功",null);
        } catch (Exception e) {
            return ApiResponse.failed("删除足迹失败："+e.getMessage());
        }
    }
}
