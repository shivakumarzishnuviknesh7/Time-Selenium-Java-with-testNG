package time_application.pages.manual_key_in_and_out_ess_pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Bank_Hours_Page {

	public WebDriver driver;
    public Properties prop;
    public WebDriverWait wait;
    public Actions action;
    public JavascriptExecutor javascriptexecutor;

    public Bank_Hours_Page  (WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
    	this.driver = driver;
        this.prop = prop;
        this.wait = wait;
        this.action = action;
        this.javascriptexecutor = javascriptexecutor;
    }

    public void loader_Wait() {

        /*
         * This method is used to make wait until the loader image gets disappear
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        List<WebElement> heading_check = driver.findElements(By.xpath("//div//img[contains(@src,'gif')]"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
    }

    public void bank_Hours_Click() throws InterruptedException {

        /*
         * This method is used to click the bank hours widget
         */
    	By Bank_Hours_Click = By.xpath("(//div[@id=\"tlmenuComponent\"]//div//div//img[contains(@title,'Bank Hours')][not(@hidden)])[1]");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Bank_Hours_Click)));
        driver.findElement(Bank_Hours_Click).click();

        loader_Wait();
    }

    public void approved_OT_Visibility_Check() {

        /*
         * This method is used to check approved ot box visibility
         */
    	By Approved_oT_visibility_check = By.xpath("//div[normalize-space()='Approved OT Hours']");
    	
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Approved_oT_visibility_check)));
        //checking Approved ot box is there or not 
        Assert.assertEquals(driver.findElement(Approved_oT_visibility_check).getText(), "Approved OT Hours", "Test failed - approved ot box is not visible");
    }

    public void clicking_Plus_Button() {

        /*
         * This method is used to click plus button in OT tab in bank hours page
         */
    	By clicking_plus_button = By.xpath("//i[@title='Apply Bank Hours']");
    	
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_plus_button)));
        driver.findElement(clicking_plus_button).click();
    }


    public void clicking_Up_Arrow_No_Of_Hours_To_Be_Banked_Minutes() {

        /*
         * This method is used to click up arrow in minutes for one time in banking hours page
         */
    	By clicking_up_arrow_no_of_hours_to_be_banked_minutes = By.xpath("(//i[normalize-space()='expand_less'])[2]");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_up_arrow_no_of_hours_to_be_banked_minutes)));
        driver.findElement(clicking_up_arrow_no_of_hours_to_be_banked_minutes).click();
    }

    public void clicking_Submit_Button() throws InterruptedException {

        /*
         * This method is used to click the submit button in banking hours page
         */
    	By clicking_submit_button = By.xpath("//button[@type='Submit']");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_submit_button)));
        driver.findElement(clicking_submit_button).click();
        Thread.sleep(2000);
    }

    public void checking_That_Bank_Hours_Waiting_To_Approve() {

        /*
         * This method is used to check the table for the status should be pending for approval
         */

        List<WebElement> table_size = driver.findElements(By.xpath("//table[@id=\"ss\"]//tbody//tr[contains(@class,\"sub-container table-row-not-expanded table_trCss tablecss\")]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(table_size));
        Integer final_an = table_size.size() - 1;

        WebElement clicking_submit_button = driver.findElement(By.xpath("(//table[@id=\"ss\"]//tbody//tr[contains(@class,'sub-container table-row-not-expanded table_trCss tablecss" + final_an + "')]//td//span[normalize-space()='Pending for Approval'])[3]"));
        wait.until(ExpectedConditions.visibilityOf(clicking_submit_button));
        clicking_submit_button.getText();

        //checking the status
        Assert.assertEquals(clicking_submit_button.getText(), "Pending for Approval", "Test failed - status is not showing properly");

    }

    public String getting_OT_Value_Before_Using() {

        /*
         * This method is used to get ot hours before action performing
         */
    	By getting_oT_value_before_using = By.xpath("//div[@id='time_bankHrchart']//span");
    	
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(getting_oT_value_before_using)));
        String value = driver.findElement(getting_oT_value_before_using).getText();
        return value;
    }

    public void getting_OT_Value_After_Using(String OT_hours) {

        /*
         * This method is used to get ot hours after action performing
         */
    	By getting_oT_value_after_using = By.xpath("//div[@id='time_bankHrchart']//span");
    	
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(getting_oT_value_after_using)));
        String value = driver.findElement(getting_oT_value_after_using).getText();
        //ot hours check gets changed
        Assert.assertNotEquals(value, OT_hours,"Test failed - value not changed");
    }

    public void clicking_Cancel_In_Action() {

        /*
         * This method is used to click the cancel button in actions in bank hours page
         */

        List<WebElement> table_size = driver.findElements(By.xpath("//table[@id='ss']//tbody//tr[contains(@class,\"sub-container table-row-not-expanded table_trCss tablecss\")]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(table_size));
        Integer final_an = table_size.size() - 1;

        try {
        WebElement clicking_submit_button = driver.findElement(By.xpath("//table[@id='ss']//tbody//tr[contains(@class,'sub-container table-row-not-expanded table_trCss tablecss" + final_an + "')]//td//span[normalize-space()='Pending for Approval']//parent::td//parent::tr//button[@title='Cancel']"));
        wait.until(ExpectedConditions.visibilityOf(clicking_submit_button));
        clicking_submit_button.click();
        } catch (NoSuchElementException e) {
			Assert.assertTrue(false,"Test failed - cancel button is missing ");
		}

    }

    public void assertion_Check(String message) throws InterruptedException {

    	

    		/*
    		 * This method is used to check the toaster message
    		 */

    		try {
    			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
    			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
    			String toaster_message_expected = message;
    			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
    			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,
    					"Test failed toaster message not came properly");

    			loader_Wait_Toaster();
    		} catch (NoSuchElementException e) {
    			Assert.assertTrue(false, "Test failed because toaster message didn't come");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	
    	
//        Thread.sleep(1000);

        /*
         * This method is used to check that toaster message is coming or not and it
         * will validate whether correct message is coming or not
         */
/*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        ArrayList<String> messages_Actual = new ArrayList<String>();
        ArrayList<String> messages_Expected = new ArrayList<String>();

        wait.until(ExpectedConditions.visibilityOfAllElements(
                driver.findElements(By.xpath("//div[@id='toast-container']//span[@class='black-text left']"))));
        List<WebElement> toaster_message_save_record = driver
                .findElements(By.xpath("//div[@id='toast-container']//span[@class='black-text left']"));
        System.out.println("actual size " + toaster_message_save_record.size());
        String toaster_message = "";
        for (int i = 0; i < toaster_message_save_record.size(); i++) {
            String temp_message = toaster_message_save_record.get(i).getText();
            String temp = toaster_message_save_record.get(i).findElement(By.xpath("i")).getText();
            temp_message = temp_message.replaceAll(temp, "");
            temp_message = temp_message.trim();
            if (i == 0) {
                toaster_message = temp_message;
                messages_Actual.add(temp_message);
            } else {
                toaster_message = toaster_message + "\n" + temp_message;
                messages_Actual.add(temp_message);
            }
        }

        String[] expectedmessges = message.split("\n");

        System.out.println("message from the excel is   \n" + expectedmessges);

        for (String text : expectedmessges) {
            System.out.println("message from the excel is   \n" + text);
            messages_Expected.add(text);
        }

        Collections.sort(messages_Actual);
        Collections.sort(messages_Expected);
        for (int i = 0; i < messages_Actual.size(); i++) {
            System.out.println("message from the Actual is   \n" + messages_Actual.get(i));

        }

        for (int i = 0; i < messages_Expected.size(); i++) {
            System.out.println("message from the expected is   \n" + messages_Expected.get(i));

        }
        
        //toaster message check
        Assert.assertEquals(messages_Actual.contains(messages_Expected), true," Test case failed - the toaster message is visible and expected and actual text is not same Actual:- "+ toaster_message + "Expected:- " + message);
*/
    }

   
    public void search_Approved_Values() {

        /*
         * This method is used to click search text area and type approved and search
         */
    	By search_Approved_values = By.xpath("//input[@name=\"universalListSearch\" and @id=\"taBankHoursMyRecordsView+universalListSearchId\"]");
        By search_click = By.xpath("(//a[@class='searchField downloadCircle']//img[@title='Search'])[1]");

        try {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_Approved_values)));
        driver.findElement(search_Approved_values).click();
        driver.findElement(search_Approved_values).sendKeys("Approved");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_click)));
        driver.findElement(search_click).click();

        }
        catch (Exception e) {
			Assert.assertTrue(false, "Test failed because of no data");
		}
    }

    public void configure_Column_Select_All_Click() throws InterruptedException {

        /*
         * This method is used to click configure column select all
         */
    	By configure_column_select_all_click = By.xpath("(//label[@class='listview_marLeft']//span//p[normalize-space()='Select All'])[1]");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_select_all_click)));
        Thread.sleep(1500);
        driver.findElement(configure_column_select_all_click).click();
        Thread.sleep(1500);
        driver.findElement(configure_column_select_all_click).click();
    }

    public void configure_Column_Bank_Hours_Click() {

        /*
         * This method is used to click the banked hours in configure column in bank hours page
         */
    	By configure_column_status_click = By.xpath("//div[@class='configColumnScrollBar']//span[@title='Banked Hours']");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_status_click)));
        driver.findElement(configure_column_status_click).click();
    }



    public void filter_Close() {

        /*
         * This method is used to click the filter close in bank hours page
         */
    	By filter_close = By.xpath("(//img[@class='listview_filterClose' and @title='Close'])[1]");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(filter_close)));
        driver.findElement(filter_close).click();
    }

    public void configure_Column_Click() throws InterruptedException {

        /*
         * This method is used to click the configure column icon in bank hours page
         */
    	By configure_column_click = By.xpath("//div[@id='taBankHoursMyRecordsView+universalListViewPageId']//div[@id='taBankHoursMyRecordsViewConfigColumn']//img[@title='Configure column']");

    	Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_click)));
        Thread.sleep(1000);
        driver.findElement(configure_column_click).click();
        
    }

    public void configure_Column_Save_Click() {

        /*
         * This method is used to click the save button in configure column in bank hours page
         */
    	By configure_column_save_click = By.xpath("//div[@id='taBankHoursMyRecordsView+universalListViewPageId']//div[@id='taBankHoursMyRecordsViewConfigColumn']//img[@title='Configure column']//parent::div//parent::div//div[@class='saveBox']");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_save_click)));
        action.click(driver.findElement(configure_column_save_click)).build().perform();
        loader_Wait_Toaster();
    }

    public void configure_Column_Click_In_Bank_Hours() throws InterruptedException {

        /*
         * This method is used to click the configure column icon in the bank hours page
         */
    	By configure_column_click_in_Bank_hours = By.xpath("//div[@id=\"taBankHoursMyRecordsView+universalListViewPageId\"]//img[@title=\"Configure column\"]");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_click_in_Bank_hours)));
        Thread.sleep(1000);
        action.click(driver.findElement(configure_column_click_in_Bank_hours)).build().perform();
    }

    public void configure_Column_Reset_Click() throws InterruptedException {

        /*
         * This method is used to click the reset icon in configure column in the bank hours page
         */

        By configure_column_reset_click = By.xpath("(//ul[@class=\"universalConfigColumnClass dropdown-content listview_tipView\"]//div[@class=\"resetBox\"]//span)[1]");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_reset_click)));
        Thread.sleep(1000);
        action.click(driver.findElement(configure_column_reset_click)).build().perform();
        loader_Wait_Toaster();
    }

    public void loader_Wait_Toaster() {

        /*
         * This method is used to make wait until the toaster image gets disappear
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        List<WebElement> loader_wait_Toaster = driver.findElements(By.xpath("//div[@id='toast-container']"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader_wait_Toaster));
    }

    public String total_Time_Add() {

        /*
         * This method is used to all the all time of respective hours and it return
         * back in hours and minutes
         */

        ArrayList<String> total_time_hours = new ArrayList<String>();

        ArrayList<String> total_time_minutes = new ArrayList<String>();

        List<WebElement> total_time_add = driver.findElements(By.xpath("//tbody//tr//td[@id=\"taBankHoursMyRecordsViewscrollId\"]//span//span//span"));

        int Sum = 0;
        int Sums = 0;

        for (int i = 0; i < total_time_add.size(); i++) {
            String temp_message = total_time_add.get(i).getText();
            String[] time = temp_message.split(":");

            total_time_hours.add(time[0]);
            int a = Integer.parseInt(total_time_hours.get(i));
            Sum = Sum + a;

            System.out.println(a);
            total_time_minutes.add(time[1]);
            int b = Integer.parseInt(total_time_minutes.get(i));
            Sums = Sums + b;

        }
        System.out.println("hours  - " + total_time_hours);
        System.out.println("hours total" + Sum);
        System.out.println("minutes  - " + total_time_minutes);
        System.out.println("minutes total" + Sums);

        int hours = Sum;
        int minutes = Sums;
        int value = 0;
        int minutes_update = 0;

        if (minutes >= 60) {
            value = minutes % 60;
            if (value > 1) {
                minutes_update = value;
            }
        } else {
            minutes_update = minutes;
        }

        int hour_in = 60;

        if ((minutes / hour_in) >= 1) {

            hours += minutes / hour_in;
        }
        System.out.println("Minutes total " + minutes_update);
        System.out.println("Hours total " + hours);

        String final_ans = "" + hours + ":" + minutes_update + "";

        System.out.println("final hours is " + final_ans);

        return final_ans;
    }


}
