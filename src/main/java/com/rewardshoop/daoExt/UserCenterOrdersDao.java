package com.rewardshoop.daoExt;

import com.rewardshoop.pojo.UserCenterOrdersQueryPojo;
import com.rewardshoop.response.EnjorStarOrdersResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCenterOrdersDao {
    public List<EnjorStarOrdersResponse> getAllEnjoyStarOrdersListByAdmin(@Param("startRow") int startRow, @Param("pageSize") int pageSize, @Param("userCenterOrdersQueryPojo") UserCenterOrdersQueryPojo userCenterOrdersQueryPojo) throws Exception;

    public Integer countAllEnjoyStarOrdersListByAdmin(@Param("userCenterOrdersQueryPojo") UserCenterOrdersQueryPojo userCenterOrdersQueryPojo) throws Exception;

}
