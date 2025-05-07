package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.Favorite;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    @Select("SELECT * FROM favorites WHERE favorite_id= #{id} ")
    Favorite getFavoriteById(Long id);

    List<Favorite> getAllFavorites(@Param("userId")String userId);

    @Insert("INSERT INTO favorites(favorite_id, user_id, resource_id,favorite_time)"+
            "VALUES(#{id},#{userId},#{resourceId},#{favoriteTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addFavorite(Favorite favorite);

    @Insert("UPDATE favorites SET user_id=#{userId},resource_id=#{resourceId},favorite_time=#{favoriteTime} "+
            "WHERE favorite_id=#{id}")
    void updateFavorite(Favorite favorite);

    @Delete("DELETE FROM favorites WHERE favorite_id=#{id}")
    void deleteFavorite(Long id);
}
