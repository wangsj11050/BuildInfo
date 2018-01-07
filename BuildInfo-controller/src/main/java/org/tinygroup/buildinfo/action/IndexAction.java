package org.tinygroup.buildinfo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.service.inter.dto.complex.UserInfo;

import javax.servlet.http.HttpSession;

/**
 * Created by Mr.wang on 2016/7/31.
 */
@Controller
public class IndexAction extends BaseController{
    @RequestMapping("/sys/index")
    public String execute(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        return "biz/index";
    }
}
