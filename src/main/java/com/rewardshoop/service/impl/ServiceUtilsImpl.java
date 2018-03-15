
package com.rewardshoop.service.impl;

import com.rewardshoop.daoExt.GoodsDao;
import com.rewardshoop.pojo.GoodsLimitPojo;
import com.rewardshoop.response.ResultResponse;
import com.rewardshoop.service.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("serviceUtils")
public class ServiceUtilsImpl implements ServiceUtils {
    @Autowired
    private GoodsDao goodsDao;

    public ResultResponse checkOverLimit(int userId, int goodsId, int num) throws Exception {
        GoodsLimitPojo pojo = goodsDao.getGoodsLimitLeftValue(userId, goodsId);
        if (pojo == null) {
            return new ResultResponse((true));
        }
        int leftValue;
        //这里如果没有发生订单的话,pojo.getLeftValue是空指针,所以要捕捉以下
        try {
            leftValue = pojo.getLeftValue();
        } catch (NullPointerException e) {
            leftValue = pojo.getLimitNum();
        }
        if (leftValue - num < 0) {
            String errMsg = "GOODS限制购买LIMIT".replace("GOODS", pojo.getGoodsName()).replace("LIMIT", pojo.getLimitNum() + "件");
            return new ResultResponse(false, errMsg);
        } else {
            return new ResultResponse(true);
        }
    }
}
