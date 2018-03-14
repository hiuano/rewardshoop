package com.rewardshoop.response;

import java.util.List;

public class GoodsDetailResponse {
    private int id;
    private String goodsName;
    private int consumePoint;
    private int prepayPoint;
    private int marketPrice;
    private String pic;
    private String factoryName;
    private String model;
    private String content;
    private String introduction;
    private String introductionPic;
    private int stock;
    private List<String> pics;

    public int getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(int marketPrice) {
        this.marketPrice = marketPrice;
    }

    @Override
    public String toString() {
        return "GoodsDetailResponse{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", consumePoint=" + consumePoint +
                ", prepayPoint=" + prepayPoint +
                ", pic='" + pic + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", model='" + model + '\'' +
                ", content='" + content + '\'' +
                ", introduction='" + introduction + '\'' +
                ", introductionPic='" + introductionPic + '\'' +
                ", stock=" + stock +
                ", pics=" + pics +
                '}';
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getConsumePoint() {
        return consumePoint;
    }

    public void setConsumePoint(int consumePoint) {
        this.consumePoint = consumePoint;
    }

    public int getPrepayPoint() {
        return prepayPoint;
    }

    public void setPrepayPoint(int prepayPoint) {
        this.prepayPoint = prepayPoint;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroductionPic() {
        return introductionPic;
    }

    public void setIntroductionPic(String introductionPic) {
        this.introductionPic = introductionPic;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public GoodsDetailResponse(int id, String goodsName, int consumePoint, int prepayPoint, String pic, String factoryName, String model, String content, String introduction, String introductionPic, int stock, List<String> pics) {
        this.id = id;
        this.goodsName = goodsName;
        this.consumePoint = consumePoint;
        this.prepayPoint = prepayPoint;
        this.pic = pic;
        this.factoryName = factoryName;
        this.model = model;
        this.content = content;
        this.introduction = introduction;
        this.introductionPic = introductionPic;
        this.stock = stock;
        this.pics = pics;
    }

    public GoodsDetailResponse() {
    }

}
