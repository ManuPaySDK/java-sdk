import com.cpt.PayClient;
import com.cpt.bean.UnifiedOrderRequestBean;
import com.cpt.bean.UnifiedOrderResponseBean;

import java.util.HashMap;

public class testPlaceOrder {
    public static void main(String[] args) {
        HashMap<String, Object> mapparam = new HashMap<>();
        mapparam.put("firstname","cy");
        mapparam.put("lastname", "harper");
        mapparam.put("city", "guangzhou");
        mapparam.put("phone", "4401000001");
        mapparam.put("email", "ck789@gmail.com");
        mapparam.put("country", "IN");
        mapparam.put("address", "foshan district");
        mapparam.put("state", "mh");
        mapparam.put("postcode", "232001");

        UnifiedOrderRequestBean unifiedOrderRequestBean = new UnifiedOrderRequestBean();
        unifiedOrderRequestBean.setAmount(800);
        unifiedOrderRequestBean.setBody("toysDesc");
        unifiedOrderRequestBean.setCurrency("inr");
        unifiedOrderRequestBean.setExpiredTime(3600);
        unifiedOrderRequestBean.setMchOrderNo("portal20230918050");
        unifiedOrderRequestBean.setWayCode("SAIL_CASHIER");
        unifiedOrderRequestBean.setSubject("toys");
        unifiedOrderRequestBean.setNotifyUrl("https://www.jpdb001.com/notifyUrl");
        unifiedOrderRequestBean.setReturnUrl("https://www.jpdb001.com/returnUrl");
        unifiedOrderRequestBean.setExtParam(mapparam.toString());

        PayClient client = new PayClient("MC1702569748987908096",
                "bDwJP1Ug17mKwq9xqlULT98IQ90QKNgqu9jx2jeF0LCntbwLTlupNPnKtLwAXnY6ZwIgfNGwQC1qDPg2qjhy8nySKZmCylcKjt1YTI",
                "https://pay-server-test.exlinkedev.com/pay/order/place");

        UnifiedOrderResponseBean response = client.PlaceUnifiedOrder(unifiedOrderRequestBean);

        System.out.println("response=" + response.toString());
    }
}
