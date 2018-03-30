package com.rewardshoop.service;

import com.rewardshoop.pojo.UserCenterOrdersQueryPojo;
import com.rewardshoop.response.EnjorStarOrdersResponse;

import java.util.List;

public interface UserCenterOrdersService {
    public List<EnjorStarOrdersResponse> getAllEnjoyStarOrdersListByAdmin(int index, UserCenterOrdersQueryPojo userCenterOrdersQueryPojo) throws Exception;

    public List<EnjorStarOrdersResponse> getAllEnjoyStarOrdersListByAdmin(UserCenterOrdersQueryPojo userCenterOrdersQueryPojo) throws Exception;

    public Integer countAllEnjoyStarOrdersListByAdmin(UserCenterOrdersQueryPojo userCenterOrdersQueryPojo) throws Exception;

}
