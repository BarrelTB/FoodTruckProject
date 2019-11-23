package com.skilldistillery.foodtrucks;

public class FoodTruck {

	// F I E L D S
	private int iD;
	private static int uniqueId;
	private String name;
	private String foodType;
	private int rating;

	// C O N S T R U C T O R S
	public FoodTruck(String name, String foodType, int rating) {
		super();
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.iD = ++uniqueId;
	}

	// M E T H O D S
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Food Truck ID: " + iD + "\nFood Truck Name: " + name + "\nFood Truck Type: " + foodType
				+ "\nFood Truck Rating: " + rating;
	}

}
