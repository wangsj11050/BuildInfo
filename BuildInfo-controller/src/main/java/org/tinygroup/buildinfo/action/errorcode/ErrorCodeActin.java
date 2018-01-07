package org.tinygroup.buildinfo.action.errorcode;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.ErrormsgService;
import org.tinygroup.buildinfo.service.inter.dto.ErrormsgDto;

/**
 * Created by Mr.wang on 2016/8/3.
 */
@Controller
@RequestMapping("/syserrorcode")
public class ErrorCodeActin extends BaseController{
    
    private ErrormsgService errormsgService;

	public ErrormsgService getErrormsgService() {
		return errormsgService;
	}

	public void setErrormsgService(ErrormsgService errormsgService) {
		this.errormsgService = errormsgService;
	}

	@RequestMapping("manage")
    public String execute(){
        return "/biz/error-code/code";
    }
    
    @RequestMapping("getPageData")
    @ResponseBody
    public PageResponse getPageData(PageRequest pageRequest, ErrormsgDto errormsgDto, Model model){
//       if(searDepCode!=null){
//           sysDepDto.setDepCode(searDepCode);
//       }
        return errormsgService.getErrormsgPager(pageRequest, errormsgDto);
    }

    @RequestMapping("edit")
    public String get(Integer id, Model model){
        if(id !=null){
            ErrormsgDto errormsgDto = errormsgService.getErrormsg(id);
            model.addAttribute("errormsgDto",errormsgDto);
        }
        model.addAttribute("errormsgLists", getErrormsgsList());
        return "/biz/error-code/code-edit";
    }
    
    @RequestMapping("update")
    @ResponseBody
    public Map<?,?> update(ErrormsgDto errormsgDto, Model model){
    	int count = errormsgService.updateErrormsg(errormsgDto);
    	if(count >0){
    		return resultMap(true,"修改成功!");
    	}
    	return resultMap(false,"修改失败!");
    }

    @RequestMapping("save")
    @ResponseBody
    public Map<?,?> add(ErrormsgDto errormsgDto,Model model){
    	boolean isExist = errormsgService.checkErrormsgExists(errormsgDto);
    	if(!isExist){
    		return (errormsgService.addErrormsg(errormsgDto)!=null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在!");
    }

    @RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="ids[]") Integer[] ids,Model model){
		if(ids != null){
			int count = errormsgService.deleteErrormsg(ids);
			if(count > 0){
				return resultMap(true,"删除成功!");
			}
			return resultMap(false,"删除失败!");
		}
		return resultMap(false,"ids 为空!");
	}
    public List getErrormsgsList(){
    	return errormsgService.getErrormsgList(null);
    }

}
