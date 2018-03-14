package com.rewardshoop.service;

import com.rewardshoop.model.Address;
import com.rewardshoop.request.AddressRequest;
import com.rewardshoop.response.AddressResponse;

import java.util.List;

public interface AddressService {

    /**
     * 根据userId获取地址
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Address> getAddressByUserId(int userId) throws Exception;

    /**
     * 删除地址
     *
     * @param userId
     * @param addId
     * @return
     * @throws Exception
     */
    public List<Address> deleteAddressById(int userId, int addId) throws Exception;

    /**
     * 获取当前地址,如果addid为0,则返回一个new address()
     *
     * @param userId
     * @param addId
     * @return
     * @throws Exception
     */
    public Address getAddressByAddId(int userId, int addId) throws Exception;

    /**
     * 获取中国地区所有地方列表
     *
     * @return
     * @throws Exception
     */
    public List<AddressResponse> getAllAddressDetail() throws Exception;

    /**
     * 更新,如果id为null,则是插入,同时addid=1,则设置为默认,其余为更新
     *
     * @param addressRequest
     * @throws Exception
     */
    public void updataAddress(AddressRequest addressRequest) throws Exception;
}
