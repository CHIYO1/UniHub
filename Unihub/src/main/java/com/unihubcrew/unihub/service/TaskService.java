package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.TaskMapper;
import com.unihubcrew.unihub.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskMapper taskMapper;

    public Task getTaskById(Long id) {
        return taskMapper.getTaskById(id);
    }

    public List<Task> getAllTasks(Long id,String targetScope,String content) {
        return taskMapper.getAllTasks(id,targetScope,content);
    }

    public Long addTask(Task task) {
        taskMapper.addTask(task);
        return task.getTaskId();
    }

    public void updateTask(Task task) {
        taskMapper.updateTask(task);
    }

    public void deleteTask(Long id) {
        taskMapper.deleteTask(id);
    }
}
