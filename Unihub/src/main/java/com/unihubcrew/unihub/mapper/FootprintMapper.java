package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.Footprint;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FootprintMapper {
    @Select("SELECT * FROM footprints WHERE footprint_id= #{id} ")
    Footprint getFootprintById(Long id);

    @Select("SELECT  * FROM footprints")
    List<Footprint> getAllFootprints();

    @Select("SELECT * FROM footprints WHERE user_id=#{userId}")
    List<Footprint> getFootprintByUserId(String userId);

    @Insert("INSERT INTO footprints(footprint_id, user_id, resource_id,view_time)"+
            "VALUES(#{id},#{userId},#{resourceId},#{viewTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void addFootprint(Footprint footprint);

    @Insert("UPDATE footprints SET user_id=#{userId},resource_id=#{resourceId},view_time=#{viewTime} "+
            "WHERE footprint_id=#{id}")
    void updateFootprint(Footprint footprint);

    @Delete("DELETE FROM footprints WHERE footprint_id=#{id}")
    void deleteFootprint(Long id);
}
