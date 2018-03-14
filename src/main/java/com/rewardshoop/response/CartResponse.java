package com.rewardshoop.response;

public class CartResponse {
    private int id;
    private int num;
    private int payWay;
    private int point;
    private CartGoods goods;
    private final int mode = 0;
    private final boolean checked = false;

    public CartResponse() {
    }

    public CartResponse(int id, int num, int payWay, int point, CartGoods goods) {
        this.id = id;
        this.num = num;
        this.payWay = payWay;
        this.point = point;
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "CartResponse{" +
                "id=" + id +
                ", num=" + num +
                ", payWay=" + payWay +
                ", point=" + point +
                ", goods=" + goods +
                ", mode=" + mode +
                ", checked=" + checked +
                '}';
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getMode() {
        return mode;
    }

    public boolean isChecked() {
        return checked;
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

    public CartGoods getGoods() {
        return goods;
    }

    public void setGoods(CartGoods goods) {
        this.goods = goods;
    }

}

class CartGoods {
    private int id;
    private String pic;
    private String goodsName;
    private int stock;
    private int typeId;
    private String typeName;
    private Integer consumePoint;
    private Integer prepayPoint;

    public Integer getConsumePoint() {
        return consumePoint;
    }

    public void setConsumePoint(Integer consumePoint) {
        this.consumePoint = consumePoint;
    }

    public Integer getPrepayPoint() {
        return prepayPoint;
    }

    public void setPrepayPoint(Integer prepayPoint) {
        this.prepayPoint = prepayPoint;
    }

    public CartGoods(int id, String pic, String goodsName, int stock, int typeId, String typeName) {
        this.id = id;
        this.pic = pic;
        this.goodsName = goodsName;
        this.stock = stock;
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public CartGoods() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", pic='" + pic + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", stock=" + stock +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
