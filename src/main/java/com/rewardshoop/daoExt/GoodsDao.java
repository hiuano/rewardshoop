package com.rewardshoop.daoExt;

import com.rewardshoop.dao.GoodsMapper;
import com.rewardshoop.pojo.GoodsLimitPojo;
import com.rewardshoop.response.GoodsDetailResponse;
import com.rewardshoop.response.TypeListResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao extends GoodsMapper {

    /**
     * 一对多关系,向type,goods多表查询
     *
     * @return
     */
    public List<TypeListResponse> getTypeList() throws Exception;

    /**
     * 一对一,多表查询,现在感觉这样设计数据库有点多余,不管了
     *
     * @param id
     * @return
     * @throws Exception
     */
    public GoodsDetailResponse getGoodsDetailById(int id) throws Exception;

    /**
     * 根据userId查询订单中的goods的剩余限制购买数量
     *
     * @param userId
     * @param goodsId
     * @return
     * @throws Exception
     */
    public GoodsLimitPojo getGoodsLimitLeftValue(@Param("userId") int userId, @Param("goodsId") int goodsId) throws Exception;
}
