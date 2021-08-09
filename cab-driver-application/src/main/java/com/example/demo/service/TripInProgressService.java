package com.example.demo.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.BookingRequestRepository;
import com.example.demo.repo.TripCabInfoRepository;



@Service
public class TripInProgressService {

	@Autowired
    private BookingRequestRepository repo;

	@Autowired
	private TripCabInfoRepository triprepo;
	

	
	
	public BookingRequest storeEmployeeStatus(String employeeID) {
		BookingRequest status= repo.findByEmployeeId(employeeID);
		if (status != null) {
			status.setStatus("Reached");
			status.setReachedTime(LocalTime.now());
		    repo.save(status);
		}
		return status;
		

	}



	//For updating the end status of cab
	public TripCabInfo updateTrip(long tripCabId) {
		Optional<TripCabInfo> save= triprepo.findById(tripCabId);
		TripCabInfo status= save.get();
		status.setEndTime(LocalTime.now());
		status.setStatus("Completed");
		return triprepo.save(status);
	}


	//For getting server time-startTime
	public TripCabInfo getBookingTime(long tripCabID) {

	Optional<TripCabInfo> save= triprepo.findById(tripCabID);
	return save.get();
	}

	public Optional<List<BookingRequest>> findShowUsers(long srchid) {
		return this.repo.findShowUsers(srchid);
	}
	
}
