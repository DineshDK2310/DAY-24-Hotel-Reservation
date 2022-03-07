package com.bridgelab.hotelreservation;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservation {
	int count;
	ArrayList<HotelDetails> hotel = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public boolean addHotel() {

		HotelDetails hotelDetail = new HotelDetails();

		System.out.println("Hotel name: ");
		hotelDetail.setHotelName(sc.next());

		System.out.println("Hotel Rate: ");
		hotelDetail.setRates(sc.nextInt());

		hotel.add(hotelDetail);
		System.out.println("Hotel Added in program");
		count++;
		if(hotel.add(hotelDetail))
			return true;
		else
			return false;
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
			System.out.println("3.Exit from Program");
			choice= sc.nextInt();
			switch(choice) {
			case 1: 
				System.out.println("How many hotels you want to add");
				for(int value=1; value<=3; value++) {
					hr.addHotel();
				}
				break;
			case 2:
				hr.displayHotels();
				break;
			case 3:
				break;
			}System.out.println("If You Want to Add or display or exit hotels then press 1");
			choice = sc.nextInt();
		}while(choice == 1);

		sc.close();
	}

}
