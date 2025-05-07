package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.dto.ResourceListData;
import com.unihubcrew.unihub.service.ResourceService;
import com.unihubcrew.unihub.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/id")
    public ApiResponse<Resource> getResourceById(@RequestParam(value = "id", required = false) Long id) {
        try{
            Resource resource = resourceService.getResourceById(id);
            return ApiResponse.success("获取资源详情成功", resource);
        }catch (Exception e) {
            return ApiResponse.failed("获取资源详情失败：" + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ApiResponse<ResourceListData> getAllResources(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "tag", required = false) String tag
    ) {
        try {
            List<Resource> resources = resourceService.getAllResources(type, tag);
            int totalCount = resources.size();

            ResourceListData data = new ResourceListData(totalCount, resources);
            return ApiResponse.success("获取资源列表成功", data);
        } catch (Exception e) {
            return ApiResponse.failed("获取资源列表失败：" + e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<Resource> addResource(@RequestBody Resource resource) {
        try {
            resourceService.addResource(resource);
            return ApiResponse.success("发布资源成功", resource);
        } catch (Exception e) {
            return ApiResponse.failed("发布资源失败：" + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ApiResponse<Void> updateResource(@RequestBody Resource resource) {
        try {
            resourceService.updateResource(resource);
            return ApiResponse.success("更新资源成功", null);
        } catch (Exception e) {
            return ApiResponse.failed("更新资源失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ApiResponse<Void> deleteResource(@RequestParam(value = "id", required = true) Long id) {
        try {
            resourceService.deleteResource(id);
            return ApiResponse.success("删除资源成功", null);
        } catch (Exception e) {
            return ApiResponse.failed("删除资源失败：" + e.getMessage());
        }
    }
}
