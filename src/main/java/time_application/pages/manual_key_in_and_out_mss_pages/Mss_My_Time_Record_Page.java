package time_application.pages.manual_key_in_and_out_mss_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Mss_My_Time_Record_Page {

    public WebDriver driver;
    public Properties prop;
    public WebDriverWait wait;
    public Actions action;
    public JavascriptExecutor javascriptexecutor;

    public Mss_My_Time_Record_Page(WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
        this.driver = driver;
        this.prop = prop;
        this.wait = wait;
        this.action = action;
        this.javascriptexecutor = javascriptexecutor;
    }

    public void clicking_Filter_IN_Time_records() {

        /*
         * This method is used to click the filter icon in the time record page
         */

        WebElement clicking_Filter_IN_Time_records = driver.findElement(By.xpath("//span[@title=\"Filter\"]"));
        wait.until(ExpectedConditions.visibilityOf(clicking_Filter_IN_Time_records));
        clicking_Filter_IN_Time_records.click();
    }
    
    public void configure_Exception_Type_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column Exception type icon in the
		 * time
		 */
		By configure_exception_type_click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Exception Type']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_exception_type_click)));
		Thread.sleep(1000);
		driver.findElement(configure_exception_type_click).click();

	}
    
   


    public void clicking_pay_period_month_IN_Time_records() {

        /*
         * This method is used to click the pay period month in the time record page
         */


        WebElement clicking_pay_period_month_IN_Time_records = driver.findElement(By.xpath("//div[@class=\"col payperiodWrap s12\"]//input[@class=\"select-dropdown dropdown-trigger\"]"));
        wait.until(ExpectedConditions.visibilityOf(clicking_pay_period_month_IN_Time_records));
        clicking_pay_period_month_IN_Time_records.click();
    }

    public void My() {

        /*
         * This method is used to click the pay period month in the time record page
         */


        WebElement clicking_pay_period_month_IN_Time_records = driver.findElement(By.xpath("//div[@class=\"col payperiodWrap s12\"]//input[@class=\"select-dropdown dropdown-trigger\"]"));
        wait.until(ExpectedConditions.visibilityOf(clicking_pay_period_month_IN_Time_records));
        clicking_pay_period_month_IN_Time_records.click();
    }
    
    public void entry_Check_Late_In(String Day, String Month) {

		/*
		 * This method is used to check the entry
		 */
		By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");
		By status_Check = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[contains(@id,\"taEmployeeSummaryViewUnique\")]//span[normalize-space()='Late In']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(status_Check)));
		String status = driver.findElement(status_Check).getText();

		//checking status
		Assert.assertEquals(status, "Late In", "Test failed status poping up wrongly");
		
		driver.findElement(display_Status_Validation).clear();

	}
    
    public void entry_Check_Early_Out(String Day, String Month) {

		/*
		 * This method is used to check the entry
		 */
		By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");
		By status_Check = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[contains(@id,\"taEmployeeSummaryViewUnique\")]//span[normalize-space()='Early Out']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(status_Check)));
		String status = driver.findElement(status_Check).getText();

		//checking status
		Assert.assertEquals(status, "Early Out", "Test failed status poping up wrongly");
		
		driver.findElement(display_Status_Validation).clear();

	}


    public void filter_Close() {

        /*
         * This method is used to click the filter close icon in the time record page
         */
        By filter_close = By.xpath("(//img[@class='listview_filterClose' and @title='Close'])[2]");

        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(filter_close)));
            driver.findElement(filter_close).click();
        } catch (Exception e) {
        	try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(filter_close)));
            driver.findElement(filter_close).click();
        	} catch (Exception e1) {
				
			}
        }
        loader_Wait();
    }
    
    public void configure_Column_Select_All_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column select all icon in the time record page
		 */
    	By selectall =By.xpath("(//label[@class='listview_marLeft']//span//p[normalize-space()='Select All']//parent::span//parent::label//input)[2]");
    	
		Thread.sleep(1500);
		System.out.println(driver.findElement(selectall).isSelected());
		Boolean value =driver.findElement(selectall).isSelected();
		if (value.equals(true)) {
			By configure_column_select_all_click = By.xpath("(//label[@class='listview_marLeft']//span//p[normalize-space()='Select All'])[2]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_select_all_click)));
			Thread.sleep(1000);
			driver.findElement(configure_column_select_all_click).click();
		} else {
		try {
		By configure_column_select_all_click = By.xpath("(//label[@class='listview_marLeft']//span//p[normalize-space()='Select All'])[2]");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_select_all_click)));
		Thread.sleep(1000);
		driver.findElement(configure_column_select_all_click).click();
		Thread.sleep(1000);
		driver.findElement(configure_column_select_all_click).click();
		} catch (ElementNotInteractableException e) {
			Assert.fail("Test failed - Configure column is not openeing");
		}
		}
	}
    
    public void configure_Paygroup_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column date icon in the time
		 */

		By configure_paygroup_click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Pay Groups']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_paygroup_click)));
		Thread.sleep(1000);
		driver.findElement(configure_paygroup_click).click();

	}
    
    public void configure_Column_Save_Click() {

		/*
		 * This method is used to click the configure column save icon in the time record page
		 */
		By configure_column_save_click = By.xpath("(//div[@class='saveBox'])[2]");

		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_save_click)));
			driver.findElement(configure_column_save_click).click();
			 loader_Wait_Toaster();

		} catch (Exception e) {
			System.out.println("save button is disabled");
		}

	}
    
    public void filter_Arrow_Click() throws InterruptedException {

		/*
		 * This method is used to click the filter arrow
		 */
		By filter_arrow_click = By.xpath("//td[@id=\"set\"]//div//span[@title=\"Date\"]//following-sibling::span");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(filter_arrow_click)));
		driver.findElement(filter_arrow_click).click();
	}
    
    public void filtering_Check(String value) throws InterruptedException {

		/*
		 * This method is used to check the filter is working or not
		 */
		By Filtered_value = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span//span//span");

		try {
			By first_value_in_filter = By.xpath("(//div[normalize-space()='01-Apr-2023']//label//input)[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(first_value_in_filter));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(first_value_in_filter)));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(first_value_in_filter)));
			driver.findElement(first_value_in_filter).click();

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(Filtered_value)));
			String actual = driver.findElement(Filtered_value).getText();
			String expected = value;
			//filter value check
			Assert.assertEquals(actual, expected, "Test failed - filter is not working");

		} catch (Exception e) {
			Thread.sleep(1500);
			By first_value_in_filter = By.xpath("(//div[normalize-space()='01-Apr-2023']//label//input)[1]");
			action.click(driver.findElement(first_value_in_filter)).build().perform();

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(Filtered_value)));
			String actual = driver.findElement(Filtered_value).getText();
			String expected = value;
			//filter value check
			Assert.assertEquals(actual, expected, "Test failed - filter is not working");
		}
	}
    
    public void configure_Column_Date_Click() {
		/*
		 * This method is used to click the configure column date icon in the time
		 * record page
		 */
		By configure_column_date_click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Date']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_date_click)));
		driver.findElement(configure_column_date_click).click();
	}
    
    public void previous_Pay_Group_Validation() {

		/*
		 * This method is used to validate the previous_pay_group_validation
		 */
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM/yyyy");
	    LocalDateTime now2 = LocalDateTime.now().minusMonths(1);
	    String date_and_time2 = dtf.format(now2);
	    System.out.println(date_and_time2 );
	    
	    try {
		By previous_pay_group_validation = By.xpath("(//span//span//span[normalize-space()='"+date_and_time2+"'])[1]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(previous_pay_group_validation)));
		String value = driver.findElement(previous_pay_group_validation).getText();
		Assert.assertEquals(value, date_and_time2, "Test failed previous pay group not showing");
	} catch (Exception e) {
		Assert.fail("Test failed - Pay group is wrong");
	}

	}
    
    public void loader_Wait_Toaster() {

		/*
		 * This method is used to make wait until the toaster image gets disappear
		 */

		List<WebElement> loader_wait_Toaster = driver.findElements(By.xpath("//div[@id='toast-container']"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(loader_wait_Toaster));
	}

    
    public void configure_Column_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column icon in the time record
		 * page
		 */
		By configure_column_click = By.xpath("(//img[@title='Configure column'])[2]");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_click)));
		Thread.sleep(1000);
		driver.findElement(configure_column_click).click();
	}


    public void clicking_Pay_Period_Month_Selecting_IN_Time_Records(String Pay_period) throws InterruptedException {

        /*
         * This method is used to click the pay period month selecting IN in the time
         * record page
         */

        WebElement clicking_pay_period_month_Selecting_IN_Time_records = driver.findElement(By.xpath("//span[normalize-space()='" + Pay_period + "']"));
        wait.until(ExpectedConditions.visibilityOf(clicking_pay_period_month_Selecting_IN_Time_records));
        Thread.sleep(1000);
        try {
            clicking_pay_period_month_Selecting_IN_Time_records.click();
        } catch (Exception e) {
            Thread.sleep(1000);
            clicking_pay_period_month_Selecting_IN_Time_records.click();
        }

    }


    public void search_validation() {

        /*
         * This method is used to validate the search
         */

        By search_get = By.xpath("//span[@id=\"taEmployeeSummaryViewUniqueCodetableDataColumn00\"]//span");
        By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_get)));
        String value1 = driver.findElement(search_get).getText();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
        driver.findElement(search_validation).click();
        driver.findElement(search_validation).clear();
        driver.findElement(search_validation).sendKeys(value1);

        By search_value_check = By.xpath("//span//span//span[normalize-space()='" + value1 + "']");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_value_check)));
        String value = driver.findElement(search_value_check).getText();

        Assert.assertEquals(value, value1, "Test failed search not  working");
        driver.findElement(search_validation).clear();
    }


    public void specific_value_filter_validation() throws InterruptedException {

        /*
         * This method is used to validate specific_value_filter
         */


        WebElement specific_value_filter_validation = driver.findElement(By.xpath("//span[@title=\"Holiday\"]"));
        //wait1.until(ExpectedConditions.visibilityOf(specific_value_filter_validation));
        Thread.sleep(2000);
        new Actions(driver).click(specific_value_filter_validation).build().perform();


        WebElement search_value_check = driver.findElement(By.xpath("//span//span//span[normalize-space()='Holiday']"));
        wait.until(ExpectedConditions.visibilityOf(search_value_check));
        String value = search_value_check.getText();
        Assert.assertEquals(value, "Holiday", "Test failed -  specific data not filtered");

    }

    public void loader_Wait() {

        /*
         * This method is used to make wait until the loader image gets disappear
         */

        
        List<WebElement> heading_check = driver.findElements(By.xpath("//div//img[contains(@src,'gif')]"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
    }
    
    public void show_Variance_Check() {


		List<WebElement> all_entry_type = driver
				.findElements(By.xpath("//td[@id='taMyRecordsOTSHApprovalViewUniqueCodescrollId']//span//span//span"));
		ArrayList<String> entry_Type_list = new ArrayList<String>();

		for (int i = 0; i < all_entry_type.size(); i++) {
			String temp_message = all_entry_type.get(i).getText();
			entry_Type_list.add(temp_message);
		}
		System.out.println(entry_Type_list);
		if (entry_Type_list.contains("Over Time") || entry_Type_list.contains("Allowance") || entry_Type_list.contains("Short Hours") ) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Test failed -OT , Allwoance, short hours  details are not showing");
		}

	

	}



}
