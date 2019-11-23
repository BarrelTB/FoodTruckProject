package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {

	public Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();

		FoodTruck[] trucks = new FoodTruck[5];

		app.run(trucks);

	}

	public void run(FoodTruck[] trucks) {

		boolean running = true;

		while (running) {
			for (int truck = 0, iD = 1; truck < trucks.length; truck++, iD++) {
				System.out.println("Please enter the name of a food truck: ");
				System.out.println("Or to quit where you're at and view the trucks type Quit:");
				System.out.println();
				String name = kb.nextLine();
				if (name.equals("Quit")) {
					running = false;
					displayFoodTruckOptions(trucks);
					break;
				}
				System.out.println();
				System.out.println("Please enter the food type of the food truck: ");
				System.out.println();
				String type = kb.nextLine();
				System.out.println();
				System.out.println("Please enter the rating of the food truck: ");
				System.out.println();
				int rating = kb.nextInt();
				kb.nextLine(); // scanner needs this because nextInt stays on same line.
				trucks[truck] = new FoodTruck(name, type, rating, iD);

			}
		}

	}

	public void displayFoodTruckOptions(FoodTruck[] trucks) {
		if (trucks[0] == null) {
			exitGame();
		} else {
			for (int i = 0; i < trucks.length; i++) {
				System.out.println("Option 1: List all existing food trucks.");
				System.out.println("Option 2: See the average rating of food trucks.");
				System.out.println("Option 3: Display the highest-rated food truck.");
				System.out.println("Option 4: Quit the program.");
				System.out.println();
				int option = kb.nextInt();
				switch (option) {
					case 1:
						displayFoodTrucks(trucks);
					case 2:
						displayAverageRating(trucks);
					case 3:
						displayHighestRated(trucks);
					case 4:
						exitGame();

				}
				kb.nextLine();
			}
		}

	}

	public void exitGame() {
		System.out.println("Thank you for playing.");
	}

	public void displayFoodTrucks(FoodTruck[] trucks) {
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				System.out.println("Food Truck: " + trucks[i].getiD());
				System.out.println("Food Truck Name: " + trucks[i].getName());
				System.out.println("Food Truck Type: " + trucks[i].getFoodType());
				System.out.println("Food Truck Rating: " + trucks[i].getRating());
				System.out.println();
			} else {
				displayFoodTruckOptions(trucks);
				break;

			}
		}
	}

	public void displayAverageRating(FoodTruck[] trucks) {
		int average = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null)
				average += trucks[i].getRating();
		}
		System.out.println("Food Trucks Average Rating: " + average);
		System.out.println();
		displayFoodTruckOptions(trucks);

	}

	public void displayHighestRated(FoodTruck[] trucks) {
		int rated = trucks[0].getRating();
		int a = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				if (trucks[i].getRating() > rated) {
					rated = trucks[i].getRating();
					a = i;
				}
			}
		}
		System.out.println("The Food Truck with the highest rating is: " + trucks[a].getName() + " with a rating of " + rated);
		System.out.println();
		displayFoodTruckOptions(trucks);
	}

}
