package com.project.dto;

public class HotelDTO {

	private Long hotelId;
	private String hotelName;
	private String hotelAddress;
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAddress() {
		return hotelAddress;
	}
	public void setAddress(String address) {
		this.hotelAddress = address;
	}

	public HotelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public HotelDTO(Long hotelId, String hotelName, String address) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelAddress= address;
	}
	
}