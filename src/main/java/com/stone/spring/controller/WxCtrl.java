package com.stone.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.stone.spring.entity.BaseEntity;
import com.stone.spring.thread.TokenThread;
import com.stone.spring.util.CheckUtil;
import com.stone.spring.util.MenuUtil;
import com.stone.spring.util.ResultUtil;

import java.util.List;

@Controller
@RequestMapping("wx/")
public class WxCtrl {


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "wx_check", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String postLogin(@RequestParam String  signature,@RequestParam String  timestamp,@RequestParam String  nonce,
                            @RequestParam String  echostr) {
        if(CheckUtil.checkSignature(signature, timestamp, nonce)){
            return echostr;
        }
        return "";
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value="/createMenu",method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseEntity createMenu(){
//调用UTI执行创建菜单的动作
        int status = MenuUtil.createMenu(MenuUtil.getMenu());
        if(status==0){

            System.out.println("菜单创建成功！");
            return ResultUtil.getResultSuccess("createMenu","菜单创建成功！",true);
        }else{
            TokenThread thread = new TokenThread();
            new Thread(thread).start();
            System.out.println("菜单创建失败！");
            return  ResultUtil.getResultSuccess("createMenu","菜单创建失败！",false);
        }

    }



}
