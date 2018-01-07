package org.tinygroup.buildinfo.action.param;

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
import org.tinygroup.buildinfo.service.inter.ParamService;
import org.tinygroup.buildinfo.service.inter.dto.ParamDto;

/**
 * Created by Mr.wang on 2016/8/2.
 */
@Controller
@RequestMapping("/sysparam")
public class ParamAction extends BaseController{
    
    private ParamService paramService;

	public ParamService getParamService() {
		return paramService;
	}

	public void setParamService(ParamService paramService) {
		this.paramService = paramService;
	}

	@RequestMapping("manage")
    public String execute(){
        return "/biz/parameter-set/parameter";
    }
    
    @RequestMapping("getPageData")
    @ResponseBody
    public PageResponse getPageData(PageRequest pageRequest, ParamDto paramDto, Model model){
//       if(searDepCode!=null){
//           sysDepDto.setDepCode(searDepCode);
//       }
        return paramService.getParamPager(pageRequest, paramDto);
    }

    @RequestMapping("edit")
    public String get(Integer id, Model model){
        if(id !=null){
            ParamDto paramDto = paramService.getParam(id);
            model.addAttribute("paramDto",paramDto);
            System.out.println("******************"+paramDto.getTaCode());
        }
        model.addAttribute("paramLists", getParamsList());
        return "/biz/parameter-set/parameter-edit";
    }
    
    @RequestMapping("update")
    @ResponseBody
    public Map<?,?> update(ParamDto paramDto, Model model){
    	int count = paramService.updateParam(paramDto);
    	if(count >0){
    		return resultMap(true,"修改成功!");
    	}
    	return resultMap(false,"修改失败!");
    }

    @RequestMapping("save")
    @ResponseBody
    public Map<?,?> add(ParamDto paramDto,Model model){
    	boolean isExist = paramService.checkParamExists(paramDto);
    	if(!isExist){
    		return (paramService.addParam(paramDto)!=null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在!");
    }

    @RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="ids[]") Integer[] ids,Model model){
		if(ids != null){
			int count = paramService.deleteParam(ids);
			if(count > 0){
				return resultMap(true,"删除成功!");
			}
			return resultMap(false,"删除失败!");
		}
		return resultMap(false,"ids 为空!");
	}
    public List getParamsList(){
    	return paramService.getParamList(null);
    }

}
