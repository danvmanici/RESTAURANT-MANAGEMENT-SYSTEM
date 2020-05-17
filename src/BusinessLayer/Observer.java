package BusinessLayer;

public abstract class Observer {
	   
	protected Subject subject;
	public abstract void update(String text);
	
}
