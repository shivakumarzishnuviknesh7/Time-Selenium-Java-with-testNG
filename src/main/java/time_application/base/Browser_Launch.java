package time_application.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import time_application.extentmanager.ExtentManager;
import time_application.pages.manual_key_in_and_out_ess_pages.Add_Allowance_Page;
import time_application.pages.manual_key_in_and_out_ess_pages.Bank_Hours_Page;
import time_application.pages.manual_key_in_and_out_ess_pages.Ess_Neosuite_Login;
import time_application.pages.manual_key_in_and_out_ess_pages.Home_Page;
import time_application.pages.manual_key_in_and_out_ess_pages.Neosuite_Home_Page;
import time_application.pages.manual_key_in_and_out_ess_pages.Outlook_Page;
import time_application.pages.manual_key_in_and_out_ess_pages.Time_Records_Page;
import time_application.pages.manual_key_in_and_out_mss_pages.Bank_Hours_Mss_Page;
import time_application.pages.manual_key_in_and_out_mss_pages.Mss_Add_Allowance_Page;
import time_application.pages.manual_key_in_and_out_mss_pages.Mss_Home_Page;
import time_application.pages.manual_key_in_and_out_mss_pages.Mss_My_Time_Record_Page;
import time_application.pages.manual_key_in_and_out_mss_pages.Mss_Neosuite_Login;
import time_application.pages.manual_key_in_and_out_mss_pages.Mss_Team_Records;
import time_application.pages.manual_key_in_and_out_mss_pages.Mss_Team_Requests;


public class Browser_Launch {

    public static RemoteWebDriver driver;

    public Ess_Neosuite_Login Ess_Neosuite_Login_calls;
    public Neosuite_Home_Page Neosuite_Home_Page_calls;
    public Home_Page Home_Page_calls;
    public Bank_Hours_Page bank_hours_Page_calls;
    public Add_Allowance_Page Add_Allowance_Page_calls;
    public Mss_Neosuite_Login Mss_Neosuite_Login_calls;
    public Bank_Hours_Mss_Page bank_hoursMss_Page_calls;
    public Time_Records_Page Time_Records_Page_calls;
    public Mss_Home_Page Mss_Home_Page_calls;
    public Mss_Add_Allowance_Page Mss_Add_Allowance_Page_calls;
    public Download_Utility download_utility_calls;
    public Mss_My_Time_Record_Page Mss_My_Time_record_Page_calls;
    public Outlook_Page Outlook_Page_calls;
    public Mss_My_Time_Record_Page Mss_My_Time_Record_Page_calls;
    public Mss_Team_Records Mss_Team_Records_calls;
    public Mss_Team_Requests Mss_Team_Requests_calls;
    

    public WebDriverWait wait;
    public Properties prop;
    public Actions action;
    public JavascriptExecutor javascriptexecutor;

    
    @SuppressWarnings("deprecation")
	public void Time_Login() throws InterruptedException, IOException {
        //Properties file to load data
    	
        prop = new Properties();
        FileInputStream Fip = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Resources" + File.separator + "Id_Password.properties");
        prop.load(Fip);


        String Browser = System.getProperty("Browser") != null ? System.getProperty("Browser") : prop.getProperty("Browser"); // From properties file, the Browser name will be fetched.
          if (Browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			/*
			String downloadFilepath = System.getProperty("user.dir") + File.separator + "DownloadFile";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			*/
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--remote-allow-origins=*");
			options.setAcceptInsecureCerts(true);
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			//options.setExperimentalOption("prefs", chromePrefs);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			if (prop.getProperty("Execution").equals("headless")) {
				options.addArguments("--headless");
			}
			if (prop.getProperty("Remote").equals("false")) {
				driver = new ChromeDriver(options);
			} else {
				String completeURL = "http://NW-SDET-ALB-1412688782.eu-central-1.elb.amazonaws.com:4444/wd/hub";
				driver = new RemoteWebDriver(new URL(completeURL), options);
			}
		}

		else if (Browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// Creating firefox profile
			
			String downloadFilepath = System.getProperty("user.dir") + File.separator + "Downloads";
			Map<String, Object> preferences = new Hashtable<String, Object>();
			preferences.put("profile.default_content_settings.popups", 0);
			preferences.put("download.prompt_for_download", "false");
			preferences.put("download.default_directory", downloadFilepath);
			// disable flash and the PDF viewer
			preferences.put("plugins.plugins_disabled", new String[] { "Adobe Flash Player", "Chrome PDF Viewer" });
			// Instructing firefox to use custom download location
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("prefs", preferences);
			// Setting custom download directory
			profile.setPreference("browser.download.dir",
					System.getProperty("user.dir") + File.separator + "DownloadFile");
			// Skipping Save As dialog box for types of files with their MIME
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
			// Creating FirefoxOptions to set profile
			FirefoxOptions option = new FirefoxOptions();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			option.merge(capabilities);
			if (prop.getProperty("Execution").equals("headless")) {
				option.addArguments("--headless");
			}
			if (prop.getProperty("Remote").equals("false")) {
				option.setProfile(profile);
				driver = new FirefoxDriver();
			} else {
				String completeURL = "http://NW-SDET-ALB-1412688782.eu-central-1.elb.amazonaws.com:4444/wd/hub";
				driver = new RemoteWebDriver(new URL(completeURL), option);
			}
		} 
		else if (Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			String downloadFilepath = System.getProperty("user.dir") + File.separator + "Downloads";
			System.out.println(downloadFilepath);
			Map<String, Object> preferences = new Hashtable<String, Object>();
			preferences.put("profile.default_content_settings.popups", 0);
			preferences.put("download.prompt_for_download", "false");
			preferences.put("download.default_directory", downloadFilepath);
			// disable flash and the PDF viewer
			preferences.put("plugins.plugins_disabled", new String[] { "Adobe Flash Player", "Chrome PDF Viewer" });
			EdgeOptions options = new EdgeOptions();
			options.setExperimentalOption("prefs", preferences);
			options.addArguments("--remote-allow-origins=*");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			options.merge(capabilities);
			
			if (prop.getProperty("Execution").equals("headless")) {
				options.addArguments("--headless");
			}
			if (prop.getProperty("Remote").equals("false")) {
				driver = new EdgeDriver(options);
			} else {
				String completeURL = "http://NW-SDET-ALB-1412688782.eu-central-1.elb.amazonaws.com:4444/wd/hub";
				driver = new RemoteWebDriver(new URL(completeURL), options);
			}
			}
          
         driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        action = new Actions(driver);
        javascriptexecutor = (JavascriptExecutor) driver;

        Neosuite_Home_Page_calls = new Neosuite_Home_Page(driver, action, prop, wait,javascriptexecutor);
        Ess_Neosuite_Login_calls = new Ess_Neosuite_Login(driver, action, prop, wait,javascriptexecutor);
        Home_Page_calls = new Home_Page(driver, action, prop, wait,javascriptexecutor);
        bank_hours_Page_calls = new Bank_Hours_Page(driver, action, prop, wait,javascriptexecutor);
        Add_Allowance_Page_calls = new Add_Allowance_Page(driver, action, prop, wait,javascriptexecutor);
        Mss_Neosuite_Login_calls = new Mss_Neosuite_Login(driver, action, prop, wait,javascriptexecutor);
        bank_hoursMss_Page_calls = new Bank_Hours_Mss_Page(driver, action, prop, wait,javascriptexecutor);
        Time_Records_Page_calls = new Time_Records_Page(driver, action, prop, wait,javascriptexecutor);
        Mss_Home_Page_calls = new Mss_Home_Page(driver, action, prop, wait,javascriptexecutor);
        Mss_Add_Allowance_Page_calls = new Mss_Add_Allowance_Page(driver, action, prop, wait,javascriptexecutor);
        download_utility_calls = new Download_Utility(driver, action, prop, wait,javascriptexecutor);
        Mss_My_Time_record_Page_calls = new Mss_My_Time_Record_Page(driver, action, prop, wait,javascriptexecutor);
        Outlook_Page_calls = new Outlook_Page(driver, action, prop, wait,javascriptexecutor);
        Mss_My_Time_Record_Page_calls = new Mss_My_Time_Record_Page(driver, action, prop, wait,javascriptexecutor);
        Mss_Team_Records_calls = new Mss_Team_Records(driver, action, prop, wait,javascriptexecutor);
        Mss_Team_Requests_calls = new Mss_Team_Requests(driver, action, prop, wait,javascriptexecutor);
        
    }

    public static synchronized String takeScreenshot(String methodName) {

        DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy_HH_mm_ss_SSS");
        Date date = new Date();
        String dateName = dateFormat.format(date);
        String OUTPUT_FOLDER_SCREENSHOTS = File.separator + "Screenshots" + File.separator;
        String filePathExtent = OUTPUT_FOLDER_SCREENSHOTS + methodName + "_" + dateName + ".png";
        String filePath = ExtentManager.getReportBaseDirectory() + filePathExtent;
        String encodedBase64 = null;
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileInputStream fileInputStreamReader;
            fileInputStreamReader = new FileInputStream(screenshotFile);
            byte[] bytes = new byte[(int) screenshotFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = Base64.encodeBase64String(bytes);
            FileUtils.copyFile(screenshotFile, new File(filePath));
            fileInputStreamReader.close();
        } catch (IOException e) {
            e.getStackTrace();
            Reporter.log("Failed To Take screenshot " + e, true);
        }
        return encodedBase64;
    }

    @AfterClass
    public void Close_Window() {
    driver.quit();
    }

}
