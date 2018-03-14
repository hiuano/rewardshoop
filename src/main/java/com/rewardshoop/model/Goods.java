package com.rewardshoop.model;

public class Goods {
    private Integer id;

    private Integer typeId;

    private String goodsName;

    private String addTime;

    private String uodateTime;

    private Integer state;

    private Integer consumePoint;

    private Integer prepayPoint;

    private Integer marketPrice;

    private String pic;

    public Goods(Integer id, Integer typeId, String goodsName, String addTime, String uodateTime, Integer state, Integer consumePoint, Integer prepayPoint, Integer marketPrice, String pic) {
        this.id = id;
        this.typeId = typeId;
        this.goodsName = goodsName;
        this.addTime = addTime;
        this.uodateTime = uodateTime;
        this.state = state;
        this.consumePoint = consumePoint;
        this.prepayPoint = prepayPoint;
        this.marketPrice = marketPrice;
        this.pic = pic;
    }

    public Goods() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getUodateTime() {
        return uodateTime;
    }

    public void setUodateTime(String uodateTime) {
        this.uodateTime = uodateTime == null ? null : uodateTime.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

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

    public Integer getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Integer marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}