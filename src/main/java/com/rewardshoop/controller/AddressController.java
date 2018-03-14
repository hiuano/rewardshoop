package com.rewardshoop.controller;

import com.rewardshoop.model.Address;
import com.rewardshoop.request.AddressRequest;
import com.rewardshoop.response.AddressResponse;
import com.rewardshoop.response.ResultResponse;
import com.rewardshoop.service.AddressService;
import com.rewardshoop.validated.deleteAddressByAddId;
import com.rewardshoop.validated.updataAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "getAddressByUserId", method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse getAddressByUserId(int userId) throws Exception {
        List<Address> list = addressService.getAddressByUserId(userId);
        return new ResultResponse(true, list);
    }

    @ResponseBody
    @RequestMapping(value = "deleteAddressByAddId", method = RequestMethod.POST)
    public ResultResponse deleteAddressByAddId(@Validated(value = deleteAddressByAddId.class) @RequestBody AddressRequest request, BindingResult br) throws Exception {
        if (br.hasErrors()) {
            List<ObjectError> errorList = br.getAllErrors();
            return new ResultResponse(false, errorList.get(0).getDefaultMessage());
        }

        int userId = request.getUserId();
        int addId = request.getAddId();
        List<Address> list = addressService.deleteAddressById(userId, addId);
        return new ResultResponse(true, list);
    }

    @ResponseBody
    @RequestMapping(value = "getAddressByAddId", method = RequestMethod.GET)
    public ResultResponse getAddressByAddId(int userId, int addId) throws Exception {
        Address address = addressService.getAddressByAddId(userId, addId);
        return new ResultResponse(true, address);
    }

    @RequestMapping(value = "getAllAddressDetail", method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse getAllAddressDetail() throws Exception {
        List<AddressResponse> list = addressService.getAllAddressDetail();
        return new ResultResponse(true, list);
    }

    @ResponseBody
    @RequestMapping(value = "updataAddress", method = RequestMethod.POST)
    public ResultResponse updataAddress(@Validated(value = updataAddress.class) @RequestBody AddressRequest address, BindingResult br) throws Exception {
        if (br.hasErrors()) {
            List<ObjectError> errorList = br.getAllErrors();
            return new ResultResponse(false, errorList.get(0).getDefaultMessage());
        }
        addressService.updataAddress(address);
        return new ResultResponse(true);
    }
}
