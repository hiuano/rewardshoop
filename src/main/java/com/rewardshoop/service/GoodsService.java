package com.rewardshoop.service;

import com.rewardshoop.model.Goods;
import com.rewardshoop.model.Type;
import com.rewardshoop.response.GoodsDetailResponse;
import com.rewardshoop.response.TypeListResponse;

import java.util.List;

public interface GoodsService {
    /**
     * index获取产品信息
     *
     * @return
     */
    public List<TypeListResponse> getTypeList() throws Exception;

    /**
     * 导航栏获取类型信息
     *
     * @return
     * @throws Exception
     */
    public List<Type> getType() throws Exception;

    /**
     * 通过typeId来获取商品信息
     *
     * @param typeId
     * @return
     * @throws Exception
     */
    public List<Goods> getGoodsByTypeId(int typeId) throws Exception;

    /**
     * 通过id获取商品详情
     *
     * @param id
     * @return
     * @throws Exception
     */
    public GoodsDetailResponse getGoodsDetailById(int id) throws Exception;

    /**
     * 通过关键字获取商品详情
     *
     * @param typeId
     * @param keyWord
     * @return
     * @throws Exception
     */
    public List<Goods> getGoodsByKeyWord(int typeId, String keyWord) throws Exception;

}
