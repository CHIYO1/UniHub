package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface  UserMapper {
    @Select("SELECT * FROM USERS WHERE account = #{account}")
    User getUserByAccount(String account);

    @Select("SELECT * FROM USERS")
    List<User> getAllUsers();

    @Insert("INSERT INTO USERS(account,password,role,avatar,bio,phone,growth_value,points,settings,permissions,"+
            "address,third_party_bind) VALUES(#{account},#{password},#{role},#{avatar},#{bio},#{phone},#{growthValue},"+
            "#{points},#{settings},#{permissions},#{address},#{thirdPartyBind})")
    void addUser(User user);

    @Update("UPDATE USERS SET password=#{password},role=#{role},avatar=#{avatar},bio=#{bio},phone=#{phone},growth_value=#{growthValue},"+
            "points=#{points},settings=#{settings},permissions=#{permissions},address=#{address},third_party_bind=#{thirdPartyBind} "+
            "WHERE account=#{account}")
    void updateUser(User user);

    @Delete("DELETE FROM USERS WHERE account=#{account}")
    void deleteUser(String account);

}
