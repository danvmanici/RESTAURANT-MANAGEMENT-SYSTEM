package PresentationLayer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import BusinessLayer.Observer;
import BusinessLayer.Subject;

public class ChefGui extends Observer{
	
	private JTextArea textArea = new JTextArea();
	private Subject s;
	
	public ChefGui(Subject s) {
		
		this.s = s;
		textArea.setEditable(false);
		textArea.setText("idle");
		JFrame frame = new JFrame();
		JLabel info = new JLabel("Info: ");
		JScrollPane textScroll;
		frame.setSize(500, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		textScroll = new JScrollPane(textArea);
		textScroll.setPreferredSize(new Dimension(400,50));
		p.add(info);
		p.add(textScroll);
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	
	
	public void setInfo(String toAdd) {
		this.textArea.setText(toAdd);
	}

	@Override
	public void update(String text) {
		
		this.textArea.setText(text);
	}
}
