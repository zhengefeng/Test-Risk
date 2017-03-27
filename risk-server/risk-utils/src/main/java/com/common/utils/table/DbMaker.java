package com.common.utils.table;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.common.utils.entity.*;
import org.apache.commons.lang3.StringUtils;

/**
 * MYSQL 脚本生成器
 * 
 * @author zhuxinyu.carter
 * @version $Id: DbCreator.java;, v 0.1 2013-7-7 上午11:06:02 zhuxinyu.carter Exp $
 */
public class DbMaker {

	public static StringBuilder generalDatabase(String schema) {
		StringBuilder sqlSchema = new StringBuilder();
		sqlSchema.append("drop database " + schema + ";\n");
		sqlSchema.append("create database " + schema + ";\n");
		sqlSchema.append("use " + schema + ";\n");
		return sqlSchema;
	}

	public static void generalTables(StringBuilder sql, String tablePre, List<Class<?>> clazzList) {
		for (Class<?> clazz : clazzList) {
			sql.append(generalTable(tablePre, clazz));
			sql.append("\n\n");
		}
	}

	public static String generalTable(String table_pre, Class<?> clazz) {
		String tableName = table_pre + clazz.getSimpleName();

		StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableName + " ( \n");
		Field fields[] = clazz.getDeclaredFields();

		String lastKey = "";
		for (Field f : fields) {
			if (!StringUtils.equalsIgnoreCase("serialVersionUID", f.getName()) && f.getAnnotation(AnnoNotColumnClass.class) == null) {
				sql.append("`").append(f.getName()).append("` ");

				Class<?> type = f.getType();
				if (type.isAssignableFrom(Integer.class) || type.isAssignableFrom(int.class)) {
					sql.append("int(11) ");
				} else if (type.isAssignableFrom(Long.class)) {
					sql.append("int(11) unsigned ");
				} else if (type.isAssignableFrom(String.class)) {
					if (f.isAnnotationPresent(Size.class)) {
						Size size = f.getAnnotation(Size.class);
						sql.append("varchar(").append(size.max()).append(")");
					} else {
						sql.append("varchar(50)");
					}
				} else if (type.isAssignableFrom(BigDecimal.class)) {
					sql.append("decimal(10,2) ");
				} else if (type.isAssignableFrom(Date.class)) {
					if (f.isAnnotationPresent(TimeStampAuto.class)) {
						sql.append("timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP ");
					} else {
						sql.append("DATETIME NOT NULL ");
					}
				}

				if (f.isAnnotationPresent(IncrementAuto.class)) {
					sql.append(" NOT NULL ").append(" AUTO_INCREMENT ");
					lastKey = "PRIMARY KEY (`" + f.getName() + "`)";
				}

				if (f.isAnnotationPresent(NotNull.class)) {
					sql.append(" NOT NULL ");
				}

				if (f.isAnnotationPresent(ColumnDesc.class)) {
					String value = f.getAnnotation(ColumnDesc.class).value();
					sql.append(" comment ").append("'").append(value).append("'");
				}

				sql.append(",\n");
			}
		}

		sql.append(lastKey);

		sql.append(" ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8; \n");

		System.out.println(sql);

		return sql.toString();
	}

	public static void makerDB(String dbName, String sql) {
		try {
			File file = new File(dbName + ".sql");
			if (file.exists()) {
				file.delete();
			}

			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(sql);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String dbName = "risk";
		List<Class<?>> cmsList = new ArrayList<Class<?>>();
		cmsList.add(Product.class);
//		cmsList.add(Company.class);
//		cmsList.add(ConsumerTemplateDetail.class);
//		cmsList.add(Consumer.class);
//
//		cmsList.add(Template.class);
//		cmsList.add(ProviderInterDetail.class);
//		cmsList.add(ProviderInter.class);
//		cmsList.add(TemplateInter.class);



//		cmsList.add(ProductCallDetail.class);
//		cmsList.add(InterParam.class);
//		cmsList.add(AdminUser.class);
//		cmsList.add(ConsumerCallDetail.class);
//		cmsList.add(TemplateInter.class);


		StringBuilder sql = generalDatabase(dbName);
		generalTables(sql, "R_", cmsList);
		makerDB(dbName, sql.toString());
	}
}
