package com.rewardshoop.service.impl;

import com.rewardshoop.constants.CommonConst;
import com.rewardshoop.dao.IndexPicMapper;
import com.rewardshoop.dao.UserMapper;
import com.rewardshoop.model.IndexPic;
import com.rewardshoop.model.IndexPicExample;
import com.rewardshoop.model.User;
import com.rewardshoop.service.LoginService;
import com.rewardshoop.utils.CommonUtil;
import com.rewardshoop.utils.NetworkUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("LoginService")
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IndexPicMapper indexPicMapper;

    @Override
    public User getUserInfo(String thirdSession) throws Exception {
        String url = CommonUtil.stitching(CommonConst.Starshine_Center_Url, "login/reflash?thirdSession=",thirdSession);

        //网络请求数据
        String result = NetworkUtil.httpsRequest(url, "GET", null);
        JSONObject json = JSONObject.fromObject(result);
        int id = json.getInt("id");

        // 从本地数据库读取用户信息
        User user = userMapper.selectByPrimaryKey(id);

        //如果用户为空
        if (user == null) {
            user = new User();
            user.setId(id);
            user.setDefaultAddId(0);
            user.setIsy(json.getInt("isy"));
            user.setUserLevel(json.getInt("level"));
            user.setUserName(json.getString("name"));
            user.setUserPhone(json.getString("phone"));

            userMapper.insert(user);
        }

        return user;
    }

    @Override
    public List<IndexPic> getIndexPic() {
        IndexPicExample example = new IndexPicExample();
        example.createCriteria().andIsSelectEqualTo(1);
        List<IndexPic> list = indexPicMapper.selectByExample(example);
        return list;
    }
}
