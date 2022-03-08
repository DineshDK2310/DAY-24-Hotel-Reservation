package com.bridgelab.hotelreservation;

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

	public int getTotalRates(int daysInBetween) {
		totalRates = rates * (daysInBetween+1);
		return totalRates;
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
