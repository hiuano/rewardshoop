package com.rewardshoop.daoExt;

import com.rewardshoop.dao.CartMapper;
import com.rewardshoop.response.CartResponse;

import java.util.List;

public interface CartDao extends CartMapper {

    /**
     * 通过UserId获取购物车信息
     *
     * @param userId
     * @return
     */
    public List<CartResponse> getCartInfoByUserId(int userId) throws Exception;

}
