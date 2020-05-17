package BusinessLayer;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import DataLayer.FileWriter;
import DataLayer.RestaurantSerializator;

public class Restaurant implements Serializable,RestaurantProcessing {
	
	private static final long serialVersionUID = 1L;
	private List<MenuItem> menu = new ArrayList<MenuItem>();
	private Map<Order, ArrayList<MenuItem>> orderInfo = new HashMap();
	
	
	public Restaurant() {
		super();
		
	}

	public Restaurant(List<MenuItem> menu, Map<Order, ArrayList<MenuItem>> orderInfo) {
		super();
		this.menu = menu;
		this.orderInfo = orderInfo;
	}
/**
 * Metoda creaza un nou produs.
 */
	@Override
	public void createNewMenuItem( int id, String name, double price, ArrayList<MenuItem> ingredients) {
		assert name != null;
		assert price != 0;
		assert id != 0;
		MenuItem product;
		int size = menu.size();
		if(ingredients.size() == 0)
		{
			product = new BaseProduct(id, name, price);
		}
		else
		{
			product = new CompositeProduct(id, name, price,ingredients);
		}
		menu.add(product);
		assert size == menu.size() - 1;
	}
/**
 * Metoda sterge un produs dupa nume.
 */
	@Override
	public void deleteMenuItem(String name) {
		assert name != null;
		for(int i=0; i<menu.size(); i++) {
			if(menu.get(i).name.equals(name))
			{
				menu.remove(i);
			}
		}
		
	}
/**
 * Metoda modifica un produs dupa nume.
 */
	@Override
	public void editMenuItem(int id, String name, double price, ArrayList<MenuItem> ingredients) {
		assert name != null;
		assert price != 0;
		assert id != 0;
			for(int i=0; i<menu.size(); i++) {
				if(menu.get(i).name.equals(name))
				{
					menu.remove(i);
					createNewMenuItem(id, name, price, ingredients);
				}
			}	
	}
	/**
	 * Metoda creaza un order.
	 */
	@Override
	public Order createNewOrder(int id, String date, int table, ArrayList<MenuItem> meniu) {
		assert id != 0;
		assert table != 0;
		Order order = new Order(id, date, table);
		orderInfo.put(order, meniu);
		
		return order;
	}
/**
 * Metoda calculeaza pretul pentru order.
 */
	@Override
	public double computePrice(Order o) {
		assert o != null;
		ArrayList<MenuItem> ingredients = new ArrayList<MenuItem>();
		ingredients = orderInfo.get(o);		
		double price = 0;
		for(int i=0; i<ingredients.size(); i++) {		
			price += ingredients.get(i).computePrice();
		}
		return price;
	}
	
	public boolean isWellFormed() {
		for (Entry<Order, ArrayList<MenuItem>> e : orderInfo.entrySet()) {
			ArrayList<MenuItem> l = e.getValue();
			for (int i = 0; i < l.size(); i++) {
				MenuItem w = l.get(i);
				if (!orderInfo.containsKey(w))
					return false;
			}
		}
		return true;
	}
	
	@Override
	public ArrayList<MenuItem> getItemList(){
		return (ArrayList<MenuItem>) this.menu;
	}

	@Override
	public void generateBill(int order, String date, int tableNb, double price) {
	
		FileWriter.createBill(order, date, tableNb, price);
	}
	

	@Override
	public void serializeRestaurant() {

		RestaurantSerializator.serializeRestaurantData(this);
	}

	public List<MenuItem> getMenu() {
		return menu;
	}

	public void setMenu(List<MenuItem> menu) {
		this.menu = menu;
	}

	public Map<Order, ArrayList<MenuItem>> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(Map<Order, ArrayList<MenuItem>> orderInfo) {
		this.orderInfo = orderInfo;
	}

	
}
