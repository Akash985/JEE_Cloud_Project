package com.capgemini.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.capgemini.exception.UserDateEqualCurrDateException;
import com.capgemini.exception.UserDateExceedLimitException;
import com.capgemini.exception.UserDateFallBehindCurrDateException;

public class DateOperationImpl implements DateOperation{

	@Override
	public String validateDate(String date) throws ParseException, UserDateExceedLimitException, UserDateFallBehindCurrDateException, UserDateEqualCurrDateException {

		SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		Date currdt = cal.getTime();//today's date
		String crrdt1 = SDFormat.format(currdt);
		
		
		cal.add(Calendar.DAY_OF_MONTH, 14);
		Date offsetDt = cal.getTime();//14 days later
//		System.out.println("offdate:"+SDFormat.format(offsetDt)); 
		
		Date userDt;
		userDt = SDFormat.parse(date);
		String userDate = SDFormat.format(userDt);

		if(userDt.after(offsetDt)) {
			throw new UserDateExceedLimitException(offsetDate());
		}else if (crrdt1.equals(userDate)) {
			throw new UserDateEqualCurrDateException();
		}else if (userDt.before(currdt)) {
			throw new UserDateFallBehindCurrDateException(date); 
		}
		
		return userDate;
	}

	
	@Override
	public String offsetDate() {
		SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		Date currdt = cal.getTime();
		
		cal.add(Calendar.DAY_OF_MONTH, 14);
		Date offsetDt = cal.getTime();
		String offsetDate = SDFormat.format(offsetDt);
		return offsetDate;
	}

}
