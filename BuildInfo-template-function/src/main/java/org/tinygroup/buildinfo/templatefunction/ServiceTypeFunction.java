package org.tinygroup.buildinfo.templatefunction;

import org.tinygroup.template.Template;
import org.tinygroup.template.TemplateContext;
import org.tinygroup.template.TemplateEngine;
import org.tinygroup.template.TemplateException;
import org.tinygroup.template.TemplateFunction;

public class ServiceTypeFunction implements TemplateFunction {

	@Override
	public String getBindingTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNames() {
		// TODO Auto-generated method stub
		return "resolveServiceType";
	}

	@Override
	public TemplateEngine getTemplateEngine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTemplateEngine(TemplateEngine templateEngine) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(Template template, TemplateContext context, Object... parameters) throws TemplateException {
		String serviceType = parameters[0].toString();
		String[] serviceList =serviceType.split(",");
		return serviceList;
	}

}
