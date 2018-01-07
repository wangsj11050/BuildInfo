package org.tinygroup.buildinfo.action.sysuser;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.security.processor.EncryptionProcessor;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.service.inter.SysMenuService;
import org.tinygroup.buildinfo.service.inter.SysUserLoginService;
import org.tinygroup.buildinfo.service.inter.SysUserService;
import org.tinygroup.buildinfo.service.inter.dto.SysUserDto;
import org.tinygroup.buildinfo.service.inter.dto.SysUserLoginDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.UserInfo;

/**
 * Created by Mr.wang on 2016/7/26.
 */
@Controller
@RequestMapping("/login")
@SessionAttributes("userInfo")
public class SysUserLoginAction extends BaseController{

	private SysUserService sysUserService;

	private SysUserLoginService sysUserLoginService;

	private SysMenuService sysMenuService;
	//md5加密
	private EncryptionProcessor encryptionProcessor;
	
	public EncryptionProcessor getEncryptionProcessor() {
		return encryptionProcessor;
	}

	public void setEncryptionProcessor(EncryptionProcessor encryptionProcessor) {
		this.encryptionProcessor = encryptionProcessor;
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public SysUserLoginService getSysUserLoginService() {
		return sysUserLoginService;
	}

	public void setSysUserLoginService(SysUserLoginService sysUserLoginService) {
		this.sysUserLoginService = sysUserLoginService;
	}

	public SysMenuService getSysMenuService() {
		return sysMenuService;
	}

	public void setSysMenuService(SysMenuService sysMenuService) {
		this.sysMenuService = sysMenuService;
	}

	@RequestMapping("check")
	@ResponseBody
	public Map<?,?> check(HttpSession session,String userId,String userPwd){
		if(userId == null || userId.trim().length()==0){
			return resultMap(false,"用户名或者密码错误！");
		}
		if(userPwd == null || userPwd.trim().length()==0){
			return resultMap(false,"用户名或者密码错误！");
		}
		//进行md5加密
		String encryPwd = encryptionProcessor.encode(userPwd);
		boolean isExist = sysUserService.validateSysUserExists(userId,encryPwd);
        int status = 0;//默认是登录失败
        String msg = "用户名或密码错误!";
		if(isExist){
			SysUserDto sysUserDto = new SysUserDto();
			sysUserDto.setUserId(userId);
			sysUserDto.setUserPwd(encryPwd);
			//如果成功，将用户信息放入session
			SysUserDto sysUser = sysUserService.getSysUser(sysUserDto.getUserId());
            SysUserLoginDto checkedSysUserLoginDto = sysUserLoginService.getSysUserLoginByUser(sysUserDto);

            if(checkedSysUserLoginDto==null){
                status = 1;//第一次登陆
                msg = "首次登陆需要修改密码!";
            }else{
                status = 2;//非第一次登陆
                msg = "登录成功!";
                checkedSysUserLoginDto.setLastLoginTime(new Date());
                sysUserLoginService.updateSysLogin(checkedSysUserLoginDto);
            }
			UserInfo userInfo = BeanUtil.copyProperties(UserInfo.class,sysUser);
			session.setAttribute("userInfo", userInfo);
			//清除缓存
			getCache().remove("authMenus",userInfo.getUserId());
		}
        return resultMap(status,msg);
	}
	@RequestMapping("logout")
	public String logout(HttpSession session,HttpServletRequest  request){
		session.removeAttribute("userInfo");
		session.invalidate();
        return "redirect:/login";

	}
}
