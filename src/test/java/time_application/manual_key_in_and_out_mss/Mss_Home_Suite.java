package time_application.manual_key_in_and_out_mss;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import time_application.base.Browser_Launch;

public class Mss_Home_Suite extends Browser_Launch {

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
    public void tc1_TimeZone_To_validate_if_an_employee_is_able_to_view_the_timezone_based_on_configuration() throws AWTException, InterruptedException, IOException {
        
        //TimeZone: To validate if an employee is able to view the time zone based on configuration.

        // time zone check
        Mss_Home_Page_calls.Time_Zone_Check();

    }

    @Test(priority = 2 )
    public void tc2_Calendar_Navigation_To_validate_if_an_employee_is_able_to_navigate_between_dates_using_calendar_navigation_arrows()  throws AWTException, InterruptedException, IOException {

    	//Calendar Navigation: To validate if an employee is able to navigate between dates using calendar navigation arrows.

        // checking the date is getting changed when we use navigation
        Mss_Home_Page_calls.Clicking_Back_And_Front_Calendar_Navigation();

    }

    @Test( priority = 3 )
    public void tc3_View_Current_Date_To_validate_if_an_employee_can_fall_back_to_current_date_if_past_date_is_selected() throws AWTException, InterruptedException, IOException {

    	//View Current Date: To validate if an employee can fall back to current date if past date is selected.

        // today button click and check its comes to current date
        Mss_Home_Page_calls.Today_Click_Validate();

    }

    @Test( priority = 4 )
    public void tc21_Apply_Leave_To_validate_if_an_employee_is_able_to_click_applyleave_and_view_screen()  throws AWTException, InterruptedException, IOException {

        // checking the apply leave window viewing
        Mss_Home_Page_calls.Apply_leave();

    }
    

    @Test(priority = 5)
    public void tc16_Shift_Details_To_validate_if_employee_can_view_the_assigned_shift_Hover_on_I_icon_it_shows_details() throws AWTException, InterruptedException, IOException {

    	 //Shift Details: To validate if employee can view the assigned shift.(Hover on I icon it shows details)

        //shift hour check
    	Mss_Home_Page_calls.shift_Hour_Check();

    }

    @Test(priority = 6)
    public void tc17_Shift_Details_on_Bar_Chart_To_validate_if_an_employee_is_able_to_view_the_details_on_bar_chart_as_per_the_color_legend_displayed_Check_the_time_details_which_is_in_colored_is_displayed_as_per_selection() throws AWTException, InterruptedException, IOException {

        String day = "22";
        String month = "June";
        String year = "2023";

    	 // selecting date from the calendar
        Mss_Home_Page_calls.date_selection_in_calendar(day, month, year);

        //getting the color of work hours and check
        Mss_Home_Page_calls.getting_Work_Hours_Check();

    }
    
    @Test(priority = 7)
    public void tc4_employee_is_able_to_see_the_Total_Time_for_the_entire_pay_cycle_Total_hours() throws Exception {

        //Time Summary: To validate if an employee is able to see the Total Time for the entire pay cycle.(Total hours)

    	//action.sendKeys(Keys.ESCAPE).build().perform();
    	
    	// home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();
        
        //clicking the configure column
        Home_Page_calls.configure_Column_Click();

        //clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking the total time check box
        Home_Page_calls.configure_Column_Total_Time_Click();

        //clicking the save button to apply the changes 
        Home_Page_calls.configure_Column_Save_Click();

        //adding all the values in the list view and validating fot total time
        Home_Page_calls.total_Time_Add();

        String a = Home_Page_calls.total_Time_Add();

        //home tab click
        Home_Page_calls.home_Click();

        // total hours check for Current month
        Home_Page_calls.time_Summary_Total_Hours_Check_Current_Month(a);

    }


    @Test(priority = 8)
    public void tc5_employee_is_able_to_see_the_Time_records_for_the_entire_pay_cycle_Work_hours() throws Exception {

        //Time Summary: To validate if an employee is able to see the Time records  for the entire pay cycle.(Work hours)

    	// home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //clicking the configure column
        Home_Page_calls.configure_Column_Click();

        //clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking the work hours check box
        Home_Page_calls.configure_Column_Work_Hours_Click();

        //clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //adding all the values in the list view and validating fot total time
        Home_Page_calls.total_Time_Add();

        String a = Home_Page_calls.total_Time_Add();

        //home tab click
        Home_Page_calls.home_Click();

        // current month work hours check
        Home_Page_calls.time_Summary_Work_Hours_Check_Current_Month(a);
    }

    @Test(priority = 9)
    public void tc6_employee_is_able_to_see_the_Break_Hours_for_the_entire_pay_cycle_Break_hours() throws Exception {

       //Time Summary: To validate if an employee is able to see the Break Hours for the entire pay cycle.(Break hours)
   
    	// home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //clicking the configure column
        Home_Page_calls.configure_Column_Click();

        //clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking the break hours check box
        Home_Page_calls.configure_Column_Break_Hours_Click();

        //clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //adding all the values in the list view and validating fot total time
        Home_Page_calls.total_Time_Add();

        String a = Home_Page_calls.total_Time_Add();

        //home tab click
        Home_Page_calls.home_Click();

        // current month break hours check
        Home_Page_calls.time_Summary_Break_Hours_Check_Current_Month(a);
    }

    @Test(priority = 10)
    public void tc7_employee_is_able_to_see_the_bank_Hours_for_the_entire_pay_cycle_bank_hours() throws AWTException, InterruptedException, IOException {

        //Time Summary: To validate if an employee is able to see the bank Hours for the entire pay cycle.(bank hours)
   
    	// home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        //Home_Page_calls.time_Record_Click();
        
        // time zone check
        bank_hours_Page_calls.bank_Hours_Click();

        //searching status as approved
        bank_hours_Page_calls.search_Approved_Values();

        //clicking the configure column
        bank_hours_Page_calls.configure_Column_Click();

        //clicking the select all check box
         bank_hours_Page_calls.configure_Column_Select_All_Click();

        //clicking the status check box
        bank_hours_Page_calls.configure_Column_Bank_Hours_Click();

        //clicking the save button to apply the changes
        bank_hours_Page_calls.configure_Column_Save_Click();

        //adding all the values in the list view and validating fot total time
        bank_hours_Page_calls.total_Time_Add();

        String a = bank_hours_Page_calls.total_Time_Add();

        //home tab click
        Home_Page_calls.home_Click();

        //clicking right arrow in time summary
        Home_Page_calls.time_Summary_Right_Arrow_Click();

        // current month bank hours check
        Home_Page_calls.time_Summary_Bank_Hours_Check_Current_Month(a);


    }

    @Test(priority = 11)
    public void tc8_employee_is_able_to_see_the_Over_Time_for_the_entire_pay_cycle_Over_time() throws Exception {

        //Time Summary: To validate if an employee is able to see the OverTime  for the entire pay cycle.(Over time)
   
    	// home tab click
        Home_Page_calls.home_Click();
        
        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //clicking the configure column
        Home_Page_calls.configure_Column_Click();

        //clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking the break hours check box
        Home_Page_calls.configure_Column_Over_Time_Hours_Click();

        //clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //adding all the values in the list view and validating fot total time
        Home_Page_calls.total_Time_Add();

        String a = Home_Page_calls.total_Time_Add();

        //home tab click
        Home_Page_calls.home_Click();

        //clicking right arrow
        Home_Page_calls.time_Summary_Right_Arrow_Click();

        // current month over time hours check
        Home_Page_calls.time_Summary_Over_Time_Hours_Check_Current_Month(a);

    }

    @Test(priority = 12)
    public void tc10_current_processing_period_is_visible_in_time_Summary_paycycle_start_and_end_date() throws  InterruptedException, IOException {
       
    	//Time Summary: To validate if current processing period is visible in time Summary.(paycycle tstart and end date)

    	//home tab click
        Home_Page_calls.home_Click();
        
        // today button click
        Home_Page_calls.today_Button_Click();

        //clicking right arrow
        Home_Page_calls.current_Processing_Period_Check();

    }

    @Test(priority = 13)
    public void tc10_Time_Summary_To_check_if_arrows_work_when_more_then_3_dials_are_configured() throws AWTException, InterruptedException, IOException {

        //Time Summary: To check if arrows work when more then 3 dials are configured.
    	
    	//home tab click
        Home_Page_calls.home_Click();

        // today button click
        Home_Page_calls.today_Button_Click();

        //clicking right arrow
        Home_Page_calls.time_Summary_Navigation_Check();

    }
    
    @Test(priority = 14)
    public void tc11_My_Statistics_To_validate_if_Short_hours_Absent_Half_Day_count_are_displayed_for_the_paycycle() throws Exception {

        //My Statistics: To validate if Short hours, Absent, Half Day count are displayed for the paycycle.(check with exception and compare the count and validate)
    	
        //home tab click
        Home_Page_calls.home_Click();

        //Time record tab click
        Home_Page_calls.time_Record_Click();

        //show time exception toggle on
        Home_Page_calls.show_Time_Exception_Toggle_On();

        //clicking the configure column
        Home_Page_calls.configure_Column_Click();

        //clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking the total time check box
        Home_Page_calls.configure_Column_Exception_Type_Click();

        //clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //adding all the values in the list view and validating exception count
        Home_Page_calls.exception_Count_Check();

        String a = Home_Page_calls.exception_Count_Check();

        //home tab click
        Home_Page_calls.home_Click();

        // current month absent days count check
        Home_Page_calls.my_Statistics_Absent_Count_Check(a);

    }
    
    @Test(priority = 15)
    public void tc12_My_Statistics_To_check_if_the_arrows_work_when_more_than_3_exception_boxes_are_configured() throws AWTException, InterruptedException, IOException {

    	//My Statistics: To check if the arrows work when more than 3 exception boxes are configured.

    	//home tab click
        Home_Page_calls.home_Click();
        
        // Checking my statistics arrow are working check
        Home_Page_calls.my_Statistics_Navigation_Check();

    }

    @Test(priority = 16)
    public void tc13_My_Statistics_To_check_after_selecting_the_exceptions_the_Exception_dates_are_visible_under_its_section() throws AWTException, InterruptedException, IOException {

        //My Statistics: To check after selecting the exceptions the Exception dates are visible under its section

    	//home tab click
        Home_Page_calls.home_Click();
        
        //this method checks all widgets visible under my statistics
        Mss_Home_Page_calls.my_Statistics_All_Widget_Visible_Check();

    }
    
    @Test(priority = 17)
    public void tc14_To_validate_if_all_the_exception_dates_are_displayed_initially() throws Exception {
    	
    	// home tab click
        Home_Page_calls.home_Click();

        //Time record tab click
        Home_Page_calls.time_Record_Click();

        //clicking the configure column
        Home_Page_calls.configure_Column_Click();

        //clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking the dates in check box
        Home_Page_calls.configure_Column_Dates_Click();

        //clicking the exception types in check box
        Home_Page_calls.configure_Column_Exception_Types_Click();

        //clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //searching the absent records
        Home_Page_calls.search_Absent();

        //adding all the values in the list view and validating fot total time
        Mss_Home_Page_calls.absent_Dates_Extraction_In_Time_Records();

        ArrayList<String> a = Mss_Home_Page_calls.absent_Dates_Extraction_In_Time_Records();

        //home tab click
        Home_Page_calls.home_Click();

        //clicking right arrow in my statistics
        Home_Page_calls.my_Statistics_Right_Arrow_Click();

        // this method is used to click the absent icon
        Home_Page_calls.my_Statistics_Absent_Click();

        // break hours check for past month
        Home_Page_calls.absent_Dates_Check_In_Exception_Dates(a);

    }
    

    @Test(priority = 18)
    public void tc15_Exception_Dates_To_validate_if_Half_Day_Absent_Short_Hours_exception_mark_is_displayed() throws Exception {
    	//Exception Dates: To validate if Half Day, Absent, Short Hours exception mark is displayed next to Today button.(Selected date category it will show like week off or holiday or tick)
    	
    	// home tab click
        Home_Page_calls.home_Click();

        
    	Mss_Home_Page_calls.check_Exception_Symbol_Reflect_In_Calendar();

    }


/*
    @Test(priority = 8, dependsOnMethods = {
            "tc1_TimeZone_To_validate_if_an_employee_is_able_to_view_the_timezone_based_on_configuration"})
    public void tc15_Add_Allowance_To_validate_if_an_employee_can_add_the_allowance_with_IN_and_OUT_Time_manually_by_selecting_the_Allowance_from_the_dropdown_we_should_able_to_go_to_allowance_screen_and_make_changes()
            throws AWTException, InterruptedException, IOException {

        String day = "5";
        String month = "January";
        String year = "2023";
        String Start_time_hours = "9";
        String Start_time_minutes = "0";
        String End_Time_hours = "9";
        String End_Time_minutes = "30";
        String Kilometer_unit = "20";
        String Toaster = "Saved Successfully";

    

        // selecting date from the calendar
        Mss_Home_Page_calls.date_selection_in_calendar(day, month, year);

        // add allowance click in home page
        Mss_Add_Allowance_Page_calls.Add_allowance_click();

        // this method is used to add the allowance in allowance page
        Mss_Add_Allowance_Page_calls.selecting_allowance();

        // giving start time in hours and minutes in allowance
        Mss_Add_Allowance_Page_calls.Start_time(Start_time_hours, Start_time_minutes);

        // giving start time in hours and minutes in allowance
        Mss_Add_Allowance_Page_calls.End_time(End_Time_hours, End_Time_minutes);

        // giving kilometer
        Mss_Add_Allowance_Page_calls.Kilometer_Providing(Kilometer_unit);

        // clicking the submit button
        Mss_Add_Allowance_Page_calls.clicking_submit();

        // Toaster message check
        Mss_Add_Allowance_Page_calls.Assertion_Check(Toaster);

        // clicking close icon
        Mss_Add_Allowance_Page_calls.clicking_close();

    }

    @Test(priority = 9, dependsOnMethods = {
            "tc1_TimeZone_To_validate_if_an_employee_is_able_to_view_the_timezone_based_on_configuration"})
    public void tc16_Add_Allowance_To_validate_if_an_employee_can_add_the_allowance_for_a_specific_date_for_which_Allowances_are_already_populated_give_multiple_allowance_and_select_apply_manager_needs_to_approve()
            throws AWTException, InterruptedException, IOException {

        String day = "6";
        String month = "April";
        String year = "2023";
        String Start_time_hours = "9";
        String Start_time_minutes = "0";
        String End_Time_hours = "9";
        String End_Time_minutes = "30";
        String Kilometer_unit = "20";
        String Toaster = "Saved Successfully";

      

        // selecting date from the calendar
        Mss_Home_Page_calls.date_selection_in_calendar(day, month, year);

        // add allowance click in home page
        Mss_Add_Allowance_Page_calls.Add_allowance_click();

        // adding allowance button click
        Mss_Add_Allowance_Page_calls.Add_allowance_button_click();

        // selecting the allowance 2
        Mss_Add_Allowance_Page_calls.selecting_allowance_two();

        // selecting the travel allowance for 2nd time
        Mss_Add_Allowance_Page_calls.selecting_Travel_allowance_two();

        // giving start time in hours and minutes in allowance
        Mss_Add_Allowance_Page_calls.Start_time_2nd_time(Start_time_hours, Start_time_minutes);

        // giving start time in hours and minutes in allowance
        Mss_Add_Allowance_Page_calls.End_time_2nd_time(End_Time_hours, End_Time_minutes);

        // giving kilometer
        Mss_Add_Allowance_Page_calls.Kilometer_Providing(Kilometer_unit);

        // clicking the submit button
        Mss_Add_Allowance_Page_calls.clicking_submit();

        // Toaster message check
        Mss_Add_Allowance_Page_calls.Assertion_Check(Toaster);

        // clicking close icon
        Mss_Add_Allowance_Page_calls.clicking_close();

    }

*/
}
