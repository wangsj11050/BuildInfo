/**
 *  Copyright (c) 1997-2013, www.tinygroup.org (luo_guo@icloud.com).
 *
 *  Licensed under the GPL, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.gnu.org/licenses/gpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.tinygroup.buildinfo.dao.inter.pojo;


/**
 * <!-- begin-user-doc --> 交易配置表 * <!-- end-user-doc -->
 */
public class Tbtrans {

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	private Integer id;

	/**
	 * <!-- begin-user-doc --> 交易编号 * <!-- end-user-doc -->
	 */
	private String transCode;

	/**
	 * <!-- begin-user-doc --> 交易名称 * <!-- end-user-doc -->
	 */
	private String transName;

	/**
	 * <!-- begin-user-doc --> 交易允许 * <!-- end-user-doc -->
	 */
	private String enableFlag;

	/**
	 * <!-- begin-user-doc --> 允许渠道组 * <!-- end-user-doc -->
	 */
	private String channels;

	/**
	 * <!-- begin-user-doc --> 后台联机 * <!-- end-user-doc -->
	 */
	private String hostOnline;

	/**
	 * <!-- begin-user-doc --> 交易类别 * <!-- end-user-doc -->
	 */
	private String transType;

	/**
	 * <!-- begin-user-doc --> 监控标志 * <!-- end-user-doc -->
	 */
	private String monitorStatus;

	/**
	 * <!-- begin-user-doc --> 日志级别 * <!-- end-user-doc -->
	 */
	private String logLevel;

	/**
	 * <!-- begin-user-doc --> 监控交易类别 * <!-- end-user-doc -->
	 */
	private String monTransType;

	/**
	 * <!-- begin-user-doc --> 备用1 * <!-- end-user-doc -->
	 */
	private String reserve1;

	/**
	 * <!-- begin-user-doc --> 备注2 * <!-- end-user-doc -->
	 */
	private String reserve2;

	/**
	 * <!-- begin-user-doc --> 保留域3 * <!-- end-user-doc -->
	 */
	private String reserve3;

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
	 * <!-- begin-user-doc --> 交易编号 * <!-- end-user-doc -->
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getTransCode() {
		return transCode;
	}

	/**
	 * <!-- begin-user-doc --> 交易名称 * <!-- end-user-doc -->
	 */
	public void setTransName(String transName) {
		this.transName = transName;
	}

	public String getTransName() {
		return transName;
	}

	/**
	 * <!-- begin-user-doc --> 交易允许 * <!-- end-user-doc -->
	 */
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	/**
	 * <!-- begin-user-doc --> 允许渠道组 * <!-- end-user-doc -->
	 */
	public void setChannels(String channels) {
		this.channels = channels;
	}

	public String getChannels() {
		return channels;
	}

	/**
	 * <!-- begin-user-doc --> 后台联机 * <!-- end-user-doc -->
	 */
	public void setHostOnline(String hostOnline) {
		this.hostOnline = hostOnline;
	}

	public String getHostOnline() {
		return hostOnline;
	}

	/**
	 * <!-- begin-user-doc --> 交易类别 * <!-- end-user-doc -->
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTransType() {
		return transType;
	}

	/**
	 * <!-- begin-user-doc --> 监控标志 * <!-- end-user-doc -->
	 */
	public void setMonitorStatus(String monitorStatus) {
		this.monitorStatus = monitorStatus;
	}

	public String getMonitorStatus() {
		return monitorStatus;
	}

	/**
	 * <!-- begin-user-doc --> 日志级别 * <!-- end-user-doc -->
	 */
	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getLogLevel() {
		return logLevel;
	}

	/**
	 * <!-- begin-user-doc --> 监控交易类别 * <!-- end-user-doc -->
	 */
	public void setMonTransType(String monTransType) {
		this.monTransType = monTransType;
	}

	public String getMonTransType() {
		return monTransType;
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

	/**
	 * <!-- begin-user-doc --> 保留域3 * <!-- end-user-doc -->
	 */
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	public String getReserve3() {
		return reserve3;
	}

}
