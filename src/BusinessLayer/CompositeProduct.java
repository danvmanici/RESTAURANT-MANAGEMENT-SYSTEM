package BusinessLayer;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {
	
	private static final long serialVersionUID = 1L;
	private List<MenuItem> ingredients = new ArrayList<MenuItem>();
	double price;
	
	public CompositeProduct( int id, String name,  double price, List<MenuItem> ingredients) {
		super(id, name);
		this.price=price;
		this.ingredients = ingredients;
		
	}	
	
	
	public double computePrice() {
		price = 0;
		for(MenuItem m: ingredients) {
			price += m.computePrice();
		}
		return price;
	}
	
	public void addItem(MenuItem item) {
		this.ingredients.add(item);
	}
	
	public void deleteItem(String name) {
		for(int i=0; i<ingredients.size(); i++) {
			if(ingredients.get(i).getName().equals(name))
			{
				ingredients.remove(i);
			}
		}
	}
	
	public List<MenuItem> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<MenuItem> ingredients) {
		this.ingredients = ingredients;
	}

	
}