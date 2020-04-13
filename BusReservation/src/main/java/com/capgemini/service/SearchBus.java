package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Bus;

public interface SearchBus {
	List<Bus> showAvailableBuses(String source,String destination);
}
