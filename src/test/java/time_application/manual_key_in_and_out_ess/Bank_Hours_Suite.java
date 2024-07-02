package time_application.manual_key_in_and_out_ess;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import time_application.base.Browser_Launch;


public class Bank_Hours_Suite extends Browser_Launch {

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
    public void tc1_Bank_Hours_To_validate_if_an_employee_is_able_to_view_the_OT_hours_in_Bank_Hours_Approved_OT_hours_box_shoud_be_visible()
            throws AWTException, InterruptedException, IOException {


    	String Widget_Name = prop.getProperty("widget_Name");
        String heading = prop.getProperty("heading_Name");

      
        // bank module widget clicking
        Neosuite_Home_Page_calls.time_Widget_Click(Widget_Name , heading);

        // time zone check
        Home_Page_calls.time_Zone_Check();

        // time zone check
        bank_hours_Page_calls.bank_Hours_Click();

        //approved ot box visibility check
        bank_hours_Page_calls.approved_OT_Visibility_Check();

    }

    @Test(priority = 2, dependsOnMethods = {"tc1_Bank_Hours_To_validate_if_an_employee_is_able_to_view_the_OT_hours_in_Bank_Hours_Approved_OT_hours_box_shoud_be_visible"})
    public void tc2_Bank_Hours_To_validate_if_an_employee_is_able_to_submit_the_OT_hours_to_Bank_Hours_Giving_OT_by_clicking_the_plus_button_and_add_() throws AWTException, InterruptedException, IOException {


       

        //getting ot hours before action
        bank_hours_Page_calls.getting_OT_Value_Before_Using();

 //       String a = bank_hours_Page_calls.getting_OT_Value_Before_Using();

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

        //configure column click in bank hours
        bank_hours_Page_calls.configure_Column_Click_In_Bank_Hours();

        //configure Reset click in bank hours
        bank_hours_Page_calls.configure_Column_Reset_Click();

        //checking the table for the status
        bank_hours_Page_calls.checking_That_Bank_Hours_Waiting_To_Approve();

    }
    
    
    @Test(priority = 3, dependsOnMethods = {"tc2_Bank_Hours_To_validate_if_an_employee_is_able_to_submit_the_OT_hours_to_Bank_Hours_Giving_OT_by_clicking_the_plus_button_and_add_"})
    public void tc3_Bank_Hours_To_validate_if_the_OT_hours_submitted_to_be_banked_are_deducted_from_the_actul_OT_hours_Checking_the_balance_OT_hours_after_applying() throws AWTException, InterruptedException, IOException {
    
        //getting ot hours before action
        bank_hours_Page_calls.getting_OT_Value_Before_Using();

        String a = bank_hours_Page_calls.getting_OT_Value_Before_Using();

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

        //configure column click in bank hours
        bank_hours_Page_calls.configure_Column_Click_In_Bank_Hours();

        //configure Reset click in bank hours
        bank_hours_Page_calls.configure_Column_Reset_Click();

        //checking the table for the status
        bank_hours_Page_calls.checking_That_Bank_Hours_Waiting_To_Approve();

        //checking the bank hours getting changes in total
        bank_hours_Page_calls.getting_OT_Value_After_Using(a);

    }

    

    @Test(priority = 4, dependsOnMethods = {"tc3_Bank_Hours_To_validate_if_the_OT_hours_submitted_to_be_banked_are_deducted_from_the_actul_OT_hours_Checking_the_balance_OT_hours_after_applying"})
    public void tc4_Bank_hours_To_validate_of_submitted_bank_hours_can_be_cancelled_before_approval_and() throws AWTException, InterruptedException, IOException {


        String toaster_message = "Bank Hour Request Cancelled Successfully";

        //getting ot hours before action
        bank_hours_Page_calls.getting_OT_Value_Before_Using();

//        String a = bank_hours_Page_calls.getting_OT_Value_Before_Using();

        //clicking cancel button
        bank_hours_Page_calls.clicking_Cancel_In_Action();

        //Toaster message check
        bank_hours_Page_calls.assertion_Check(toaster_message);

    }
    
    
    @Test(priority = 5)
    public void tc5_Bank_Hours_To_validate_if_cancelled_bank_hours_are_added_in_the_OT_hours() throws AWTException, InterruptedException, IOException {

    	 String toaster_message = "Bank Hour Request Cancelled Successfully";
        //String toaster_message = "Bank Hour Request Cancelled Successfully";

        //getting ot hours before action
        bank_hours_Page_calls.getting_OT_Value_Before_Using();

        String a = bank_hours_Page_calls.getting_OT_Value_Before_Using();

        //clicking cancel button
        bank_hours_Page_calls.clicking_Cancel_In_Action();

        //Toaster message check
        bank_hours_Page_calls.assertion_Check(toaster_message);

        //home tab click
        Home_Page_calls.home_Click();

        // time zone check
        bank_hours_Page_calls.bank_Hours_Click();

        //checking the bank hours getting changes in total
        bank_hours_Page_calls.getting_OT_Value_After_Using(a);

    }



}
