package com.capgemini.service;

import java.text.ParseException;

import com.capgemini.exception.UserDateEqualCurrDateException;
import com.capgemini.exception.UserDateExceedLimitException;
import com.capgemini.exception.UserDateFallBehindCurrDateException;

public interface DateOperation {
	
	String validateDate(String date) throws ParseException, UserDateExceedLimitException, UserDateFallBehindCurrDateException, UserDateEqualCurrDateException;	
	String offsetDate();

}
