package com.rewardshoop.model;

public class AdminUser {
    private Integer id;

    private String adminName;

    private String addTime;

    private String adminPassword;

    public AdminUser(Integer id, String adminName, String addTime, String adminPassword) {
        this.id = id;
        this.adminName = adminName;
        this.addTime = addTime;
        this.adminPassword = adminPassword;
    }

    public AdminUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }
}