package com.rewardshoop.model;

public class User {
    private Integer id;

    private Integer isy;

    private Integer userLevel;

    private String userName;

    private String userPhone;

    private Integer defaultAddId;

    public User(Integer id, Integer isy, Integer userLevel, String userName, String userPhone, Integer defaultAddId) {
        this.id = id;
        this.isy = isy;
        this.userLevel = userLevel;
        this.userName = userName;
        this.userPhone = userPhone;
        this.defaultAddId = defaultAddId;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsy() {
        return isy;
    }

    public void setIsy(Integer isy) {
        this.isy = isy;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getDefaultAddId() {
        return defaultAddId;
    }

    public void setDefaultAddId(Integer defaultAddId) {
        this.defaultAddId = defaultAddId;
    }
}