package com.rewardshoop.request;

import com.rewardshoop.validated.InsertCart;
import com.rewardshoop.validated.UpdateCartById;
import com.rewardshoop.validated.deleteCartByIds;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CartRequest {
    @NotNull(message = "{NOT_NULL}", groups = {UpdateCartById.class})
    private int id;

    private int num;

    @Max(value = 1, message = "{NOT_MORE_THAN_THE_MAX}")
    @Min(value = 0, message = "{NOT_LESS_THAN_THE_MIX}")
    private int payWay;

    @Min(value = 0, message = "{NOT_LESS_THAN_THE_MIX}", groups = {InsertCart.class})
    private int goodsId;
    @Min(value = 0, message = "{NOT_LESS_THAN_THE_MIX}", groups = {InsertCart.class})
    private int userId;
    @Min(value = 0, message = "{NOT_LESS_THAN_THE_MIX}", groups = {InsertCart.class})
    private int point;

    @NotEmpty(message = "{NOT_NULL}", groups = {deleteCartByIds.class})
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getGoodsId() {

        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPayWay() {
        return payWay;
    }

    public void setPayWay(int payWay) {
        this.payWay = payWay;
    }
}
