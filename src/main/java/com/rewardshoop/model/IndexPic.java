package com.rewardshoop.model;

public class IndexPic {
    private Integer id;

    private Integer goodsId;

    private String pic;

    private Integer isSelect;

    public IndexPic(Integer id, Integer goodsId, String pic, Integer isSelect) {
        this.id = id;
        this.goodsId = goodsId;
        this.pic = pic;
        this.isSelect = isSelect;
    }

    public IndexPic() {
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }
}