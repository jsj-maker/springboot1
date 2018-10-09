package com.stone.spring.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stone.spring.entity.Button;
import com.stone.spring.entity.CommonButton;
import com.stone.spring.entity.ComplexButton;
import com.stone.spring.entity.Menu;
import com.stone.spring.entity.MiniPMenu;
import com.stone.spring.entity.ViewButton;
import com.stone.spring.thread.TokenThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jisj on 2018/9/2.
 */
public class MenuUtil {

    private static String sgsUrl = "https://mysafeguard-jd.sgsonline.com.cn/app/#/box_lists";
//    private static String sgsUrl = "http://www.baidu.com";


    private static String appId = "wx75647275c5494041";

    /**
     * 封装菜单数据
     * */
    public static Menu getMenu(){
//首先创建二级菜单
 /*       CommonButton cb_1 = new CommonButton();
        cb_1.setKey("key1");
        cb_1.setName("子菜单1");
        cb_1.setType("click");


        CommonButton cb_2 = new CommonButton();
        cb_2.setKey("key2");
        cb_2.setName("子菜单2");
        cb_2.setType("click");

//创建第一个一级菜单
        ComplexButton cx_1 = new ComplexButton();
        cx_1.setName("一级菜单");
        cx_1.setSub_button(new Button[]{cb_1,cb_2});*/

        CommonButton cb_1 = new CommonButton();
        cb_1.setName("关于京曌");
        cb_1.setType("click");
        cb_1.setKey("key1");

        ComplexButton cx_1 = new ComplexButton();
        cx_1.setName("京曌科技");
        cx_1.setSub_button(new Button[]{cb_1});


        ViewButton cx_2 = new ViewButton();
        cx_2.setName("在线下单");
        cx_2.setType("view");
        cx_2.setUrl("https://pro.m.jd.com/mall/active/2MMUFuDMo2kBq6ZyVbcwVRNwnCLg/index.html?utm_source=iosapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=Wxfriends&ad_od=share&ShareTm=Sxm9CYD0/BrKTRuDnQDdwxHRzwHtBQn20gRmSjW8PNi0fyHH6XIQbujr3eJYaXc/NcG2xih5il1MD/8t%2BKQEIyMHOevwDPY1G97su3P/gVlLjcxuGWyfDECS%2B9Acm/gvouqjj8Z2qhyS1BPAwBLtgL2W8hCQQ8YAp9rLQh%2BO9bs=&from=singlemessage&isappinstalled=0");
//        cx_2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId+"&redirect_uri="+sgsUrl+"&response_type=code&scope=snsapi_base&state=xxx");

        //继续创建二级菜单
        ViewButton cb_3 = new ViewButton();
        cb_3.setName("SGS甲醛检测服务");
        cb_3.setType("view");
//        cb_3.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId+"&redirect_uri="+sgsUrl+"&response_type=code&scope=snsapi_base&state=xxx");
        cb_3.setUrl(sgsUrl);

        MiniPMenu cb_4 = new MiniPMenu();
        cb_4.setName("甲醛检测报告");
        cb_4.setType("miniprogram");
        cb_4.setUrl(sgsUrl);
        cb_4.appid = "wx2088031c1512d6ab";

        //创建第二个一级菜单
        ComplexButton cx_3 = new ComplexButton();
        cx_3.setName("我的服务");
        cx_3.setSub_button(new Button[]{cb_3,cb_4});

        //封装菜单数据
        Menu menu=new Menu();
        menu.setButton(new Button[]{cx_1,cx_2,cx_3});

        return menu;
    }


    /**
     * 创建自定义菜单(每天限制1000次)
     * */
    public static int createMenu(Menu menu){
        String jsonMenu= JSON.toJSONString(menu);

        int status= -1;

        System.out.println("菜单："+jsonMenu);
//        String path="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
        try {
            String path="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+ TokenThread.access_token.getAccess_token();
            URL url=new URL(path);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setDoOutput(true);
            http.setDoInput(true);
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.connect();
            OutputStream os = http.getOutputStream();
            os.write(jsonMenu.getBytes("UTF-8"));
            os.close();

            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] bt = new byte[size];
            is.read(bt);
            String message=new String(bt,"UTF-8");
            JSONObject jsonMsg = JSONObject.parseObject(message);
            status = Integer.parseInt(jsonMsg.getString("errcode"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
