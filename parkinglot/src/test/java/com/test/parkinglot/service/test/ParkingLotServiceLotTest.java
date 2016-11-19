package com.test.parkinglot.service.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.test.parkinglot.model.ParkingSlot;
import com.test.parkinglot.model.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.test.parkinglot.model.ParkingLot;
import com.test.parkinglot.service.ParkingLotService;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotServiceLotTest {

	@Mock
	private ParkingLot parkingLot;

	@InjectMocks
	private ParkingLotService parkingLotService = new ParkingLotService();

	@Before
	public void createMocks() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void createParkingLotTest(){
		String result = parkingLotService.createParkingLot("create_parking_lot 6");
		Assert.assertEquals("Created a parking lot with 6 slots", result);
	}
	
	@Test
	public void slotNumbersForCarsWithColourTest(){
		List<ParkingSlot> parkingSlots = new ArrayList<>();
		parkingSlots.add(new ParkingSlot(1,new Vehicle("KA­01­HH­1234","White")));
		parkingSlots.add(new ParkingSlot(2,new Vehicle("KA­01­HH­8055","Red")));
		when(parkingLot.getParkingSlots()).thenReturn(parkingSlots);
		String result = parkingLotService.slotNumbersForCarsWithColour("slot_numbers_for_cars_with_colour White");
		Assert.assertEquals("1", result);
	}

	@Test
	public void slotNumberForRegistrationNumberTest(){
		List<ParkingSlot> parkingSlots = new ArrayList<>();
		parkingSlots.add(new ParkingSlot(1,new Vehicle("KA­01­HH­1234","White")));
		parkingSlots.add(new ParkingSlot(2,new Vehicle("KA-01-HH-8055","Red")));
		when(parkingLot.getParkingSlots()).thenReturn(parkingSlots);
		String result = parkingLotService.slotNumberForRegistrationNumber("slot_number_for_registration_number KA-01-HH-8055");
		Assert.assertEquals("2", result);
	}

	@Test
	public void registrationNumbersForCarsWithColourTest(){
		List<ParkingSlot> parkingSlots = new ArrayList<>();
		parkingSlots.add(new ParkingSlot(1,new Vehicle("KA­01­HH­1234","White")));
		parkingSlots.add(new ParkingSlot(2,new Vehicle("KA­01­HH­8055","Red")));
		when(parkingLot.getParkingSlots()).thenReturn(parkingSlots);
		String result = parkingLotService.registrationNumbersForCarsWithColour("registration_numbers_for_cars_with_colour Red");
		Assert.assertEquals("KA­01­HH­8055", result);
	}

	@Test
	public void displayStatusTest(){
		String expected = "Slot No.\tRegistration No\tColour\n" +
				"1\tKA\u00AD01\u00ADHH\u00AD1234\tWhite\n" +
				"2\tKA\u00AD01\u00ADHH\u00AD8055\tRed";
		List<ParkingSlot> parkingSlots = new ArrayList<>();
		parkingSlots.add(new ParkingSlot(1,new Vehicle("KA­01­HH­1234","White")));
		parkingSlots.add(new ParkingSlot(2,new Vehicle("KA­01­HH­8055","Red")));
		when(parkingLot.getParkingSlots()).thenReturn(parkingSlots);
		String result = parkingLotService.displayStatus();
		Assert.assertEquals(expected, result);
	}

	@Test
	public void leaveTheVehicleTest(){
		List<ParkingSlot> parkingSlots = new ArrayList<>();
		parkingSlots.add(new ParkingSlot(1,new Vehicle("KA­01­HH­1234","White")));
		parkingSlots.add(new ParkingSlot(2,new Vehicle("KA­01­HH­8055","Red")));
		when(parkingLot.getParkingSlots()).thenReturn(parkingSlots);
		String result = parkingLotService.leaveTheVehicle("leave 1");
		Assert.assertEquals("Slot number 1 is free", result);
	}

	@Test
	public void parkTheVehicleTest(){
		List<ParkingSlot> parkingSlots = new ArrayList<>();
		parkingSlots.add(new ParkingSlot(1,new Vehicle("KA­01­HH­1234","White")));
		parkingSlots.add(new ParkingSlot(2,new Vehicle("KA­01­HH­8055","Red")));
		when(parkingLot.getParkingSlots()).thenReturn(parkingSlots);
		String result = parkingLotService.parkTheVehicle("park KA\u00AD01\u00ADHH\u00AD3141 Black");
		Assert.assertEquals("Sorry, parking lot is full", result);
	}
}
