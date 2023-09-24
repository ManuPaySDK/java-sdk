import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cpt.bean.UnifiedOrderRequestBean;

import java.util.Map;
import java.util.TreeMap;

public class TestBean2Map {
    public static void main(String[] args) {
        UnifiedOrderRequestBean  unifiedOrderRequest = new UnifiedOrderRequestBean();
        unifiedOrderRequest.setAmount(10000);
        unifiedOrderRequest.setMchOrderNo("P0123456789101");
        unifiedOrderRequest.setClientIp("192.168.0.111");
        unifiedOrderRequest.setReturnUrl("https://www.google.com");
        unifiedOrderRequest.setNotifyUrl("https://www.google.com");

        String orderstring = JSON.toJSONString(unifiedOrderRequest);
        System.out.println("orderstring=" + orderstring);
        TreeMap<String, Object> map = JSON.parseObject(orderstring, new TypeReference<TreeMap<String, Object>>(){});

        StringBuilder rawStringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry:map.entrySet()) {

            System.out.println(entry.getKey() + "=" + entry.getValue());
            if (!rawStringBuilder.isEmpty()) {
                rawStringBuilder.append("&");
            }
            rawStringBuilder.append(entry.getKey()+ "=" + entry.getValue());
        }
        System.out.println("rawString=" + rawStringBuilder.toString());
    }
}
