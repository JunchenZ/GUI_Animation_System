import java.awt.geom.AffineTransform;
import java.io.PrintWriter;

public class BounceMover implements Mover{
	private double position_x;
	private double origin_x;
	private double position_y;
	private double origin_y;
	private double vx;
	private double vy;
	
	public BounceMover(double x, double y) {
		position_x = x;
		position_y = y;	
		origin_x = x;
		origin_y = y;
		vx = 1;
		vy = 1;
	}
	
	@Override
	public void update() {
		position_x += vx;
		position_y += vy;
		if(position_x > 400 || position_x < 0) {
			vx = -vx;
		}if(position_y > 400|| position_y < 0) {
			vy = -vy;
		}
	}

	@Override
	public AffineTransform getTransform() {
		AffineTransform affine_transform = new AffineTransform();
		affine_transform.translate(position_x-origin_x, position_y-origin_y);
		return affine_transform;
	}

	@Override
	public void save(PrintWriter print_writer) {
		print_writer.println("mover: bounce");	
		print_writer.flush();		
	}

}
