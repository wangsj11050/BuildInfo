package org.tinygroup.buildinfo.service.inter.dto;

import java.io.Serializable;

public class TaskpoolDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7812868642103164513L;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 市场代码 * <!-- end-user-doc -->
	 */
	private String marketCode;

	/**
	 * <!-- begin-user-doc --> 作业代码 * <!-- end-user-doc -->
	 */
	private String taskCode;

	/**
	 * <!-- begin-user-doc --> 作业名称 * <!-- end-user-doc -->
	 */
	private String taskName;

	/**
	 * <!-- begin-user-doc --> 作业处理库 * <!-- end-user-doc -->
	 */
	private String actionClass;

	/**
	 * <!-- begin-user-doc --> 流水号 * <!-- end-user-doc -->
	 */
	private String serialNo;

	/**
	 * <!-- begin-user-doc --> 父作业数 * <!-- end-user-doc -->
	 */
	private Integer parentTaskNum;

	/**
	 * <!-- begin-user-doc --> 父作业码 * <!-- end-user-doc -->
	 */
	private String parentTaskCode;

	/**
	 * <!-- begin-user-doc --> 归属页面页码 * <!-- end-user-doc -->
	 */
	private String taskPage;

	/**
	 * <!-- begin-user-doc --> 作业归属模块类型 * <!-- end-user-doc -->
	 */
	private String taskType;

	/**
	 * <!-- begin-user-doc --> 作业位置行 * <!-- end-user-doc -->
	 */
	private Integer taskRow;

	/**
	 * <!-- begin-user-doc --> 作业位置列 * <!-- end-user-doc -->
	 */
	private Integer taskColumn;

	/**
	 * <!-- begin-user-doc --> 允许重做标志 * <!-- end-user-doc -->
	 */
	private String redoFlag;

	/**
	 * <!-- begin-user-doc --> 延时处理标志 * <!-- end-user-doc -->
	 */
	private String delayFlag;

	/**
	 * <!-- begin-user-doc --> 延时时间 * <!-- end-user-doc -->
	 */
	private String delayTime;

	/**
	 * <!-- begin-user-doc --> 操作员编号 * <!-- end-user-doc -->
	 */
	private String opCode;

	/**
	 * <!-- begin-user-doc --> 操作次数 * <!-- end-user-doc -->
	 */
	private Integer opTimes;

	/**
	 * <!-- begin-user-doc --> 执行状态 * <!-- end-user-doc -->
	 */
	private String dealStatus;

	/**
	 * <!-- begin-user-doc --> 该市场暂停清算时是否处理 * <!-- end-user-doc -->
	 */
	private String stopDealFlag;

	/**
	 * <!-- begin-user-doc --> 执行百分比例 * <!-- end-user-doc -->
	 */
	private Integer excutePercentage;

	/**
	 * <!-- begin-user-doc --> 执行结果 * <!-- end-user-doc -->
	 */
	private String errCode;

	/**
	 * <!-- begin-user-doc --> 执行结果信息 * <!-- end-user-doc -->
	 */
	private String errMsg;

	/**
	 * <!-- begin-user-doc --> 警告级别 * <!-- end-user-doc -->
	 */
	private String warnFlag;

	/**
	 * <!-- begin-user-doc --> 提示或警告信息 * <!-- end-user-doc -->
	 */
	private String warnMsg;

	/**
	 * <!-- begin-user-doc --> 执行开始时间(秒) * <!-- end-user-doc -->
	 */
	private Integer beginTime;

	/**
	 * <!-- begin-user-doc --> 执行结束时间(秒) * <!-- end-user-doc -->
	 */
	private Integer endTime;

	/**
	 * <!-- begin-user-doc --> 执行持续时间(秒) * <!-- end-user-doc -->
	 */
	private Integer holdTime;

	/**
	 * <!-- begin-user-doc --> 最近执行日期 * <!-- end-user-doc -->
	 */
	private Integer lastTransDate;

	/**
	 * <!-- begin-user-doc --> 传递子作业值 * <!-- end-user-doc -->
	 */
	private String transToSub;

	/**
	 * <!-- begin-user-doc --> 传递子作业值2 * <!-- end-user-doc -->
	 */
	private String transToSub2;

	/**
	 * <!-- begin-user-doc --> 明细URL * <!-- end-user-doc -->
	 */
	private String detailUrl;

	/**
	 * <!-- begin-user-doc --> 备用1 * <!-- end-user-doc -->
	 */
	private String reserve1;

	/**
	 * <!-- begin-user-doc --> 备注2 * <!-- end-user-doc -->
	 */
	private String reserve2;

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> 市场代码 * <!-- end-user-doc -->
	 */
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}

	public String getMarketCode() {
		return marketCode;
	}

	/**
	 * <!-- begin-user-doc --> 作业代码 * <!-- end-user-doc -->
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskCode() {
		return taskCode;
	}

	/**
	 * <!-- begin-user-doc --> 作业名称 * <!-- end-user-doc -->
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskName() {
		return taskName;
	}

	/**
	 * <!-- begin-user-doc --> 作业处理库 * <!-- end-user-doc -->
	 */
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}

	public String getActionClass() {
		return actionClass;
	}

	/**
	 * <!-- begin-user-doc --> 流水号 * <!-- end-user-doc -->
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	/**
	 * <!-- begin-user-doc --> 父作业数 * <!-- end-user-doc -->
	 */
	public void setParentTaskNum(Integer parentTaskNum) {
		this.parentTaskNum = parentTaskNum;
	}

	public Integer getParentTaskNum() {
		return parentTaskNum;
	}

	/**
	 * <!-- begin-user-doc --> 父作业码 * <!-- end-user-doc -->
	 */
	public void setParentTaskCode(String parentTaskCode) {
		this.parentTaskCode = parentTaskCode;
	}

	public String getParentTaskCode() {
		return parentTaskCode;
	}

	/**
	 * <!-- begin-user-doc --> 归属页面页码 * <!-- end-user-doc -->
	 */
	public void setTaskPage(String taskPage) {
		this.taskPage = taskPage;
	}

	public String getTaskPage() {
		return taskPage;
	}

	/**
	 * <!-- begin-user-doc --> 作业归属模块类型 * <!-- end-user-doc -->
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskType() {
		return taskType;
	}

	/**
	 * <!-- begin-user-doc --> 作业位置行 * <!-- end-user-doc -->
	 */
	public void setTaskRow(Integer taskRow) {
		this.taskRow = taskRow;
	}

	public Integer getTaskRow() {
		return taskRow;
	}

	/**
	 * <!-- begin-user-doc --> 作业位置列 * <!-- end-user-doc -->
	 */
	public void setTaskColumn(Integer taskColumn) {
		this.taskColumn = taskColumn;
	}

	public Integer getTaskColumn() {
		return taskColumn;
	}

	/**
	 * <!-- begin-user-doc --> 允许重做标志 * <!-- end-user-doc -->
	 */
	public void setRedoFlag(String redoFlag) {
		this.redoFlag = redoFlag;
	}

	public String getRedoFlag() {
		return redoFlag;
	}

	/**
	 * <!-- begin-user-doc --> 延时处理标志 * <!-- end-user-doc -->
	 */
	public void setDelayFlag(String delayFlag) {
		this.delayFlag = delayFlag;
	}

	public String getDelayFlag() {
		return delayFlag;
	}

	/**
	 * <!-- begin-user-doc --> 延时时间 * <!-- end-user-doc -->
	 */
	public void setDelayTime(String delayTime) {
		this.delayTime = delayTime;
	}

	public String getDelayTime() {
		return delayTime;
	}

	/**
	 * <!-- begin-user-doc --> 操作员编号 * <!-- end-user-doc -->
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getOpCode() {
		return opCode;
	}

	/**
	 * <!-- begin-user-doc --> 操作次数 * <!-- end-user-doc -->
	 */
	public void setOpTimes(Integer opTimes) {
		this.opTimes = opTimes;
	}

	public Integer getOpTimes() {
		return opTimes;
	}

	/**
	 * <!-- begin-user-doc --> 执行状态 * <!-- end-user-doc -->
	 */
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getDealStatus() {
		return dealStatus;
	}

	/**
	 * <!-- begin-user-doc --> 该市场暂停清算时是否处理 * <!-- end-user-doc -->
	 */
	public void setStopDealFlag(String stopDealFlag) {
		this.stopDealFlag = stopDealFlag;
	}

	public String getStopDealFlag() {
		return stopDealFlag;
	}

	/**
	 * <!-- begin-user-doc --> 执行百分比例 * <!-- end-user-doc -->
	 */
	public void setExcutePercentage(Integer excutePercentage) {
		this.excutePercentage = excutePercentage;
	}

	public Integer getExcutePercentage() {
		return excutePercentage;
	}

	/**
	 * <!-- begin-user-doc --> 执行结果 * <!-- end-user-doc -->
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCode() {
		return errCode;
	}

	/**
	 * <!-- begin-user-doc --> 执行结果信息 * <!-- end-user-doc -->
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * <!-- begin-user-doc --> 警告级别 * <!-- end-user-doc -->
	 */
	public void setWarnFlag(String warnFlag) {
		this.warnFlag = warnFlag;
	}

	public String getWarnFlag() {
		return warnFlag;
	}

	/**
	 * <!-- begin-user-doc --> 提示或警告信息 * <!-- end-user-doc -->
	 */
	public void setWarnMsg(String warnMsg) {
		this.warnMsg = warnMsg;
	}

	public String getWarnMsg() {
		return warnMsg;
	}

	/**
	 * <!-- begin-user-doc --> 执行开始时间(秒) * <!-- end-user-doc -->
	 */
	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}

	public Integer getBeginTime() {
		return beginTime;
	}

	/**
	 * <!-- begin-user-doc --> 执行结束时间(秒) * <!-- end-user-doc -->
	 */
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	/**
	 * <!-- begin-user-doc --> 执行持续时间(秒) * <!-- end-user-doc -->
	 */
	public void setHoldTime(Integer holdTime) {
		this.holdTime = holdTime;
	}

	public Integer getHoldTime() {
		return holdTime;
	}

	/**
	 * <!-- begin-user-doc --> 最近执行日期 * <!-- end-user-doc -->
	 */
	public void setLastTransDate(Integer lastTransDate) {
		this.lastTransDate = lastTransDate;
	}

	public Integer getLastTransDate() {
		return lastTransDate;
	}

	/**
	 * <!-- begin-user-doc --> 传递子作业值 * <!-- end-user-doc -->
	 */
	public void setTransToSub(String transToSub) {
		this.transToSub = transToSub;
	}

	public String getTransToSub() {
		return transToSub;
	}

	/**
	 * <!-- begin-user-doc --> 传递子作业值2 * <!-- end-user-doc -->
	 */
	public void setTransToSub2(String transToSub2) {
		this.transToSub2 = transToSub2;
	}

	public String getTransToSub2() {
		return transToSub2;
	}

	/**
	 * <!-- begin-user-doc --> 明细URL * <!-- end-user-doc -->
	 */
	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	/**
	 * <!-- begin-user-doc --> 备用1 * <!-- end-user-doc -->
	 */
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve1() {
		return reserve1;
	}

	/**
	 * <!-- begin-user-doc --> 备注2 * <!-- end-user-doc -->
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public String getReserve2() {
		return reserve2;
	}

}
