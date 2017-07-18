package com.beisun.dinghao.controller;

import com.beisun.dinghao.model.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DingHao on 2017/7/13.
 */
@Controller
public class MainController extends BaseController {
    private static final Logger log = LogManager.getLogger(MainController.class);

    @RequestMapping("main")
    public String main(HttpServletRequest request, Model model){
        UserModel user = (UserModel) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("userName",user.getUserName());

        return "main";
    }
}
