package com.stone.spring.entity;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jisj on 2018/9/2.
 */
public class AccessToken {


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    private String access_token;//获取到的access_token
    private int expires_in;//有效时间（两个小时，7200s）

    /**
     * 获取accessToken
     * @param appID 微信公众号凭证
     * @param appScret 微信公众号凭证秘钥
     * @return
     */
    public static AccessToken getAccessToken(String appID, String appScret) {
        AccessToken token = new AccessToken();
// 访问微信服务器
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appID + "&secret="
                + appScret;
        try {
            URL getUrl=new URL(url);
            HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);


            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] b = new byte[size];
            is.read(b);

            String message = new String(b, "UTF-8");

            JSONObject json = JSONObject.parseObject(message);


            token.setAccess_token(json.getString("access_token"));
            token.setExpires_in(new Integer(json.getString("expires_in")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

}
