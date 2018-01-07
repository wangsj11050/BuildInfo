package org.tinygroup.buildinfo.action.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;

/**
 * Created by Mr.wang on 2016/7/28.
 */
@Controller
@RequestMapping("/login")
public class LoginAction extends BaseController{
    @RequestMapping("")
    public String execute(){
        return "/login/login";
    }

    @RequestMapping("/redirect")
    public String redirectLogin(){
        return "/login_redirect";
    }

}
