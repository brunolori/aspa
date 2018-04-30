package com.lori.aspa.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.lori.aspa.exceptions.AppException;
import org.springframework.transaction.annotation.Transactional;



@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(rollbackFor= {AppException.class,Exception.class})
public @interface AppTransactional {
	

}