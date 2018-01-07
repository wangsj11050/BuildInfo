
package org.tinygroup.workplan.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;
import org.tinygroup.workplan.dao.inter.pojo.TUserNotepad;

/**
 * <!-- begin-user-doc --> 员工记事本 * <!-- end-user-doc -->
 */
public class TUserNotepadTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TUserNotepadTable T_USER_NOTEPAD_TABLE = new TUserNotepadTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 记事本名称 * <!-- end-user-doc -->
	 */
	public final Column NOTEPAD_NAME = new Column(this, "notepad_name");
	/**
	 * <!-- begin-user-doc --> 知识类别 * <!-- end-user-doc -->
	 */
	public final Column KNOWLEDGE_TYPE = new Column(this, "knowledge_type");
	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	public final Column CREATE_USER = new Column(this, "create_user");
	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	public final Column CREATE_TIME = new Column(this, "create_time");
	/**
	 * <!-- begin-user-doc --> 记事本内容 * <!-- end-user-doc -->
	 */
	public final Column NOTEPAD_CONTENT = new Column(this, "notepad_content");
	/**
	 * <!-- begin-user-doc --> 移交人员 * <!-- end-user-doc -->
	 */
	public final Column TRANSFER_USER = new Column(this, "transfer_user");
	/**
	 * <!-- begin-user-doc --> 移交时间 * <!-- end-user-doc -->
	 */
	public final Column TRANSFER_TIME = new Column(this, "transfer_time");
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

	public TUserNotepadTable() {
		super("t_user_notepad");
	}

	public TUserNotepadTable(String schemaName) {
		super(schemaName, "t_user_notepad");
	}

	public TUserNotepadTable(String schemaName, String alias) {
		super(schemaName, "t_user_notepad", alias);
	}

	public TUserNotepadTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "t_user_notepad", alias, withAs);
	}

	public Class<TUserNotepad> getPojoType() {
		return TUserNotepad.class;
	}

}
