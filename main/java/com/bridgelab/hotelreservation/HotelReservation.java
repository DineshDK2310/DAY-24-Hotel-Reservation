package com.bridgelab.hotelreservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotelReservation {

	private final DateTimeFormatter DATE_RANGE_FORMAT = DateTimeFormatter.ofPattern("ddMMMyyyy");

	ArrayList<HotelDetails> hotel = new ArrayList<>();

	static Scanner sc = new Scanner(System.in);

	//usecase1
	public boolean addHotel() {

		HotelDetails hotelDetail = new HotelDetails();

		System.out.println("Hotel name: ");
		hotelDetail.setHotelName(sc.next());

		System.out.println("Hotel Rate: ");
		hotelDetail.setRates(sc.nextInt());

		System.out.println("Hotel Added in program");

		if(hotel.add(hotelDetail))
			return true;
		else
			return false;
	}

	//ucecase2
	public  ArrayList<HotelResult> findCheapestHotel(String startDateRange, String endDateRange) {
		LocalDate startDate = LocalDate.parse(startDateRange, DATE_RANGE_FORMAT);
		LocalDate endDate = LocalDate.parse(endDateRange, DATE_RANGE_FORMAT);
		int noOfDaysBetween = (int)ChronoUnit.DAYS.between(startDate, endDate);
		
		ArrayList<HotelResult> hotelObj = (ArrayList<HotelResult>) hotel.stream()
				.map(hotel -> {
					HotelResult hotelresult = new HotelResult();
					hotelresult.setName(hotel.getHotelName());
					hotelresult.setTotalRate(hotel.getTotalRates(noOfDaysBetween));
					return hotelresult;
				})
				.sorted((type1, type2) -> (int)(type1.getTotalRate() - type2.getTotalRate()))
				.collect(Collectors.toList());
		return (ArrayList<HotelResult>) hotelObj.stream().filter(result -> result.getTotalRate() == hotelObj.get(0).getTotalRate())
				.collect(Collectors.toList());
	}

	public void displayHotels() {
		System.out.println("\nDifferent Hotels available");

		for (HotelDetails data : hotel)
			System.out.println(data);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program");

		HotelReservation hr = new HotelReservation(); 

		int choice;
		do {
			System.out.println("You can give your choice : ");
			System.out.println("1.Add Hotels");
			System.out.println("2.Display Hotels");
			System.out.println("3.Cheapest Hotel");
			System.out.println("4.Exit from Program");
			choice= sc.nextInt();
			switch(choice) {
			case 1: 
				System.out.println("How many hotels you want to add");
				int hotelNum = sc.nextInt();
				for(int value=1; value<=hotelNum; value++) {
					hr.addHotel();
				}
				break;
			case 2:
				hr.displayHotels();
				break;
			case 3:
				System.out.println(hr.findCheapestHotel("10Sep2020", "11Sep2020"));
				break;
			case 4:
				break;
			}System.out.println("Want to do more operation on hotels then press 1");
			choice = sc.nextInt();
		}while(choice == 1);

		sc.close();
	}

}
