package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.ResourceMapper;
import com.unihubcrew.unihub.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    public Resource getResourceById(Long id) {
        return resourceMapper.getResourceById(id);
    }

    public List<Resource> getAllResources(String type, String tag) {
        return resourceMapper.getAllResources(type,tag);
    }

    public void addResource(Resource resource) {
        resourceMapper.addResource(resource);
    }

    public void updateResource(Resource resource) {
        resourceMapper.updateResource(resource);
    }

    public void deleteResource(Long id) {
        resourceMapper.deleteResource(id);
    }
}
