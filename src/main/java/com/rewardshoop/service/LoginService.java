package com.rewardshoop.service;

import com.rewardshoop.model.IndexPic;
import com.rewardshoop.model.User;

import java.util.List;

public interface LoginService {
    /**
     *
     * 用thirdSession换取用户信息,如果该用户在当前数据库不存在,则新建一条数据
     *
     * @param thirdSession thirdSession
     * @return
     * @throws Exception
     */
    public User getUserInfo(String thirdSession) throws Exception;

    /**
     *
     * 获取小程序封面的轮播图
     *
     * @return
     */
    public List<IndexPic> getIndexPic();
}
