import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private Scene scene_in_panel;
	
	public MyPanel(Scene scene) {
		super();	
		this.setVisible(true);
		scene_in_panel = scene;
		
	}
	
	@Override									
	public void paint(Graphics graphics) {     
		super.paint(graphics);
		scene_in_panel.draw((Graphics2D) graphics);
	}
}
