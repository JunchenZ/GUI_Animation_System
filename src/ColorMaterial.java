import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Scanner;

public class ColorMaterial implements Material{
	private Color color;
	
	public ColorMaterial(Scanner s) {
		int color_r = s.nextInt();
		int color_g = s.nextInt();
		int color_b = s.nextInt();
		color = new Color(color_r, color_g, color_b);		
	}
	
	public ColorMaterial(Color c) {
		color = new Color(c.getRed(), c.getGreen(), c.getBlue());		
	}

	@Override
	public void setupGraphics(Graphics2D graphics2D) {
		graphics2D.setStroke(new BasicStroke(5));
		graphics2D.setColor(color);
	}
}