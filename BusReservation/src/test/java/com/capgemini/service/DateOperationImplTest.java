package com.capgemini.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.exception.UserDateEqualCurrDateException;
import com.capgemini.exception.UserDateExceedLimitException;
import com.capgemini.exception.UserDateFallBehindCurrDateException;

public class DateOperationImplTest {
	 DateOperation dtopt=null;
	 SimpleDateFormat SDFormat = null;
	 Calendar cal = null;
	 Date currdt = null;
	 Date offsetDt1 = null;
	 Date offsetDt2 = null;
	 Date offsetDt3 = null;
	 String currDate = null;
	 String offsetBeforCurDate = null;
	 String offsetAfter5Days = null;
	 String offsetAfterLimDate = null;
	
	
	
	@Before
	public  void setUp() {
		dtopt = new DateOperationImpl();
		
		SDFormat = new SimpleDateFormat("dd/MM/yyyy");
		cal = Calendar.getInstance();
		currdt = cal.getTime();//indate format
		currDate = SDFormat.format(currdt);//in String format
	}
	
	@After
	public  void teardown() {
		 dtopt=null;
		 cal = null;
	}

	
	
	@Test
	public void testValidateDateFallsInValidDateRange() {
		cal.add(Calendar.DAY_OF_MONTH, 5);
		offsetDt2 = cal.getTime();//indate format-->5 days later
		offsetAfter5Days = SDFormat.format(offsetDt2);//in String format
		String str = null;
		try {
			str = dtopt.validateDate(offsetAfter5Days);
		} catch (ParseException | UserDateExceedLimitException | UserDateFallBehindCurrDateException
				| UserDateEqualCurrDateException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(offsetAfter5Days, str);
	}
	
	@Test(expected = ParseException.class)
	public void testValidateDateForParseException() throws ParseException {
		
		try {
			String str1 = dtopt.validateDate("3-6-2020");
		} catch ( UserDateExceedLimitException | UserDateFallBehindCurrDateException
				| UserDateEqualCurrDateException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	@Test(expected = UserDateExceedLimitException.class)
	public void testValidateDateForUserDateExceedLimitException() throws UserDateExceedLimitException {
		
		
		cal.add(Calendar.DAY_OF_MONTH, 15);
		offsetDt3 = cal.getTime();//indcate format-->15 days after
		offsetAfterLimDate = SDFormat.format(offsetDt3);//in String format
		
		try {
			String str1 = dtopt.validateDate(offsetAfterLimDate);
		} catch ( ParseException | UserDateFallBehindCurrDateException
				| UserDateEqualCurrDateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(expected = UserDateEqualCurrDateException.class)
	public void testValidateDateForUserDateEqualCurrDateException() throws UserDateEqualCurrDateException {
		try {
			String str1 = dtopt.validateDate(currDate);
		} catch ( ParseException | UserDateExceedLimitException | UserDateFallBehindCurrDateException
				 e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(expected = UserDateFallBehindCurrDateException.class)
	public void testValidateDateForUserDateFallBehindCurrDateException() throws UserDateFallBehindCurrDateException {
		cal.add(Calendar.DAY_OF_MONTH, -1);
		offsetDt1 = cal.getTime();//indcate format-->yesterday
		offsetBeforCurDate = SDFormat.format(offsetDt1);//in String format		
		try {
			String str1 = dtopt.validateDate(offsetBeforCurDate);
		} catch ( ParseException| UserDateExceedLimitException | UserDateEqualCurrDateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	@Test
	public void testOffsetDateForReturning15DaysLaterDate() {
		cal.add(Calendar.DAY_OF_MONTH, 14);
		offsetDt3 = cal.getTime();//indcate format-->on 15th day
		offsetAfterLimDate = SDFormat.format(offsetDt3);//in String format		
		assertEquals(offsetAfterLimDate, dtopt.offsetDate());
		
	}

}
