package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.dto.LoginResponse;
import com.unihubcrew.unihub.mapper.UserMapper;
import com.unihubcrew.unihub.model.User;
import com.unihubcrew.unihub.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(String account) {
        userMapper.deleteUser(account);
    }

    public LoginResponse login(String account, String password) {
        User user = userMapper.getUserByAccount(account);

        if (user == null || user.getPassword() == null || !user.getPassword().equals(password)) {
            return null;
        }

        try {
            String token = JwtUtil.generateToken(account);
            LoginResponse response = new LoginResponse();
            response.setToken(token);
            response.setAccount(account);
            response.setBio(user.getBio());
            response.setAvatar(user.getAvatar());
            response.setRole(user.getRole());
            response.setPoints(user.getPoints());
            response.setGrowthValue(user.getGrowthValue());

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
