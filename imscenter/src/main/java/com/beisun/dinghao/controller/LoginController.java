package com.beisun.dinghao.controller;

import com.beisun.dinghao.model.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by DingHao on 2017/7/11.
 */
@Controller
public class LoginController extends BaseController {
    private static final Logger log = LogManager.getLogger(LoginController.class);

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user", new UserModel());
        return "/login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, Model model){
        String msg = "";
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new
                UsernamePasswordToken(userName,password);
        try {

            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated()) {
                log.info("======登陆成功=======");
                return "redirect:/main";
            } else {
                return "login";
            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + usernamePasswordToken.getPrincipal() + " was incorrect.";
            System.out.println(msg);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多，请10分钟后重试。";
            System.out.println(msg);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + usernamePasswordToken.getPrincipal() + " was locked.";
            System.out.println(msg);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + usernamePasswordToken.getPrincipal() + " was disabled.";
            System.out.println(msg);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + usernamePasswordToken.getPrincipal() + "  was expired.";
            System.out.println(msg);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + usernamePasswordToken.getPrincipal();
            System.out.println(msg);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
            System.out.println(msg);
        } catch (Exception e) {
            log.error("======登陆异常=======");
            log.error(e.getMessage());
            msg = "登录出现异常！";
            e.printStackTrace();
        }
        model.addAttribute("message", msg);
        return "login";
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(){
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        //redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:/login";
    }
}
