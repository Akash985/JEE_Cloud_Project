package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.BusNotAvailableException;
import com.capgemini.exception.SourceAndDestinationAreEqualException;
import com.capgemini.model.Bus;

public interface SearchBus {
	List<Bus> showAvailableBuses(String source, String destination, String date) throws BusNotAvailableException, SourceAndDestinationAreEqualException;
}
