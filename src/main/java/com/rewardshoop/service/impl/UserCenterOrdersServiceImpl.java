package com.rewardshoop.service.impl;

import com.rewardshoop.daoExt.UserCenterOrdersDao;
import com.rewardshoop.pojo.UserCenterOrdersQueryPojo;
import com.rewardshoop.response.EnjorStarOrdersResponse;
import com.rewardshoop.service.UserCenterOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserCenterOrdersService")
@Transactional
public class UserCenterOrdersServiceImpl implements UserCenterOrdersService {
    //分页显示条数
    @Value("${pageSize}")
    private int pageSize;

    @Autowired
    private UserCenterOrdersDao userCenterOrdersDao;

    @Override
    public List<EnjorStarOrdersResponse> getAllEnjoyStarOrdersListByAdmin(int index, UserCenterOrdersQueryPojo userCenterOrdersQueryPojo) throws Exception {
        int startRow = index * pageSize;
        return userCenterOrdersDao.getAllEnjoyStarOrdersListByAdmin(startRow, pageSize, userCenterOrdersQueryPojo);
    }

    @Override
    public List<EnjorStarOrdersResponse> getAllEnjoyStarOrdersListByAdmin(UserCenterOrdersQueryPojo userCenterOrdersQueryPojo) throws Exception {
        return userCenterOrdersDao.getAllEnjoyStarOrdersListByAdmin(0, 0, userCenterOrdersQueryPojo);
    }

    @Override
    public Integer countAllEnjoyStarOrdersListByAdmin(UserCenterOrdersQueryPojo userCenterOrdersQueryPojo) throws Exception {
        int total = userCenterOrdersDao.countAllEnjoyStarOrdersListByAdmin(userCenterOrdersQueryPojo);
        return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }
}
