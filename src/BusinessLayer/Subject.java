package BusinessLayer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	   private List<Observer> observers = new ArrayList<Observer>();
	   private String state;

	   public String getState() {
	      return state;
	   }

	   public void setState(String state) {
		      this.state = state;
		}

	   public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   	
}
