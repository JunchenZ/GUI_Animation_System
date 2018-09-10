import java.awt.geom.AffineTransform;
import java.io.PrintWriter;

public interface Mover {
	
	void update();
	AffineTransform getTransform();
	void save(PrintWriter print_writer);
	
}
