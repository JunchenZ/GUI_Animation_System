import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.PrintWriter;
import java.util.Scanner;

public class SceneObject {
	private Shape shape;
	private Material material_fill;
	private Material material_outline;
	private Mover mover;
	private double position_x;
	private double position_y;
	
	public SceneObject(Scanner s) throws Exception{
		
		String string_shape = s.next();
	    if(string_shape.equals("circle")) {
	    		double radius = s.nextDouble();
	    		position_x = s.nextDouble();
	    		position_y = s.nextDouble();
	    		shape = new Ellipse2D.Double(position_x, position_y, radius, radius);
	   }else if(string_shape.equals("rectangle")) {
   		double radius = s.nextDouble();
   		position_x = s.nextDouble();
   		position_y = s.nextDouble();
   		shape = new Rectangle.Double(position_x, position_y, radius, radius);
	   }else {
		   System.out.println(string_shape);
		   throw new UnknownShapeException("The shape is unknown");
	   }
	    
	    String string_mover = s.next();
	    if(string_mover.equals("static")) {
	    		mover = new StaticMover(position_x, position_y);
	    }else if(string_mover.equals("linear")){
	    		mover = new LinearMover(position_x, position_y);
	    }else if(string_mover.equals("bounce")) {
	    		mover = new BounceMover(position_x, position_y);
	    }else {}
	   
	    String string_material = s.next();
	    if(string_material.equals("default")) {
	    		material_outline = new DefaultMaterial(s);
	    		material_fill = new ColorMaterial(Color.white);
	    }else if(string_material.equals("color")){
	    		material_outline = new ColorMaterial(s);
	    		material_fill = new ColorMaterial(Color.white);
	    }else {
	    		throw new UnknownMaterialException("The material is unknown");
	    }

	}
	
	public void draw(Graphics2D graphics2D) {
		graphics2D.setTransform(mover.getTransform());
		material_outline.setupGraphics(graphics2D);
		graphics2D.draw(shape);
		material_fill.setupGraphics(graphics2D);
		graphics2D.fill(shape);
	}
	
	public void save(PrintWriter print_writer) {
		if(shape instanceof Ellipse2D) {
			print_writer.println("shape: ellipse");
		}else if(shape instanceof Rectangle2D) {
			print_writer.println("shape: rectangle");
		}else print_writer.println("shape: unknown");
		mover.save(print_writer);
		print_writer.println();
		print_writer.flush();
	}
	
	public void update() {
		mover.update();
	}
	
}
