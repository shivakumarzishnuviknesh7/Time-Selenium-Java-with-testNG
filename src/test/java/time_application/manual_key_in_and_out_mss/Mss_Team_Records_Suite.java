package time_application.manual_key_in_and_out_mss;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import time_application.base.Browser_Launch;

public class Mss_Team_Records_Suite extends Browser_Launch {

    @BeforeClass
    public void browser_Intialize() throws InterruptedException, AWTException, IOException {

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
    public void tc1_Search_Option_To_valdiate_if_an_employee_is_able_to_search_the_time_records()
            throws AWTException, InterruptedException, IOException {

    	//User is able to login into Time and he shoud able to search records in the time records

    	// home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //clicking team records
        Mss_Team_Records_calls.clicking_Team_Records();
        
        //search validation
        Mss_Team_Records_calls.search_validation();

    }
    
    @Test(priority = 2)
    public void tc3_Previous_Paycycle_Data_To_validate_if_an_employee_can_view_the_time_records_for_previous_paycycle() throws AWTException, InterruptedException, IOException {

    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM/yyyy");
	    LocalDateTime now2 = LocalDateTime.now();
	    String date_and_time2 = dtf.format(now2);
	    System.out.println(date_and_time2 );
	    
        String pay_period = date_and_time2;
        
        // home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //clicking team records
        Mss_Team_Records_calls.clicking_Team_Records();
        
        // clicking the filter icon
        Mss_My_Time_Record_Page_calls.clicking_Filter_IN_Time_records();

        // clicking pay period month
        Mss_My_Time_Record_Page_calls.clicking_pay_period_month_IN_Time_records();

        // clicking pay period month selecting
        Mss_My_Time_Record_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        Mss_My_Time_Record_Page_calls.filter_Close();

        // clicking the configure column
        Mss_My_Time_Record_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Mss_My_Time_Record_Page_calls.configure_Column_Select_All_Click();

        // this method used to click the date
        Mss_My_Time_Record_Page_calls.configure_Paygroup_Click();

        // clicking the save button to apply the changes
        Mss_My_Time_Record_Page_calls.configure_Column_Save_Click();

        // search validation
        Mss_My_Time_Record_Page_calls.previous_Pay_Group_Validation();
    }
    
    @Test(priority = 3,dependsOnMethods = "tc3_Previous_Paycycle_Data_To_validate_if_an_employee_can_view_the_time_records_for_previous_paycycle")
    public void tc4_Configure_Column_To_validate_if_an_employee_is_able_to_select_and_view_the_time_records_in_detail_as_per_column_selection()
            throws AWTException, InterruptedException, IOException {

        // checking selected value is coming in configure column
        Time_Records_Page_calls.check_The_Selected_Column_Is_Coming_Or_Not_In_Configurecolumn();

    }
    
    @Test(priority = 4)
    public void tc7_Filter_To_validate_if_an_employee_is_able_to_filter_any_specific_records_as_per_selection() throws Exception {

    	//filtering specific data in list view
    	
		String pay_period = "May/2023";
		String filter_value="27-Apr-2023";

		// home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //clicking team records
        Mss_Team_Records_calls.clicking_Team_Records();
        
        // clicking the filter icon
        Mss_My_Time_Record_Page_calls.clicking_Filter_IN_Time_records();

        // clicking pay period month
        Mss_My_Time_Record_Page_calls.clicking_pay_period_month_IN_Time_records();

        // clicking pay period month selecting
        Mss_My_Time_Record_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        Mss_My_Time_Record_Page_calls.filter_Close();

        // clicking the configure column
        Mss_My_Time_Record_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Mss_My_Time_Record_Page_calls.configure_Column_Select_All_Click();

		// Clicking the date in check box
        Mss_My_Time_Record_Page_calls.configure_Column_Date_Click();

		// clicking the save button to apply the changes
		Mss_My_Time_Record_Page_calls.configure_Column_Save_Click();

		// clicking the filter arrow
		Mss_My_Time_Record_Page_calls.filter_Arrow_Click();

		// clicking the specific record in the filter
		Mss_Team_Records_calls.filtering_Check(filter_value);
		
		// reseting the list view
        Time_Records_Page_calls.reset_Click();

        // clicking yes for reset
        Time_Records_Page_calls.reset_Click_Yes();

    }
    
    @Test(priority = 5)
    public void tc11_Show_Variance_Entry_Status() throws AWTException, InterruptedException, IOException {

      

        //user should able to see overtime datas in show variance

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //clicking team records
        Mss_Team_Records_calls.clicking_Team_Records();

        //clicking show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking Entry Type
        Mss_Team_Records_calls.configure_Entry_Type_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //Overtime checking
        Mss_Team_Records_calls.show_Variance_Check();

    }
    
    @Test(priority = 6)
    public void tc20_Status_Display_Status_To_validate_if_an_employee_is_able_to_see_the_overall_status_of_the_time_record() throws AWTException, InterruptedException, IOException {

        //user should able to see the status of the record

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //clicking team records
        Mss_Team_Records_calls.clicking_Team_Records();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        // this method used to click the display status
        Mss_Team_Records_calls.configure_Column_Display_Status_Click();

        //clicking the dates in check box
        Mss_Team_Records_calls.configure_Column_Dates_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        // display status  validation
        Time_Records_Page_calls.display_Status_Validation();

    }




    
    

}
