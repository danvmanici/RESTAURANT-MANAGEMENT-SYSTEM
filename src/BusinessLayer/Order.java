package BusinessLayer;
import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int orderID;
	private String date;
	private int table;
	
	public Order(int orderID, String date, int table) {
		this.orderID = orderID;
		this.date = date;
		this.table = table;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + orderID;
		result = prime * result + table;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderID != other.orderID)
			return false;
		if (table != other.table)
			return false;
		return true;
	}
	
	public int getId() {
		return this.orderID;
	}
	
	public void setId(int id) {
		this.orderID = id;
	}
	
	public int getTable() {
		return this.table;
	}
	
	public void setTable(int table) {
		this.table = table;
	}
	
}
