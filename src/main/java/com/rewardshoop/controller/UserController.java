package com.rewardshoop.controller;

import com.rewardshoop.request.UserRequest;
import com.rewardshoop.response.ResultResponse;
import com.rewardshoop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "updataDefaultAddId", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse updataDefaultAddId(@Validated @RequestBody UserRequest request) throws Exception {
        int id = request.getId();
        int defaultAddId = request.getDefaultAddId();
        userService.updataDefaultAddId(id, defaultAddId);
        return new ResultResponse(true);
    }

}
