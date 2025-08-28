package reports;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.ReportStats;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting {
	
public static String reportPath ;	
	
public static ExtentReports reports ;
@Test
public static ExtentReports getreports() {
	if (reports == null) {
		reports= new ExtentReports() ;
		LocalDateTime dateTime = LocalDateTime.now() ;
		String time = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss").format(dateTime) ;
		
		String reportFolderName = time ;
		reportPath = "C:\\Users\\Anu\\eclipse-workspace\\TestinfDDFramework\\reports" + "\\" + reportFolderName;
		
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath) ;
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("My First Report");
		reporter.config().setDocumentTitle("Data Driven Test Report");
		reporter.config().setEncoding("utf-8");
		reports.attachReporter(reporter) ;
	}
	return reports ;
	
}
}
