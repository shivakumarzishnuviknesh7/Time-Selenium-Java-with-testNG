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
import time_application.base.Excel_Utility;

public class Time_Records_Suite extends Browser_Launch {
	
    public Properties prop;

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

        // Time record tab click
        Home_Page_calls.time_Record_Click();

    }
    
    @Test(priority = 1)
    public void tc1_Search_Option_To_valdiate_if_an_employee_is_able_to_search_the_time_records() throws AWTException, InterruptedException, IOException {
        

        //User is able to login into Time and he shoud able to search records in the time records
        
        // search validation
        Time_Records_Page_calls.search_Validation();

    }

    @Test(priority = 2)
    public void tc3_Advance_Filter_To_validate_if_an_employee_can_view_the_time_records_for_previous_paycycle() throws AWTException, InterruptedException, IOException {

        //User is able to login into Time user should able to view records of previous pay cycle in time records
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM/yyyy");
	    LocalDateTime now2 = LocalDateTime.now();
	    String date_and_time2 = dtf.format(now2);
	    System.out.println(date_and_time2 );
	    
        String pay_period = date_and_time2;

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        // this method used to click the date
        Time_Records_Page_calls.configure_Column_Pay_Group_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        // search validation
        Time_Records_Page_calls.previous_Pay_Group_Validation();

    }

    @Test(priority = 3)
    public void tc4_Configure_Column_To_validate_if_an_employee_is_able_to_select_and_view_the_time_records_in_detail_as_per_column_selection()  throws AWTException, InterruptedException, IOException {
   	
    	//User is able to login into Time and select some column and click save it should show its name in column
    	
        // checking selected value is coming in configure column
        Time_Records_Page_calls.check_The_Selected_Column_Is_Coming_Or_Not_In_Configurecolumn();

    }

    @Test(priority = 4)
    public void tc6_Sort_To_validate_if_an_employee_is_able_to_sort_the_records_from_A_to_Z_or_Z_to_A_as_required()
            throws AWTException, InterruptedException, IOException {

        //User is able to login into Time and able to sort records in a to z or z to A

        String pay_period = prop.getProperty("tc_6_pay_Period");

        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        // this method used to click the display status
        Time_Records_Page_calls.configure_Column_Display_Status_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        // clicking down arrow
        Time_Records_Page_calls.configure_Column_Drop_Down_Click();

        // sort and check for ascending
        Time_Records_Page_calls.a_To_Z_Sort_Click();

        // sort and check in descending
        Time_Records_Page_calls.z_To_A_Sort_Click();
    }

    @Test(priority = 5)
    public void tc8_Verifying_Week_offs_To_validate_if_week_offs_are_displayed_in_the_Exception_type() throws Exception {
    	
    	Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		
    	String sheet = "Sheet1";
		String test_case_number = methodName;
		Excel_Utility datas = new Excel_Utility();
		ArrayList<String> data = datas.getData(test_case_number, sheet);
		String Date = (String) data.get(2);
		System.out.println(Date);

		

        String pay_period = prop.getProperty("tc_8_pay_Period");

        //Expected Output user should able ti see week off in exception in time records  under exception

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
/*
        // reseting the list view
        Time_Records_Page_calls.reset_Click();

        // clicking yes for reset
        Time_Records_Page_calls.reset_Click_Yes();
*/
        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        // this method used to click the exception type
        Home_Page_calls.configure_Column_Exception_Type_Click();

        //clicking the dates in check box
        Home_Page_calls.configure_Column_Dates_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        // week off validation
        Time_Records_Page_calls.week_Off_Validation(Date);
    }

    @Test(priority = 6)
    public void tc9_Verifying_Holidays_To_validate_if_holidays_are_displayed_in_the_Exception_type()
            throws AWTException, InterruptedException, IOException {
    	
    	Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		
    	String sheet = "Sheet1";
		String test_case_number = methodName;
		Excel_Utility datas = new Excel_Utility();
		ArrayList<String> data = datas.getData(test_case_number, sheet);
		String Date = (String) data.get(2);
		System.out.println(Date);


        //Expected Output user should able to see holiday in exception in time records under exception

        String pay_period = prop.getProperty("tc_9_pay_Period");

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
/*
        // reseting the list view
        Time_Records_Page_calls.reset_Click();

        // clicking yes for reset
        Time_Records_Page_calls.reset_Click_Yes();
*/
        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking the dates in check box
        Home_Page_calls.configure_Column_Dates_Click();

        // this method used to click the exception type
        Home_Page_calls.configure_Column_Exception_Type_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        // holiday validation
        Time_Records_Page_calls.holiday_Validation(Date);

    }

    @Test(priority = 7)
    public void tc10_Verifying_Absent_records_To_validate_if_Absent_is_being_displayed_under_exception_type()
            throws AWTException, InterruptedException, IOException {
    	
    	Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		
    	String sheet = "Sheet1";
		String test_case_number = methodName;
		Excel_Utility datas = new Excel_Utility();
		ArrayList<String> data = datas.getData(test_case_number, sheet);
		String Date = (String) data.get(2);
		System.out.println(Date);

        //Expected Output user should able to see absent in exception in time records under exception

        String pay_period = prop.getProperty("tc_10_pay_Period");

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
/*
        // reseting the list view
        Time_Records_Page_calls.reset_Click();

        // clicking yes for reset
        Time_Records_Page_calls.reset_Click_Yes();
*/
        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking the dates in check box
        Home_Page_calls.configure_Column_Dates_Click();

        // this method used to click the exception type
        Home_Page_calls.configure_Column_Exception_Type_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        // absent validation
        Time_Records_Page_calls.absent_Validation(Date);

    }


    @Test(priority = 8)
    public void tc11_Verifying_Leave_applied_records_To_validate_if_Leave_applied_is_visible_under_the_exception_type()
            throws AWTException, InterruptedException, IOException {
    	
    	Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		
    	String sheet = "Sheet1";
		String test_case_number = methodName;
		Excel_Utility datas = new Excel_Utility();
		ArrayList<String> data = datas.getData(test_case_number, sheet);
		String Date = (String) data.get(2);
		System.out.println(Date);

        //Expected Output user should able to see leave applied  in exception in time records under exception
    	
        String pay_period = prop.getProperty("tc_11_pay_Period");

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        // this method used to click the exception type
        Home_Page_calls.configure_Column_Exception_Type_Click();

        //clicking the dates in check box
        Home_Page_calls.configure_Column_Dates_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        // leave applied  validation
        Time_Records_Page_calls.leave_Applied_Validation(Date );

    }


    @Test(priority = 9)
    public void tc12_Verifying_the_Leave_type_column_To_validate_if_the_correct_leave_name_is_visbile_under_the_Leave_type() throws AWTException, InterruptedException, IOException {

    	Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		
    	String sheet = "Sheet1";
		String test_case_number = methodName;
		Excel_Utility datas = new Excel_Utility();
		ArrayList<String> data = datas.getData(test_case_number, sheet);
		String Date = (String) data.get(2);
		System.out.println(Date);
		
        //Expected Output user should able to see leave applied  in exception in time records under exception and check the leave type is showing or not
    	
        String pay_period = prop.getProperty("tc_12_pay_Period");

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
/*
        // reseting the list view
        Time_Records_Page_calls.reset_Click();

        // clicking yes for reset
        Time_Records_Page_calls.reset_Click_Yes();
*/
        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        // this method used to click the exception type
        Home_Page_calls.configure_Column_Exception_Type_Click();

        //clicking the dates in check box
        Home_Page_calls.configure_Column_Dates_Click();

        //leave type check box selecting
        Home_Page_calls.configure_Column_Leave_Type_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        // leave type  validation
        Time_Records_Page_calls.leave_Type_Validation(Date );

    }


    @Test(priority = 10)
    public void tc28_Status_Display_Status_To_validate_if_an_employee_is_able_to_see_the_overall_status_of_the_time_record() throws AWTException, InterruptedException, IOException {

        //user should able to see the status of the record

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        // this method used to click the display status
        Home_Page_calls.configure_Column_Display_Status_Click();

        //clicking the dates in check box
        Home_Page_calls.configure_Column_Dates_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        // display status  validation
        Time_Records_Page_calls.display_Status_Validation();

    }


    @Test(priority = 11)
    public void tc34_Overtime_for_working_day() throws AWTException, InterruptedException, IOException {

        Integer date = 28;
        String pay_period="Apr/2023";
        
        //user should able to see the overtime for working day

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();
        
        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking payment name
        Time_Records_Page_calls.configure_Column_Payment_Name_Click();

        //selecting processing from
        Time_Records_Page_calls.configure_Processing_From_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //checking working day  overtime
        Time_Records_Page_calls.working_Day_Overtime_Check(date);


    }

    @Test(priority = 12)
    public void tc35_Overtime_for_Week_off_day() throws AWTException, InterruptedException, IOException {

        Integer date = 26;
        String pay_period="Apr/2023";
        
        //user should able to see the overtime for week off day
        
        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();
        
        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking payment name
        Time_Records_Page_calls.configure_Column_Payment_Name_Click();

        //selecting processing from
        Time_Records_Page_calls.configure_Processing_From_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //checking weekoff overtime
        Time_Records_Page_calls.week_Off_Overtime_Check(date);


    }

    @Test(priority = 13)
    public void tc36_Overtime_for_Holiday() throws AWTException, InterruptedException, IOException {

    	Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		
    	String sheet = "Sheet1";
		String test_case_number = methodName;
		Excel_Utility datas = new Excel_Utility();
		ArrayList<String> data = datas.getData(test_case_number, sheet);
		String Date = (String) data.get(2);
		System.out.println(Date);
		
       // String date = prop.getProperty("Date");
        String pay_period = prop.getProperty("tc_36_pay_Period");
        
        //user should able to see the overtime for holiday

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();

        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking payment name
        Time_Records_Page_calls.configure_Column_Payment_Name_Click();

        //selecting processing from
        Time_Records_Page_calls.configure_Processing_From_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //checking weekoff overtime
        Time_Records_Page_calls.holiday_Day_Overtime_Check(Date);
    }

    @Test(priority = 14)
    public void tc13_Verifying_Processing_Start_and_End_Date() throws AWTException, InterruptedException, IOException {

        //user should able to see the proper processing start and end date

        // home tab click
        Home_Page_calls.home_Click();

        //current processing period value extract
        Time_Records_Page_calls.processing_Period_Check();

        String data[] = Time_Records_Page_calls.processing_Period_Check();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking processing start check box
        Time_Records_Page_calls.configure_Processing_Start_Date_Click();

        //selecting processing end check box
        Time_Records_Page_calls.configure_Processing_End_Date_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //checking the processing start and end date check
        Time_Records_Page_calls.processing_Start_And_End_Check(data);

    }

    @Test(priority = 15)
    public void tc14_Verifying_Paygroup() throws AWTException, InterruptedException, IOException {

        //user should able to see the proper pay group

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking processing start check box
        Time_Records_Page_calls.configure_Pay_Group_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //checking the pay group
        Time_Records_Page_calls.pay_Group_Check();

    }

    @Test(priority = 16)
    public void tc39_Automatic_Allowance_calculation() throws AWTException, InterruptedException, IOException {

    	Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		
    	String sheet = "Sheet1";
		String test_case_number = methodName;
		Excel_Utility datas = new Excel_Utility();
		ArrayList<String> data = datas.getData(test_case_number, sheet);
		String Date = (String) data.get(2);
		System.out.println(Date);

        String pay_period = prop.getProperty("tc_39_pay_Period");
        
        //user should able to see the Automatic allowance is getting populated

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();

        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking processing from
        Time_Records_Page_calls.configure_Processing_From_Click();

        //selecting payment name
        Time_Records_Page_calls.configure_Column_Payment_Name_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //Automatic allowance check
        Time_Records_Page_calls.automatic_Allowance_Check(Date);

    }


    @Test(priority = 17)
    public void tc40_Manual_Allowance_calculation() throws AWTException, InterruptedException, IOException {


    	Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		
    	String sheet = "Sheet1";
		String test_case_number = methodName;
		Excel_Utility datas = new Excel_Utility();
		ArrayList<String> data = datas.getData(test_case_number, sheet);
		String Date = (String) data.get(2);
		System.out.println(Date);
		
        String pay_period = prop.getProperty("tc_40_pay_Period");
        
        //user should able to see the proper pay group

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();

        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking processing from
        Time_Records_Page_calls.configure_Processing_From_Click();

        //selecting payment name
        Time_Records_Page_calls.configure_Column_Payment_Name_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //Manual allowance check
        Time_Records_Page_calls.manual_Allowance_Check(Date);
    }


    @Test(priority = 18)
    public void tc29_Show_Exception() throws AWTException, InterruptedException, IOException {


    	String pay_period = prop.getProperty("tc_40_pay_Period");
    	
        //user should able to see the exceptions

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //clicking show time exception toggle on
        Home_Page_calls.show_Time_Exception_Toggle_On();
        
        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking exception type
        Time_Records_Page_calls.configure_Exception_Type_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //exceptions checking
        Time_Records_Page_calls.exceptions_Check();

    }

    @Test(priority = 19)
    public void tc30_Show_Variance_Entry_Type_Over_Time() throws AWTException, InterruptedException, IOException {

        String pay_period = prop.getProperty("tc_30_pay_Period");

        //user should able to see overtime datas in show variance

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //clicking show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();

        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking Entry Type
        Time_Records_Page_calls.configure_Entry_Type_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //Overtime checking
        Time_Records_Page_calls.overtime_Check();

    }

    @Test(priority = 20)
    public void tc33_Show_Variance_Entry_Type_Allowance() throws AWTException, InterruptedException, IOException {

        String pay_period = prop.getProperty("tc_33_pay_Period");

        //user should able to see allowance datas in show variance

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //clicking show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();

        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking Entry Type
        Time_Records_Page_calls.configure_Entry_Type_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //Allowance checking
        Time_Records_Page_calls.allowance_Check();

    }

    @Test(priority = 21)
    public void tc31_Show_Variance_Entry_Type_short_Hours() throws AWTException, InterruptedException, IOException {

        String pay_period = prop.getProperty("tc_31_pay_Period");

        //user should able to see short hours datas in show variance
        
        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        //clicking show variance toggle on
        Home_Page_calls.show_Variance_Records_Toggle_On();

        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking Entry Type
        Time_Records_Page_calls.configure_Entry_Type_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //short Hours checking
        Time_Records_Page_calls.short_Hours_Check();

    }
        
    @Test(priority = 22)
    public void tc16_Editing_Time_Entry_at_detail_Level() throws AWTException, InterruptedException, IOException {

       // String pay_period = prop.getProperty("tc_31_pay_Period");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
	    LocalDateTime now = LocalDateTime.now().minusDays( 1 );
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
    
    @Test(priority = 23,dependsOnMethods = "tc16_Editing_Time_Entry_at_detail_Level")
    public void tc27_Edit_Status() throws AWTException, InterruptedException, IOException {

        //String pay_period = "Jun/2023";
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
	    LocalDateTime now = LocalDateTime.now().minusDays( 1 );
	    String date_and_time = dtf.format(now);
	    String values[]= date_and_time.split(" ");
	    
	    String day = values[0];
	    String month = values[1];
	    //String year = values[2];

        //user should able to see the edited entry status
	    
	    Time_Records_Page_calls.close();
        
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

        //clicking regularization status
        Time_Records_Page_calls.configure_Regularization_Status();

        //selecting the date
        Time_Records_Page_calls.configure_Column_Date_Click();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();
        
        //search and look for status
        Time_Records_Page_calls.edit_Check(day  , month);
    }

    

    @Test(priority = 24)
    public void tc24_Cancel_Edited_Entry_before_approval() throws AWTException, InterruptedException, IOException {

      //  String pay_period = prop.getProperty("tc_31_pay_Period");

        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
	    LocalDateTime now = LocalDateTime.now().minusDays( 1 );
	    String date_and_time = dtf.format(now);
	    String values[]= date_and_time.split(" ");
	    
	    String day = values[0];
	    String month = values[1];
	  //  String year = values[2];
	    
        //user should able to cancel edited time entry

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

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();

        //canceling the record
        Time_Records_Page_calls.search_Data_Click_Cancel(day  , month);

        //toaster message check
        Time_Records_Page_calls.toaster_Message_Check_Cancel_Regularization();

    }

        
    @Test(priority = 25)
    public void tc18_Bulk_Edit() throws AWTException, InterruptedException, IOException {

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
/*        
        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();
*/
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
    
    @Test(priority = 26)
    public void tc19_Bulk_Edit_reset() throws AWTException, InterruptedException, IOException {

    //	String pay_period = "Jun/2023";
    	 String Start_time_hours = "9";
         String Start_time_minutes = "0";
         String End_Time_hours = "19";
         String End_Time_minutes = "30";
        
        //user should able to edit time entry for multiple entries

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
/*        
        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();
*/
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
        
        //giving comment
        Time_Records_Page_calls.giving_Comment();
        
        //selecting record type
        Time_Records_Page_calls.bulk_Edit_Reset_Click_Check();

        //page close
        Time_Records_Page_calls.time_Bulk_Edit_Page_Close();

    }
    
    @Test(priority = 27)
	public void tc7_Filter_Specific_record() throws Exception {

    	//filtering specific data in list view
    	
		String pay_period = "May/2023";
		String filter_value="01-Apr-2023";

		// home tab click
		Home_Page_calls.home_Click();

		// Time record tab click
		Home_Page_calls.time_Record_Click();

		// clicking the filter icon
		Home_Page_calls.clicking_Filter_IN_Time_Records();

		// clicking pay period month
		Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

		// clicking pay period month selecting
		Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

		// clicking the filter close icon
		//Home_Page_calls.filter_Close();

		// clicking the configure column
		Home_Page_calls.configure_Column_Click();

		// clicking the select all check box
		Home_Page_calls.configure_Column_Select_All_Click();

		// Clicking the date in check box
		Time_Records_Page_calls.configure_Column_Date_Click();

		// clicking the save button to apply the changes
		Home_Page_calls.configure_Column_Save_Click();

		// clicking the filter arrow
		Time_Records_Page_calls.filter_Arrow_Click();

		// clicking the specific record in the filter
		Time_Records_Page_calls.filtering_Check(filter_value);
		
        // reseting the list view
        Time_Records_Page_calls.reset_Click();

        // clicking yes for reset
        Time_Records_Page_calls.reset_Click_Yes();

	}
    
    @Test(priority = 28)
    public void tc26_Initial_Time_Entry_Status() throws AWTException, InterruptedException, IOException {

        String pay_period = "Jun/2023";

        //user should able to see the time entry status

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();

        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();

        // clicking the configure column
        Home_Page_calls.configure_Column_Click();

        // clicking the select all check box
        Home_Page_calls.configure_Column_Select_All_Click();

        //clicking regularization status
        Time_Records_Page_calls.configure_Display_Status();

        // clicking the save button to apply the changes
        Home_Page_calls.configure_Column_Save_Click();
        
        //seeing all status
        Time_Records_Page_calls.total_Visibility_Check();

    }
    
        
    @Test(priority = 29)
    public void tc16_Editing_Time_Entry_at_detail_Level_reset() throws AWTException, InterruptedException, IOException {

    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
	    LocalDateTime now = LocalDateTime.now().minusDays( 1 );
	    String date_and_time = dtf.format(now);
	    String values[]= date_and_time.split(" ");
	    
	    String day = values[0];
	    String month = values[1];
//	    String year = values[2];
	    
 //       String pay_period = prop.getProperty("tc_31_pay_Period");
        
        String Start_time_hours = "09";
        String Start_time_minutes = "00";
        String End_Time_hours = "19";
        String End_Time_minutes = "00";

        //user should able to edit time entry in detail level

        // home tab click
        Home_Page_calls.home_Click();

        // Time record tab click
        Home_Page_calls.time_Record_Click();
/*
        // clicking the filter icon
        Home_Page_calls.clicking_Filter_IN_Time_Records();

        // clicking pay period month
        Home_Page_calls.clicking_Pay_Period_Month_IN_Time_Records();

        // clicking pay period month selecting
        Home_Page_calls.clicking_Pay_Period_Month_Selecting_IN_Time_Records(pay_period);

        // clicking the filter close icon
        //Home_Page_calls.filter_Close();
*/
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
   

}
