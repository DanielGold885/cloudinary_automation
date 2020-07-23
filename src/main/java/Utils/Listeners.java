package Utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Common implements ITestListener {


    public void onFinish(ITestContext result) {
        System.out.println("---------------------------- ENDING EXECUTION ----------------------------");
    }

    public void onStart(ITestContext result) {
        System.out.println("---------------------------- STARTING EXECUTION ----------------------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("---------------------------- " +
                "FAILED TEST: " + result.getName() + " ----------------------------");
            saveScreenshot();
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("---------------------------- " +
                "SKIPPED TEST: " + result.getName() + " ----------------------------");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("---------------------------- " +
                "STARTING TEST: " + result.getName() + " ----------------------------");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("---------------------------- " +
                "TEST FINISHED SUCCESSFULLY: " + result.getName() + " ----------------------------");
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(){
        return((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
