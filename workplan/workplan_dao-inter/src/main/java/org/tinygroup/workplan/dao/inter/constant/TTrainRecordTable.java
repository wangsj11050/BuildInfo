
package org.tinygroup.workplan.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;
import org.tinygroup.workplan.dao.inter.pojo.TTrainRecord;

/**
 * <!-- begin-user-doc --> 平台培训记录表 * <!-- end-user-doc -->
 */
public class TTrainRecordTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TTrainRecordTable T_TRAIN_RECORD_TABLE = new TTrainRecordTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 培训主题 * <!-- end-user-doc -->
	 */
	public final Column TRAIN_THEME = new Column(this, "train_theme");
	/**
	 * <!-- begin-user-doc --> 主讲人 * <!-- end-user-doc -->
	 */
	public final Column SPEEKER = new Column(this, "speeker");
	/**
	 * <!-- begin-user-doc --> 记录人 * <!-- end-user-doc -->
	 */
	public final Column MEETING_RECORDER = new Column(this, "meeting_recorder");
	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	public final Column CREATE_USER = new Column(this, "create_user");
	/**
	 * <!-- begin-user-doc --> 知识类别 * <!-- end-user-doc -->
	 */
	public final Column KNOWLEDGE_TYPE = new Column(this, "knowledge_type");
	/**
	 * <!-- begin-user-doc --> 培训内容 * <!-- end-user-doc -->
	 */
	public final Column TRAIN_CONTENT = new Column(this, "train_content");
	/**
	 * <!-- begin-user-doc --> 培训时间 * <!-- end-user-doc -->
	 */
	public final Column TRAIN_TIME = new Column(this, "train_time");
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

	public TTrainRecordTable() {
		super("t_train_record");
	}

	public TTrainRecordTable(String schemaName) {
		super(schemaName, "t_train_record");
	}

	public TTrainRecordTable(String schemaName, String alias) {
		super(schemaName, "t_train_record", alias);
	}

	public TTrainRecordTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "t_train_record", alias, withAs);
	}

	public Class<TTrainRecord> getPojoType() {
		return TTrainRecord.class;
	}

}
