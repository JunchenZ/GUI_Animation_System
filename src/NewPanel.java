import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewPanel extends JPanel{
	private String [] shape_list;
	private String [] mover_list;
	private String [] material_list;
	private JTextField radius;
	private JTextField position;
	private JTextField color;
	private JComboBox <String> shape;
	private JComboBox <String> mover;
	private JComboBox <String> material;
	String [] object;
	String object_infor;
	
	public NewPanel(Scene scene) {
		super();
		this.setLayout(new GridLayout(13,1));
		object = new String [9];
		shape_list = new String [] {"circle", "rectangle"};
		mover_list = new String [] {"linear", "static", "bounce"};
		material_list = new String [] {"color", "default"};
		radius = new JTextField();
		position = new JTextField();
		color = new JTextField();
		shape = new JComboBox <> (shape_list);
		mover = new JComboBox <> (mover_list);
		material = new JComboBox <> (material_list);
		JLabel shape_label = new JLabel("	select the shape:");	
		JLabel mover_label = new JLabel("	select the mover:");	
		JLabel material_label = new JLabel("	select the material:");	
		JLabel radius_label = new JLabel("	 enter the radius:");
		JLabel position_label = new JLabel("	enter the position x and position y:");
		JLabel color_label = new JLabel("	enter the color's r,g,b value:");
		JButton button = new JButton("add");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				object[0] = (String)shape.getSelectedItem();
				object[1] = radius.getText();
				String [] string_position = position.getText().split(" ");
				object[2] = string_position[0];
				object[3] = string_position[1];
				object[4] = (String)mover.getSelectedItem();
				object[5] = (String)material.getSelectedItem();
				String [] string_color = color.getText().split(" ");
				object[6] = string_color[0];
				object[7] = string_color[1];
				object[8] = string_color[2];
				object_infor = new String();
				for(int i=0; i<9; i++) {
					object_infor += object[i] + " ";
				}
				Scanner s = new Scanner (object_infor);
				try {
					scene.addSceneObject(s);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}	
		});
		this.add(shape_label);
		this.add(shape);
		this.add(radius_label);
		this.add(radius);
		this.add(position_label);
		this.add(position);
		this.add(mover_label);
		this.add(mover);
		this.add(material_label);
		this.add(material);
		this.add(color_label);
		this.add(color);
		this.add(button);
		
	}


}
