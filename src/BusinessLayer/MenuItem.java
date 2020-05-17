package BusinessLayer;
import java.io.Serializable;


	public abstract class MenuItem implements Serializable {
		
		
		private static final long serialVersionUID = 1L;
		protected int id;
		protected String name;
				
		public MenuItem(int id, String name) {
			this.name = name;
			this.id = id;
		}
	
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public abstract double computePrice();
		
}

