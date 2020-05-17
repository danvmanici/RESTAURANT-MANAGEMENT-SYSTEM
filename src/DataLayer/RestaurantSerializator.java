package DataLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import BusinessLayer.Restaurant;

public class RestaurantSerializator {
	
	public static void serializeRestaurantData(Restaurant restaurant) {
		try {
			String filename = "restaurant.ser"; 
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(restaurant);
			out.close();
			fileOut.close();
			System.out.println("\nObject has been serialized\n"); 
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Restaurant deserializeRestaurantData() {
		Restaurant restaurant = null;
		try {
			String filename = "restaurant.ser";
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			restaurant = (Restaurant) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("\nObject has been deserialized\n"); 
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Restaurant class not found!");
		}
		
		return restaurant;

	}
}
