package time_application.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import time_application.base.Browser_Launch;
import time_application.extentmanager.ExtentTestManager;


public class Listeners extends Browser_Launch implements ITestListener {
    private static long endTime;

    private static void setStartTime(long startTime) {
    }

    private static void setEndTime(long endTime) {
        Listeners.endTime = endTime;
    }

    @Override
    public synchronized void onStart(ITestContext context) {
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        setStartTime(context.getStartDate().getTime());
        setEndTime(context.getEndDate().getTime());
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println("--------- Executing :- " + getSimpleMethodName(result) + " ---------");
        ExtentTestManager.createTest(result.getName(), result.getMethod().getDescription());
        ExtentTestManager.setCategoryName(getSimpleClassName(result));
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
        ExtentTestManager.getTest().log(Status.PASS, result.getName() + " Test is Passed");
//        try {
//            extentTestManager.getTest().pass("<br><font color= green>"+"Screenshot of Web"+"</font></b>",
//                    MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot(getSimpleClassName(result))).build());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        addExtentLabelToTest(result);
        ExtentTestManager.endTest();
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
//        ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
//        ExtentTestManager.getTest().log(Status.FAIL, result.getName() + " Test is failed" +result.getThrowable());
//        addExtentLabelToTest(result);
//        ExtentTestManager.endTest();
        ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
        ExtentTestManager.getTest().log(Status.FAIL, result.getName() + " Test is failed" + result.getThrowable());
        ExtentTestManager.getTest().fail("<br><font color= red>" + "Screenshot of Web" + "</font></b>",
                MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot(getSimpleMethodName(result)))
                        .build());
        addExtentLabelToTest(result);
        ExtentTestManager.endTest();
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, result.getName() + " Test is Skipped" + result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    private synchronized String getSimpleClassName(ITestResult result) {
        return result.getMethod().getRealClass().getSimpleName();
    }

    private synchronized String getSimpleMethodName(ITestResult result) {
        return result.getName();
    }

    private synchronized void addExtentLabelToTest(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS)
            ExtentTestManager.getTest().pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
        else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
        } else
            ExtentTestManager.getTest().skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));
    }
}
