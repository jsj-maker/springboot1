package com.stone.spring.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.stone.spring.thread.TokenThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by jisj on 2018/9/2.
 */
public class StartInit implements ServletContextListener {
    // 系统初始化执行方法
    public void contextDestroyed(ServletContextEvent e) {
    }

    public void contextInitialized(ServletContextEvent e) {
        // 获取项目根目录
        String root_path  = e.getServletContext().getRealPath("/");
        TokenThread thread = new TokenThread();
//        new Thread(thread).start();
    }




//    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
}
