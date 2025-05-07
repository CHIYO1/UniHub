package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Select("SELECT * FROM tasks WHERE task_id= #{id} ")
    Task getTaskById(Long id);

    List<Task> getAllTasks(Long id,String targetScope,String content);

    @Insert("INSERT INTO tasks(task_id, start_time, duration,target_scope,content)"+
            "VALUES(#{id},#{startTime},#{duration},#{targetScope},#{content})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void addTask(Task task);

    @Insert("UPDATE tasks SET start_time=#{startTime},duration=#{duration},"+
            "target_scope=#{targetScope},content=#{content} "+
            "WHERE task_id=#{id}")
    void updateTask(Task task);

    @Delete("DELETE FROM tasks WHERE task_id=#{id}")
    void deleteTask(Long id);
}
