
package org.tinygroup.workplan.dao.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;
import org.tinygroup.workplan.dao.inter.pojo.TStikyno;

/**
 * <!-- begin-user-doc --> 记事便签 * <!-- end-user-doc -->
 */
public class TStikynoTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final TStikynoTable T_STIKYNO_TABLE = new TStikynoTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 创建人员 * <!-- end-user-doc -->
	 */
	public final Column CREATE_USER = new Column(this, "create_user");
	/**
	 * <!-- begin-user-doc --> 创建时间 * <!-- end-user-doc -->
	 */
	public final Column CREATE_TIME = new Column(this, "create_time");
	/**
	 * <!-- begin-user-doc --> 标题 * <!-- end-user-doc -->
	 */
	public final Column TILTE = new Column(this, "tilte");
	/**
	 * <!-- begin-user-doc --> 内容 * <!-- end-user-doc -->
	 */
	public final Column CONTENT = new Column(this, "content");
	/**
	 * <!-- begin-user-doc --> TYPE * <!-- end-user-doc -->
	 */
	public final Column TYPE = new Column(this, "type");
	/**
	 * <!-- begin-user-doc --> 拟处理时间 * <!-- end-user-doc -->
	 */
	public final Column HANDLE_TIME = new Column(this, "handle_time");
	/**
	 * <!-- begin-user-doc --> 拟解决时间 * <!-- end-user-doc -->
	 */
	public final Column SOLVE_TIME = new Column(this, "solve_time");
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

	public TStikynoTable() {
		super("t_stikyno");
	}

	public TStikynoTable(String schemaName) {
		super(schemaName, "t_stikyno");
	}

	public TStikynoTable(String schemaName, String alias) {
		super(schemaName, "t_stikyno", alias);
	}

	public TStikynoTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "t_stikyno", alias, withAs);
	}

	public Class<TStikyno> getPojoType() {
		return TStikyno.class;
	}

}
