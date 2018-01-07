
package org.tinygroup.buildinfo.dao.inter.constant;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildAboutas;
import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;

/**
 * <!-- begin-user-doc --> 企业简介表 * <!-- end-user-doc -->
 */
public class BuildAboutasTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static final BuildAboutasTable BUILD_ABOUTAS_TABLE = new BuildAboutasTable();

	/**
	 * <!-- begin-user-doc --> ID * <!-- end-user-doc -->
	 */
	public final Column ID = new Column(this, "id");
	/**
	 * <!-- begin-user-doc --> 企业简介内容 * <!-- end-user-doc -->
	 */
	public final Column ABOUTAS_CONTENT = new Column(this, "aboutas_content");
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

	public BuildAboutasTable() {
		super("build_aboutas");
	}

	public BuildAboutasTable(String schemaName) {
		super(schemaName, "build_aboutas");
	}

	public BuildAboutasTable(String schemaName, String alias) {
		super(schemaName, "build_aboutas", alias);
	}

	public BuildAboutasTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "build_aboutas", alias, withAs);
	}

	public boolean isAutoGeneratedKeys() {
		return true;
	}

	public Class<BuildAboutas> getPojoType() {
		return BuildAboutas.class;
	}

}
