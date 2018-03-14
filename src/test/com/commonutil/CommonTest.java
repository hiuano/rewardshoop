package com.commonutil;

import com.rewardshoop.constants.CommonConst;
import com.rewardshoop.utils.CommonUtil;
import com.rewardshoop.utils.NetworkUtil;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CommonTest {

    @Test
    public void test() {
        String url = CommonUtil.stitching(CommonConst.Starshine_Center_Url, "api/withDrawByType");
        Map<String, String> map = new HashMap<>();
        map.put("userId", "6044");
        map.put("payPwd", "135135");
        map.put("totalConsumePoint", "1000000");
        map.put("totalPrepayPoint", "10000");

        String out = JSONObject.fromObject(map).toString();
        String result = NetworkUtil.httpsRequest(url, "POST", out);
        System.out.println(result);

    }
}
