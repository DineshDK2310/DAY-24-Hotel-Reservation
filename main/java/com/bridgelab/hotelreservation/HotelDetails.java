package com.bridgelab.hotelreservation;

public class HotelDetails {
	
	private int rates;
    private String hotelName;
    
    
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
    
    @Override
    public String toString() {
    	return "\n Hotel Name : " + hotelName +
    			"\n Hotel Rates : " + rates;
    }
    

}
