package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.Follow;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FollowMapper {
    @Select("SELECT * FROM follows WHERE follow_id= #{id} ")
    Follow getFollowById(Long id);

    List<Follow> getAllFollows(@Param("followerId")String followerId, @Param("followedId")String followedId);

    @Insert("INSERT INTO follows(follow_id, follower_id, followed_id,follow_time)"+
            "VALUES(#{id},#{followerId},#{followedId},#{followedTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addFollow(Follow follow);

    @Insert("UPDATE follows SET follow_id=#{followerId},follower_id=#{followedId},follow_time=#{followedTime} "+
            "WHERE follow_id=#{id}")
    void updateFollow(Follow follow);

    @Delete("DELETE FROM follows WHERE follow_id=#{id}")
    void deleteFollow(Long id);
}
