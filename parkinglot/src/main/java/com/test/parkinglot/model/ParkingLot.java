package com.test.parkinglot.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	
	private List<ParkingSlot> parkingSlots;
	private Integer Size;
	
	public ParkingLot() {
		super();
		Size = 0;
		parkingSlots = new ArrayList<ParkingSlot>();
	}
	public List<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}
	public void setParkingSlots(List<ParkingSlot> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}
	public Integer getSize() {
		return Size;
	}
	public void setSize(Integer size) {
		Size = size;
	}
	
	
}
