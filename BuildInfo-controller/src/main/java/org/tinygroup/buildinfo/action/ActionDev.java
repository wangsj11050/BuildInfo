package org.tinygroup.buildinfo.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.common.util.UploadUtils;
import org.tinygroup.buildinfo.service.inter.BuildAdisverService;
import org.tinygroup.buildinfo.service.inter.BuildCustomerCaseService;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;
import org.tinygroup.buildinfo.service.inter.BuildNewsService;
import org.tinygroup.commons.tools.StringUtil;
import org.tinygroup.convert.objectjson.fastjson.ObjectToJson;
import org.tinygroup.springmvc.multipart.TinyMultipartFile;

import com.alibaba.fastjson.JSON;


@Controller()
public class ActionDev extends BaseController{
	
	private BuildInfoServiceService buildInfoServiceService;

	private BuildCustomerCaseService buildCustomerCaseService;

	private BuildNewsService buildNewsService;
	
	private BuildAdisverService buildAdisverService;

	public BuildAdisverService getBuildAdisverService() {
		return buildAdisverService;
	}

	public void setBuildAdisverService(BuildAdisverService buildAdisverService) {
		this.buildAdisverService = buildAdisverService;
	}
	
	public BuildNewsService getBuildNewsService() {
		return buildNewsService;
	}

	public void setBuildNewsService(BuildNewsService buildNewsService) {
		this.buildNewsService = buildNewsService;
	}
	
	public BuildCustomerCaseService getBuildCustomerCaseService() {
		return buildCustomerCaseService;
	}

	public void setBuildCustomerCaseService(BuildCustomerCaseService buildCustomerCaseService) {
		this.buildCustomerCaseService = buildCustomerCaseService;
	}
	public BuildInfoServiceService getBuildInfoServiceService() {
		return buildInfoServiceService;
	}

	public void setBuildInfoServiceService(BuildInfoServiceService buildInfoServiceService) {
		this.buildInfoServiceService = buildInfoServiceService;
	}
	
	/**
     * 上传路径
     */
    @Value("${servicefiles.basedir}")
    protected String UPLOAD_PATH;

    @RequestMapping(value = "/{pageId}", method = RequestMethod.GET)
    public String showPageView(@PathVariable String pageId) {
        return pageId;
    }

    @RequestMapping(value = "/{pageId2}/{pageId}", method = RequestMethod.GET)
    public String showPageView1(@PathVariable String pageId2, @PathVariable String pageId) {
        return pageId2 + "/" + pageId;
    }

    @RequestMapping(value = "/{partId1}/{pageId}/{pageId2}", method = RequestMethod.GET)
    public String showPageSubView(@PathVariable String partId1, @PathVariable String pageId, @PathVariable String pageId2) {
        return partId1+"/" + pageId + "/" + pageId2;
    }

    @RequestMapping(value = "/{partId1}/{pageId}/{pageId2}/{pageId3}", method = RequestMethod.GET)
    public String showPageSubView2(@PathVariable String partId1, @PathVariable String pageId, @PathVariable String pageId2, @PathVariable String pageId3) {
        return partId1+"/" + pageId + "/" + pageId2+"/"+pageId3;
    }

    @RequestMapping({"", "/"})
    public String dodo(Model model) {
    	model.addAttribute("buildServiceList",buildInfoServiceService.getServicetypeList(null));
    	model.addAttribute("buildCustomerCaseList",buildCustomerCaseService.getCustomerCaseList(null));
    	model.addAttribute("buildNewsList",buildNewsService.getNewsList(null));
    	model.addAttribute("buildAdisverList",buildAdisverService.getAdisverList(null));
    	model.addAttribute("firstFlag",true);
        return "buildinfo/buildinfohome";
    }

    @RequestMapping("/saveMenu")
    @ResponseBody
    public void saveTree(HttpServletRequest request, HttpSession session) {
        session.setAttribute("menuList", JSON.parse(request.getParameter("data")));
    }


    /**
     * 图片异步上传
     *
     * @param uploadFile
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/ajaxUploadImage")
    public String ajaxUploadImage(@RequestParam(value = "upfile", required = false) TinyMultipartFile uploadFile,
    		HttpServletRequest request,HttpServletResponse response) {
        Map<String, String> map = new HashMap<String, String>();
        if (uploadFile.toFileObject() == null || StringUtil.isBlank(uploadFile.toFileObject().getAbsolutePath())) {
            map.put("state", "n");
        } else {
            String fileUrl = uploadFile.toFileObject().getAbsolutePath();
            fileUrl = UploadUtils.resolverFilePath(fileUrl, UPLOAD_PATH);
            map.put("url", fileUrl);
            map.put("state", "SUCCESS");
        }
        ObjectToJson objectToJson = new ObjectToJson();
        return renderString(response, objectToJson.convert(map), "text/html");
    }
}
