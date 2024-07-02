package time_application.manual_key_in_and_out_ess;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import time_application.base.Browser_Launch;


public class Home_Suite extends Browser_Launch {

    @BeforeClass
    public void browser_Intialize() throws InterruptedException, AWTException, IOException {

    	prop = new Properties();
        FileInputStream Fip = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Resources" + File.separator + "Id_Password.properties");
        prop.load(Fip);
        
        Time_Login();

        // login to neosuite for ESS
        Ess_Neosuite_Login_calls.eSS_Login();
        
        String Role = "Employee";
        // change role method
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_Employee(Role); 


    }

    @Test(priority = 1)
    public void tc1_Time_Zone() throws Exception {

        String Widget_Name = prop.getProperty("widget_Name");
        String heading = prop.getProperty("heading_Name");
        
        //TimeZone: To validate if an employee is able to view the time zone based on configuration.
        
        // bank module widget clicking
        Neosuite_Home_Page_calls.time_Widget_Click(Widget_Name , heading);

        // time zone check
        Home_Page_calls.time_Zone_Check();

    }

    @Test(priority = 4, dependsOnMethods = "tc1_Time_Zone")
    public void tc2_Calendar_Navigation() throws AWTException, InterruptedException, IOException {

    	//Calendar Navigation: To validate if an employee is able to navigate between dates using calendar navigation arrows.
       
        // checking the date is getting changed when we use navigation
        Home_Page_calls.clicking_Back_And_Front_Calendar_Navigation();

    }

    @Test(priority = 5, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc3_View_Current_Date() throws AWTException, InterruptedException, IOException {

    	//View Current Date: To validate if an employee can fall back to current date if past date is selected.
    	
        // today button click and check its comes to current date
        Home_Page_calls.today_Click_Validate();

    }

    @Test(priority = 17, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc4_employee_is_able_to_see_the_Total_Time_for_the_entire_pay_cycle_Total_hours() throws Exception {

        //Time Summary: To validate if an employee is able to see the Total Time for the entire pay cycle.(Total hours)
/*
        String day = prop.getProperty("tc4_day_home");
        String month = prop.getProperty("tc4_month_home");
        String year = prop.getProperty("tc4_year_home");
        String pay_period = prop.getProperty("tc4_pay_period_home");
*/
        //Time record tab click
        Home_Page_calls.time_Record_Click();
/*
        //clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        //clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        //clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        //clicking the filter close icon
        //Home_Page_calls.filter_Close();
*/
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
/*
        //selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);
*/
        // total hours check for Current month
        Home_Page_calls.time_Summary_Total_Hours_Check_Current_Month(a);

    }


    @Test(priority = 18, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc5_employee_is_able_to_see_the_Time_records_for_the_entire_pay_cycle_Work_hours() throws Exception {

        //Time Summary: To validate if an employee is able to see the Time records  for the entire pay cycle.(Work hours)
/*
    	String day = prop.getProperty("tc5_day_home");
        String month = prop.getProperty("tc5_month_home");
        String year = prop.getProperty("tc5_year_home");
        String pay_period = prop.getProperty("tc5_pay_period_home");
*/
        // today button click
        Home_Page_calls.today_Button_Click();

        //Time record tab click
        Home_Page_calls.time_Record_Click();
/*
        //clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        //clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        //clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        //clicking the filter close icon
        //Home_Page_calls.filter_Close();
*/
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
/*
        //selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);
*/
        // current month work hours check
        Home_Page_calls.time_Summary_Work_Hours_Check_Current_Month(a);
    }

    @Test(priority = 20, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc6_employee_is_able_to_see_the_Break_Hours_for_the_entire_pay_cycle_Break_hours() throws Exception {

       //Time Summary: To validate if an employee is able to see the Break Hours for the entire pay cycle.(Break hours)
/*
    	String day = prop.getProperty("tc6_day_home");
        String month = prop.getProperty("tc6_month_home");
        String year = prop.getProperty("tc6_year_home");
        String pay_period = prop.getProperty("tc6_pay_period_home");
   */     
        // today button click
        Home_Page_calls.today_Button_Click();

        //Time record tab click
        Home_Page_calls.time_Record_Click();
/*
        //clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        //clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        //clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        //clicking the filter close icon
        //Home_Page_calls.filter_Close();
*/
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
/*
        //selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);
*/
        // current month break hours check
        Home_Page_calls.time_Summary_Break_Hours_Check_Current_Month(a);
    }

    @Test(priority = 7, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc7_employee_is_able_to_see_the_bank_Hours_for_the_entire_pay_cycle_bank_hours() throws AWTException, InterruptedException, IOException {

        //Time Summary: To validate if an employee is able to see the bank Hours for the entire pay cycle.(bank hours)
/*
    	String day = prop.getProperty("tc7_day_home");
        String month = prop.getProperty("tc7_month_home");
        String year = prop.getProperty("tc7_year_home");
        String pay_period = prop.getProperty("tc7_pay_period_home");
   */     
        // time zone check
        bank_hours_Page_calls.bank_Hours_Click();

        //searching status as approved
        bank_hours_Page_calls.search_Approved_Values();
/*
        //clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        //clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        //clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        //clicking the filter close icon
        bank_hours_Page_calls.filter_Close();
*/
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

        //selecting date from the calendar
        //Home_Page_calls.date_Selection_In_Calendar(day, month, year);

        //clicking right arrow in time summary
        Home_Page_calls.time_Summary_Right_Arrow_Click();

        // current month bank hours check
        Home_Page_calls.time_Summary_Bank_Hours_Check_Current_Month(a);


    }

    @Test(priority = 8, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc8_employee_is_able_to_see_the_Over_Time_for_the_entire_pay_cycle_Over_time() throws Exception {

        //Time Summary: To validate if an employee is able to see the OverTime  for the entire pay cycle.(Over time)
/*
    	String day = prop.getProperty("tc8_day_home");
        String month = prop.getProperty("tc8_month_home");
        String year = prop.getProperty("tc8_year_home");
        String pay_period = prop.getProperty("tc8_pay_period_home");
  */     
        // today button click
        Home_Page_calls.today_Button_Click();

        //Time record tab click
        Home_Page_calls.time_Record_Click();
/*
        //clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        //clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        //clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        //clicking the filter close icon
        //Home_Page_calls.filter_Close();
*/
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
/*
        //selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);
*/
        //clicking right arrow
        Home_Page_calls.time_Summary_Right_Arrow_Click();

        // current month over time hours check
        Home_Page_calls.time_Summary_Over_Time_Hours_Check_Current_Month(a);

    }
/*
    @Test(priority = 9, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc9_employee_is_able_to_see_the_Special_Hours_for_the_entire_pay_cycle_Special_hours() throws AWTException, InterruptedException, IOException {

        // String Widget_Name = (String) data.get(1);


        // today button click
        Home_Page_calls.today_Button_Click();

        //clicking right arrow
        Home_Page_calls.Time_Summary_right_arrow_click();

        // current month special hours check
        Home_Page_calls.Time_Summary_special_Hours_Check_current_Month();

        // this method is used to select the past pay cycle month
        Home_Page_calls.past_Month_Selection();

        //clicking right arrow
        Home_Page_calls.Time_Summary_right_arrow_click();

        // special hours check for past month
        Home_Page_calls.Time_Summary_special_Hours_Check_Past_Month();

    }
*/
    @Test(priority = 10, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc10_current_processing_period_is_visible_in_time_Summary_paycycle_start_and_end_date() throws  InterruptedException, IOException {
       
    	//Time Summary: To validate if current processing period is visible in time Summary.(paycycle tstart and end date)

    	//home tab click
        Home_Page_calls.home_Click();
        
        // today button click
        Home_Page_calls.today_Button_Click();

        //clicking right arrow
        Home_Page_calls.current_Processing_Period_Check();

    }

    @Test(priority = 11, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc11_Time_Summary_To_check_if_arrows_work_when_more_then_3_dials_are_configured() throws AWTException, InterruptedException, IOException {

        //Time Summary: To check if arrows work when more then 3 dials are configured.

        // today button click
        Home_Page_calls.today_Button_Click();

        //clicking right arrow
        Home_Page_calls.time_Summary_Navigation_Check();

    }


    @Test(priority = 12, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc12_Overtime_Bifurcation() throws AWTException, InterruptedException, IOException {

       //Overtime Bifurcation: To validate if employee is able to view the bifurcation of overtime.(Hover mouse in I icon it shows details)

        //mouse hove check in over time
        Home_Page_calls.mouse_Hover_In_Overtime_Check();


    }

    @Test(priority = 13, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc13_My_Statistics_To_validate_if_Short_hours_Absent_Half_Day_count_are_displayed_for_the_paycycle() throws Exception {

        //My Statistics: To validate if Short hours, Absent, Half Day count are displayed for the paycycle.(check with exception and compare the count and validate)
    	
    	String day = prop.getProperty("tc13_day_home");
        String month = prop.getProperty("tc13_month_home");
        String year = prop.getProperty("tc13_year_home");
        String pay_period = prop.getProperty("tc13_pay_period_home");

        // Checking my statistics icon visible or not
        //Home_Page_calls.my_Statistics_All_Widget_Visible_Check();

        //Time record tab click
        Home_Page_calls.time_Record_Click();

        //show time exception toggle on
        Home_Page_calls.show_Time_Exception_Toggle_On();

        //clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        //clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        //clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        //clicking the filter close icon
        //Home_Page_calls.filter_Close();

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

        //selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);

        // current month absent days count check
        Home_Page_calls.my_Statistics_Absent_Count_Check(a);

    }

    @Test(priority = 14, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc14_My_Statistics_To_check_if_the_arrows_work_when_more_than_3_exception_boxes_are_configured() throws AWTException, InterruptedException, IOException {

    	//My Statistics: To check if the arrows work when more than 3 exception boxes are configured.

        // Checking my statistics arrow are working check
        Home_Page_calls.my_Statistics_Navigation_Check();

    }

    @Test(priority = 15, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc15_My_Statistics_To_check_after_selecting_the_exceptions_the_Exception_dates_are_visible_under_its_section() throws AWTException, InterruptedException, IOException {

        //My Statistics: To check after selecting the exceptions the Exception dates are visible under its section

        //this method checks all widgets visible under my statistics
        Home_Page_calls.my_Statistics_All_Widget_Visible_Check();

    }


    @Test(priority = 16, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc16_To_validate_if_all_the_exception_dates_are_displayed_initially() throws Exception {
    	
    	
    	String day = prop.getProperty("tc16_day_home");
        String month = prop.getProperty("tc16_month_home");
        String year = prop.getProperty("tc16_year_home");
        String pay_period = prop.getProperty("tc16_pay_period_home");

        //Time record tab click
        Home_Page_calls.time_Record_Click();

        //clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        //clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        //clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        //clicking the filter close icon
        //Home_Page_calls.filter_Close();

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
        Home_Page_calls.absent_Dates_Extraction_In_Time_Records();

        ArrayList<String> a = Home_Page_calls.absent_Dates_Extraction_In_Time_Records();

        //home tab click
        Home_Page_calls.home_Click();

        //selecting date from the calendar
        Home_Page_calls.date_Selection_In_Calendar(day, month, year);

        //clicking right arrow in my statistics
        Home_Page_calls.my_Statistics_Right_Arrow_Click();

        // this method is used to click the absent icon
        Home_Page_calls.my_Statistics_Absent_Click();

        // break hours check for past month
        Home_Page_calls.absent_Dates_Check_In_Exception_Dates(a);
/*
        //clicking left arrow in my statistics
        Home_Page_calls.my_Statistics_Left_Arrow_Click();

        // exception date not data check 
        Home_Page_calls.my_Statistics_Late_In_Check();

*/
    }
    

    @Test(priority = 2, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc17_Exception_Dates_To_validate_if_Half_Day_Absent_Short_Hours_exception_mark_is_displayed() throws Exception {
    	//Exception Dates: To validate if Half Day, Absent, Short Hours exception mark is displayed next to Today button.(Selected date category it will show like week off or holiday or tick)

        //this method checks the selected exception shows its symbol next to today for no exception
        //Home_Page_calls.exception_Symbol_Check_No_Exception();

        Home_Page_calls.check_Exception_Symbol_Reflect_In_Calendar();

/*
        //short hours symbol check for exception
        Home_Page_calls.exception_Symbol_Check_Short_Hours();

        //clicking the right arrow in my statistics
        Home_Page_calls.my_Statistics_Right_Arrow_Click();

        //absent hours symbol check for exception
        Home_Page_calls.exception_Symbol_Absent();
*/


    }

    @Test(priority = 3, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc18_Half_Day_Absent_Short_Hours_exception_is_selected_then_that_specific_record_is_displayed_on_the_dashboard_to_make_the_changes_Select_the_date() throws AWTException, InterruptedException, IOException {


        //Exception Dates: To validate if Half Day, Absent, Short Hours exception is selected then that specific record is displayed on the dashboard to make the changes(Select the date and check all details is showing in the center dashboard)

        Home_Page_calls.check_Exception_Date_Reflect_In_Calendar();

/*
        //short hours symbol check for exception
        Home_Page_calls.exception_Symbol_Check_Short_Hours();

        //short hours date check in dash board
        Home_Page_calls.my_Statistics_Short_Hours_Dates_Check_With_Dash_Board();
*/
    }


    @Test(priority = 19, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc19_Hover_on_I_icon_it_shows_details() throws AWTException, InterruptedException, IOException {

       //Shift Details: To validate if employee can view the assigned shift.(Hover on I icon it shows details)

        //shift hour check
        Home_Page_calls.shift_Hour_Check();

    }


    @Test(priority = 6, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc20_Shift_Details() throws AWTException, InterruptedException, IOException {


        //Shift Details: To validate if employee is able to select the shift while Keying IN and OUT the time entry.(Shift changing can be done by employee while time entering)

    	//check the shift
        //Today Button Click
        Home_Page_calls.today_Button_Click();

        //shift drop down click
        Home_Page_calls.shift_Drop_Down_Click();

        //flexi shift click
        Home_Page_calls.flexi_Shift_Selection();

        //shift selection checking
        Home_Page_calls.shift_Selection_Check();

    }

    @Test(priority = 21, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc21_Shift_Details_on_Bar_Chart() throws AWTException, InterruptedException, IOException {


       //Shift Details on Bar Chart: To validate if an employee is able to view the details on bar chart as per the color legend displayed(Check the time details which is in colored is displayed as per selection)

        //past month some date going
        Home_Page_calls.past_Month_Selection();//change to dynamic

        //getting the color of work hours and check
        Home_Page_calls.getting_Work_Hours_Check();

    }

    @Test(priority = 22, dependsOnMethods = {"tc1_Time_Zone"})
    public void tc32_apply_Leave() throws AWTException, InterruptedException, IOException {

        // checking the apply leave window viewing
        Home_Page_calls.apply_Leave();

    }


}
