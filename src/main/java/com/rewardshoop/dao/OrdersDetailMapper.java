package com.rewardshoop.dao;

import com.rewardshoop.model.OrdersDetail;
import com.rewardshoop.model.OrdersDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersDetailMapper {
    int countByExample(OrdersDetailExample example);

    int deleteByExample(OrdersDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrdersDetail record);

    int insertSelective(OrdersDetail record);

    List<OrdersDetail> selectByExample(OrdersDetailExample example);

    OrdersDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrdersDetail record, @Param("example") OrdersDetailExample example);

    int updateByExample(@Param("record") OrdersDetail record, @Param("example") OrdersDetailExample example);

    int updateByPrimaryKeySelective(OrdersDetail record);

    int updateByPrimaryKey(OrdersDetail record);
}