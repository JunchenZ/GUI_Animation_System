import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MyWindow extends JFrame{
	private int click_time;
	private Scene scene;
	public MyWindow() throws Exception{
		super("My Window");
		scene = new Scene();
		try {
		this.setSize(1000, 500);
		this.setBackground(Color.white);
		this.setLayout(new GridLayout(1, 2));
		
//		GUI_Panel gui_panel = new GUI_Panel(scene);
//		getContentPane().add(gui_panel);
		
		NewPanel new_panel = new NewPanel(scene);
		getContentPane().add(new_panel);
		MyPanel my_panel = new MyPanel(scene);	
		getContentPane().add(my_panel);
		int delay = 5;
		ActionListener taskPerformer = new ActionListener() {
		    @Override
			public void actionPerformed(ActionEvent e) {
				scene.update();
				my_panel.repaint();
			}
		};	
		Timer timer = new Timer(delay, taskPerformer);
		timer.start();	
			
		click_time = 0;
		JButton save_button = new JButton("save");
		save_button.setPreferredSize(new Dimension(50,50));
		save_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				click_time++;
				BufferedImage buffer_image = new BufferedImage(my_panel.getSize().width, my_panel.getSize().height,BufferedImage.TYPE_INT_RGB); 
			    my_panel.paint(buffer_image.createGraphics());
			    try {
					ImageIO.write(buffer_image, "PNG", new File("screenshot" + click_time +".PNG"));
				} catch (IOException e1) {
					System.out.println("Error: " + e);
				}
			}	
		});
		my_panel.add(save_button);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}catch(Exception e) {
			System.out.println("Error in window: " + e);
		}
	}
}
