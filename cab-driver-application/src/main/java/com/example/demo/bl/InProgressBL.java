package com.example.demo.bl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.service.TripInProgressService;

@Component
public class InProgressBL {

	@Autowired
	private TripInProgressService serviceforinprogress;

	public Optional<List<BookingRequest>> findShowusers(long srchid) {
		return this.serviceforinprogress.findShowUsers(srchid);

	}

	// For storing status of Employee
	public BookingRequest storeEmployeeStatus(String employeeID) {

		return this.serviceforinprogress.storeEmployeeStatus(employeeID);
	}

	public TripCabInfo updateTrip(long tripCabID) {

		return this.serviceforinprogress.updateTrip(tripCabID);
	}

	public TripCabInfo getBookingTime(long tripCabID) {

		return this.serviceforinprogress.getBookingTime(tripCabID);
	}

}
