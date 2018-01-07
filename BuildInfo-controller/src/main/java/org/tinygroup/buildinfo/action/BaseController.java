package org.tinygroup.buildinfo.action;

import org.tinygroup.beancontainer.BeanContainerFactory;
import org.tinygroup.cache.Cache;
import org.tinygroup.convert.objectjson.fastjson.ObjectToJson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mr.wang on 2016/6/12.
 */
public class BaseController {
    private Cache cache;
    /**
     * 拼装前台Ajax请求结果
     *
     * @param result
     * @param msg
     * @return
     */
    protected Map<String, String> resultMap(boolean result, final String msg) {
        Map<String, String> map = new HashMap<String, String>();
        if (result) {
            map.put("status", "y");
        } else {
            map.put("status", "n");
        }
        map.put("info", msg);
        return map;
    }

    /**
     * 拼装前台Ajax请求结果
     * 返回状态为int类型
     * @param result
     * @param msg
     * @return
     */
    protected Map<?, ?> resultMap(Integer result, final String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", result);
        map.put("info", msg);
        return map;
    }

    /**
     * 客户端返回JSON字符串
     *
     * @param response
     * @param object
     * @return
     */
    protected String renderString(HttpServletResponse response, Object object) {
        ObjectToJson objectToJson = new ObjectToJson();
        return renderString(response, objectToJson.convert(object), "application/json");
    }
    
    /**
     * 客户端返回字符串
     *
     * @param response
     * @param string
     * @return
     */
    protected String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
        }
        return null;
    }
    protected Cache getCache(){
        if(cache==null){
            cache = BeanContainerFactory.getBeanContainer(BaseController.class.getClassLoader()).getBean("cacheBean");
        }
        return cache;
    }
}
