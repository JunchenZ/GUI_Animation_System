import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws Exception {
		try {
			MyWindow my_window = new MyWindow();
		}catch(Exception e) {
			System.out.println("Error in main: " + e );
		}
	}

}
