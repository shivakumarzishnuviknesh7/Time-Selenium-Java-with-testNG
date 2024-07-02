package time_application;

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

public class Data_Entry extends Browser_Launch {

    @BeforeClass
    public void browser_Intialize() throws InterruptedException, AWTException, IOException {

        prop = new Properties();
        FileInputStream Fip = new FileInputStream(
                System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                        + "java" + File.separator + "Resources" + File.separator + "Id_Password.properties");
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
        Neosuite_Home_Page_calls.time_Widget_Click(Widget_Name, heading);

        // time zone check
        Home_Page_calls.time_Zone_Check();

    }

    @Test(priority = 1)
    public void tc22_Keying_IN_and_OUT_Time() throws AWTException, InterruptedException, IOException {

        Thread.sleep(1000);
        for (int i = 1; i < 4; i++) {
            Thread.sleep(1000);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
            LocalDateTime now = LocalDateTime.now().minusDays(i);
            String date_and_time = dtf.format(now);
            String values[] = date_and_time.split(" ");

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

            // Expected Output user should able to give time entry

            // home tab click
            Home_Page_calls.home_Click();

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
        }
    }
}
