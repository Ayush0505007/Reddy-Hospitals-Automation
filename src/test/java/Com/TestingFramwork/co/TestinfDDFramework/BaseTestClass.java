package Com.TestingFramwork.co.TestinfDDFramework;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentReporting;

public class BaseTestClass extends Application{
	public ExtentReports report ;
	public ExtentTest Test ;
	public Application app ;

	@org.testng.annotations.BeforeTest
	public void BeforeTest(ITestContext context) {
	 // Suppress TestNG INFO logs
	 System.setProperty("org.testng.internal.Utils.verbose", "0");
	 
	 System.out.println("This is Beforetest ");
	 app = new Application() ;
	 context.setAttribute("app", app);
	 report = ExtentReporting.getreports();
	 Test = report.createTest(context.getCurrentXmlTest().getName()) ;
	 Test.log(Status.INFO , "Starting the test : " + context.getCurrentXmlTest().getName()) ;
	 
	 ((GenericKeyword) app).Setreport(Test);
	 context.setAttribute("report", report);
	 context.setAttribute("Test", Test);
	 
	}
	
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod(ITestContext context) {
	    System.out.println("This is BeforeMethod");
	    app = (Application) context.getAttribute("app");
	    report = (ExtentReports) context.getAttribute("report");
	    Test = (ExtentTest) context.getAttribute("Test");

	    // 👇 Re-establish the ExtentTest link before every test method
	    ((GenericKeyword) app).Setreport(Test);
	}

	@AfterMethod
	public void aftermethod(ITestContext context) {
		
	}
	@AfterClass
	public void AfterTest() {
		System.out.println("This is AfterClass "); 
	}
	@AfterTest
	public void Aftertest(ITestContext context) {
		report = (ExtentReports) context.getAttribute("report") ;
		if (report !=null) {
			report.flush();
		}
		reportAll(); 
	 	app.driver.quit();
	}
}
