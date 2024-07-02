package time_application.manual_key_in_and_out_ess;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import time_application.base.Browser_Launch;

public class Email_Validation_Testcases extends Browser_Launch {

    @BeforeClass
    public void browser_Intialize() throws InterruptedException, AWTException, IOException {

    	prop = new Properties();
        FileInputStream Fip = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Resources" + File.separator + "Id_Password.properties");
        prop.load(Fip);
      
        String Widget_Name = prop.getProperty("widget_Name");
        String heading = prop.getProperty("heading_Name");
       
        Time_Login();

        // login to neosuite for ESS
        Ess_Neosuite_Login_calls.eSS_Login();

        String Role = "Employee";
        // change role method
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_Employee(Role); 

        // bank module widget clicking
        Neosuite_Home_Page_calls.time_Widget_Click(Widget_Name , heading);

        // time zone check
        Home_Page_calls.time_Zone_Check();

    }
    
    @Test(priority = 1)
    public void tc63_Email_Notification() throws Exception {

    	String Role = "Employee";
        String Widget_Name = prop.getProperty("widget_Name");
        String heading = prop.getProperty("heading_Name");

    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
 	    LocalDateTime now = LocalDateTime.now().minusDays( 1 );
 	    String date_and_time = dtf.format(now);
 	    String values[]= date_and_time.split(" ");
 	    
 	    String day = values[0];
 	    String month = values[1];
 	    String year = values[2];
 	    
        String Start_time_hours = "9";
        String Start_time_minutes = "0";
        String End_Time_hours = "19";
        String End_Time_minutes = "30";
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();

        // canceling the record
        Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);
        
        // home tab click
        Home_Page_calls.home_Click();
        
        Home_Page_calls.collect_Time();
        
        ArrayList<String> time = Home_Page_calls.collect_Time(); 
      
        // selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);

        // giving start time in hours and minutes
        Home_Page_calls.in_Time_Click(Start_time_hours, Start_time_minutes);

        // giving out time in hours and minutes
        Home_Page_calls.out_Time_Click(End_Time_hours, End_Time_minutes);

        // clicking the tick icon
        Home_Page_calls.tick_Icon_Click();

        // giving comment and submit
        Home_Page_calls.giving_Comment();

        // toaster check
        Home_Page_calls.toaster_Message_Check_Time_Entry();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd");
	    LocalDateTime present = LocalDateTime.now();
	    String date = format.format(present);
	    
	    if (date.equals("01")) {
        	DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM/yyyy");
    	    LocalDateTime no = LocalDateTime.now();
    	    String month_yr = dt.format(no);
        	String pay_period = month_yr;  	
        	
    		// clicking the filter icon
    		Home_Page_calls.clicking_Filter_IN_Time_Records();

    		// clicking pay period month
    		Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

    		// clicking pay period month selecting
    		Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

    		// clicking the filter close icon
    		//Home_Page_calls.filter_Close();

        } else {
			
		}
        
       // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        // this method used to click the status
        Time_Records_Page_calls.configure_Column_Display_Status_Click();
     
        // this method used to click the processing from
        Time_Records_Page_calls.configure_Date_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();
        
        //checking allowance
        Time_Records_Page_calls.entry_Check(day  , month);

        // clicking logout
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_And_Log_Out();
    
        //email login
        Outlook_Page_calls.outlook_Login();
        
        //email filtering
        Outlook_Page_calls.filtering();
        
        //checking the mail
        Outlook_Page_calls.mail_Check(time);
        /*
        // login to neosuite for ESS
        Ess_Neosuite_Login_calls.eSS_Login();

        // change role method
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_Employee(Role); 

        // bank module widget clicking
        Neosuite_Home_Page_calls.time_Widget_Click(Widget_Name , heading);
        
        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
    
        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking action
        Time_Records_Page_calls.configure_Action_Click();

        //selecting the date
        Time_Records_Page_calls.configure_Column_Date_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //canceling the record
        Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel( day  , month );

        //toaster message check
        Time_Records_Page_calls.toaster_Message_Check_Cancel_After_Approval();
*/
        
    }



}
