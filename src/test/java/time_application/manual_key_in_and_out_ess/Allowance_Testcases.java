package time_application.manual_key_in_and_out_ess;

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

public class Allowance_Testcases extends Browser_Launch {

	@BeforeClass
    public void browser_Intialize() throws InterruptedException, AWTException, IOException {

    	prop = new Properties();
        FileInputStream Fip = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Resources" + File.separator + "Id_Password.properties");
        prop.load(Fip);

        String Role = "Employee";
        String Widget_Name = prop.getProperty("widget_Name");
        String heading = prop.getProperty("heading_Name");
        
        Time_Login();

        // login to neosuite for ESS
        Ess_Neosuite_Login_calls.eSS_Login();
        
        // change role method
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_Employee(Role); 
        
        // bank module widget clicking
        Neosuite_Home_Page_calls.time_Widget_Click(Widget_Name , heading);

        // time zone check
        Home_Page_calls.time_Zone_Check();



    }
	
	@Test(priority = 1)
    public void tc28_Add_Allowance_To_validate_if_an_employee_can_add_the_allowance_with_IN_and_OUT_Time_manually_Reset() throws AWTException, InterruptedException, IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
	    LocalDateTime now = LocalDateTime.now().minusDays( 1 );
	    String date_and_time = dtf.format(now);
	    String values[]= date_and_time.split(" ");
	    
	    // String day = values[0];
	    String day = "27";
	    String month = values[1];
	    String year = values[2];
	    
	    System.out.println( day );
	    System.out.println( month );
	    System.out.println( year );
	
	    String Start_time_hours = "09";
        String Start_time_minutes = "00";
        String End_Time_hours = "09";
        String End_Time_minutes = "30";
        String Kilometer_unit ="10";

        //Add Allowance: To validate if an employee can add the allowance with IN & OUT Time manually by selecting the Allowance from the dropdown.(we should able to go to allowance screen and make changes )
        
        //Clicking the home tab
        Home_Page_calls.home_Click();

        //selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);

        //add allowance click in home page
        Add_Allowance_Page_calls.add_Allowance_Click();

        // this method is used to add the allowance in allowance page
        Add_Allowance_Page_calls.selecting_Allowance();

        //giving start time in hours and minutes in allowance
        Add_Allowance_Page_calls.start_Time(Start_time_hours, Start_time_minutes);

        //giving start time in hours and minutes in allowance
        Add_Allowance_Page_calls.end_Time(End_Time_hours, End_Time_minutes);

        //giving kilometer
        Add_Allowance_Page_calls.kilometer_Providing(Kilometer_unit);
        
        //reset checking
        Add_Allowance_Page_calls.reset_Check();

        //clicking close icon
        Add_Allowance_Page_calls.clicking_Close();
        
    }

	
	@Test(priority = 2)
    public void tc28_Add_Allowance_To_validate_if_an_employee_can_add_the_allowance_with_IN_and_OUT_Time_manually() throws AWTException, InterruptedException, IOException {
    
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
	    LocalDateTime now = LocalDateTime.now().minusDays( 1 );
	    String date_and_time = dtf.format(now);
	    String values[]= date_and_time.split(" ");
	    
	   // String day = values[0];
	    String day = "27";
	    String month = values[1];
	    String year = values[2];
	    
	    System.out.println( day );
	    System.out.println( month );
	    System.out.println( year );
	
	    String Start_time_hours = "09";
        String Start_time_minutes = "00";
        String End_Time_hours = "09";
        String End_Time_minutes = "30";
        String Kilometer_unit ="10";
        String Toaster = "Saved Successfully";

        //Add Allowance: To validate if an employee can add the allowance with IN & OUT Time manually by selecting the Allowance from the dropdown.(we should able to go to allowance screen and make changes )
        
        //Clicking the home tab
        Home_Page_calls.home_Click();

        //selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);

        //add allowance click in home page
        Add_Allowance_Page_calls.add_Allowance_Click();

        // this method is used to add the allowance in allowance page
        Add_Allowance_Page_calls.selecting_Allowance();

        //giving start time in hours and minutes in allowance
        Add_Allowance_Page_calls.start_Time(Start_time_hours, Start_time_minutes);

        //giving start time in hours and minutes in allowance
        Add_Allowance_Page_calls.end_Time(End_Time_hours, End_Time_minutes);

        //giving kilometer
        Add_Allowance_Page_calls.kilometer_Providing(Kilometer_unit);

        //clicking the submit button
        Add_Allowance_Page_calls.clicking_Submit();

        //Toaster message check
        Add_Allowance_Page_calls.assertion_Check(Toaster);

        //clicking close icon
        Add_Allowance_Page_calls.clicking_Close();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();
        
       // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        // this method used to click the status
        Time_Records_Page_calls.configure_Column_Display_Status_Click();
     
        // this method used to click the processing from
        Time_Records_Page_calls.configure_Processing_From_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();
        
        //checking allowance
        Time_Records_Page_calls.alowance_Check(day  , month);
        
    }

    
    @Test(priority = 3)
    public void tc30_validate_if_automatic_allowance_are_populated() throws AWTException, InterruptedException, IOException {

        //Checking that whether the - Auto allowance (Meal allowance) which is present in approved records or not

        //Time record tab click
        Home_Page_calls.time_Record_Click();

        // clicking the show variance record toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();

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

        //clicking the configure column
        Home_Page_calls.configure_Column_Click();

        //clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking the processing from in check box
        Home_Page_calls.configure_Processing_From_Click();

        //clicking the payment name in check box
        Home_Page_calls.configure_Payment_Name_Click();

        //clicking the paid hours in check box
        Home_Page_calls.configure_Paid_Hours_Click();

        //clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //passing value for search for meal allowance
        Home_Page_calls.search_Value_Passing_For_Meal_Allowance();

        //checking meal allowance added or not
        Home_Page_calls.checking_For_Meal_Allowance();

    }


    @Test(priority = 4)
    public void tc31_allowance_can_be_removed_totally_by_using_Dash_icon_in_the_Add_Allowance_screen() throws AWTException, InterruptedException, IOException {

    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
	    LocalDateTime now = LocalDateTime.now().minusDays( 1 );
	    String date_and_time = dtf.format(now);
	    String values[]= date_and_time.split(" ");
	    
	    String day = values[0];  
	    String month = values[1];
	    String year = values[2];
        
        //Checking that whether the - button is working in allowance page
        
        //Clicking the home tab
        Home_Page_calls.home_Click();

        //selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);

        //add allowance click in home page
        Add_Allowance_Page_calls.add_Allowance_Click();

        //clicking the add allowance button in allowance page
        Add_Allowance_Page_calls.clicking_Add_Allowance();

        //clicking close icon
        Add_Allowance_Page_calls.clicking_Close();

    }
     
    @Test(priority = 5)
    public void tc29_employee_can_add_the_allowance_for_a_specific_date_for_which_Allowances_are_already_populated_give_multiple_allowance() throws AWTException, InterruptedException, IOException {

    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
	    LocalDateTime now = LocalDateTime.now().minusDays( 1 );
	    String date_and_time = dtf.format(now);
	    String values[]= date_and_time.split(" ");
	    
	   // String day = values[0];
	    String day = "21";
	    String month = values[1];
	    String year = values[2];
	    
	    System.out.println( day );
	    System.out.println( month );
	    System.out.println( year );
	    
	    String Start_time_hours = "09";
        String Start_time_minutes = "00";
        String End_Time_hours = "09";
        String End_Time_minutes = "30";
        String Kilometer_unit ="10";
        String Toaster = "Saved Successfully";

        // Checking that whether the - We can add multiple allowance
        
        //Clicking the home tab
        Home_Page_calls.home_Click();
        
        //selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);

        //add allowance click in home page
        Add_Allowance_Page_calls.add_Allowance_Click();

        //adding allowance button click
        Add_Allowance_Page_calls.add_Allowance_Button_Click();

        //selecting the allowance 2
        Add_Allowance_Page_calls.selecting_Allowance_Two();

        //selecting the travel allowance for 2nd time
        Add_Allowance_Page_calls.selecting_Travel_Allowance_Two();

        //giving start time in hours and minutes in allowance
        Add_Allowance_Page_calls.start_Time_2nd_Time(Start_time_hours, Start_time_minutes);

        //giving start time in hours and minutes in allowance
        Add_Allowance_Page_calls.end_Time_2nd_Time(End_Time_hours, End_Time_minutes);

        //giving kilometer
        Add_Allowance_Page_calls.kilometer_Providing(Kilometer_unit);

        //clicking the submit button
        Add_Allowance_Page_calls.clicking_Submit();

        //Toaster message check
        Add_Allowance_Page_calls.assertion_Check(Toaster);

        //clicking close icon
        Add_Allowance_Page_calls.clicking_Close();
        
    }
    
    @Test(priority = 6)
    public void tc51_Allowance_Cancellation_After_Approval() throws AWTException, InterruptedException, IOException {

        //user should able to cancel allowance after approval

        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking action
        Time_Records_Page_calls.configure_Action_Click();

        //clicking payment name
        Time_Records_Page_calls.configure_Column_Payment_Name_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //canceling the record
        Time_Records_Page_calls.search_Data_Click_Allowance_Cancel();

        //toaster message check
        Time_Records_Page_calls.toaster_Message_Check_allowance_cancel();


    }




}
