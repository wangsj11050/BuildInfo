package org.tinygroup.buildinfo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.service.inter.SysMenuService;
import org.tinygroup.buildinfo.service.inter.dto.SysMenuDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.UserInfo;
import org.tinygroup.cache.Cache;
import org.tinygroup.menuframe.config.Menu;
import org.tinygroup.menuframe.dto.MenuInfo;
import org.tinygroup.menuframe.dto.MenuNode;
import org.tinygroup.menuframe.manager.MenuTreeManager;
import org.tinygroup.menuframe.manager.UserAuthManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuthInterceptor implements HandlerInterceptor {
    private static final String USER_AUTH_MENUS = "authMenus";
    private static final String USER_MENU_PATHS = "menuPaths";
    @Autowired
    private MenuTreeManager menuTreeManager;

    @Autowired
    private UserAuthManager userAuthManager;

    private SysMenuService sysMenuService;

    private Cache cache;

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public SysMenuService getSysMenuService() {
        return sysMenuService;
    }

    public void setSysMenuService(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

	/**
     * 登录控制
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestUrl = httpServletRequest.getRequestURI()
                .replace(httpServletRequest.getContextPath(), "");
        UserInfo userInfo = (UserInfo) httpServletRequest.getSession().getAttribute("userInfo");
        List<Integer> userMenuIdList = sysMenuService.findMenuIdsByUser(userInfo.getUserId());
        List<SysMenuDto> allMenuList = sysMenuService.getSysMenuList(null);
        List<Menu> menuList = new ArrayList<Menu>();
        for(SysMenuDto sysMenuDto:allMenuList){
            Menu menu = BeanUtil.copyProperties(Menu.class,sysMenuDto);
            menu.setId(sysMenuDto.getMenuId());
            menu.setUrl(sysMenuDto.getMenuUrl());
            menuList.add(menu);
        }
        Collections.sort(userMenuIdList);
        //menuNodeList可以做缓存
        List<MenuNode> menuNodeList = menuTreeManager.getAuthMenuNodeList(menuList,userMenuIdList);
        //分成两步是为了方便缓存
        MenuInfo menuInfo = menuTreeManager.getAuthMenuInfo(requestUrl,menuNodeList);
        
        httpServletRequest.setAttribute(USER_MENU_PATHS,menuInfo.getMenuPaths());
        httpServletRequest.setAttribute(USER_AUTH_MENUS,menuInfo.getMenuList());
        return true;
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 异常处理
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
