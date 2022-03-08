package com.bridgelab.hotelreservation;

import java.time.LocalDate;
import java.util.stream.Stream;
import java.time.*;

public class HotelDetails {
	
	private int rates;
    private String hotelName;
    private int totalRates;
    private int weekdaysRate;
	private int weekendsRate;
    
    @Override
    public String toString() {
    	return "\n Hotel Name : " + hotelName +
    			"\n Week Days Rates: " + weekdaysRate +
    			"\n Week Ends Rates: " + weekendsRate;
//    			"\n Hotel Rates : " + rates;
    }
    
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRates() {
        return rates;
    }

    public void setRates(int rates) {
        this.rates = rates;
    }

//	public int getTotalRates(int daysInBetween) {
//		totalRates = rates * (daysInBetween+1);
//		return totalRates;
//	}
    
    //UseCase4
    public int getTotalRates(LocalDate startDate, LocalDate endDate) {
		int day1Rate = Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1)
                .map(date -> {
                    if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                        return getWeekendsRate();
                    }
                    return getWeekdaysRate();
                })
                .reduce((total, next) -> total).get();
		int day2Rate = Stream.iterate(endDate, date -> date.plusDays(1))
                .limit(endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1)
                .map(date -> {
                    if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                        return getWeekendsRate();
                    }
                    return getWeekdaysRate();
                })
                .reduce((total, next) -> total).get();
		
		return day1Rate+day2Rate;
	} 
	
	public void setTotalRates(int totalRates) {
		this.totalRates = totalRates;
	}
	
	public int getWeekdaysRate() {
		return weekdaysRate;
	}

	public void setWeekdaysRate(int weekdaysRate) {
		this.weekdaysRate = weekdaysRate;
	}
	
	public int getWeekendsRate() {
		return weekendsRate;
	}

	public void setWeekendsRate(int weekendsRate) {
		this.weekendsRate = weekendsRate;
	}
}
