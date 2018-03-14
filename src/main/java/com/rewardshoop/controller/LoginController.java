package com.rewardshoop.controller;

import com.rewardshoop.model.IndexPic;
import com.rewardshoop.model.User;
import com.rewardshoop.response.ResultResponse;
import com.rewardshoop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     *
     * 根据thirdSession,向会员中心的后台获取用户信息
     *
     * @param thirdSession
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse getUserInfo (String thirdSession) throws Exception {
        User user = loginService.getUserInfo(thirdSession);
        return new ResultResponse(true,user);
    }

    /**
     *
     * 获取首页轮播图
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getIndexPic",method = RequestMethod.GET)
    public ResultResponse getIndexPic(){
        List<IndexPic> list = loginService.getIndexPic();
        return new ResultResponse(true,list);
    }
}
