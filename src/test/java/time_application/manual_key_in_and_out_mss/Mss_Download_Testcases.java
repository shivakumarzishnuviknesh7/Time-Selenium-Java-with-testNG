package time_application.manual_key_in_and_out_mss;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import time_application.base.Browser_Launch;

public class Mss_Download_Testcases extends Browser_Launch {

    @BeforeClass
    public void browser_Intialize() throws InterruptedException, AWTException, IOException {

    	prop = new Properties();
        FileInputStream Fip = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Resources" + File.separator + "Id_Password.properties");
        prop.load(Fip);
        
        
    	String Widget_Name = prop.getProperty("widget_Name");
        String heading = prop.getProperty("heading_Name");
        
    	String Role = "Reporting Manager";
        Time_Login();

        // login to neosuite for ESS
        Mss_Neosuite_Login_calls.Time_Login();

        // change role method
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_Employee(Role);
        
        // bank module widget clicking
        Neosuite_Home_Page_calls.time_Widget_Click(Widget_Name , heading);

    }
    
    @Test(priority = 1)
    public void tc2_Download_Detailed_Report_Mss_My_Records() throws AWTException, InterruptedException, IOException {

      
        String Download_File_name = "TimeSheet Detail Record";
        String Folder_name = "Time";
        String File_Rename = "TimeSheet Detail Record";
        String file_extension = "xlsx";
        
        // home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();

        // this method is used to click the detail download
        Time_Records_Page_calls.detail_Download_Click();

        // checking the file is getting downloaded or not
        download_utility_calls.File_Download_Check(Download_File_name, Folder_name, File_Rename, file_extension);

    }
    
    @Test(priority = 2)
    public void tc5_Download_Report_my_record()  throws AWTException, InterruptedException, IOException {

    	// User is able to login into Time user should able to download the detailed records
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("-dd-MMM-yyyy");
	    LocalDateTime now2 = LocalDateTime.now();
	    String date_and_time2 = dtf.format(now2);
	    System.out.println(date_and_time2 );
    	
        String Download_File_name = "File1"+date_and_time2+"";
        String Folder_name = "Time";
        String File_Rename = "TimeSheet Detail Record";
        String file_extension = "xlsx";
        
        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //two data select for edit
        Time_Records_Page_calls.selecting_Two_Check_Box_Record();

        // this method is used to click the detail download
        Time_Records_Page_calls.download_Click();

        // checking the file is getting downloaded or not
        download_utility_calls.File_Download_Check(Download_File_name, Folder_name, File_Rename, file_extension);

    }
    
    @Test(priority = 3)
    public void tc2_Download_Detailed_Report_Mss_Team_Records() throws AWTException, InterruptedException, IOException {

      
        String Download_File_name = "TimeSheet Detail Record";
        String Folder_name = "Time";
        String File_Rename = "TimeSheet Detail Record";
        String file_extension = "xlsx";
        
        // home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //clicking team records
        Mss_Team_Records_calls.clicking_Team_Records();

        // this method is used to click the detail download
        Time_Records_Page_calls.detail_Download_Click();

        // checking the file is getting downloaded or not
        download_utility_calls.File_Download_Check(Download_File_name, Folder_name, File_Rename, file_extension);

    }
    
    @Test(priority = 4)
    public void tc5_Download_Repor_team_records()  throws AWTException, InterruptedException, IOException {

    	// User is able to login into Time user should able to download the detailed records
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("-dd-MMM-yyyy");
	    LocalDateTime now2 = LocalDateTime.now();
	    String date_and_time2 = dtf.format(now2);
	    System.out.println(date_and_time2 );
    	
        String Download_File_name = "File1"+date_and_time2+"";
        String Folder_name = "Time";
        String File_Rename = "TimeSheet Detail Record";
        String file_extension = "xlsx";
        
        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //clicking team records
        Mss_Team_Records_calls.clicking_Team_Records();
        
        //two data select for edit
        Mss_Team_Records_calls.selecting_Two_Check_Box_Record();

        // this method is used to click the detail download
        Time_Records_Page_calls.download_Click();

        // checking the file is getting downloaded or not
        download_utility_calls.File_Download_Check(Download_File_name, Folder_name, File_Rename, file_extension);

    }
    
    @Test(priority = 5)
    public void tc2_Download_Detailed_Report_Mss_Team_requests() throws AWTException, InterruptedException, IOException {

      
        String Download_File_name = "TimeSheet Detail Record";
        String Folder_name = "Time";
        String File_Rename = "TimeSheet Detail Record";
        String file_extension = "xlsx";
        
        // home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //clicking team requests
        Mss_Team_Requests_calls.clicking_Team_Requests();

        // this method is used to click the detail download
        Time_Records_Page_calls.detail_Download_Click();

        // checking the file is getting downloaded or not
        download_utility_calls.File_Download_Check(Download_File_name, Folder_name, File_Rename, file_extension);

    }
    
    @Test(priority = 6)
    public void tc5_Download_Repor_team_requests()  throws AWTException, InterruptedException, IOException {

    	// User is able to login into Time user should able to download the detailed records
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("-dd-MMM-yyyy");
	    LocalDateTime now2 = LocalDateTime.now();
	    String date_and_time2 = dtf.format(now2);
	    System.out.println(date_and_time2 );
    	
        String Download_File_name = "File1"+date_and_time2+"";
        String Folder_name = "Time";
        String File_Rename = "TimeSheet Detail Record";
        String file_extension = "xlsx";
        
        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //clicking team requests
        Mss_Team_Requests_calls.clicking_Team_Requests();
        
        //two data select for edit
        Time_Records_Page_calls.selecting_Two_Check_Box_Record();

        // this method is used to click the detail download
        Time_Records_Page_calls.download_Click();

        // checking the file is getting downloaded or not
        download_utility_calls.File_Download_Check(Download_File_name, Folder_name, File_Rename, file_extension);

    }




}
