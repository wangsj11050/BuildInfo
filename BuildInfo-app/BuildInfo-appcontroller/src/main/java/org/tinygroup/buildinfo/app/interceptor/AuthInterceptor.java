package org.tinygroup.buildinfo.app.interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.service.inter.SysMenuService;
import org.tinygroup.buildinfo.service.inter.dto.SysMenuDto;
import org.tinygroup.cache.Cache;
import org.tinygroup.menuframe.config.Menu;
import org.tinygroup.menuframe.dto.MenuInfo;
import org.tinygroup.menuframe.dto.MenuNode;
import org.tinygroup.menuframe.manager.MenuTreeManager;

public class AuthInterceptor implements HandlerInterceptor {
    private static final String USER_AUTH_MENUS = "authMenus";
    private static final String USER_MENU_PATHS = "menuPaths";
    @Autowired
    private MenuTreeManager menuTreeManager;

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
        SysMenuDto menuDto = new SysMenuDto();
        menuDto.setKindCode("BUILDINFO");
        List<Integer> menuIdList = sysMenuService.findAppMenuIds(menuDto);
        List<SysMenuDto> allMenuList = sysMenuService.getSysMenuList(menuDto);
        List<Menu> menuList = new ArrayList<Menu>();
        for(SysMenuDto sysMenuDto:allMenuList){
            Menu menu = BeanUtil.copyProperties(Menu.class,sysMenuDto);
            menu.setId(sysMenuDto.getMenuId());
            menu.setUrl(sysMenuDto.getMenuUrl());
            menuList.add(menu);
        }
        Collections.sort(menuIdList);
        //menuNodeList可以做缓存
        List<MenuNode> menuNodeList = menuTreeManager.getAuthMenuNodeList(menuList,menuIdList);
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
