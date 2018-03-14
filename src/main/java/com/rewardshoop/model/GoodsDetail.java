package com.rewardshoop.model;

public class GoodsDetail {
    private Integer id;

    private Integer goodsId;

    private String factoryName;

    private String model;

    private String content;

    private String introduction;

    private String introductionPic;

    private Integer stock;

    public GoodsDetail(Integer id, Integer goodsId, String factoryName, String model, String content, String introduction, String introductionPic, Integer stock) {
        this.id = id;
        this.goodsId = goodsId;
        this.factoryName = factoryName;
        this.model = model;
        this.content = content;
        this.introduction = introduction;
        this.introductionPic = introductionPic;
        this.stock = stock;
    }

    public GoodsDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getIntroductionPic() {
        return introductionPic;
    }

    public void setIntroductionPic(String introductionPic) {
        this.introductionPic = introductionPic == null ? null : introductionPic.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}