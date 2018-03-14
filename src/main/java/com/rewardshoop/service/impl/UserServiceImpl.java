package com.rewardshoop.service.impl;

import com.rewardshoop.dao.UserMapper;
import com.rewardshoop.model.User;
import com.rewardshoop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void updataDefaultAddId(int id, int defaultAddId) throws Exception {
        User user = userMapper.selectByPrimaryKey(id);
        user.setDefaultAddId(defaultAddId);
        userMapper.updateByPrimaryKey(user);
    }
}
