package com.test.parkinglot.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.test.parkinglot.service.ParkingLotService;

import static java.lang.System.exit;

public class ParkingLotClient {
	
	private static ParkingLotService parkingLotService;
	
	public static void main(String[] args) throws IOException {
		parkingLotService  = new ParkingLotService();
		if(args.length == 0){
			interactiveMethod();
		}
		else if(args.length == 3){
			inputFileMethod(args);
		}
	}

	private static void interactiveMethod() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String input = br.readLine();
			System.out.println(execute(input)+"\n");
		}
	}

	private static void inputFileMethod(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String input;
		
		File file = new File(args[2]);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		while ((input = br.readLine()) != null) {
			bw.write(execute(input));
			bw.write("\n\n");
		}
		br.close();
		bw.close();
	}
	
	private static String execute(String input) {
		// TODO Auto-generated method stub
		switch(input.split(" ")[0]){
			case "create_parking_lot" : return parkingLotService.createParkingLot(input);
			case "park" :return parkingLotService.parkTheVehicle(input);
			case "leave" :return parkingLotService.leaveTheVehicle(input);
			case "status" :return parkingLotService.displayStatus();
			case "registration_numbers_for_cars_with_colour" :return parkingLotService.registrationNumbersForCarsWithColour(input);
			case "slot_numbers_for_cars_with_colour" :return parkingLotService.slotNumbersForCarsWithColour(input);
			case "slot_number_for_registration_number" :return parkingLotService.slotNumberForRegistrationNumber(input);
			case "exit":exit(0);
		}
		return "Command not found";
	}
}
