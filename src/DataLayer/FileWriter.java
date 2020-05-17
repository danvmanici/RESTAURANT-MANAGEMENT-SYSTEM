package DataLayer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {

	int counter = 1;
	/**
	 * Metoda scrie in fisier datele pentru order.
	 */
	public static void createBill(int order, String date, int tableNb, double price) {
		File file = new File("Order" + order + ".txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			PrintWriter print = new PrintWriter(file);
			print.println("Order " + order + " " + " Date " + date + " Table " + tableNb + " price " + price );
			print.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
