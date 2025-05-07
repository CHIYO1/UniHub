package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.UserTask;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserTaskMapper {
    @Select("SELECT * FROM user_tasks WHERE task_record_id= #{id} ")
    UserTask getUserTaskById(Long id);

    @Select("SELECT  * FROM user_tasks")
    List<UserTask> getAllUserTasks();

    @Select("SELECT * FROM user_tasks WHERE user_id=#{userId}")
    List<UserTask> getUserTaskByUserId(String userId);

    @Insert("INSERT INTO user_tasks(task_record_id, user_id, task_id,task_status,status_update_time)"+
            "VALUES(#{taskRecordId},#{userId},#{taskId},#{taskStatus},#{statusUpdateTime})")
    @Options(useGeneratedKeys = true,keyProperty = "taskRecordId")
    void addUserTask(UserTask usertask);

    @Update("UPDATE user_tasks SET task_status=#{taskStatus}, status_update_time=#{statusUpdateTime} " +
            "WHERE task_record_id=#{taskRecordId}")
    void updateUserTask(@Param("taskRecordId") Long taskRecordId,
                              @Param("taskStatus") String taskStatus,
                              @Param("statusUpdateTime") LocalDateTime statusUpdateTime);

    @Delete("DELETE FROM user_tasks WHERE task_record_id=#{id}")
    void deleteUserTask(Long id);
}
