package PresentationLayer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import BusinessLayer.MenuItem;
import BusinessLayer.Observer;
import BusinessLayer.Order;
import BusinessLayer.Restaurant;
import BusinessLayer.RestaurantProcessing;
import BusinessLayer.Subject;

public class WaiterGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public WaiterGui(Restaurant restaurant, Observer o) {

		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		JFrame frame = new JFrame("Waiter");
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel0 = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();

		JButton id = new JButton("        Id         ");
		JTextField idT = new JTextField(17);
		panel1.add(id);
		panel1.add(idT);
		panel1.setLayout(new FlowLayout());

	

		JButton table = new JButton("   Table        ");
		JTextField tableT = new JTextField(17);
		panel4.add(table);
		panel4.add(tableT);
		panel4.setLayout(new FlowLayout());

		JButton produs = new JButton("    Produs    ");
		JTextField produsT = new JTextField(17);
		panel5.add(produs);
		panel5.add(produsT);
		panel5.setLayout(new FlowLayout());

		JButton butonCreate = new JButton("Create");
		JButton butonCompute = new JButton(" Compute ");
		
		panel3.add(butonCreate);
		panel3.add(butonCompute);
		panel3.setLayout(new FlowLayout());

		panel6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Date");
		model.addColumn("Table");
		model.addColumn("Produs");
		JTable table1 = new JTable(model);
		panel6.add(new JScrollPane(table1));
		
		JPanel p = new JPanel();
		p.add(panel3);
		p.add(panel0);
		p.add(panel1);
		p.add(panel2);
		p.add(panel4);
		p.add(panel5);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		JPanel pf = new JPanel();
		pf.add(p);
		pf.add(panel6);
		pf.setLayout(new FlowLayout());
		frame.setContentPane(pf);
		frame.setVisible(true);
		
		butonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == butonCreate) {
				
					if (!idT.getText().isEmpty()  && !tableT.getText().isEmpty()) {
					
						restaurant.createNewOrder(Integer.parseInt(idT.getText()), df.format(dateobj),
								Integer.parseInt(tableT.getText()),menu);
						Vector v = new Vector();
						v.add(Integer.parseInt(idT.getText()));
						v.add(df.format(dateobj));
						v.add(Integer.parseInt(tableT.getText()));
						v.add(produsT.getText());
						model.addRow(v);
						o.update("cooking for table " + tableT.getText());
						
					}
				}
						
			}
		});
		
		butonCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == butonCompute) {
				
					if (!produsT.getText().isEmpty()) {
						double price=0;
						for (int j = 0; j < restaurant.getMenu().size(); j++) {
							if(produsT.getText().equals(restaurant.getMenu().get(j).getName())) {
							price=restaurant.getMenu().get(j).computePrice();
							}
						}
						restaurant.generateBill(Integer.parseInt(idT.getText()), df.format(dateobj),
								Integer.parseInt(tableT.getText()),price);	
						o.update("idle");
					}
				}
						
			}
		});
	
	}	
}
