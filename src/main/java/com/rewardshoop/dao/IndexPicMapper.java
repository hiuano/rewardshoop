package com.rewardshoop.dao;

import com.rewardshoop.model.IndexPic;
import com.rewardshoop.model.IndexPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexPicMapper {
    int countByExample(IndexPicExample example);

    int deleteByExample(IndexPicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndexPic record);

    int insertSelective(IndexPic record);

    List<IndexPic> selectByExample(IndexPicExample example);

    IndexPic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndexPic record, @Param("example") IndexPicExample example);

    int updateByExample(@Param("record") IndexPic record, @Param("example") IndexPicExample example);

    int updateByPrimaryKeySelective(IndexPic record);

    int updateByPrimaryKey(IndexPic record);
}