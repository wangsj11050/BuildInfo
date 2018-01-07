package org.tinygroup.buildinfo.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.tinygroup.logger.LogLevel;
import org.tinygroup.logger.Logger;
import org.tinygroup.logger.LoggerFactory;

public class BusiExceptionResolver implements HandlerExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(BusiExceptionResolver.class);

	/**
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @return
	 */
	@ResponseBody
	public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
		
		logger.error(ex);
		String message = "出现异常!";
		ModelAndView model = new ModelAndView();
		//对存在子记录的数据异常进行捕获  SQL完整性约束冲突异常
    	if(ex.getCause() instanceof InvocationTargetException){
    		InvocationTargetException invocationTargetException = (InvocationTargetException)ex.getCause();
    		if(invocationTargetException.getTargetException().getCause() instanceof SQLIntegrityConstraintViolationException){
				if(invocationTargetException.getTargetException().getCause().getMessage().contains("唯一")){
					message="失败,已经存在！";
				}else{
					message = "失败,存在子记录!";
				}
    		}
    	}
    	//判断是否ajax
    	if((request.getHeader("X-Requested-With") != null  && "XMLHttpRequest".equals( request.getHeader("X-Requested-With").toString()))){
    		MappingJackson2JsonView view = new MappingJackson2JsonView();
    		Map attributes = new HashMap();
    		attributes.put("status", Boolean.TRUE);
    		attributes.put("info", message);
    		view.setAttributesMap(attributes);
    		model.setView(view);
    	}else{
    		model.setViewName("/syserror/error");
    	}
        return model;
	}

	
}
