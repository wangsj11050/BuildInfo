package org.tinygroup.buildinfo.action.customercase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinygroup.buildinfo.action.BaseController;

@Controller
@RequestMapping("syscustomercasemenu")
public class BuildCustomercaseMenuAction extends BaseController {

	@RequestMapping("customercase")
	public String customercase(){
		
		return "biz/buildinfo/customer-case/buildcustomer_case.page";
	}
}
