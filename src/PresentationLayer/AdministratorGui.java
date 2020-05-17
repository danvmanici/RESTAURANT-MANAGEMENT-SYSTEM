package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BusinessLayer.BaseProduct;
import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;


public class AdministratorGui extends JFrame {

	private static final long serialVersionUID = 1L;

	public AdministratorGui(Restaurant restaurant) {
		
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		JFrame frame = new JFrame("Admin");
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

		JButton name = new JButton("    Name      ");
		JTextField nameT = new JTextField(17);
		panel2.add(name);
		panel2.add(nameT);
		panel2.setLayout(new FlowLayout());

		JButton price = new JButton("   Price        ");
		JTextField priceT = new JTextField(17);
		panel4.add(price);
		panel4.add(priceT);
		panel4.setLayout(new FlowLayout());

		JButton ingredients = new JButton("Ingredients");
		JTextField ingredientsT = new JTextField(17);
		panel5.add(ingredients);
		panel5.add(ingredientsT);
		panel5.setLayout(new FlowLayout());

		JButton butonCreate = new JButton("Create");
		JButton butonEdit = new JButton(" Edit ");
		JButton butonDelete = new JButton("Delete");
		panel3.add(butonCreate);
		panel3.add(butonEdit);
		panel3.add(butonDelete);
		panel3.setLayout(new FlowLayout());

		panel6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Price");
		model.addColumn("Ingredients");
		JTable table = new JTable(model);
		panel6.add(new JScrollPane(table));

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
				if(!ingredientsT.getText().isEmpty()) {
					BaseProduct ing = new BaseProduct(0,"",0.0);
					String[] s;
					s=ingredientsT.getText().split(",");					
					for(int z=0; z<s.length; z+=3) {
						ing.setId(Integer.parseInt(s[z]));
						ing.setName(s[z+1]);
						ing.setPrice(Double.parseDouble(s[z+2]));
						menu.add(ing);
						
					}
				}
					if (!idT.getText().isEmpty() && !nameT.getText().isEmpty() && !priceT.getText().isEmpty()) {
					
						restaurant.createNewMenuItem(Integer.parseInt(idT.getText()), nameT.getText(),
								Double.parseDouble(priceT.getText()),menu);
						menu.clear();
					}
				}
						int row=model.getRowCount();
						for (int k = row - 1; k >= 0; k--) {
						    model.removeRow(k);
						}
						for (int i = 0; i < restaurant.getMenu().size(); i++) {
							Vector v = new Vector();
							v.add(restaurant.getMenu().get(i).getId());
							v.add(restaurant.getMenu().get(i).getName());
							v.add(restaurant.getMenu().get(i).computePrice());
							v.add(ingredientsT.getText());
							model.addRow(v);
						}
						RestaurantSerializator.serializeRestaurantData(restaurant);
						idT.setText("");
						nameT.setText("");
						priceT.setText("");
						ingredientsT.setText("");
			}
		});

		butonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == butonDelete) {
					String name = nameT.getText();
					for (int i = 0; i < restaurant.getMenu().size(); i++) {
						if (name.equals(restaurant.getMenu().get(i).getName())) {
							restaurant.deleteMenuItem(name);
						}
					}
							int row=model.getRowCount();
							for (int k = row - 1; k >= 0; k--) {
							    model.removeRow(k);
							}
							for (int j = 0; j < restaurant.getMenu().size(); j++) {
								Vector v = new Vector();
								v.add(restaurant.getMenu().get(j).getId());
								v.add(restaurant.getMenu().get(j).getName());
								v.add(restaurant.getMenu().get(j).computePrice());
								model.addRow(v);
							}
						}
				nameT.setText("");
					}
		});
		
		butonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == butonEdit) {
					String name = nameT.getText();
					for (int i = 0; i < restaurant.getMenu().size(); i++) {
						if (name.equals(restaurant.getMenu().get(i).getName())) {
							restaurant.editMenuItem(Integer.parseInt(idT.getText()), nameT.getText(),
									Double.parseDouble(priceT.getText()),menu);
						}
					}
							int row=model.getRowCount();
							for (int k = row - 1; k >= 0; k--) {
							    model.removeRow(k);
							}
							for (int j = 0; j < restaurant.getMenu().size(); j++) {
								Vector v = new Vector();
								v.add(restaurant.getMenu().get(j).getId());
								v.add(restaurant.getMenu().get(j).getName());
								v.add(restaurant.getMenu().get(j).computePrice());
								model.addRow(v);
							}
						}
				idT.setText("");
				nameT.setText("");
				priceT.setText("");
				ingredientsT.setText("");
			}
		});

	}
}