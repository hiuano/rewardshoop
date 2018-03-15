package com.rewardshoop.service;

import com.rewardshoop.response.ResultResponse;

/**
 * 一些业务上的判断
 */
public interface ServiceUtils {
    /**
     * 判断商品超过限制数量
     *
     * @param userId
     * @param goodsId
     * @param num
     * @return
     * @throws Exception
     */
    public ResultResponse checkOverLimit(int userId, int goodsId, int num) throws Exception;
}
