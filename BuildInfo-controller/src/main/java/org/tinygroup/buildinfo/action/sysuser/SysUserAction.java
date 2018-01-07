package org.tinygroup.buildinfo.action.sysuser;

import java.util.Date;
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
import org.tinygroup.buildinfo.common.security.MD5Util;
import org.tinygroup.buildinfo.common.security.processor.EncryptionProcessor;
import org.tinygroup.buildinfo.service.inter.*;
import org.tinygroup.buildinfo.service.inter.dto.*;
import org.tinygroup.buildinfo.service.inter.dto.complex.RoleUserRefDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.TRightRefDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.UserInfo;

import javax.servlet.http.HttpSession;

/**
 * Created by Mr.wang on 2016/7/15.
 */

@Controller
@RequestMapping("/sysuser")
public class SysUserAction extends BaseController{
    private String DEFAULT_PWD = "abcdef";
    //给用户分配角色，角色挂在机构下面
    private SysBranchService sysBranchService;
    //给用户分配权限
    private SysMenuService sysMenuService;
    //系统分类
    private SysKindService sysKindService;
    //岗位
    private SysOfficeService sysOfficeService;
    //部门
    private SysDepService sysDepService;

    private SysRoleService sysRoleService;

    private SysUserService sysUserService;

    private SysUserLoginService sysUserLoginService;
    //md5加密
    protected EncryptionProcessor encryptionProcessor;

    public SysKindService getSysKindService() {
		return sysKindService;
	}

	public void setSysKindService(SysKindService sysKindService) {
		this.sysKindService = sysKindService;
	}

	public SysDepService getSysDepService() {
		return sysDepService;
	}

	public void setSysDepService(SysDepService sysDepService) {
		this.sysDepService = sysDepService;
	}

	public EncryptionProcessor getEncryptionProcessor() {
        return encryptionProcessor;
    }

    public void setEncryptionProcessor(EncryptionProcessor encryptionProcessor) {
        this.encryptionProcessor = encryptionProcessor;
    }

    public SysRoleService getSysRoleService() {
        return sysRoleService;
    }

    public void setSysRoleService(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    public SysMenuService getSysMenuService() {
		return sysMenuService;
	}

	public void setSysMenuService(SysMenuService sysMenuService) {
		this.sysMenuService = sysMenuService;
	}

	public SysBranchService getSysBranchService() {
		return sysBranchService;
	}

	public void setSysBranchService(SysBranchService sysBranchService) {
		this.sysBranchService = sysBranchService;
	}

	public SysUserService getSysUserService() {
        return sysUserService;
    }

    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    public SysOfficeService getSysOfficeService() {
        return sysOfficeService;
    }

    public void setSysOfficeService(SysOfficeService sysOfficeService) {
        this.sysOfficeService = sysOfficeService;
    }

    public SysUserLoginService getSysUserLoginService() {
        return sysUserLoginService;
    }

    public void setSysUserLoginService(SysUserLoginService sysUserLoginService) {
        this.sysUserLoginService = sysUserLoginService;
    }

    @RequestMapping("manage")
    public String execute(Model model){
        model.addAttribute("roleList",sysRoleService.getRoleList(null));
        model.addAttribute("depList",sysDepService.getSysDepList(null));
        model.addAttribute("branchList",sysBranchService.getSysBranchList(null));
        return "/biz/user/user";
    }
    /**
     * 获取机构信息
     * @return
     */
    @RequestMapping("getBranchInfos")
    @ResponseBody
    public List<SysBranchDto> getBranchInfos(SysBranchDto sysBranchDto){
    	List sysBranchList = sysBranchService.getSysBranchList(sysBranchDto);
    	return sysBranchList;
    }
    /**
     * 获取机构信息
     * @return
     * @date 2016/07/20
     */
    @RequestMapping("getMenuInfos")
    @ResponseBody
    public List<SysBranchDto> getMenuInfos(SysMenuDto sysMenuDto){
    	return sysMenuService.getMenuInfos(sysMenuDto);
    }
    
    @RequestMapping("getPageData")
    @ResponseBody
    public PageResponse getPager(PageRequest pageRequest, SysUserDto sysUserDto, Model model){
        return sysUserService.getSysUserPager(pageRequest, sysUserDto);
    }

    @RequestMapping("edit")
    public String get(String userId, Model model){
        if(userId !=null){
            SysUserDto sysUserDto = sysUserService.getSysUser(userId);
            model.addAttribute("sysUserDto",sysUserDto);
        }
        return "/biz/user/user-edit";
    }
    @RequestMapping("details")
    public String detail(String userId, Model model){
        if(userId !=null){
            SysUserDto sysUserDto = sysUserService.getSysUser(userId);
            model.addAttribute("sysUserDto",sysUserDto);
        }
        return "/biz/user/details";
    }
    @RequestMapping("update")
    @ResponseBody
    public Map<?,?> update(SysUserDto sysUserDto, Model model){
        int count = sysUserService.updateSysUser(sysUserDto);
        if(count > 0 ){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
    }

    @RequestMapping("save")
    @ResponseBody
    public Map<?,?> add(SysUserDto sysUserDto,Model model){
    	boolean isExist = sysUserService.checkSysUserExists(sysUserDto);
    	if(!isExist){
    		if(sysUserDto.getUserPwd() == null){
    			sysUserDto.setUserPwd(MD5Util.GetMD5Code(DEFAULT_PWD));
    		}
    		sysUserDto.setCreateDate(new Date());//创建时间
    		return (sysUserService.addSysUser(sysUserDto)!=null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在！");
    }
    @RequestMapping("delete")
    @ResponseBody
    public Map<?,?> delete(@RequestParam(value="userIds[]") String[] userIds,Model model){
    	if(userIds != null){
    		return sysUserService.deleteSysUser(userIds) > 0 ? resultMap(true,"删除成功!") : resultMap(false,"删除失败!");
    	}
    	return resultMap(false,"userIds 为空");
    }

    @RequestMapping("roleAssign")
    public String assignOffices(){
        return "/biz/user/assign-roles";
    }

    @RequestMapping("updateOffices")
    @ResponseBody
    public Map<?,?> updateOffices(String userCode, String officeIds, String removeOfficeIds){
        String[] officeIdArray = officeIds.split(",");
        String[] removeOfficeIdArray = removeOfficeIds.split(",");
        sysUserService.updateUserOffices(userCode, officeIdArray, removeOfficeIdArray);
        return resultMap(true,"保存成功!");
    }

    @RequestMapping("/offices/manage")
    public String userOfficesManage(String userId, Model model){
        return "/biz/user/assign-job";
    }

    @RequestMapping("/offices/manage/assign")
    public String assignOfficesManage(String userId,Boolean isAssigned,Model model){
        model.addAttribute("officeList", sysOfficeService.getOfficeList(null));//部门
        model.addAttribute("depList", sysDepService.getSysDepList(null));//岗位
        model.addAttribute("branchList", sysBranchService.getSysBranchList(null));//机构
    	if(isAssigned.booleanValue()){
            return "/biz/user/job2";//未分配
        }else{
            return "/biz/user/job1";//分配
        }
    }


    /**
     *
     * @param isAssigned 是否分配
     * @return
     */
    @RequestMapping("/offices/getAssignData")
    @ResponseBody
    public PageResponse<?> userOfficesData(PageRequest pageRequest,String userCode,SysOfficeDto sysOfficeDto,Boolean isAssigned){
        return sysUserService.queryOfficeInUser(pageRequest,userCode, sysOfficeDto, isAssigned);
    }

    /**
     * 用户岗位
     * @param sysOfficeUserDto
     * @return
     */
    @RequestMapping("/offices/getUserOffices")
    @ResponseBody
    public List getTsysOfficeUserList(SysOfficeUserDto sysOfficeUserDto){
        return sysUserService.getTsysOfficeUserList(sysOfficeUserDto);
    }


    /**
     * 收回岗位
     * @param userCode
     * @param officeIds
     * @return
     */
    @RequestMapping("/offices/revoke")
    @ResponseBody
    public Map<?,?> revokeOffices(String userCode,String officeIds){
        String[] officeIdArray = officeIds.split(",",-1);
        boolean result = sysUserService.revokeUserOffices(userCode,officeIdArray);
        if(result){
            return resultMap(true,"操作成功!");
        }else{
            return resultMap(false,"操作失败!");
        }
    }

    /**
     * 分配岗位
     * @param userCode
     * @param officeIds
     * @return
     */
    @RequestMapping("/offices/grant")
    @ResponseBody
    public Map<?,?> grantOffices(String userCode,String officeIds){
        String[] officeIdArray = officeIds.split(",",-1);
        if(sysUserService.grantUserOffices(userCode,officeIdArray)){
            return resultMap(true,"操作成功!");
        }else{
            return resultMap(false,"操作失败!");
        }

    }

    @RequestMapping("/roles/manage")
    public String rolesManage(String userId,Model model){
        return "/biz/user/assign-roles";
    }

    @RequestMapping("/roles/manage/assign")
    public String assignRolesManage(String userId,Boolean isAssigned,Model model){
        if(isAssigned.booleanValue()){
            return "/biz/user/role2";//取消分配
        }else{
            return "/biz/user/role1";//分配
        }
    }

    @RequestMapping("/roles/manage/assignData")
    @ResponseBody
    public PageResponse getRolesData(PageRequest pageRequest,String userCode,RoleUserRefDto roleUserRefDto,
                                     Boolean isAssigned,Integer rightFlag){
            return sysUserService.queryRoleInUser(pageRequest,userCode,roleUserRefDto,isAssigned,rightFlag);
    }

    /**
     * 分配角色
     * @param userCode
     * @param roles
     * @return
     */
    @RequestMapping("/roles/grant")
    @ResponseBody
    public Map<?,?> grantRoles(String userCode,String roles){
        String[] roleIdArray = roles.split(",",-1);
        Integer[] roleIdIntArray = new Integer[roleIdArray.length];
        for(int i=0;i<roleIdArray.length;i++){
            String menuIdStr = roleIdArray[i];
            roleIdIntArray[i]=Integer.parseInt(menuIdStr);
        }
        boolean result = sysUserService.grantUserRoles(userCode,roleIdIntArray);
        if(result){
            return resultMap(true,"操作成功!");
        }else{
            return resultMap(false,"操作失败!");
        }
    }

    /**
     * 收回角色
     * @param userCode
     * @param roles
     * @return
     */
    @RequestMapping("/roles/revoke")
    @ResponseBody
    public Map<?,?> revokeRoles(String userCode,String roles){
        String[] roleIdArray = roles.split(",",-1);
        Integer[] roleIdIntArray = new Integer[roleIdArray.length];
        for(int i=0;i<roleIdArray.length;i++){
            String menuIdStr = roleIdArray[i];
            roleIdIntArray[i]=Integer.parseInt(menuIdStr);
        }
        boolean result = sysUserService.revokeUserRoles(userCode,roleIdIntArray);
        if(result){
            return resultMap(true,"操作成功!");
        }else{
            return resultMap(false,"操作失败!");
        }
    }

    @RequestMapping("/rights/manage/assignData")
    @ResponseBody
    public PageResponse getRightsData(PageRequest pageRequest, String userCode, TRightRefDto tRightRefDto, Boolean isAssigned){
        return sysUserService.queryRightsInUser(pageRequest,userCode,tRightRefDto,isAssigned);
    }

    /**
     * @param userCode
     * @param menuIds
     * @param httpSession
     * @return
     */
    @RequestMapping("/rights/grant")
    @ResponseBody
    public Map<?,?> grantRight(String userCode,String menuIds,HttpSession httpSession){
        String[] menuIdArray = menuIds.split(",",-1);
        Integer[] menuIdIntArray = new Integer[menuIdArray.length];
        for(int i=0;i<menuIdArray.length;i++){
            String menuIdStr = menuIdArray[i];
            menuIdIntArray[i]=Integer.parseInt(menuIdStr);
        }
        boolean result = sysUserService.grantRights(userCode,menuIdIntArray,(String)httpSession.getAttribute("userCode"));
        if(result){
            return resultMap(true,"操作成功!");
        }else{
            return resultMap(false,"操作失败!");
        }
    }

    /**
     *
     * @param userCode
     * @param menuIds
     * @return
     */
    @RequestMapping("/rights/revoke")
    @ResponseBody
    public Map<?,?> revokeRight(String userCode,String menuIds){
        String[] menuIdArray = menuIds.split(",",-1);
        Integer[] menuIdIntArray = new Integer[menuIdArray.length];
        for(int i=0;i<menuIdArray.length;i++){
            String menuIdStr = menuIdArray[i];
            menuIdIntArray[i]=Integer.parseInt(menuIdStr);
        }
        boolean result = sysUserService.revokeRights(userCode,menuIdIntArray);
        if(result){
            return resultMap(true,"操作成功!");
        }else{
            return resultMap(false,"操作失败!");
        }
    }

    @RequestMapping("/home/manage")
    public String userHome(){
        return "/biz/homepage/home";
    }

    @RequestMapping("getAllInfoPageData")
    @ResponseBody
    public PageResponse getAllInfoPageData(PageRequest pageRequest, SysUserDto sysUserDto, Model model){
        return sysUserService.getAllInfoData(pageRequest, sysUserDto);
    }

    @RequestMapping("/home/edit")
    public String editHome(PageRequest pageRequest, String userId, Model model){
        model.addAttribute("sysUserDto",sysUserService.getSysUser(userId));
        return "/biz/homepage/home-edit";
    }
    @RequestMapping("/updateLockStatus")
    @ResponseBody
    public Map<?,?> updateLockStatus(@RequestParam(value="userIds[]") String[] userIds,String lockStatus,Model model){
    	if(userIds != null){
    		sysUserService.updateLockStatusByKeys(userIds, lockStatus);
			return resultMap(true,"修改成功!");
    	}
    	return resultMap(false,"userIds 为空！");
    }
    /**
     * 权限分配
     * @param userId 用户编号
     * @param model 
     * @return
     */
    @RequestMapping("/juris/manage")
    public String jurisManage(String userId,Model model){
        return "/biz/user/assign-jur";
    }
    
    @RequestMapping("/juris/manage/assign")
    public String assignJurisManage(String userId,Boolean isAssigned,Model model){
    	model.addAttribute("kindList", sysKindService.getKindsList(null));
        if(isAssigned.booleanValue()){
            return "/biz/user/jur2";//未分配
        }else{
            return "/biz/user/jur1";//分配
        }
    }

    @RequestMapping("/resetPwd")
    @ResponseBody
    public Map<?,?> pwdReset(@RequestParam(value="userIds[]") String[] userIds){
        int result = sysUserService.resetPwd(MD5Util.GetMD5Code(DEFAULT_PWD),userIds);
        return resultMap(true,"操作成功!");
    }

    @RequestMapping("/pwd/index")
    public String pwdChangePage(){
        return "/biz/user-pwd/set-list";
    }

    /**
     * 首次登陆修改密码
     * @param httpSession
     * @param oldPassword
     * @param password
     * @return
     */
    @RequestMapping("/pwd/change")
    @ResponseBody
    public Map<?,?> pwdChange(HttpSession httpSession,String oldPassword,String password){
        Map<?,?> pwdResult = updatePwd(httpSession,oldPassword,password);
        if("n".equals(pwdResult.get("status"))){
            return pwdResult;
        }
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setUserId(userInfo.getUserId());
        int result = sysUserService.resetOnePwd(MD5Util.GetMD5Code(password),userInfo.getUserId());
        if(result>0 && sysUserLoginService.getSysUserLoginByUser(sysUserDto)==null) {
            //延迟登录时间
            SysUserLoginDto sysUserLoginDto = new SysUserLoginDto();
            sysUserLoginDto.setUserId(sysUserDto.getUserId());
            sysUserLoginDto.setLastLoginTime(new Date());
            sysUserLoginService.addSysUserLogin(sysUserLoginDto);
        }
        return resultMap(true,"修改成功！");
    }

    @RequestMapping("pwd/update")
    @ResponseBody
    public Map<?,?> updatePwd(HttpSession httpSession, String oldPassword, String password){
        UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
        if(userInfo.getUserId()==null){
            return resultMap(false,"会话无用户名！");
        }
        if(oldPassword.equals(password)){
            return resultMap(false,"新旧密码不能一样!");
        }
        //进行md5加密
        String encryPwd = encryptionProcessor.encode(oldPassword);
        boolean isExist = getSysUserService().validateSysUserExists(userInfo.getUserId(),encryPwd);
        if(!isExist){
            return resultMap(false,"原密码错误！");
        }
        int result = getSysUserService().resetOnePwd(MD5Util.GetMD5Code(password),userInfo.getUserId());

        return resultMap(true,"修改成功！");
    }

    @RequestMapping("pwd/edit")
    public String pwdEditPage(){
        return "/biz/user-pwd/pwd-edit";
    }

    @ResponseBody
    @RequestMapping("ajax/userInCondition")
    public List<SysUserDto> userInCondition(String initKey, HttpSession httpSession,PageRequest pageRequest) {
    	if(initKey != null && !"".equals(initKey)){
    		return sysUserService.getUserByIds(initKey.split(","));
    	}
    	UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
    	return null;
    }
}
