import java.awt.geom.AffineTransform;
import java.io.PrintWriter;

public class StaticMover implements Mover {
	
	private AffineTransform affine_transform;
	
	public StaticMover(double x, double y) {
		affine_transform = new AffineTransform();
	}
	
	@Override
	public void update() {}

	@Override
	public AffineTransform getTransform() {
		return affine_transform;
	}

	@Override
	public void save(PrintWriter print_writer) {
		print_writer.println("mover: static");	
		print_writer.flush();
	}

}
