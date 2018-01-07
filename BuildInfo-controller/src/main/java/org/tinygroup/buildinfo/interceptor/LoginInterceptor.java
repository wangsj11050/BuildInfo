package org.tinygroup.buildinfo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.tinygroup.logger.LogLevel;
import org.tinygroup.logger.Logger;
import org.tinygroup.logger.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * Created by Mr.wang on 2016/7/31.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (null != session.getAttribute("userInfo")) {
            return true;
        }
        logger.logMessage(LogLevel.DEBUG, "未登录");
        String basePath = httpServletRequest.getContextPath();
        String path = "/login/redirect";
        if (basePath != null) {
            path = basePath + path;
        }
        httpServletResponse.sendRedirect(path);
        return  false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
