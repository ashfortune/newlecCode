package com.newlecture.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Precision {
	public int val() default 2;
	public int value() default 2;
	public String format() default "%.2f";
}
