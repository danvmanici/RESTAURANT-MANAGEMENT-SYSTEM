package BusinessLayer;

import java.sql.Date;
import java.util.ArrayList;

public interface RestaurantProcessing {

		/**
		 * 
		 * @param name
		 * @param price
		 * @param ingredients
		 * @param id
		 * pre name != null
		 * pre price != 0
		 * pre id != 0
		 * post product != null
		 */
		public void createNewMenuItem(int id, String name, double price, ArrayList<MenuItem> ingredients);
		
		/**
		 * 
		 * @param id
		 * @param name
		 * @param price
		 * pre id != 0
		 * pre name != null
		 * post product != null
		 */
		public void deleteMenuItem(String name);
		
		/**
		 * 
		 * @param name
		 * pre name != null
		 */
		public void editMenuItem(int id, String name, double price, ArrayList<MenuItem> lst);
		
		/**
		 * 
		 * @param id
		 * @param name
		 * @param price
		 * pre id != 0
		 * pre name != null
		 * post menu != null
		 */
		public Order createNewOrder(int id, String date, int table, ArrayList<MenuItem> menu);
		
		/**
		 * 
		 * @param o
		 * pre o != null
		 */
		public double computePrice(Order o);
		
		/**
		 * 
		 * @param order
		 * @param date
		 * @param tableNb
		 * @param price
		 * pre order != null
		 * pre date != null
		 * pre tableNb != 0
		 * pre price != 0
		 */
		public void generateBill(int order, String date, int tableNb, double price);
		
		public void serializeRestaurant();
		
		public ArrayList<MenuItem> getItemList();

	
}
	
