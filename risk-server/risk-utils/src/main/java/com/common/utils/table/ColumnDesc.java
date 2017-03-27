package com.common.utils.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字段描述
 * 
 * @author zhuxinyu.carter
 * @version $Id: ColumnDesc.java, v 0.1 2013-7-17 下午1:26:36 zhuxinyu.carter Exp $
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnDesc {

	String value() default "";
}
