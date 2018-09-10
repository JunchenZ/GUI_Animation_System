import java.awt.Graphics2D;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Scene {
	private ArrayList<SceneObject> scene_object = new ArrayList<SceneObject> ();
	private int width;
	private int height;
		
	public Scene()  {
		
	}
	
	public int get_width() {
		return width;
	}
	
	public int get_height() {
		return height;
	}
	
	public void draw(Graphics2D graphics2D) {
		for(int i=0; i<scene_object.size(); i++) {
			scene_object.get(i).draw(graphics2D);
		}
	}
	
	public void save(PrintWriter print_writer) {
		for(int i=0; i<scene_object.size(); i++) {
			print_writer.print(i+1 + " ");
			scene_object.get(i).save(print_writer);
		}
	}
	
	public void update() {
		for(int i=0; i<scene_object.size(); i++) {
			scene_object.get(i).update();
		}
	}
	
	public void addSceneObject(Scanner s) throws Exception {
		scene_object.add(new SceneObject(s));
	}

}
