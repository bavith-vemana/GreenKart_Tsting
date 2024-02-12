package Bavith.Tsting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class prop {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream fls = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Tsting\\src\\test\\java\\Data\\browser.properties");
		prop.load(fls);
		String name = prop.getProperty("browser");
		System.out.println(name);
	}

}
