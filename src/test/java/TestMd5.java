import com.cpt.util.Md5Util;

public class TestMd5 {
    public static void main(String[] args) {
        try {
            String data = "amount=800&body=toysDesc&currency=inr&expiredTime=3600&extParam={\"address\":\"foshan district\",\"city\":\"guangzhou\",\"country\":\"IN\",\"email\":\"ck789@gmail.com\",\"firstname\":\"cy\",\"lastname\":\"harper\",\"phone\":\"4401000001\",\"postcode\":\"232001\",\"state\":\"mh\"}&mchNo=MC1702569748987908096&mchOrderNo=portal20230918044&notifyUrl=https://www.jpdb001.com/notifyUrl&reqTime=1695474779371&returnUrl=https://www.jpdb001.com/returnUrl&subject=toys&wayCode=SAIL_CASHIER&key=bDwJP1Ug17mKwq9xqlULT98IQ90QKNgqu9jx2jeF0LCntbwLTlupNPnKtLwAXnY6ZwIgfNGwQC1qDPg2qjhy8nySKZmCylcKjt1YTI";
            String md5 = Md5Util.md5(data);
            System.out.println(md5);
        } catch (Exception e) {
            System.out.println("error md5 info");
        }
    }
}
