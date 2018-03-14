package com.rewardshoop.service;

import com.rewardshoop.response.CartResponse;

import java.util.List;

public interface CartService {

    /**
     * 通过userId获取购物车信息
     *
     * @return
     */
    public List<CartResponse> getCartInfoByUserId(int userId) throws Exception;

    /**
     * 通过Id更新购物车信息
     *
     * @param id     id
     * @param num    购买数量
     * @param payWay 支付方式
     * @throws Exception
     */
    public void updateCartById(int id, int num, int payWay, int point) throws Exception;

    /**
     * 通过Id删除某一条购物车信息
     *
     * @param id
     * @throws Exception
     */
    public void deleteCartById(int id) throws Exception;

    /**
     * 添加购物车
     *
     * @param goodsId 商品id
     * @param userId  用户id
     * @param payWay  支付方式
     * @param num     购买数量
     * @param point   积分数(*100)
     * @throws Exception
     */
    public void insertCart(int goodsId, int userId, int payWay, int num, int point) throws Exception;

    /**
     * 批量删除购物车
     *
     * @param ids
     */
    public void deleteCartByIds(List<Integer> ids) throws Exception;
}
