package Com.TestingFramwork.co.TestinfDDFramework;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

public class Application extends Validationkeywords{
 
	public Application () {
		prop = new Properties();
		try {
 			FileInputStream fS = new FileInputStream("C:\\Users\\Anu\\eclipse-workspace\\TestinfDDFramework\\Projrct.Properties") ;
 			prop.load(fS);
		} catch (Exception e) {
			// TODO: handle exception
		}
	System.out.println( prop.getProperty("URl"));
		
	
	softAssert = new SoftAssert();
	}
}
