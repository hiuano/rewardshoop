package com.rewardshoop.service.impl;

import com.rewardshoop.dao.UserMapper;
import com.rewardshoop.daoExt.AddressDao;
import com.rewardshoop.model.Address;
import com.rewardshoop.model.AddressExample;
import com.rewardshoop.model.User;
import com.rewardshoop.request.AddressRequest;
import com.rewardshoop.response.AddressResponse;
import com.rewardshoop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service("AddressService")
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private UserMapper userMapper;

    private static List<AddressResponse> listAddressResponse = new ArrayList<>();

    @Override
    public List<Address> getAddressByUserId(int userId) {
        AddressExample example = new AddressExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return addressDao.selectByExample(example);
    }

    @Override
    public List<Address> deleteAddressById(int userId, int addId) {
        AddressExample example = new AddressExample();
        example.createCriteria().andUserIdEqualTo(userId).andAddIdEqualTo(addId);
        addressDao.deleteByExample(example);
        example.clear();
        example.createCriteria().andUserIdEqualTo(userId);
        return addressDao.selectByExample(example);

    }

    @Override
    public Address getAddressByAddId(int userId, int addId) {
        AddressExample example = new AddressExample();
        AddressExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);

        if (addId == 0) {
            example.setOrderByClause("add_id asc");
            List<Address> list = addressDao.selectByExample(example);

            if (list.size() == 0) {
                addId = 1;
            } else {
                for (int i = 0; i < list.size(); i++) {
                    addId = list.get(i).getAddId() + 1;
                    try {
                        if (addId < list.get(i + 1).getAddId()) {
                            break;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        break;
                    }
                }
            }

            Address address = new Address();
            address.setAddId(addId);
            address.setUserId(userId);
            address.setProvince("广东省");
            address.setCity("佛山市");
            address.setArea("顺德区");
            return address;
        } else {
            criteria.andAddIdEqualTo(addId);
            return addressDao.selectByExample(example).get(0);
        }
    }

    public List<AddressResponse> getAllAddressDetail() throws Exception {
        if (listAddressResponse.size() == 0) {
            listAddressResponse = addressDao.getAllAddressDetail();
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    listAddressResponse.clear();
                }
            };
            timer.schedule(timerTask, 2 * 60 * 60 * 1000);
        }

        return listAddressResponse;


    }

    @Override
    public void updataAddress(AddressRequest addressRequest) throws Exception {
        Address address = new Address();
        address.setArea(addressRequest.getArea());
        address.setCity(addressRequest.getCity());
        address.setProvince(addressRequest.getProvince());
        address.setUserId(addressRequest.getUserId());
        address.setAddId(addressRequest.getAddId());
        address.setDescription(addressRequest.getDescription());
        address.setId(addressRequest.getId());
        address.setName(addressRequest.getName());
        address.setPhone(addressRequest.getPhone());
        address.setPostNo(addressRequest.getPostNo());
        address.setStreet(addressRequest.getStreet());

        int userId = address.getUserId();
        //如果主键为null,则证明这条是新增
        if (address.getId() == null) {
            addressDao.insert(address);
            //如果addId==1,先查看user的默认地址是否为0,如果为0,这证明这是第一个地址,必须设置为默认
            if (address.getAddId() == 1) {
                User user = userMapper.selectByPrimaryKey(userId);
                if (user.getDefaultAddId() == 0) {
                    user.setDefaultAddId(address.getAddId());
                    userMapper.updateByPrimaryKey(user);
                }
            }
        } else {
            addressDao.updateByPrimaryKey(address);
        }
    }
}
