package Com.TestingFramwork.co.TestinfDDFramework;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends BaseTestClass {
	
 // @org.testng.annotations.Test
	public void Testcase1() throws InterruptedException {
		
	 app.openbrowser("Chrome");
		app.openURL("URL");
		app.takescreenshot();
		app.Click("signin_xpath");
		app.Click("emailbox_id") ;
		app.Sendkeys("emailbox_id", "ayushpersonal") ;
		app.Click("password_id") ;
		app.Sendkeys("password_id", "5D5gLnK3LvFUNZb@") ;
		app.waitplease();
		app.Click("sublit_id") ;
		app.Click("create_potfolio_id") ;
		app.Click("NameYourPortfolio_id") ;
		app.Cleartextbox("NameYourPortfolio_id") ;
		app.Sendkeys("NameYourPortfolio_id", "Dummy portfor");
		app.Click("create_Portfoio_id");
		app.compatetext(app.Gettext("portfolio_dropdown_id") , "Dummy portfolio");
		app.Scrolltotheelement("AddStock_xpath");
		app.Sendkeys("StocknameTextBox_xpath", "Yes Bank");
		app.getelemnet("StocknameTextBox_xpath").sendKeys(Keys.ENTER); 
		app.calender( "February 2025,06","calendermonthyear_xpath");
		
		
		app.reportAll();

	}
 @org.testng.annotations.Test 
	public void TestCase2() {		
	 	app.openbrowser("Chrome");
		app.openURL("URL");
		app.takescreenshot();
		app.Click("signin_xpath");
		app.Click("emailbox_id") ;
		app.Sendkeys("emailbox_id", "ayushtestbook") ;
		app.Click("password_id") ;
		app.Sendkeys("password_id", "cNu67BmmPHtCpFz@");
		app.waitplease();
		app.Click("sublit_id") ;
		app.Scrolltotheelement("AddStock_xpath");
		app.Click("AddStock_xpath");
		app.Sendkeys("StocknameTextBox_xpath", "YES Ba");
		app.getelemnet("StocknameTextBox_xpath").sendKeys(Keys.ENTER); 
		app.Click("calendericon_xpath");
		app.calender( "February 2025,06","calendermonthyear_xpath");
		app.Sendkeys("Quantity_id", "150");
		app.Sendkeys("purchasePrice_id", "100");
		app.Click("Nsebutton_xpath");
		app.Click("Addstovk_id");
		app.Scrolltotheelement("AddMfButton_xpath");
		app.waitplease();
		app.takescreenshot();
		app.Tabletextfinder("Tableafteraddingthestocks_xpath", "YES Bank Ltd.");
				
	}
// @org.testng.annotations.Test
	public void Testcase3() throws InterruptedException {
		
		app.openbrowser("Chrome");
		app.openURL("URL");
		app.BrokenURLvalidation();
		app.movetotheelement("Solution_xpath");
		app.movetotheelementandclick("Student_xpath");
		app.BrokenURLvalidation();
		app.validateDynamicText("Student_page_Do_it_xpath", "Do it all with Entrata's operating system") ;
		app.validateDynamicText("Student_page_header_component_xpath", "An award-winning platform for property owners and operators");
		app.validateDynamicText("Student_page_ready_tobuild_xpath", "Ready to build smarter?") ;
		
	}
}
