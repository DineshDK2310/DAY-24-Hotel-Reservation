package com.bridgelab.hotelreservation;

public class HotelResult {
	
	private String name;
	private int totalRate;
	
	@Override
    public String toString() {
        return "Result{" +
                "hotelName='" + name + '\'' +
                ", totalRate=" + totalRate +
                '}';
    }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTotalRate() {
		return totalRate;
	}
	
	public void setTotalRate(int totalRate) {
		this.totalRate = totalRate;
	}

}
