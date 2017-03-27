package com.common.utils.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自增长标志
 * 
 * @author zhuxinyu.carter
 * @version $Id: AutoIncrement.java, v 0.1 2013-7-17 下午1:23:22 zhuxinyu.carter Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface IncrementAuto {

	String value() default "0";
}
