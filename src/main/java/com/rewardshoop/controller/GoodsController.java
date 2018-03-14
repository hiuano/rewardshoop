package com.rewardshoop.controller;

import com.rewardshoop.model.Goods;
import com.rewardshoop.model.Type;
import com.rewardshoop.response.GoodsDetailResponse;
import com.rewardshoop.response.ResultResponse;
import com.rewardshoop.response.TypeListResponse;
import com.rewardshoop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     *
     * 获取类型列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getTypeList", method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse getTypeList() throws Exception {
        List<TypeListResponse> list = goodsService.getTypeList();
        return list.size() > 0 ? new ResultResponse(true, list) : new ResultResponse(false, "未知错误,请稍后重试");
    }

    /**
     *
     * 获取所有类型
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getType", method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse getType() throws Exception {
        List<Type> list = goodsService.getType();
        return list.size() > 0 ? new ResultResponse(true, list) : new ResultResponse(false, "未知错误,请稍后重试");
    }

    /**
     *
     * 通过类型id获取商品列表
     *
     * @param typeId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getGoodsByTypeId", method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse getGoodsByTypeId(@RequestParam(value = "id") int typeId) throws Exception {
        List<Goods> list = goodsService.getGoodsByTypeId(typeId);
        return new ResultResponse(true, list);
    }


    /**
     *
     *
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "getGoodsDetailById",method = RequestMethod.GET)
    public ResultResponse getGoodsDetailById(@NotNull @RequestParam(value = "id") int id) throws Exception{
        GoodsDetailResponse detail = goodsService.getGoodsDetailById(id);
        return (detail != null ?new ResultResponse(true, detail):new ResultResponse (false, "该商品可能下架或售罄"));
    }

    /**
     *
     *
     *
     * @param typeId
     * @param keyWord
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getGoodsByKeyWord",method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse getGoodsByKeyWord(@NotNull @RequestParam(value = "id") int typeId,String keyWord)throws Exception{
        List<Goods> list = goodsService.getGoodsByKeyWord(typeId,keyWord);
        return (list.size()>0 ?new ResultResponse(true, list):new ResultResponse (false, "要搜索的商品不存在"));
    }
}
