package PresentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BusinessLayer.Observer;
import BusinessLayer.Restaurant;
import BusinessLayer.Subject;
import DataLayer.RestaurantSerializator;

public class Main {
	
	public static void main(String[] args) {
		
		Restaurant r=new Restaurant();
		Subject s=new Subject();
		RestaurantSerializator.deserializeRestaurantData();
		AdministratorGui adminView = new AdministratorGui(r);
		ChefGui chefView = new ChefGui(s);
		WaiterGui waiterView = new WaiterGui(r,chefView);		
		
	}	
}
