package cn.steamedfish.baiduAI;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.imageclassify.AipImageClassify;

/**
 * 调用ai样例
 * @author zzy
 *
 */

/*
 * 1.连接必须是static 以确保返回一个token，也就是说所有的servlet 共用一个client
 * 2.注释的地方是默认的，可以不设置
 * 3.sample为使用方法
 *
 */


public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "11275379 ";
    public static final String API_KEY = "OXCBDpnGQHcCoAy9zLO0Gb6K";
    public static final String SECRET_KEY = "87CDg2uxGrHkxSjOzOtOhPvUjr83nAnf";

    public static void main(String[] args) {
        // 初始化一个AipImageClassifyClient
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        sample(client);
       // String path = "test.jpg";
       // JSONObject res = client.objectDetect(path, new HashMap<String, String>());
       // System.out.println(res.toString(2));
        
    }
    public static void sample(AipImageClassify client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        // 参数为本地图片路径
        String image = "image/test.jpg";
        JSONObject res = client.advancedGeneral(image, options);
        System.out.println(res.toString(2));
        
        ClassifyResult cr=new ClassifyResult(res);
        cr.print();
        ClassifyResult cr2=new ClassifyResult(res);
        System.out.print(cr2.sameWith(cr));
    }  

}
