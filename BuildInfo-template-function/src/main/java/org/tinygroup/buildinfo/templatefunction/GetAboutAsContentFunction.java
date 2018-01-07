package org.tinygroup.buildinfo.templatefunction;

import org.springframework.beans.factory.annotation.Value;
import org.tinygroup.template.Template;
import org.tinygroup.template.TemplateContext;
import org.tinygroup.template.TemplateEngine;
import org.tinygroup.template.TemplateException;
import org.tinygroup.template.TemplateFunction;

public class GetAboutAsContentFunction implements TemplateFunction {

	@Override
	public String getBindingTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNames() {
		// TODO Auto-generated method stub
		return "getContentFunction";
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
		String fileName = parameters[0].toString();
		
		return null;
	}

}
