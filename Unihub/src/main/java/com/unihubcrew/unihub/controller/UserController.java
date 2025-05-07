package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.*;
import com.unihubcrew.unihub.model.User;
import com.unihubcrew.unihub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/account")
    public ApiResponse<UserDto> getUserByAccount(@RequestParam String account) {
        try{
            User user=userService.getUserByAccount(account);
            UserDto userDto=new UserDto(user);

            return ApiResponse.success("获取用户信息成功",userDto);
        } catch (Exception e) {
            return ApiResponse.failed("获取用户信息失败");
        }

    }

    @GetMapping("/all")
    public ApiResponse<UsersListData> getAllUsers() {
        try{
            List<User> users = userService.getAllUsers();
            int totalCount=users.size();

            UsersListData data=new UsersListData(totalCount,users);
            return ApiResponse.success("获取用户列表成功",data);
        }catch (Exception e){
            return ApiResponse.failed("获取用户列表失败：" + e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<User> addUser(@RequestBody User user) {
        try{
            userService.addUser(user);
            return ApiResponse.success("注册成功", user);
        }catch (Exception e){
            return ApiResponse.failed("注册失败：" + e.getMessage());
        }
    }

    @PostMapping("login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        String account = request.getAccount();
        String password = request.getPassword();

        LoginResponse response = userService.login(account, password);
        if (response == null) {
            return ApiResponse.failed("账号或密码错误");
        }
        return ApiResponse.success("登录成功",response);
    }

    @PutMapping("/update")
    public ApiResponse<Void> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return ApiResponse.success("更新用户信息成功", null);
        } catch (Exception e) {
            return ApiResponse.failed("更新用户信息失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ApiResponse<Void> deleteUser(@RequestParam String account) {
        try{
            userService.deleteUser(account);
            return ApiResponse.success("删除用户成功", null);
        } catch (Exception e) {
            return ApiResponse.failed("删除用户失败");
        }
    }
}
