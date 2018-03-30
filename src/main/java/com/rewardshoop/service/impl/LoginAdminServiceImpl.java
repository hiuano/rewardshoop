package com.rewardshoop.service.impl;

import com.rewardshoop.dao.AdminUserMapper;
import com.rewardshoop.model.AdminUser;
import com.rewardshoop.model.AdminUserExample;
import com.rewardshoop.service.LoginAdminService;
import com.rewardshoop.utils.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("loginAdminService")
@Transactional
public class LoginAdminServiceImpl implements LoginAdminService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public int login(String adminName, String password) throws Exception {
        //加密密码
        password = EncryptionUtil.MD5(password);
        AdminUserExample example = new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();
        criteria.andAdminNameEqualTo(adminName);
        criteria.andAdminPasswordEqualTo(password);
        List<AdminUser> list = adminUserMapper.selectByExample(example);
        int id = list.size() == 0 ? 0 : list.get(0).getId();
        return id;
    }
}
