package com.stone.spring.thread;

import com.stone.spring.entity.AccessToken;

/**
 * Created by jisj on 2018/9/2.
 */
public class TokenThread implements Runnable {
    //微信公众号的凭证和秘钥
    public static final String appID = "wx798ca9299322c8ed";
    public static final String appScret = "01e8ba1cecf43d212ce2ebb294829d34";
    public static AccessToken access_token = null;

    @Override
    public void run() {
       /* while (true) {
            try {
                //调用工具类获取access_token(每日最多获取100000次，每次获取的有效期为7200秒)
                access_token = AccessToken.getAccessToken(appID, appScret);
                if (null != access_token) {
                    System.out.println("accessToken获取成功：" + access_token.getExpires_in());
                    //7000秒之后重新进行获取
                    Thread.sleep((access_token.getExpires_in() - 200) * 1000);
                } else {
                    //获取失败时，60秒之后尝试重新获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        access_token = AccessToken.getAccessToken(appID, appScret);
    }

}
