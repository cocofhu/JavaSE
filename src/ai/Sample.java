package ai;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "14975064";
    public static final String API_KEY = "rGRkL2GpdpTmF5ht6fGZbZPx";
    public static final String SECRET_KEY = "cCh0Vhtysbp1itwofr9c6clNlqogaXIt";

    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "D:\\88.jpg";
        JSONObject res = client.detect(path,"jpg", new HashMap<String, String>());
        System.out.println(res.toString(2));
        
    }
}