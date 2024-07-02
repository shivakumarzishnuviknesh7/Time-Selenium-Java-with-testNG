package time_application.manual_key_in_and_out_mss;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import time_application.base.Browser_Launch;

public class Mss_Time_Edit_Testcases extends Browser_Launch {
	
	
	@BeforeClass
    public void browser_Intialize() throws Exception {

        Time_Login();

        String Widget_Name = prop.getProperty("widget_Name");
        String heading = prop.getProperty("heading_Name");

        // login to neosuite for ESS
        Mss_Neosuite_Login_calls.Time_Login();

        // change role method
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_Manager();

        // bank module widget clicking
        Neosuite_Home_Page_calls.time_Widget_Click(Widget_Name , heading);

        // time zone check
        Mss_Home_Page_calls.Time_Zone_Check();

    }
	
	@Test(priority = 1)
	public void tc19_Edit_Time_through_Home_Screen() throws AWTException, InterruptedException, IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(1);
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		String Start_time_hours = "9";
		String Start_time_minutes = "0";
		String End_Time_hours = "19";
		String End_Time_minutes = "30";

		// Expected Output user should able to edit through home screen

		// home tab click
		Home_Page_calls.home_Click();

		// selecting date from the calendar
		Home_Page_calls.date_Selection_In_Calendar(day, month, year);

		// clicking edit button
		Home_Page_calls.edit_Button_Click();

		// select reason type
		Home_Page_calls.summary_Edit();

		// giving in time
		Home_Page_calls.in_Time_Edit(Start_time_hours, Start_time_minutes);

		// giving out time
		Home_Page_calls.out_Time_Edit(End_Time_hours, End_Time_minutes);

		// save click
		Home_Page_calls.save_Click();

		// toaster check
		Home_Page_calls.toaster_Message_Check();

		// edit page close
		Home_Page_calls.time_Edit_Page_Close();

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

		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// this method used to click the processing from
		Time_Records_Page_calls.configure_Date_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// checking allowance
		Time_Records_Page_calls.entry_Check(day, month);

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day, month);

		// toaster wait
		Home_Page_calls.loader_Wait_Toaster();

	}

	@Test(priority = 2)
	public void tc20_Edit_Time_through_Home_Screen_reset() throws AWTException, InterruptedException, IOException {
		
		// edit page close
		Home_Page_calls.time_Edit_Page_Close();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(1);
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		String Start_time_hours = "9";
		String Start_time_minutes = "0";
		String End_Time_hours = "19";
		String End_Time_minutes = "30";

		// Expected Output user should able to edit through home screen

		// home tab click
		Home_Page_calls.home_Click();

		// selecting date from the calendar
		Home_Page_calls.date_Selection_In_Calendar(day, month, year);

		// clicking edit button
		Home_Page_calls.edit_Button_Click();

		// select reason type
		Home_Page_calls.summary_Edit();

		// giving in time
		Home_Page_calls.in_Time_Edit(Start_time_hours, Start_time_minutes);

		// giving out time
		Home_Page_calls.out_Time_Edit(End_Time_hours, End_Time_minutes);

		// save click
		Mss_Home_Page_calls.reset_Checking();

		// edit page close
		Home_Page_calls.time_Edit_Page_Close();

	}


	@Test(priority = 3)
	public void tc10_Editing_Time_Entry_at_Summary_Level() throws AWTException, InterruptedException, IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(  2  );
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		System.out.println(day);
		System.out.println(month);
		System.out.println(year);

		String Start_time_hours = "10";
		String Start_time_minutes = "0";
		String End_Time_hours = "19";
		String End_Time_minutes = "30";

		// Time record tab click
		Home_Page_calls.time_Record_Click();

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);

		// user should able to edit time entry in summary level

		// home tab click
		Home_Page_calls.home_Click();

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

		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// selecting date
		Time_Records_Page_calls.configure_Column_Date_Click();
		
		// regularization status
		Time_Records_Page_calls.configure_Regularization_Status();

		// this method used to click the status
		Time_Records_Page_calls.configure_Column_Display_Status_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// search data for to edit
		Time_Records_Page_calls.search_Data_For_Summary_Edit(day, month);

		// editing in time
		Time_Records_Page_calls.in_Time_Edit(Start_time_hours, Start_time_minutes);

		// giving out time in hours and minutes
		Home_Page_calls.out_Time_Edit(End_Time_hours, End_Time_minutes);

		// save click
		Time_Records_Page_calls.save_Time_Edit();

		// toaster message check
		Time_Records_Page_calls.toaster_Message_Check();

		// page close
		Time_Records_Page_calls.time_Edit_Page_Close();

		// checking allowance
		Time_Records_Page_calls.entry_Check(day, month);
		
		// checking regularization
		Time_Records_Page_calls.edit_Check(day, month);
		
		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day, month);
		
		// toaster wait
		Home_Page_calls.loader_Wait_Toaster();


	}
	
	@Test(priority = 4)
	public void tc11_Editing_Time_Entry_at_Summary_Level_reset() throws AWTException, InterruptedException, IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(  2  );
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		System.out.println(day);
		System.out.println(month);
		System.out.println(year);

		String Start_time_hours = "10";
		String Start_time_minutes = "0";
		String End_Time_hours = "19";
		String End_Time_minutes = "30";

		// Time record tab click
		Home_Page_calls.time_Record_Click();

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);

		// user should able to edit time entry in summary level

		// home tab click
		Home_Page_calls.home_Click();

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

		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// selecting date
		Time_Records_Page_calls.configure_Column_Date_Click();
		
		// regularization status
		Time_Records_Page_calls.configure_Regularization_Status();

		// this method used to click the status
		Time_Records_Page_calls.configure_Column_Display_Status_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// search data for to edit
		Time_Records_Page_calls.search_Data_For_Summary_Edit(day, month);

		// editing in time
		Time_Records_Page_calls.in_Time_Edit(Start_time_hours, Start_time_minutes);

		// giving out time in hours and minutes
		Home_Page_calls.out_Time_Edit(End_Time_hours, End_Time_minutes);

		// reset click
		Mss_Home_Page_calls.reset_Checking();
				
		// page close
		Time_Records_Page_calls.time_Edit_Page_Close();

	}
	
	@Test(priority = 5)
    public void tc12_Editing_Time_Entry_at_detail_Level() throws AWTException, InterruptedException, IOException {

       // String pay_period = prop.getProperty("tc_31_pay_Period");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
	    LocalDateTime now = LocalDateTime.now().minusDays( 2 );
	    String date_and_time = dtf.format(now);
	    String values[]= date_and_time.split(" ");
	    
	    String day = values[0];
	    String month = values[1];
	    //String year = values[2];
	    
        
        String Start_time_hours = "09";
        String Start_time_minutes = "00";
        String End_Time_hours = "19";
        String End_Time_minutes = "00";

        //user should able to edit time entry in detail level

        // home tab click
        Home_Page_calls.home_Click();

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

        //clicking action
        Time_Records_Page_calls.configure_Action_Click();

        //selecting the date
        Time_Records_Page_calls.configure_Column_Date_Click();
        
        // this method used to click the status
        Time_Records_Page_calls.configure_Column_Display_Status_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //search data for edit
        Time_Records_Page_calls.search_Detail_Data_For_Summary_Edit(day  , month  );

        // editing in time
     	Time_Records_Page_calls.in_Time_Edit_Detail(Start_time_hours, Start_time_minutes,End_Time_hours, End_Time_minutes);
     	
     	//save click
     	Time_Records_Page_calls.save();

        //toaster message check
        Time_Records_Page_calls.toaster_Message_Check();

        //page close
        Time_Records_Page_calls.time_Edit_Page_Close();
        
        Time_Records_Page_calls.entry_Check(day  , month);

    }
	
		
		
	@Test(priority = 6)
    public void tc15_Bulk_Edit() throws AWTException, InterruptedException, IOException {

    	//String pay_period = "Jun/2023";
    	 String Start_time_hours = "9";
         String Start_time_minutes = "0";
         String End_Time_hours = "19";
         String End_Time_minutes = "30";
        
        //user should able to edit time entry for multiple entries

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //selecting date
        Time_Records_Page_calls.configure_Column_Date_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //two data select for edit
        Time_Records_Page_calls.selecting_Two_Check_Box_Record();
        
        //clicking bulk edit
        Time_Records_Page_calls.clicking_Bulk_Edit();
        
        //in time giving
        Time_Records_Page_calls.in_Time_Click(Start_time_hours,Start_time_minutes);
        
        //out time giving
        Time_Records_Page_calls.out_Time_Click( End_Time_hours, End_Time_minutes);
        
        //selecting shift
        Time_Records_Page_calls.clicking_Shift();
        
        //selecting record type
        Time_Records_Page_calls.selecting_Record_Type();
        
        //giving comment
        Time_Records_Page_calls.giving_Comment();
        
        //clicking submit
        Time_Records_Page_calls.clicking_Submit();
        
        //toaster message check
        Time_Records_Page_calls.toaster_Message_Bulk_Edit_Check();

        //page close
        Time_Records_Page_calls.time_Bulk_Edit_Page_Close();

    }
	
	@Test(priority = 7)
	public void tc17_Cancel_Edited_Entry() throws AWTException, InterruptedException, IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(  2  );
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		System.out.println(day);
		System.out.println(month);
		System.out.println(year);

		String Start_time_hours = "10";
		String Start_time_minutes = "0";
		String End_Time_hours = "19";
		String End_Time_minutes = "30";

		// Time record tab click
		Home_Page_calls.time_Record_Click();

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);

		// user should able to edit time entry in summary level

		// home tab click
		Home_Page_calls.home_Click();

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

		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// selecting date
		Time_Records_Page_calls.configure_Column_Date_Click();
		
		// regularization status
		Time_Records_Page_calls.configure_Regularization_Status();

		// this method used to click the status
		Time_Records_Page_calls.configure_Column_Display_Status_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// search data for to edit
		Time_Records_Page_calls.search_Data_For_Summary_Edit(day, month);

		// editing in time
		Time_Records_Page_calls.in_Time_Edit(Start_time_hours, Start_time_minutes);

		// giving out time in hours and minutes
		Home_Page_calls.out_Time_Edit(End_Time_hours, End_Time_minutes);

		// save click
		Time_Records_Page_calls.save_Time_Edit();

		// toaster message check
		Time_Records_Page_calls.toaster_Message_Check();

		// page close
		Time_Records_Page_calls.time_Edit_Page_Close();

		// checking allowance
		Time_Records_Page_calls.entry_Check(day, month);
		
		// checking regularization
		Time_Records_Page_calls.edit_Check(day, month);
		
		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day, month);
		
		// toaster wait
		Home_Page_calls.loader_Wait_Toaster();
		
		// checking regularization cancel
		Time_Records_Page_calls.edit_Cancel_Check(day, month);
	}
	
	@Test(priority = 8)
	public void tc19_Edit_Status() throws AWTException, InterruptedException, IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(  2  );
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		System.out.println(day);
		System.out.println(month);
		System.out.println(year);

		String Start_time_hours = "10";
		String Start_time_minutes = "0";
		String End_Time_hours = "19";
		String End_Time_minutes = "30";

		// Time record tab click
		Home_Page_calls.time_Record_Click();

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);

		// user should able to edit time entry in summary level

		// home tab click
		Home_Page_calls.home_Click();

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

		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// selecting date
		Time_Records_Page_calls.configure_Column_Date_Click();
		
		// regularization status
		Time_Records_Page_calls.configure_Regularization_Status();

		// this method used to click the status
		Time_Records_Page_calls.configure_Column_Display_Status_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// search data for to edit
		Time_Records_Page_calls.search_Data_For_Summary_Edit(day, month);

		// editing in time
		Time_Records_Page_calls.in_Time_Edit(Start_time_hours, Start_time_minutes);

		// giving out time in hours and minutes
		Home_Page_calls.out_Time_Edit(End_Time_hours, End_Time_minutes);

		// save click
		Time_Records_Page_calls.save_Time_Edit();

		// toaster message check
		Time_Records_Page_calls.toaster_Message_Check();

		// page close
		Time_Records_Page_calls.time_Edit_Page_Close();

		// checking allowance
		Time_Records_Page_calls.entry_Check(day, month);
		
		// checking regularization
		Time_Records_Page_calls.edit_Check(day, month);
		
		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day, month);
		
		// toaster wait
		Home_Page_calls.loader_Wait_Toaster();
		
		// checking regularization cancel
		Time_Records_Page_calls.edit_Cancel_Check(day, month);


	}
	
	@Test(priority = 9)
	public void tc14_Editing_Time_Entry_at_Detail_Level() throws Exception {
		
		//page close
        Time_Records_Page_calls.time_Edit_Page_Close();


		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(3);
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		System.out.println(day);
		System.out.println(month);
		System.out.println(year);

		String Start_time_hours = "09";
		String Start_time_minutes = "00";
		String End_Time_hours = "12";
		String End_Time_minutes = "00";

		String Start_time_hours_2 = "13";
		String Start_time_minutes_2 = "00";
		String End_Time_hours_2 = "18";
		String End_Time_minutes_2 = "00";

		// Time record tab click
		Home_Page_calls.time_Record_Click();

		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);

		// home tab click
		Home_Page_calls.home_Click();

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

		// user should able to edit time entry in detail level

		// clicking the configure column
		Home_Page_calls.configure_Column_Click();

		// clicking the select all check box
		Home_Page_calls.configure_Column_Select_All_Click();

		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// selecting date
		Time_Records_Page_calls.configure_Column_Date_Click();

		// this method used to click the status
		Time_Records_Page_calls.configure_Column_Display_Status_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// search data for to edit
		Time_Records_Page_calls.search_Data_For_Detail_Edit(day, month);

		// editing in time
		Time_Records_Page_calls.in_Time_Edit_Detail(Start_time_hours, Start_time_minutes, End_Time_hours,End_Time_minutes);

		// giving out time in hours and minutes
		Time_Records_Page_calls.in_Time_Edit_Detail_2nd_Value(Start_time_hours_2, Start_time_minutes_2,End_Time_hours_2, End_Time_minutes_2);

		// save click
		Time_Records_Page_calls.save_Time_Edit();

		// toaster message check
		Time_Records_Page_calls.toaster_Message_Detail_Edit_Check();

		// page close
		Time_Records_Page_calls.time_Edit_Page_Close();

		//entry checking
		Time_Records_Page_calls.entry_Check(day, month);

		// canceling the record
		Time_Records_Page_calls.search_Data_Click_Cancel(day, month);

		// toaster message check
		Time_Records_Page_calls.toaster_Message_Check_Cancel_Regularization();

	}

	
	@Test(priority = 10)
    public void tc13_Editing_Time_Entry_at_detail_Level_reset() throws AWTException, InterruptedException, IOException {

    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
	    LocalDateTime now = LocalDateTime.now().minusDays( 2 );
	    String date_and_time = dtf.format(now);
	    String values[]= date_and_time.split(" ");
	    
	    String day = values[0];
	    String month = values[1];
	    String year = values[2];
        
        String Start_time_hours = "09";
        String Start_time_minutes = "00";
        String End_Time_hours = "19";
        String End_Time_minutes = "00";

        //user should able to edit time entry in detail level

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

        //search data for edit
        Time_Records_Page_calls.search_Detail_Data_For_Summary_Edit(day  , month  );

        // editing in time
     	Time_Records_Page_calls.in_Time_Edit_Detail(Start_time_hours, Start_time_minutes,End_Time_hours, End_Time_minutes);
     	
     	//reset checking
     	Time_Records_Page_calls.reset_Checking();

        //page close
        Time_Records_Page_calls.time_Edit_Page_Close();

    }
	
	@Test(priority = 11)
	public void tc14_Editing_Time_Entry_at_Summary_Level_On_Behalf_of_Reportee() throws AWTException, InterruptedException, IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(  1  );
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		System.out.println(day);
		System.out.println(month);
		System.out.println(year);

		String Start_time_hours = "10";
		String Start_time_minutes = "0";
		String End_Time_hours = "19";
		String End_Time_minutes = "30";

		// Time record tab click
		Home_Page_calls.time_Record_Click();
/*
		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Run_Click_Cancel(day, month);
*/
		// user should able to edit time entry in summary level

		// home tab click
		Home_Page_calls.home_Click();

		// Time record tab click
		Home_Page_calls.time_Record_Click();
		
		 //clicking team records
        Mss_Team_Records_calls.clicking_Team_Records();
		
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

		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// selecting date
		Time_Records_Page_calls.configure_Column_Date_Click();
		
		// regularization status
		Time_Records_Page_calls.configure_Regularization_Status();

		// this method used to click the status
		Time_Records_Page_calls.configure_Column_Display_Status_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// search data for to edit
		Mss_Team_Records_calls.search_Data_For_Summary_Edit(day, month);

		// editing in time
		Time_Records_Page_calls.in_Time_Edit(Start_time_hours, Start_time_minutes);

		// giving out time in hours and minutes
		Home_Page_calls.out_Time_Edit(End_Time_hours, End_Time_minutes);

		// save click
		Time_Records_Page_calls.save_Time_Edit();

		// toaster message check
		Time_Records_Page_calls.toaster_Message_Check();

		// page close
		Time_Records_Page_calls.time_Edit_Page_Close();

		// checking allowance
		Mss_Team_Records_calls.entry_Check_Auto_Approved(day, month);
		
		// checking regularization
		Mss_Team_Records_calls.edit_Check(day, month);
/*
		// canceling the record
		Time_Records_Page_calls.search_Initial_Entry_Data_Before_Approval_Click_Cancel(day, month);
		
		// toaster wait
		Home_Page_calls.loader_Wait_Toaster();
*/

	}

	
	@Test(priority = 12)
	public void tc15_Editing_Time_Entry_at_Summary_Level_On_Behalf_of_Reportee_Reset() throws AWTException, InterruptedException, IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDateTime now = LocalDateTime.now().minusDays(  1  );
		String date_and_time = dtf.format(now);
		String values[] = date_and_time.split(" ");

		String day = values[0];
		String month = values[1];
		String year = values[2];

		System.out.println(day);
		System.out.println(month);
		System.out.println(year);

		String Start_time_hours = "10";
		String Start_time_minutes = "0";
		String End_Time_hours = "19";
		String End_Time_minutes = "30";

		// Time record tab click
		Home_Page_calls.time_Record_Click();

		// user should able to edit time entry in summary level

		// home tab click
		Home_Page_calls.home_Click();

		// Time record tab click
		Home_Page_calls.time_Record_Click();
		
		 //clicking team records
        Mss_Team_Records_calls.clicking_Team_Records();
		
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

		// clicking action
		Time_Records_Page_calls.configure_Action_Click();

		// selecting date
		Time_Records_Page_calls.configure_Column_Date_Click();
		
		// regularization status
		Time_Records_Page_calls.configure_Regularization_Status();

		// this method used to click the status
		Time_Records_Page_calls.configure_Column_Display_Status_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// search data for to edit
		Mss_Team_Records_calls.search_Data_For_Summary_Edit(day, month);

		// editing in time
		Time_Records_Page_calls.in_Time_Edit(Start_time_hours, Start_time_minutes);

		// giving out time in hours and minutes
		Home_Page_calls.out_Time_Edit(End_Time_hours, End_Time_minutes);

		// save click
		Mss_Team_Records_calls.reset_Checking();

		// page close
		Time_Records_Page_calls.time_Edit_Page_Close();


	}



}
