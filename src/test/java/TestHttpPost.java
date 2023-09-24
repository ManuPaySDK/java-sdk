import com.cpt.util.HttpUtil;

public class TestHttpPost {
    public static void main(String[] args) {
        /*
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://10.10.61.156:10018/zaibo/inner/stack");
        String jsonParams = "{\"name\":\"karl\",\"age\":18,\"cmd\":\"TPLC\",\"imei\":\"1233\",\"slaveAddr\":\"12323\"}";
        StringEntity paramsEntity = new StringEntity(jsonParams, "utf-8");
        paramsEntity.setContentType("application/json");
    httpPost.setEntity(paramsEntity);
        try {
            HttpResponse response = httpclient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity(), "utf-8");

            System.out.println("response=" + result);
        }catch (Exception e) {
            System.out.println("got response=" + e);
        }
         */
        String jsonParams = "{\"name\":\"karl\",\"age\":18,\"cmd\":\"TPLC\",\"imei\":\"1233\",\"slaveAddr\":\"12323\"}";
        String result1 = HttpUtil.getInstance().post("http://10.10.61.156:10018/zaibo/inner/stack", jsonParams);
        System.out.println("result1=" + result1);
        String result2 = HttpUtil.getInstance().post("http://10.10.61.156:10018/zaibo/inner/command", jsonParams);
        System.out.println("result2=" + result2);
    }
}
