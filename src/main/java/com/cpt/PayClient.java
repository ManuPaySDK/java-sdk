package com.cpt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cpt.bean.CommonRequestInfoBean;
import com.cpt.bean.UnifiedOrderRequestBean;
import com.cpt.bean.UnifiedOrderResponseBean;
import com.cpt.util.HttpUtil;
import com.cpt.util.Md5Util;

import java.util.Map;
import java.util.TreeMap;

public class PayClient {
    String MachNo;
    String PrivateSecret;

    String Url;

    public PayClient(String machNo, String privateSecret, String url) {
        MachNo = machNo;
        PrivateSecret = privateSecret;
        Url = url;
    }
    public String getMachNo() {
        return MachNo;
    }

    public void setMachNo(String machNo) {
        MachNo = machNo;
    }

    public String getPrivateSecret() {
        return PrivateSecret;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public void setPrivateSecret(String privateSecret) {
        PrivateSecret = privateSecret;
    }

    public JSONObject convert(TreeMap<String, Object> map) {
        JSONObject json = new JSONObject();

        for (Map.Entry<String, Object> entry:map.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }
        return json ;
    }

    public UnifiedOrderResponseBean PlaceUnifiedOrder(UnifiedOrderRequestBean requestBean) {
        CommonRequestInfoBean commonRequestInfoBean = new CommonRequestInfoBean();

        commonRequestInfoBean.setMchNo(getMachNo());
        commonRequestInfoBean.setReqTime(System.currentTimeMillis());
        //commonRequestInfoBean.setReqTime(1695481735108L);
        String commoninfostr = JSON.toJSONString(commonRequestInfoBean);
        TreeMap<String, Object> commoninfomap = JSON.parseObject(commoninfostr, new TypeReference<TreeMap<String, Object>>(){});
        String requeststr = JSON.toJSONString(requestBean);
        TreeMap<String, Object> requeststrmap = JSON.parseObject(requeststr, new TypeReference<TreeMap<String, Object>>(){});
        requeststrmap.putAll(commoninfomap);

        StringBuilder rawStringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry:requeststrmap.entrySet()) {
            if (!rawStringBuilder.isEmpty()) {
                rawStringBuilder.append("&");
            }
            rawStringBuilder.append(entry.getKey()+ "=" + entry.getValue());
        }
        rawStringBuilder.append("&key=").append(getPrivateSecret());

        try {
            //commonRequestInfoBean.setSign(Md5Util.md5(rawStringBuilder.toString()));
            String rawstr = rawStringBuilder.toString(); //.replace(" ", "");
            String signval = Md5Util.md5(rawstr);
           // System.out.println("rawsignsrc=" + rawstr);
          //  System.out.println("sign=" + signval);
            requeststrmap.put("sign", signval.toUpperCase());
        } catch (Exception e) {
          //  System.out.println("md5sum ex=" + e);
        }
      //  requeststrmap.remove("key");

        String postparam = convert(requeststrmap).toJSONString();
      //  System.out.println("maps=" + postparam);

        String result1 = HttpUtil.getInstance().post(getUrl(), postparam);

        //System.out.println("result=" + result1);

        UnifiedOrderResponseBean unifiedOrderResponseBean = JSONObject.parseObject(result1, UnifiedOrderResponseBean.class);

        return unifiedOrderResponseBean;
    }

}
