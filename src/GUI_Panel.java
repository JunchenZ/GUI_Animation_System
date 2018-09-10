import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_Panel extends JPanel{
	private JButton button;
	private JTextField textfield;
	
	public GUI_Panel(Scene scene) {
		super();
		this.setLayout(new GridLayout(3,1));
		JLabel label = new JLabel("enter:  circle/rectangle  radius  x  y  linear/static/bounce  color/default  r  g  b");		 
		this.add(label);

		JTextField textfield = new JTextField();
		this.add(textfield);
		
		JButton button = new JButton("add");
		//textfield.setBounds(40, 150, 120, 25);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Scanner s = new Scanner(textfield.getText());
				try {
					scene.addSceneObject(s);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}	
		});
				this.add(button);
		this.setBounds(0, 0, 400, 40);
		this.setVisible(true);
		
		
		
		//button.setBounds(0, 0, 100, 15);
		
		
	}
	
}
