package com.rewardshoop.daoExt;

import com.rewardshoop.dao.AddressMapper;
import com.rewardshoop.response.AddressResponse;

import java.util.List;

public interface AddressDao extends AddressMapper {

    /**
     * 获取地区数据
     *
     * @return
     * @throws Exception
     */
    public List<AddressResponse> getAllAddressDetail() throws Exception;
}
