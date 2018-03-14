package com.rewardshoop.response;

import com.rewardshoop.model.Goods;

import java.util.List;

public class TypeListResponse {
    private int id;
    private String pic;
    private String name;
    private List<Goods> goods;

    public TypeListResponse() {
    }

    public TypeListResponse(int id, String pic, String name, List<Goods> goods) {
        this.id = id;
        this.pic = pic;
        this.name = name;
        this.goods = goods;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "TypeListResponse{" +
                "id='" + id + '\'' +
                ", pic='" + pic + '\'' +
                ", name='" + name + '\'' +
                ", goods=" + goods +
                '}';
    }
}
