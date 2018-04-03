package com.commonutil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

public class CommonTest {

    @Test
    public void test() throws Exception {
        String result = "{\n" +
                "      \"EBusinessID\": \"1257021\",\n" +
                "      \"Success\": true,\n" +
                "      \"LogisticCode\": \"3967950525457\",\n" +
                "      \"Shippers\": [\n" +
                "              {\n" +
                "                \"ShipperCode\": \"YD\",\n" +
                "                \"ShipperName\": \"韵达快递\"\n" +
                "              }\n" +
                "            ]\n" +
                "  }";
        JSONObject json = JSONObject.fromObject(result);
        JSONArray array = json.getJSONArray("Shippers");
    }
}
