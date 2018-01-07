package org.tinygroup.buildinfo.action.trans;

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
import org.tinygroup.buildinfo.service.inter.TransService;
import org.tinygroup.buildinfo.service.inter.dto.TransDto;

/**
 * Created by Mr.wang on 2016/8/2.
 */
@Controller
@RequestMapping("/sysbiztrans")
public class TransAction extends BaseController{
    
    private TransService transService;

	public TransService getTransService() {
		return transService;
	}

	public void setTransService(TransService transService) {
		this.transService = transService;
	}

	@RequestMapping("manage")
    public String execute(Model model){
		model.addAttribute("transList", getTranssList());
        return "/biz/deal/deal";
    }
    
    @RequestMapping("getPageData")
    @ResponseBody
    public PageResponse getPageData(PageRequest pageRequest, TransDto transDto, Model model){
        return transService.getTransPager(pageRequest, transDto);
    }

    @RequestMapping("edit")
    public String get(Integer id, Model model){
        if(id !=null){
            TransDto transDto = transService.getTrans(id);
            model.addAttribute("transDto",transDto);
        }
        model.addAttribute("transLists", getTranssList());
        return "/biz/deal/deal-edit";
    }
    
    @RequestMapping("update")
    @ResponseBody
    public Map<?,?> update(TransDto transDto, Model model){
    	int count = transService.updateTrans(transDto);
    	if(count >0){
    		return resultMap(true,"修改成功!");
    	}
    	return resultMap(false,"修改失败!");
    }

    @RequestMapping("save")
    @ResponseBody
    public Map<?,?> add(TransDto transDto,Model model){
    	boolean isExist = transService.checkTransExists(transDto);
    	if(!isExist){
    		return (transService.addTrans(transDto)!=null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在!");
    }

    @RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="ids[]") Integer[] ids,Model model){
		if(ids != null){
			int count = transService.deleteTrans(ids);
			if(count > 0){
				return resultMap(true,"删除成功!");
			}
			return resultMap(false,"删除失败!");
		}
		return resultMap(false,"ids 为空!");
	}
    public List getTranssList(){
    	return transService.getTransList(null);
    }

}
