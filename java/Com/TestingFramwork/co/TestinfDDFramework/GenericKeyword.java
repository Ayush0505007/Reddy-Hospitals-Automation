package Com.TestingFramwork.co.TestinfDDFramework;

import java.beans.PropertyChangeEvent;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.util.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.ExtentTest;


public class GenericKeyword {
	
 public WebDriver driver ;
 public Properties prop ;
 public ExtentTest test ;
 public SoftAssert softAssert ;
 public Actions action ;
 public String textrecceived ;
 
 public void BrokenURLvalidation() {
	List<WebElement> links = driver.findElements(By.xpath("//a")) ;
	loginfo("Validation of Broken URL in the curernt page") ;
	for (WebElement link : links) {
		String uRL = link.getAttribute("href");
		if (uRL==null||uRL.isEmpty() ) {
			System.out.println("This Link is empty or null :" + uRL);
			continue ;
		}
		if (!uRL.startsWith("http")) {
		    System.out.println("Skipping non-http URL: " + uRL);
		    continue;
		}

		try {
			HttpURLConnection urlConnection = (HttpURLConnection) new URL(uRL).openConnection() ;
			urlConnection.setRequestMethod("HEAD");
	        urlConnection.connect();
	        
	        int responcecode = urlConnection.getResponseCode();
	        
	        if (responcecode >=400) {
				System.out.println("Broken URL :" + uRL + " || Responce COde :"+responcecode);
				loginfo("Broken URL :" + uRL + " || Responce COde :"+responcecode) ;
			} 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
}
public void Click2(String locate) {
	loginfo("Clicking on element: " + locate);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(getlocater(locate))).click();
}
 
  public void Click(String locate) {
	    loginfo("Clicking on element: " + locate);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(getlocater(locate))).click();
	}

 public void CalenderdateselectorMediapp(String date, String monthYearLocater ) {
	 loginfo("Choosing the Date from the Calender") ;
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd,yyyy");
  YearMonth targatMonth = YearMonth.parse(date, formatter);
  
  while (true) {
	  String calenderdate = getelemnet(monthYearLocater).getText();
	  DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMMM yyyy") ;
	  YearMonth calenderm = YearMonth.parse(calenderdate, formatter2) ;
	  
	  if (calenderm.getMonth().equals(targatMonth.getMonth()) && calenderm.getYear()==targatMonth.getYear()) {
		break ;
	}
	  if (targatMonth.isBefore(calenderm)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(@class,'ui-datepicker-prev')]/span[text()='Prev']")));
			
		}else {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(@class,'ui-datepicker-next')]/span[text()='Next']")));
		}
	  
}
  }
 public void calender(String date , String calenderdatepresent ) {
	
	LocalDate dateweneed = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMMM yyyy,dd")) ;
	
	WebElement dateomcal = getelemnet(calenderdatepresent) ;
	String calendermonth =  dateomcal.getText() ;
	YearMonth calyearmon = YearMonth.parse( calendermonth , DateTimeFormatter.ofPattern("MMMM yyyy")) ;
	
	while (dateweneed.getMonth()!=calyearmon.getMonth() && dateweneed.getYear()==calyearmon.getYear()) {
		driver.findElement(By.xpath("//*[text()='<']")).click() ;
		dateomcal = getelemnet(calenderdatepresent);
		 calendermonth =  dateomcal.getText() ;
		 calyearmon = YearMonth.parse( calendermonth , DateTimeFormatter.ofPattern("MMMM yyyy")) ;
	}
	driver.findElement(By.xpath("//*[text()='"+ dateweneed.getDayOfMonth() + "']")).click() ;
	
}
 
  	public void Findelementintable(String Locaterpath , String search) {
  		
		WebElement Table = getelemnet(Locaterpath) ;
		List<WebElement> rows = Table.findElements(By.xpath("//ul")) ;
		int i = 1 ; 
		for (WebElement row : rows) {
			List<WebElement> columns = row.findElements(By.xpath("//li")) ;
			int col = 1 ;
		for (WebElement column : columns) {
			
			if (column.getText().equalsIgnoreCase(search)) {
				System.out.println("Found the Searched item");
				System.out.println("Present at the Row :" + i +" And Present on the Column :"+ col);
				break ;
			}
			
			col ++ ;
		}
		
	  }
	}
 
	public void openbrowser(String string) {
		loginfo("Opening the Browser"+string) ;
		if (string.equalsIgnoreCase("Chrome")) {
			String driverPath = System.getProperty("user.dir") +"/Driver/chromedriver.exe"; 
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anu\\eclipse-workspace\\TestinfDDFramework\\Driver\\chromedriver.exe");
			 
			 ChromeOptions options = new ChromeOptions() ;
			 options.addArguments("--incognito");
			 
			 driver = new ChromeDriver(options);
			 
			 driver.manage().window().maximize();
		} else if (string.equalsIgnoreCase("Edge")) {
			
				String driverPath = System.getProperty("user.dir") +"/Driver/chromedriver.exe"; 
				 System.setProperty("webdriver.chrome.driver", driverPath);
				 
            driver = new EdgeDriver(); 
			}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
		
		}
		
		public void openURL(String uRLS) {
			String url = prop.getProperty(uRLS); 
			loginfo("Opening the uRL"+ uRLS) ;			
			System.out.println("Opening the URL : " + url );
			driver.get(url);
		}	 
		
		 public boolean isElementPresent(String loc) {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout in seconds	
			 try {
				 
	     wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getlocater(loc))) ;
			} catch (Exception e) {
				// TODO: handle exception
				takescreenshot();
				return false ;
			}
			return true ;	
		}
		 
		 public boolean isElementVisble(String loc) {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout in seconds	
			 try {	 
				 wait.until(ExpectedConditions.visibilityOfElementLocated(getlocater(loc))) ;
			} catch (Exception e) {
				reportfailure("unable to find the Visiblity of element :" + loc);
				e.printStackTrace();
				takescreenshot();
				return false ;
			}
				 
			return true ;	
		}
		
		public WebElement getelemnet(String loc) {
			if (!isElementPresent(loc)) {
				System.out.println("Elemnt is not Present");
			}
            if (!isElementVisble(loc)) {
				System.out.println("Elemrnt is not Present");
			}
			WebElement element = driver.findElement(getlocater(loc)) ;
			return element;
		}
		
		 public By getlocater(String locater) {
			By by = null ;
			
			if (locater.toLowerCase().endsWith("id")){
				String locater2 = prop.getProperty(locater);
			 by = By.id(locater2) ;
				
			}else if (locater.toLowerCase().endsWith("class")){
				String locater2 = prop.getProperty(locater);
				 by = By.className(locater2) ;
				
			}else if (locater.toLowerCase().endsWith("likedtext")){
				String locater2 = prop.getProperty(locater);
				 by = By.linkText(locater2) ;

			}else if (locater.toLowerCase().endsWith("xpath")){
				String locater2 = prop.getProperty(locater);
				 by = By.xpath(locater2) ;
				
			}else if (locater.toLowerCase().endsWith("css")){
				String locater2 = prop.getProperty(locater);
				 by = By.cssSelector(locater2) ;
			}else {
				System.out.println("The Locater is not Working Properly");
				takescreenshot();
			}
			return by;
			
			
		}
		 public void waitplease() {
			 try {
				 Thread.sleep(9000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		 public void reportfailure(String msg) {
			 logfailure(msg);
			softAssert.fail(msg);
		}
		 public void reportAll() {
			softAssert.assertAll();
		}
		 
		 public void Setreport(ExtentTest test) {
			this.test = test ;
		}
		 public void loginfo(String msg) {
			test.log(Status.INFO , msg) ;
		}
		 public void logfailure(String msg) {
			test.log(Status.FAIL, msg) ;
		}
		 public void Cleartextbox(String txtboxpath) {
			getelemnet(txtboxpath).clear();
		}
		 public String Gettext(String loc) {
			 Select selecting = new Select(getelemnet(loc)) ;
			 return	selecting.getFirstSelectedOption().getText().trim() ;
			
		}
		 public void compatetext(String a, String b) {
			 softAssert.assertEquals(a, b) ;
			
		}
		 
		public void takescreenshot() {
		   String timing = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_ss-mm-HH")) ;
		   
		    String destinationpath = "C:\\Users\\Anu\\eclipse-workspace\\FinalEntrata\\Screenshot" + "\\" + timing + ".png" ;
		    
		    File destiFile = new File(destinationpath) ;
		    File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) ;
		    
		    try {
				FileUtils.copyFile(sourceFile, destiFile) ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    test.log(Status.INFO, MarkupHelper.createLabel("Screenshot"	, null)) ; 
		    test.log(Status.INFO, "<img src='" + destinationpath + "' height='100%' style='border:2px solid red'/>") ; 
		}
		 public void movetotheelement(String Webelement) {
			 loginfo("Move to the element "+ Webelement);
			action = new Actions(driver);
			action.moveToElement(getelemnet(Webelement)).clickAndHold().build().perform();
		}
		 public void Tabletextfinder(String tablewebelementinvludingrow , String Findingtext ) {
			List<WebElement> rows = driver.findElements(getlocater(tablewebelementinvludingrow)) ;
			Boolean one = false ;
			outerloop :
			for (WebElement row : rows) {
				
				List<WebElement> columns = row.findElements(By.tagName("td")) ;
				for (WebElement column : columns) {
					if (column.getText().equalsIgnoreCase(Findingtext)) {
						one = true ;
						System.out.println("We got the element");
						test.log( Status.PASS	, "We are able to locate the element in the table") ;
					break outerloop ;	
					}
				}
			}
			if (!one) {
				test.log(Status.FAIL, "This test got failed because we cannot find the testBoolean one in the table ") ;  
				org.testng.Assert.fail("This test case is failed as the Value is not at all present in the Table where we are searching "); ;
			}
		}
		 public void movetotheelementandclick(String Webelement) {
			 loginfo("Move to the element "+ Webelement);
				action = new Actions(driver);
				System.out.println("Moving to the element and clicking" + Webelement );
				action.moveToElement(getelemnet(Webelement)).click().perform();
			}
		 
		 public void Contextclick(String Webelement) {
				action = new Actions(driver);
				action.contextClick(getelemnet(Webelement)).build().perform();
			}
		 public void Scrolltotheelement(String Webelement) {
			 loginfo("scrolling to the element"+ Webelement );
			 action = new Actions(driver);
			action.scrollToElement(getelemnet(Webelement)).click().build().perform();
		}
		 public void Sendkeys(String Webelement , String msg) {
			 loginfo("Send the information :"+ msg);
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25)) ;
			 WebElement iem = wait.until(ExpectedConditions.visibilityOf(getelemnet(Webelement))) ;
			 iem.clear();
			 iem.sendKeys(msg);
		}
		 
		 public void Navigateback() {
			 driver.navigate().back();
		}
		 public void SelectDropdownByVisibleText(String locator, String visibleText) {
			 loginfo("Selecting the "+ visibleText + "From the dropdown");
			    Select dropdown = new Select(getelemnet(locator));
			    dropdown.selectByVisibleText(visibleText);
			}	 
		 public void Quit() {
			 loginfo("Quiting the Application");
			    driver.quit();
			}
		 
		 public boolean validateDynamicText(String locator, String expectedText) {
			    loginfo("Validating dynamic text of: " + locator); // Log only once

			    try {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			        wait.until(ExpectedConditions.textToBePresentInElementLocated(getlocater(locator), expectedText));

			        String actualText = driver.findElement(getlocater(locator)).getText().trim();
			        if (actualText.equals(expectedText.trim())) {
			            System.out.println("✅ Text validation passed: " + actualText);
			            return true;
			        } else {
			            System.out.println("❌ Text validation failed. Expected: '" + expectedText + "', but got: '" + actualText + "'");
			            reportfailure("Text mismatch for " + locator);
			            return false;
			        }

			    } catch (Exception e) {
			        System.out.println("❌ Exception during text validation: " + e.getMessage());
			        reportfailure("Text validation failed due to exception: " + locator);
			        return false;
			    }
			} 
		
		
	}
	
	

