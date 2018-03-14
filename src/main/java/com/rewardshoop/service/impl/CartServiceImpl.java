package com.rewardshoop.service.impl;

import com.rewardshoop.daoExt.CartDao;
import com.rewardshoop.model.Cart;
import com.rewardshoop.model.CartExample;
import com.rewardshoop.response.CartResponse;
import com.rewardshoop.service.CartService;
import com.rewardshoop.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("CartService")
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;


    @Override
    public List<CartResponse> getCartInfoByUserId(int userId) throws Exception {
        return cartDao.getCartInfoByUserId(userId);
    }

    @Override
    public void updateCartById(int id, int num, int payWay, int point) throws Exception {
        Cart cart = cartDao.selectByPrimaryKey(id);
        cart.setUpdateTime(TimeUtil.currentTime() + "");
        cart.setNum(num);
        cart.setPayWay(payWay);
        cart.setPoint(point);
        cartDao.updateByPrimaryKey(cart);
    }

    @Override
    public void deleteCartById(int id) throws Exception {
        cartDao.deleteByPrimaryKey(id);
    }

    @Override
    public void insertCart(int goodsId, int userId, int payWay, int num, int point) throws Exception {
        CartExample example = new CartExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<Cart> list = cartDao.selectByExample(example);
        for (Cart c : list) {
            if (c.getGoodsId() == goodsId && c.getPayWay() == payWay) {
                c.setNum(c.getNum() + num);
                c.setUpdateTime(TimeUtil.currentTime() + "");
                cartDao.updateByPrimaryKey(c);
                return;
            }
        }

        Cart cart = new Cart();
        cart.setPayWay(payWay);
        cart.setNum(num);
        cart.setAddTime(TimeUtil.currentTime() + "");
        cart.setGoodsId(goodsId);
        cart.setPoint(point);
        cart.setUserId(userId);

        cartDao.insert(cart);
    }

    @Override
    public void deleteCartByIds(List<Integer> ids) throws Exception {
        CartExample example = new CartExample();
        example.createCriteria().andIdIn(ids);
        cartDao.deleteByExample(example);
    }
}
