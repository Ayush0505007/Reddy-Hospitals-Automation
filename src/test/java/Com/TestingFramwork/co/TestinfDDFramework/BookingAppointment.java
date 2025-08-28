package Com.TestingFramwork.co.TestinfDDFramework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.security.KeyStore.Entry;
import java.sql.Date;
import java.sql.Driver;
import java.text.BreakIterator;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beust.jcommander.Strings;
import com.google.errorprone.annotations.InlineMe;

public class BookingAppointment {
	public int q = 1;
	public Scanner scanner ;
	
	
		public void starformation() {
		 
	 String input = "STrinGHere" ;
	 char[] array = input.toCharArray() ;
	 
	 for (int i = 0; i < array.length; i++) {
		 String characteer = String.valueOf(array[i]) ; 
		 
		if (array[i] >= 'A' && array[i] <= 'Z') {
			array[i] = characteer.toLowerCase().charAt(0) ; 
		} else {
			array[i] = characteer.toUpperCase().charAt(0) ; 
		}
	}
	 System.out.println(array);
		}
		
		
		
	public void HASHmapimplementation () {
		int a = 0 ;
		int b = 1 ;
		
		int c = a+ b;
		int d = 0 ;
		System.out.println(a + " , ");
		System.out.println(b + " , ");
		
		
		for (int i = 0; i < 17 ; i++) {
			b = c;
			c = d;
			d =c + b ;
			System.out.println(d);
		}
	}
	
	
public void ValidationOfTable() {
	int colno = 0  ;
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anu\\eclipse-workspace\\TestinfDDFramework\\Driver\\chromedriver.exe") ;
	WebDriver driver =  new ChromeDriver();
	driver.manage().window().maximize(); 
	
 //	Alert alert = driver.switchTo().alert() ;
//	alert.accept();
	
	driver.get("https://money.rediff.com/index.html");
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.xpath("//*[text()='NSE INDICES']"))).build().perform() ;
	WebElement Table = driver.findElement(By.id("div_bseindices")) ;
	
	int rowno = 1 ;
	List<WebElement> rows = Table.findElements(By.tagName("ul")) ;
	outerloop:
	for (WebElement row : rows) {
		
		List<WebElement> columns = row.findElements(By.tagName("li")) ;
		colno = 1; 
		for (WebElement column : columns) {
			
			if (column.getText().equalsIgnoreCase("-27.42")) {			
				System.out.println("we got the text");
				break outerloop ;
			}
			colno ++ ;
		}
		rowno++ ;
	}
	System.out.println( "This text is present on the row : "+ rowno + " and on the column : " + colno );
	driver.quit();
 }
		
		
public void Flipkartautomation() throws InterruptedException {
			
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anu\\eclipse-workspace\\TestinfDDFramework\\Driver\\chromedriver.exe") ;
	WebDriver driver = new ChromeDriver() ;
	driver.manage().window().maximize() ;
	driver.get("https://money.rediff.com/index.html") ;
	Actions action = new Actions(driver) ;

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", driver.findElement(By.xpath("//*[text()='BSE INDICES']"))) ;
	WebElement Table = driver.findElement(By.xpath("//*[@id='div_bseindices']//div")) ;
	List<WebElement> rows = Table.findElements(By.xpath("./ul")) ;
	System.out.println(rows.size());
	int i = 1 ; 
	
	for (WebElement row : rows) {
		List<WebElement> columns = row.findElements(By.xpath("./li")) ;
		int col = 1 ;
		System.out.println(columns.size());
	for (WebElement column : columns) {
		
		if (column.getText().equalsIgnoreCase("11209.06")) {
			System.out.println("Found the Searched item");
			System.out.println("Present at the Row :" + i +" And Present on the Column :"+ col);
			break ;
		}
		col ++ ;
	}
	i++ ;
	}	
}
@Test
		public void ArrowFormation () {
		scanner = new Scanner(System.in) ;
		String input = scanner.nextLine() ; 
		char ch[] = input.toCharArray() ;
		
		List<Character> characters = new ArrayList<>() ;
		Set<Character> refinedCharacters = new HashSet<>() ;
		for (Character character : ch) {
			
			if (characters.contains(character)) { 
				refinedCharacters.add(character) ;
			}
			
				characters.add(character) ;
		}
		System.out.println("Hi this is the refined character" + refinedCharacters);
	} 
		
	private void reversestring() {		
		StringBuilder sbuilder = new StringBuilder() ;
		
		Scanner sc = new Scanner(System.in) ;
		String ourString = sc.nextLine() ;
		sbuilder.append(ourString) ;
	String revercedString = sbuilder.reverse().toString();
	
	if (revercedString.equalsIgnoreCase(ourString)) {
		System.out.println("this is philandrome ");
	} else {
		System.out.println("this is not a philandrome ");
	}
	}
	        public void BrokenLinkValidateion() {
	        	scanner = new Scanner(System.in) ;	        
	        	
	        	  int n =  scanner.nextInt();
	        	  
	        	  System.out.println("Please enter " + n+ " numbers ");
	        	  int max = Integer.MIN_VALUE;
	        	  ArrayList<Integer> numbers = new ArrayList<>();
	        	  
	        	  while (true) {
	        		  try {
	        			  int num = scanner.nextInt();
		        		  numbers.add(num) ;
					} catch (Exception e) {
						break ;
					}
                for (Integer integer : numbers) {
					if (integer > max) {
						max = integer ;
					}
					
				}
	        		  
				} 
	        	  System.out.println("Your maximum integer is " + max);
	        	  
	        }
	      
	public void Fibonachi() {
		
		scanner = new Scanner(System.in) ;
		ArrayList<Integer> numbers = new ArrayList<>() ;
		while (true) {
			try {
				System.out.println("Please Enter the digit");
				int m =scanner.nextInt() ;
				numbers.add(m) ;
			} catch (Exception e) {
				break ;
			}
		}
			int max = Integer.MIN_VALUE ;
			
			for (int integer : numbers) {
				if (integer>max) {
					max = integer ;
				}
			}
			System.out.println(" The Maximum value from this array is : " + max);
			
		
	}
	
	
    public void Flipkartdropdown() {
	System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Anu\\eclipse-workspace\\TestinfDDFramework\\Driver\\chromedriver.exe") ;
	WebDriver driver = new ChromeDriver() ;
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
	
	driver.get("https://www.cognizant.com/us/en");
	WebElement element = driver.findElement(By.xpath("//ul/li/a[text()='Industries']")) ;
	
	JavascriptExecutor js = (JavascriptExecutor) driver ; 
	js.executeScript("arguments[0].click();", element) ;
	element.click() ;
    }
    
 
    public void SorttheString() {
	 Scanner sc = new Scanner(System.in) ;
	 
	 List<Character> LHset = new ArrayList<>() ;
	 StringBuilder sBuilder  = new StringBuilder() ; 
	 
	 String input = sc.nextLine() ;

	 for (Character character : input.toCharArray() ) {
	 
		LHset.add(character) ;
 }
	 Collections.reverse(LHset);
	 System.out.println(LHset);
	 for (Character characters : LHset) {
		 sBuilder.append(characters)  ;
	}
	 
	 System.out.println("THe new string is this : " + sBuilder.toString());
 
 
 }
 }
