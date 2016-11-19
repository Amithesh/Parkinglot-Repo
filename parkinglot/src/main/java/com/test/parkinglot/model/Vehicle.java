package com.test.parkinglot.model;

public class Vehicle {
	
	private String registerationNumber;
	private String Color;
	
	
	public Vehicle(String registerationNumber, String color) {
		super();
		this.registerationNumber = registerationNumber;
		Color = color;
	}
	
	public String getRegisterationNumber() {
		return registerationNumber;
	}
	public void setRegisterationNumber(String registerationNumber) {
		this.registerationNumber = registerationNumber;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Color == null) ? 0 : Color.hashCode());
		result = prime * result + ((registerationNumber == null) ? 0 : registerationNumber.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (Color == null) {
			if (other.Color != null)
				return false;
		} else if (!Color.equals(other.Color))
			return false;
		if (registerationNumber == null) {
			if (other.registerationNumber != null)
				return false;
		} else if (!registerationNumber.equals(other.registerationNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [registerationNumber=" + registerationNumber + ", Color=" + Color + "]";
	}
	
	
	
}
