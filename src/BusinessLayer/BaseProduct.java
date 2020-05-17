package BusinessLayer;

public class BaseProduct extends MenuItem {
	
	private static final long serialVersionUID = 1L;
	double price;
	
	public BaseProduct(int id, String name, double price) {
		super(id, name);
		this.price=price;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public double computePrice() {
		return price;
	}
	
	
}
