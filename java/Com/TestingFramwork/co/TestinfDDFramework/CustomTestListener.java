package Com.TestingFramwork.co.TestinfDDFramework;

import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomTestListener implements ITestListener {
    static {
        // Disable TestNG's internal logging completely
        System.setProperty("org.testng.internal.Utils.verbose", "0");
        
        // Disable all java.util.logging from TestNG
        Logger.getLogger("org.testng").setLevel(Level.OFF);
        
        // Disable specific TestNG loggers
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        
        // Disable console output for org.testng
        System.setProperty("org.testng.dtd.http", "false");
        
        // Disable TestNG's default listeners
        System.setProperty("testng.show.stack.frames", "false");
        System.setProperty("testng.memory.friendly", "true");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Keep this empty to prevent any output
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Keep this empty to prevent any output
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Keep this empty to prevent any output
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Keep this empty to prevent any output
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Keep this empty to prevent any output
    }

    @Override
    public void onStart(org.testng.ITestContext context) {
        // Keep this empty to prevent any output
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        // Keep this empty to prevent any output
    }
}
