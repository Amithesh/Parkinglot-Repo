package com.test.parkinglot.model;

public class ParkingSlot {
	
	private int number;
	private Vehicle vehicle;
	
	public ParkingSlot(int number, Vehicle car) {
		super();
		this.number = number;
		this.vehicle = car;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		result = prime * result + number;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingSlot other = (ParkingSlot) obj;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ParkingLot [number=" + number + ", car=" + vehicle + "]";
	}
	
	
}
