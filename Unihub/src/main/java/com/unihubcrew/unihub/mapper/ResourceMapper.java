package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.Resource;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResourceMapper {
    @Select("SELECT * FROM resources WHERE id= #{id} ")
    Resource getResourceById(Long id);

    List<Resource> getAllResources(@Param("type") String type, @Param("tag") String tag);

    @Insert("INSERT INTO resources(id, type, description,merchant_id,price,stock,image,tag)"+
            "VALUES(#{id},#{type},#{description},#{merchantId},#{price},#{stock},#{image},#{tag})")
    void addResource(Resource resource);

    @Insert("UPDATE resources SET type=#{type},description=#{description},merchant_id=#{merchantId},"+
            "price=#{price},stock=#{stock},image=#{image},tag=#{tag} "+
            "WHERE id=#{id}")
    void updateResource(Resource resource);

    @Delete("DELETE FROM resources WHERE id=#{id}")
    void deleteResource(Long id);
}
