
package org.tinygroup.workplan.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;
import org.tinygroup.workplan.dao.inter.pojo.TMeetingRecord;

/**
 * <!-- begin-user-doc --> 会议记录表 * <!-- end-user-doc -->
 */
public class TMeetingRecordTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TMeetingRecordTable T_MEETING_RECORD_TABLE = new TMeetingRecordTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 会议主题 * <!-- end-user-doc -->
	 */
	public final Column MEETING_SUBJECT = new Column(this, "meeting_subject");
	/**
	 * <!-- begin-user-doc --> 会议时间 * <!-- end-user-doc -->
	 */
	public final Column MEETING_TIME = new Column(this, "meeting_time");
	/**
	 * <!-- begin-user-doc --> 地点 * <!-- end-user-doc -->
	 */
	public final Column MEETING_ADDRESS = new Column(this, "meeting_address");
	/**
	 * <!-- begin-user-doc --> 主持人 * <!-- end-user-doc -->
	 */
	public final Column MEETING_PRESENTER = new Column(this, "meeting_presenter");
	/**
	 * <!-- begin-user-doc --> 记录人 * <!-- end-user-doc -->
	 */
	public final Column MEETING_RECORDER = new Column(this, "meeting_recorder");
	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	public final Column CREATE_USER = new Column(this, "create_user");
	/**
	 * <!-- begin-user-doc --> 会议内容 * <!-- end-user-doc -->
	 */
	public final Column MEETING_CONTENT = new Column(this, "meeting_content");
	/**
	 * <!-- begin-user-doc --> 会议决议 * <!-- end-user-doc -->
	 */
	public final Column MEETING_RESULT = new Column(this, "meeting_result");
	/**
	 * <!-- begin-user-doc --> 参会人员 * <!-- end-user-doc -->
	 */
	public final Column JOIN_MEETING_USER = new Column(this, "join_meeting_user");
	/**
	 * <!-- begin-user-doc --> 扩展字段1 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_1 = new Column(this, "ext_field_1");
	/**
	 * <!-- begin-user-doc --> 扩展字段2 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_2 = new Column(this, "ext_field_2");
	/**
	 * <!-- begin-user-doc --> 扩展字段3 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_3 = new Column(this, "ext_field_3");
	/**
	 * <!-- begin-user-doc --> 扩展字段4 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_4 = new Column(this, "ext_field_4");
	/**
	 * <!-- begin-user-doc --> 扩展字段5 * <!-- end-user-doc -->
	 */
	public final Column EXT_FIELD_5 = new Column(this, "ext_field_5");

	public TMeetingRecordTable() {
		super("t_meeting_record");
	}

	public TMeetingRecordTable(String schemaName) {
		super(schemaName, "t_meeting_record");
	}

	public TMeetingRecordTable(String schemaName, String alias) {
		super(schemaName, "t_meeting_record", alias);
	}

	public TMeetingRecordTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "t_meeting_record", alias, withAs);
	}

	public Class<TMeetingRecord> getPojoType() {
		return TMeetingRecord.class;
	}

}
