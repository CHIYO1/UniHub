package com.unihubcrew.unihub.model;

public class User {
    private String account;      // 用户账户
    private String password;     // 用户密码
    private String role;         // 用户角色（枚举值：'会员', '管理员', '普通用户', '商家'）
    private String avatar;       // 用户头像
    private String bio="";          // 用户简介
    private String phone="";        // 用户电话
    private int growthValue=0;     // 用户成长值
    private int points=0;          // 用户积分
    private String settings="{}";     // 用户设置（JSON 格式）
    private String permissions="{}";  // 用户权限（JSON 格式）
    private String address="";      // 用户地址
    private String thirdPartyBind="{}"; // 第三方绑定信息（JSON 格式）

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGrowthValue() {
        return growthValue;
    }

    public void setGrowthValue(int growthValue) {
        this.growthValue = growthValue;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThirdPartyBind() {
        return thirdPartyBind;
    }

    public void setThirdPartyBind(String thirdPartyBind) {
        this.thirdPartyBind = thirdPartyBind;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", avatar='" + avatar + '\'' +
                ", bio='" + bio + '\'' +
                ", phone='" + phone + '\'' +
                ", growthValue=" + growthValue +
                ", points=" + points +
                ", settings='" + settings + '\'' +
                ", permissions='" + permissions + '\'' +
                ", address='" + address + '\'' +
                ", thirdPartyBind='" + thirdPartyBind + '\'' +
                '}';
    }
}
