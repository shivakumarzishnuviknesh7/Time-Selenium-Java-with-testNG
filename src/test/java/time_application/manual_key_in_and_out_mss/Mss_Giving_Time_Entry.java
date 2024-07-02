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

public class Mss_Giving_Time_Entry extends Browser_Launch {

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
	public void tc8_Verifying_Late_In_Details() throws Exception {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(1);
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		String Start_time_hours = "12";
		String Start_time_minutes = "00";
		String End_Time_hours = "19";
		String End_Time_minutes = "30";
		
		// home tab click
		Home_Page_calls.home_Click();

		// Time record tab click
		Home_Page_calls.time_Record_Click();

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);

		// Expected Output user should able to give time entry

		// home tab click
		Home_Page_calls.home_Click();

		// selecting date from the calendar
		Home_Page_calls.date_Selection_In_Calendar(day, month, year);
		
		 //shift drop down click
    	Mss_Home_Page_calls.shift_Drop_Down_Click();

        //morning shift click
    	Mss_Home_Page_calls.morning_Shift_Selection();

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
			Home_Page_calls.filter_Close();

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
		
		//clicking exception type
        Time_Records_Page_calls.configure_Exception_Type_Click();
		
		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// checking allowance
		Time_Records_Page_calls.entry_Check(day, month);
		
		//late in check
		Mss_My_Time_Record_Page_calls.entry_Check_Late_In(day, month);
		
		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day, month);
		
		// toaster wait
		Home_Page_calls.loader_Wait_Toaster();


	}
    
    @Test(priority = 2)
	public void tc9_Verifying_Early_Out_Details() throws Exception {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(1);
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		String Start_time_hours = "10";
		String Start_time_minutes = "00";
		String End_Time_hours = "17";
		String End_Time_minutes = "00";
		
		// home tab click
		Home_Page_calls.home_Click();

		// Time record tab click
		Home_Page_calls.time_Record_Click();

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);

		// Expected Output user should able to give time entry

		// home tab click
		Home_Page_calls.home_Click();

		// selecting date from the calendar
		Home_Page_calls.date_Selection_In_Calendar(day, month, year);
		
		 //shift drop down click
    	Mss_Home_Page_calls.shift_Drop_Down_Click();

        //morning shift click
    	Mss_Home_Page_calls.morning_Shift_Selection();

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
			Home_Page_calls.filter_Close();

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
		
		//clicking exception type
        Time_Records_Page_calls.configure_Exception_Type_Click();
		
		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// checking allowance
		Time_Records_Page_calls.entry_Check(day, month);
		
		//early out check
		Mss_My_Time_Record_Page_calls.entry_Check_Early_Out(day, month);
		
		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day, month);
		
		// toaster wait
		Home_Page_calls.loader_Wait_Toaster();
		
	}

    
    
    @Test(priority = 3)
   	public void tc18_Initial_Time_Entry_Status()  throws  Exception  {

   		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
   		LocalDateTime now = LocalDateTime.now().minusDays(1);
   		String date_and_time = dtf.format(now);
   		String values[] = date_and_time.split(" ");

   		String day = values[0];
   		String month = values[1];
   		String year = values[2];

   		String Start_time_hours = "10";
   		String Start_time_minutes = "00";
   		String End_Time_hours = "17";
   		String End_Time_minutes = "00";
   		
   		// home tab click
   		Home_Page_calls.home_Click();

   		// Time record tab click
   		Home_Page_calls.time_Record_Click();

   		// canceling the record
   		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);

   		//  Expected Output user should able to give time entry

   		// home tab click
   		Home_Page_calls.home_Click();

   		// selecting date from the calendar
   		Home_Page_calls.date_Selection_In_Calendar(day, month, year);
   		
   		 //shift drop down click
       	Mss_Home_Page_calls.shift_Drop_Down_Click();

         //morning shift click
       	Mss_Home_Page_calls.morning_Shift_Selection();

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
   			Home_Page_calls.filter_Close();

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
   		
   		//clicking exception type
           Time_Records_Page_calls.configure_Exception_Type_Click();
   		
   		// clicking action
   		Time_Records_Page_calls.configure_Action_Click();

   		// clicking the save button to apply the changes
   		Home_Page_calls.configure_Column_Save_Click();

   		// checking allowance
   		Time_Records_Page_calls.entry_Check(day, month);
   		
   		// canceling the record
   		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day, month);
   		
   		// toaster wait
   		Home_Page_calls.loader_Wait_Toaster();


   	}
    
    @Test(priority = 4)
   	public void tc16_Cancel_Initial_Time_Entry() throws Exception {

   		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
   		LocalDateTime now = LocalDateTime.now().minusDays(1);
   		String date_and_time = dtf.format(now);
   		String values[] = date_and_time.split(" ");

   		String day = values[0];
   		String month = values[1];
   		String year = values[2];

   		String Start_time_hours = "10";
   		String Start_time_minutes = "00";
   		String End_Time_hours = "17";
   		String End_Time_minutes = "00";
   		
   		// home tab click
   		Home_Page_calls.home_Click();

   		// Time record tab click
   		Home_Page_calls.time_Record_Click();

   		// canceling the record
   		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);

   		// Expected Output user should able to give time entry

   		// home tab click
   		Home_Page_calls.home_Click();

   		// selecting date from the calendar
   		Home_Page_calls.date_Selection_In_Calendar(day, month, year);
   		
   		 //shift drop down click
       	Mss_Home_Page_calls.shift_Drop_Down_Click();

         //morning shift click
       	Mss_Home_Page_calls.morning_Shift_Selection();

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
   			Home_Page_calls.filter_Close();

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
   		
   		//clicking exception type
        Time_Records_Page_calls.time_Entry_Status_Click();
   		
   		// clicking action
   		Time_Records_Page_calls.configure_Action_Click();

   		// clicking the save button to apply the changes
   		Home_Page_calls.configure_Column_Save_Click();

   		// checking allowance
   		Time_Records_Page_calls.entry_Check(day, month);
   		
   		// canceling the record
   		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day, month);
   		
   		// toaster message check
   		Time_Records_Page_calls.toaster_Message_Check_Cancel_After_Approval();
   		
   		//cancelled entry check
   		Time_Records_Page_calls.entry_Cancel_Check(day, month);


   	}
    
    @Test(priority = 5)
	public void tc18_BOD() throws AWTException, InterruptedException, IOException {

		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now2 = LocalDateTime.now().minusDays(2);
		String date_and_time2 = dtf2.format(now2);
		String values2[] = date_and_time2.split(" ");

		String day2 = values2[0];
		String month2 = values2[1];
		String year2 = values2[2];

		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now1 = LocalDateTime.now().minusDays(1);
		String date_and_time1 = dtf1.format(now1);
		String values1[] = date_and_time1.split(" ");

		String day1 = values1[0];
		String month1 = values1[1];
		String year1 = values1[2];

		String Start_time_hours = "9";
		String Start_time_minutes = "0";

		String End_Time_hours = "19";
		String End_Time_minutes = "30";

		// home tab click
   		Home_Page_calls.home_Click();

   		// Time record tab click
   		Home_Page_calls.time_Record_Click();

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day1, month1);

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day2, month2);

		// home tab click
		Home_Page_calls.home_Click();

		// selecting date from the calendar
		Home_Page_calls.date_Selection_In_Calendar(day2, month2, year2);

		// giving start time in hours and minutes
		Home_Page_calls.in_Time_Click(Start_time_hours, Start_time_minutes);

		// giving out time in hours and minutes
		Home_Page_calls.out_Time_Click_Bod(day1, month1, year1, End_Time_hours, End_Time_minutes);

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

		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// checking allowance
		Time_Records_Page_calls.entry_Check(day1, month1);

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day1, month1);

		// toaster wait
		Home_Page_calls.loader_Wait_Toaster();

		// checking allowance
		Time_Records_Page_calls.entry_Check(day2, month2);

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day2, month2);

		// toaster wait
		Home_Page_calls.loader_Wait_Toaster();

	}







}
