package time_application.extentmanager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static WebDriver driver;
    private static String reportBaseDirectory;
    private static ExtentReports extent;
    public static final String OUTPUT_FOLDER_SCREENSHOTS = File.separator + "Screenshots" + File.separator;

    public static final String REPORT_FILE_PATH = System.getProperty("user.dir") + File.separator + "Automation_Reports";

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    // Create an extent report instance
    public static void createInstance() {
        ExtentManager.initDirectories();
        setReportBaseDirectory(REPORT_FILE_PATH);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss_a");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
                REPORT_FILE_PATH + File.separator + "Time-Automaton-Report_" + formater.format(calendar.getTime()) + ".html");
        htmlReporter.config().setDocumentTitle("Time Employee Role Report");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setJs("$('.brand-logo').text('TIME');");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.specification.version"));
        extent.setSystemInfo("Time Automation Script Prepared By", "NW Testing Team");
        extent.setSystemInfo("Test Executed By", System.getProperty("user.name"));
    }

    public synchronized static String getReportBaseDirectory() {
        return reportBaseDirectory;
    }

    public synchronized static void setReportBaseDirectory(String reportBaseDirectory) {
        ExtentManager.reportBaseDirectory = reportBaseDirectory;
    }

    public static void initDirectories() {
        try {
            createFolder(REPORT_FILE_PATH + OUTPUT_FOLDER_SCREENSHOTS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createFolder(String folderPath) {
        File file = new File(folderPath);
        if (!file.exists())
            file.mkdirs();
    }

}
