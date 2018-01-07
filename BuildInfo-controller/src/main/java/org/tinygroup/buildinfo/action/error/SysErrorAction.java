package org.tinygroup.buildinfo.action.error;

import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;

@RequestMapping("/syserror")
public class SysErrorAction extends BaseController {

	@RequestMapping("error")
	public String returnErrorPage (){
		return "/biz/error/error";
	}
}
