package com.rewardshoop.service.impl;

import com.rewardshoop.dao.TypeMapper;
import com.rewardshoop.daoExt.GoodsDao;
import com.rewardshoop.model.Goods;
import com.rewardshoop.model.GoodsExample;
import com.rewardshoop.model.Type;
import com.rewardshoop.model.TypeExample;
import com.rewardshoop.response.GoodsDetailResponse;
import com.rewardshoop.response.TypeListResponse;
import com.rewardshoop.service.GoodsService;
import com.rewardshoop.utils.CommonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("GoodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<TypeListResponse> getTypeList() throws Exception {
        return goodsDao.getTypeList();
    }

    @Override
    public List<Type> getType() throws Exception {
        TypeExample example = new TypeExample();
        example.createCriteria();
        List<Type> list = typeMapper.selectByExample(example);
        Collections.sort(list, new Comparator<Type>() {

            @Override
            public int compare(Type o1, Type o2) {
                return o1.getId() < o2.getId() ? -1 : 1;
            }
        });
        return list;
    }

    @Override
    public List<Goods> getGoodsByTypeId(int typeId) throws Exception {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        if (typeId > 1) {
            criteria.andTypeIdEqualTo(typeId);
        }
        List<Goods> list = goodsDao.selectByExample(example);
        return list;
    }

    @Override
    public GoodsDetailResponse getGoodsDetailById(int id) throws Exception {
        GoodsDetailResponse detail = goodsDao.getGoodsDetailById(id);
        if (detail != null) {
            List<String> list = CommonUtil.stringToList(detail.getIntroductionPic());
            detail.setPics(list);
        }
        return detail;
    }

    @Override
    public List<Goods> getGoodsByKeyWord(int typeId, String keyWord) throws Exception {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(keyWord)) {
            keyWord = new String(keyWord.getBytes("ISO-8859-1"), "UTF-8");
            keyWord = CommonUtil.stitching("%", keyWord, "%");
            criteria.andGoodsNameLike(keyWord);
        }
        if (typeId > 1) {
            criteria.andTypeIdEqualTo(typeId);
        }
        List<Goods> list = goodsDao.selectByExample(example);
        return list;
    }


}
