package time_application.manual_key_in_and_out_ess;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import time_application.base.Browser_Launch;

public class Bank_Approval_From_Manager extends Browser_Launch {

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
    public void tc6_make_a_request_from_bank_and_approve_then_come_to_employee_then_validate_in_absence() throws AWTException, InterruptedException, IOException {


    	String Widget_Name = prop.getProperty("widget_Name");
        String heading = prop.getProperty("heading_Name");

        //this method is used to click the absence widget 
        Neosuite_Home_Page_calls.absence_Widget_Click();

        //this method is used to collect the leave balance before approval
        Neosuite_Home_Page_calls.total_Leave_Balance_Before();

        String value = Neosuite_Home_Page_calls.total_Leave_Balance_Before();

        //this method is used to click the home icon in absence page
        Neosuite_Home_Page_calls.home_Click_In_Absence();

        // bank module widget clicking
        Neosuite_Home_Page_calls.time_Widget_Click(Widget_Name , heading);

        // time zone check
        Home_Page_calls.time_Zone_Check();

        // time zone check
        bank_hours_Page_calls.bank_Hours_Click();

        //clicking the plus button to add the record
        bank_hours_Page_calls.clicking_Plus_Button();

        //clicking the plus button to add the record
        bank_hours_Page_calls.clicking_Up_Arrow_No_Of_Hours_To_Be_Banked_Minutes();

        //clicking the submit button
        bank_hours_Page_calls.clicking_Submit_Button();

        //home tab click
        Home_Page_calls.home_Click();

        // time zone check
        bank_hours_Page_calls.bank_Hours_Click();

        //clicking logout
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_And_Log_Out();

        //login for 2nd time
        Neosuite_Home_Page_calls.login_2nd_Time();

        // login to neosuite for ESS
        Mss_Neosuite_Login_calls.Time_Login();

        //changing the role to manager for time
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_Manager();

        // bank module widget clicking
        Neosuite_Home_Page_calls.time_Widget_Click(Widget_Name , heading);

        // time zone check
        bank_hours_Page_calls.bank_Hours_Click();

        //team requests click
        bank_hoursMss_Page_calls.team_Requests_Click();

        //clicking approve 
        bank_hoursMss_Page_calls.approve_Click();

        //Clicking yes for approve
        bank_hoursMss_Page_calls.approve_Click_Yes();

        //clicking logout
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_And_Log_Out();

        //login for 2nd time
        Neosuite_Home_Page_calls.login_2nd_Time();

        // login to neosuite for ESS
        Ess_Neosuite_Login_calls.eSS_Login();

        String Role = "Employee";
        // change role method
        Neosuite_Home_Page_calls.click_On_AppRole_Icon_Employee(Role); 

        //this method is used to click the absence widget 
        Neosuite_Home_Page_calls.absence_Widget_Click();

        //checking the leave balance is reflected
        Neosuite_Home_Page_calls.total_Leave_Balance_After(value);

    }

}