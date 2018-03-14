package com.rewardshoop.controller;

import com.rewardshoop.request.CartRequest;
import com.rewardshoop.response.CartResponse;
import com.rewardshoop.response.ResultResponse;
import com.rewardshoop.service.CartService;
import com.rewardshoop.validated.InsertCart;
import com.rewardshoop.validated.UpdateCartById;
import com.rewardshoop.validated.deleteCartByIds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 通过userId获取购物车信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getCartInfoByUserId", method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse getCartInfoByUserId(@NotNull int userId) throws Exception {
        List<CartResponse> list = cartService.getCartInfoByUserId(userId);
        return new ResultResponse(true, list);
    }

    /**
     * 通过id来更新购物车信息
     *
     * @param request
     * @param br
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateCartById", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse updateCartById(@Validated(value = UpdateCartById.class) @RequestBody CartRequest request, BindingResult br) throws Exception {
        if (br.hasErrors()) {
            List<ObjectError> errorList = br.getAllErrors();
            return new ResultResponse(false, errorList.get(0).getDefaultMessage());
        }
        int id = request.getId();
        int num = request.getNum();
        int payWay = request.getPayWay();
        int point = request.getPoint();
        cartService.updateCartById(id, num, payWay, point);
        return new ResultResponse(true);
    }

    /**
     * 根据id删除购物车信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deleteCartById", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse deleteCartById(@RequestBody CartRequest request) throws Exception {
        int id = request.getId();
        cartService.deleteCartById(id);
        return new ResultResponse(true);
    }

    /**
     * 根据ids删除购物车信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deleteCartByIds", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse deleteCartByIds(@Validated(value = deleteCartByIds.class) @RequestBody CartRequest request, BindingResult br) throws Exception {
        if (br.hasErrors()) {
            List<ObjectError> errorList = br.getAllErrors();
            return new ResultResponse(false, errorList.get(0).getDefaultMessage());
        }

        List<Integer> ids = request.getIds();
        cartService.deleteCartByIds(ids);
        return new ResultResponse(true);
    }

    /**
     * 增加购物车信息
     *
     * @param request
     * @param br
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "insertCart", method = RequestMethod.POST)
    public ResultResponse insertCart(@Validated(value = {InsertCart.class}) @RequestBody CartRequest request, BindingResult br) throws Exception {
        if (br.hasErrors()) {
            List<ObjectError> errorList = br.getAllErrors();
            return new ResultResponse(false, errorList.get(0).getDefaultMessage());
        }

        int goodsId = request.getGoodsId();
        int userId = request.getUserId();
        int payWay = request.getPayWay();
        int num = request.getNum();
        int point = request.getPoint();
        cartService.insertCart(goodsId, userId, payWay, num, point);
        return new ResultResponse(true, true);
    }
}
