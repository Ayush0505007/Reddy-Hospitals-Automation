package listner;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MytestListners implements ITestListener{
	
public void onTestSuccess(ITestResult result) {
ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("Test");
test.pass("This Test case is passed :" + result.getName()) ;
}
public void onTestFailure(ITestResult result) {
	ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("Test");
	test.fail( " this test case is failed ") ;
}
public void onTestSkipped(ITestResult result) {
	ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("Test");
	test.skip("This Test case is passed :" + result.getName()) ;
}
	
}
