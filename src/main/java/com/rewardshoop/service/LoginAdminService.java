package com.rewardshoop.service;

public interface LoginAdminService {

    /**
     * 验证管理员用户
     *
     * @param adminName
     * @param password
     * @return
     * @throws Exception
     */
    public int login(String adminName, String password) throws Exception;
}
