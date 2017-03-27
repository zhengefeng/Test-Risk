package com.common.utils.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动更新标识
 * 
 * @author zhuxinyu.carter
 * @version $Id: AutoTimestamp.java, v 0.1 2013-7-17 下午1:23:38 zhuxinyu.carter Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface TimeStampAuto {

}
