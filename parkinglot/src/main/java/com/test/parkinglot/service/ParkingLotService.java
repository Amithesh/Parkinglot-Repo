package com.test.parkinglot.service;

import com.test.parkinglot.model.ParkingLot;
import com.test.parkinglot.model.ParkingSlot;
import com.test.parkinglot.model.Vehicle;
import com.test.parkinglot.utils.Utils;

import java.util.Iterator;
import java.util.List;

public class ParkingLotService {

	private ParkingLot parkingLot;

	public ParkingLotService(){
		parkingLot = new ParkingLot();
	}
	
	public String slotNumberForRegistrationNumber(String input) {
		// TODO Auto-generated method stub
		StringBuilder result =new StringBuilder();
		String registerNumber = input.split(" ")[1];
		int index = 0;
		for(ParkingSlot parkingSlot :parkingLot.getParkingSlots()){
			if(parkingSlot.getVehicle().getRegisterationNumber().equals(registerNumber)){
				if(index == 0)
					result.append(parkingSlot.getNumber());
				else
					result.append(","+parkingSlot.getNumber());
				index++;
			}
		}
		if(index == 0){
			result.append("Not found");
		}
		//result.append("\n");
		return result.toString();
	}

	public String slotNumbersForCarsWithColour(String input) {
		// TODO Auto-generated method stub
		StringBuilder result =new StringBuilder();
		String color = input.split(" ")[1];
		int index = 0;
		for(ParkingSlot parkingSlot :parkingLot.getParkingSlots()){
			if(parkingSlot.getVehicle().getColor().equals(color)){
				if(index == 0)
					result.append(parkingSlot.getNumber());
				else
					result.append(","+parkingSlot.getNumber());
				index++;
			}
		}
		if(index == 0){
			result.append("Not found");
		}
		//result.append("\n");
		return result.toString();
	}

	public String registrationNumbersForCarsWithColour(String input) {
		// TODO Auto-generated method stub
		StringBuilder result =new StringBuilder();
		String color = input.split(" ")[1];
		int index = 0; 
		for(ParkingSlot parkingSlot :parkingLot.getParkingSlots()){
			if(parkingSlot.getVehicle().getColor().equals(color)){
				if(index == 0)
					result.append(parkingSlot.getVehicle().getRegisterationNumber());
				else
					result.append(","+parkingSlot.getVehicle().getRegisterationNumber());
				index++;
			}
		}
		if(index == 0){
			result.append("Not found");
		}
		//result.append("\n");
		return result.toString();
	}

	public String displayStatus() {
		// TODO Auto-generated method stub
		StringBuilder result =new StringBuilder();
		result.append("Slot No."+ "\t" +"Registration No"+ "\t" +"Colour");
		for(ParkingSlot parkingSlot :parkingLot.getParkingSlots()){
			result.append("\n"+parkingSlot.getNumber()+"\t"+parkingSlot.getVehicle().getRegisterationNumber()+"\t"+parkingSlot.getVehicle().getColor());
		}
		return result.toString();
	}

	public String leaveTheVehicle(String input) {
		// TODO Auto-generated method stub
		int slot = Integer.parseInt(input.split(" ")[1]);
		List<ParkingSlot> parkingSlotList = parkingLot.getParkingSlots();
		Iterator<ParkingSlot> parkingSlotIterator = parkingSlotList.iterator();
		while(parkingSlotIterator.hasNext()){
			ParkingSlot parkingSlot = parkingSlotIterator.next();
			if(parkingSlot.getNumber() == slot){
				parkingSlotIterator.remove();
				return "Slot number "+slot+" is free";
			}
		}
		return "Slot is already empty";
	}

	public String parkTheVehicle(String input) {
		// TODO Auto-generated method stub
		StringBuilder result =new StringBuilder();
		if(parkingLot.getParkingSlots().size() < parkingLot.getSize()){
			int slot = getEmptyParkingLotNumber();
			String vehicleNumber = input.split(" ")[1].toUpperCase();
			String carColor = input.split(" ")[2];
			Vehicle vehicle = new Vehicle(vehicleNumber,carColor);
			ParkingSlot parkingSlot = new ParkingSlot(slot, vehicle);
			result.append("Allocated slot number: "+slot);
			parkingLot.getParkingSlots().add(parkingSlot);
			//System.out.println(parkingLot.getParkingSlots().toString());
		}
		else{
			result.append("Sorry, parking lot is full");
		}
		return result.toString();
	}

	private int getEmptyParkingLotNumber() {
		int min=1;
		for(ParkingSlot parkingSlot: parkingLot.getParkingSlots()){
			min  = min<parkingSlot.getNumber() ? min : parkingSlot.getNumber()+1;
		}	
		return min;
	}

	public String createParkingLot(String input){
		// TODO Auto-generated method stub
		int size = Integer.parseInt(input.split(" ")[1]);
		parkingLot.setSize(size);
		return "Created a parking lot with "+ size +" slots";
	}	
}
