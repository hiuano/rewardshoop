package com.rewardshoop.request;

import com.rewardshoop.model.Address;
import com.rewardshoop.validated.deleteAddressByAddId;
import com.rewardshoop.validated.updataAddress;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddressRequest extends Address {
    @Min(value = 0, message = "{NOT_LESS_THAN_THE_MIN}", groups = {deleteAddressByAddId.class})
    private int userId;
    @Min(value = 0, message = "{NOT_LESS_THAN_THE_MIN}", groups = {deleteAddressByAddId.class})
    private int addId;

    private Integer id;

    @NotNull(message = "姓名{NOT_NULL}", groups = {updataAddress.class})
    private String name;

    @NotNull(message = "电话{NOT_NULL}", groups = {updataAddress.class})
    private String phone;

    private String province;

    private String city;

    private String area;

    @NotNull(message = "街道{NOT_NULL}", groups = {updataAddress.class})
    private String street;

    @NotNull(message = "详细地址{NOT_NULL}", groups = {updataAddress.class})
    private String description;

    private Integer postNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPostNo() {
        return postNo;
    }

    public void setPostNo(Integer postNo) {
        this.postNo = postNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }
}
