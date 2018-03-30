package com.rewardshoop.dao;

import com.rewardshoop.model.OrdersStateDesc;
import com.rewardshoop.model.OrdersStateDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersStateDescMapper {
    int countByExample(OrdersStateDescExample example);

    int deleteByExample(OrdersStateDescExample example);

    int insert(OrdersStateDesc record);

    int insertSelective(OrdersStateDesc record);

    List<OrdersStateDesc> selectByExample(OrdersStateDescExample example);

    int updateByExampleSelective(@Param("record") OrdersStateDesc record, @Param("example") OrdersStateDescExample example);

    int updateByExample(@Param("record") OrdersStateDesc record, @Param("example") OrdersStateDescExample example);
}