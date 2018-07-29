/**
 * 
 */
package com.example.demo.model.entities;

/**
 * @author msaxena
 *
 */
public class Restaurant extends Entity {

	private final String City;

	private final String houseNo;

	private final String streetName;

	public Restaurant(final String id, final String restaurantName, final String streetName, final String city, final String houseNo) {
		this.id = id;
		this.name = restaurantName;
		this.streetName = streetName;
		this.City = city;
		this.houseNo = houseNo;
	}

	public String getCity() {
		return City;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Restaurant [City=" + City + ", houseNo=" + houseNo + ", streetName=" + streetName + ", id=" + id
				+ ", name=" + name + "]";
	}

}
