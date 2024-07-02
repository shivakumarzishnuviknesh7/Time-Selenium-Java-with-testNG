package time_application.pages.manual_key_in_and_out_ess_pages;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home_Page {

	public WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	public Actions action;
	public JavascriptExecutor javascriptexecutor;

	public Home_Page(WebDriver driver, Actions action, Properties prop, WebDriverWait wait,JavascriptExecutor javascriptexecutor) {
		
		this.driver = driver;
		this.prop = prop;
		this.wait = wait;
		this.action = action;
		this.javascriptexecutor = javascriptexecutor;
	}

	public void time_Zone_Check() {

		/*
		 * This method is used to check the time zone and it will validate
		 */
		try {
			WebElement Time_Zone_Check = driver.findElement(By.xpath("(//div[@title='(GMT +01:00) Stockholm'])[1]")); // no
			wait.until(ExpectedConditions.visibilityOf(Time_Zone_Check));
			String actual = Time_Zone_Check.getText().trim();
			String excepted = "(GMT +01:00) Stockholm";

			Assert.assertEquals(actual, excepted, " test failed - time zone not showing properly");

		} catch (NoSuchElementException e) {
			System.out.println("time zone not available");
			Assert.assertTrue(false, "Test failed - time zone not available");
		}
		catch (Exception e) {
			 e.printStackTrace();
        }
	}

	public void clicking_Back_And_Front_Calendar_Navigation() {

		/*
		 * This method is used to check date is getting changed when we use navigation arrows
		 */
		
		try {
			By Today_button_click = By.xpath("//div[@title='Today']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(Today_button_click)));
			driver.findElement(Today_button_click).click();
			} catch (Exception e) {
				
			}
		
		By Date = By.xpath("//input[@value='selectedDate']");
		By back_arrow_click = By.xpath("//a[@title='Back']");
		By forward_arrow_click = By.xpath("//a[@title='Next' and @class='scrollDateArrowsBorder']");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
	    LocalDateTime now = LocalDateTime.now();
	    String date_and_time = dtf.format(now);
	    System.out.println("current time" + date_and_time);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Date)));
		String current_date = driver.findElement(Date).getAttribute("value");
		System.out.println("value is  -- " + current_date);
		Assert.assertEquals(date_and_time, current_date,"Test failed today button not working");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(back_arrow_click)));
		driver.findElement(back_arrow_click).click();

		String past_date = driver.findElement(Date).getAttribute("value");
		System.out.println("value is  -- " + past_date);

		//checking the date gets changes
		Assert.assertNotEquals(current_date, past_date, "Test failed because date didn't get changed");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(forward_arrow_click)));
		driver.findElement(forward_arrow_click).click();

		String current_date_present = driver.findElement(Date).getAttribute("value");
		System.out.println("value is  -- " + current_date_present);
		
		//checking the date gets changes
		Assert.assertEquals(current_date, current_date_present, "Test failed because date didn't get changed");
	}

	public void today_Click_Validate() {

		/*
		 * This method is used to check date when we click today button
		 */
		By Date = By.xpath("//input[@value='selectedDate']");
		By Today_button_click = By.xpath("//div[@title='Today']");
		By back_arrow_click = By.xpath("//a[@title='Back']");
		By Today_button_click_Date = By.xpath("//input[@value='selectedDate']");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
	    LocalDateTime now = LocalDateTime.now();
	    String date_and_time = dtf.format(now);
	    System.out.println("current time" + date_and_time);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Date)));
		String current_date = driver.findElement(Date).getAttribute("value");
		System.out.println("value is  -- " + current_date);
		Assert.assertEquals(date_and_time, current_date,"Test failed today button not working");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(back_arrow_click)));
		driver.findElement(back_arrow_click).click();

		String past_date = driver.findElement(Date).getAttribute("value");
		System.out.println("value is  -- " + past_date);

		//checking the date gets changes
		Assert.assertNotEquals(current_date, past_date, "Test failed because date didn't get changed");

		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Today_button_click)));
		driver.findElement(Today_button_click).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Today_button_click_Date)));
		String Today_button_click_date = driver.findElement(Date).getAttribute("value");

		//checking the date gets changes
		Assert.assertEquals(current_date, Today_button_click_date, "Test failed because date didn't get changed");

	}

	public void time_Summary_Total_Hours_Check_Current_Month(String total_time_adds) throws Exception {

		/*
		 * This method is used to check Time Summary Total Hours Check
		 */

		By total_Hours = By.xpath("//span[normalize-space()='Total Hours']//parent::div//parent::div//div[@id='contTotalHours']");
		By Next_Arrow_Button = By.xpath("(//div[@class='col arrowsActive s1']//a[@title='Next']//i[normalize-space()='chevron_right'])[1]");
		
		List<WebElement> total_dial = driver.findElements(By.xpath("//div[@id='scrollId']//div[contains(@class,'col dailDiv')]"));
		for (int i = 0; i < total_dial.size(); i++) {
			if (driver.findElement(total_Hours).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(total_Hours)));
				Thread.sleep(1000);
				String Time_summary_value = driver.findElement(total_Hours).getAttribute("data-pct");
				System.out.println("valur in dial -   "+Time_summary_value);
				Assert.assertTrue(Time_summary_value.contains(total_time_adds) , "Test failed - total hours is not showing properly");
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(Next_Arrow_Button)));
				new Actions(driver).click(driver.findElement(Next_Arrow_Button)).build().perform();
			}
		}

	}

	public void today_Button_Click() {

		/*
		 * This method is used to click today button
		 */
		By today_click = By.xpath("//div[@title='Today']");

		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(today_click)));
			driver.findElement(today_click).click();
		} catch (Exception e) {
			System.out.println("its today");
		}

	}

	public void time_Summary_Work_Hours_Check_Current_Month(String total_time_adds) throws Exception {

		/*
		 * This method is used to check Time Summary work Hours Check
		 */

		By work_Hours = By.xpath("//span[normalize-space()='Work Hours']//parent::div//parent::div//div[@id='contWorkHours']");
		By Next_Arrow_Button = By.xpath("(//div[@class='col arrowsActive s1']//a[@title='Next']//i[normalize-space()='chevron_right'])[1]");
		List<WebElement> total_dial = driver.findElements(By.xpath("//div[@id='scrollId']//div[contains(@class,'col dailDiv')]"));

		for (int i = 0; i < total_dial.size(); i++) {
			if (driver.findElement(work_Hours).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(work_Hours)));
				Thread.sleep(1000);
				String Time_summary_value = driver.findElement(work_Hours).getAttribute("data-pct");
				System.out.println("valur in dial -   "+Time_summary_value);
				//work hours check
				Assert.assertTrue(Time_summary_value.contains(total_time_adds),"Test failed - work hours is not showing properly");
				
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(Next_Arrow_Button)));
				new Actions(driver).click(driver.findElement(Next_Arrow_Button)).build().perform();
			}
		}
	}

	public void time_Summary_Break_Hours_Check_Current_Month(String total_time_adds) throws Exception {

		/*
		 * This method is used to check Time Summary break Hours Check
		 */
		By break_Hours = By.xpath("//span[contains(normalize-space(),'Break Hour')]//parent::div//parent::div//div[@id='contBreakHours']");
		By Next_Arrow_Button = By.xpath("(//div[@class='col arrowsActive s1']//a[@title='Next']//i[normalize-space()='chevron_right'])[1]");

		List<WebElement> total_dial = driver.findElements(By.xpath("//div[@id='scrollId']//div[contains(@class,'col dailDiv')]"));

		for (int i = 0; i < total_dial.size(); i++) {
			if (driver.findElement(break_Hours).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(break_Hours)));
				Thread.sleep(1000);
				String Time_summary_value = driver.findElement(break_Hours).getAttribute("data-pct");
				System.out.println("valur in dial -   "+Time_summary_value);
				//break hours check
				Assert.assertTrue(Time_summary_value.contains(total_time_adds),"Test failed - total hours is not showing properly");
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(Next_Arrow_Button)));
				new Actions(driver).click(driver.findElement(Next_Arrow_Button)).build().perform();
			}
		}
	}

	public void time_Summary_Right_Arrow_Click() {

		/*
		 * This method is used to click Time Summary right arrow
		 */
		By Time_Summary_right_arrow_click = By.xpath("(//a[@title='Next'])[2]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Time_Summary_right_arrow_click)));
		driver.findElement(Time_Summary_right_arrow_click).click();
	}

	public void time_Summary_Over_Time_Hours_Check_Current_Month(String total_time_adds) throws Exception {

		/*
		 * This method is used to check Time Summary over time Hours Check
		 */
		By overtime_Hours = By.xpath("//span[normalize-space()='Over Time']//parent::div//parent::div//parent::div//div[@id='contOverTime']");
		By Next_Arrow_Button = By.xpath("(//div[@class='col arrowsActive s1']//a[@title='Next']//i[normalize-space()='chevron_right'])[1]");
		List<WebElement> total_dial = driver.findElements(By.xpath("//div[@id='scrollId']//div[contains(@class,'col dailDiv')]"));

		for (int i = 0; i < total_dial.size(); i++) {
			if (driver.findElement(overtime_Hours).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(overtime_Hours)));
				Thread.sleep(1000);
				String Time_summary_value = driver.findElement(overtime_Hours).getAttribute("data-pct");
				//over time check
				Assert.assertEquals(Time_summary_value, total_time_adds,"Test failed - overtime hours is not showing properly");
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(Next_Arrow_Button)));
				new Actions(driver).click(driver.findElement(Next_Arrow_Button)).build().perform();
			}
		}
	}

	public void time_Summary_Special_Hours_Check_Current_Month() {

		/*
		 * This method is used to check Time Summary special Hours Check
		 */
		By Special_hours = By.xpath("//span[normalize-space()='Special Hours']//parent::div//parent::div//parent::div//div[@id='contSpecialHours']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Special_hours)));
		String Time_summary_value = driver.findElement(Special_hours).getAttribute("data-pct");
		String total_time_adds = "00:00";
		Assert.assertEquals(Time_summary_value, total_time_adds);

	}

	public void current_Processing_Period_Check() {

		/*
		 * This method is used to check current processing period check
		 */
		By current_processing_period_check = By.xpath("//div[@id='payPeriodDetailsTab']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(current_processing_period_check)));
		String current_processing_period = driver.findElement(current_processing_period_check).getText();

		System.out.println(current_processing_period);
		// 01 May 2023 to 31 May 2023
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date_and_time = dtf.format(now);
		System.out.println("current time" + date_and_time);
		
		//checking current processing period
		Assert.assertTrue(current_processing_period.contains(date_and_time),"test failed - current processing period is not showing correctly");

	}

	public void time_Summary_Navigation_Check() {

		/*
		 * This method is used to check time summary navigation check
		 */
		By left_arrow_click = By.xpath("(//a[@title='Previous'])[1]");
		By total_hours = By.xpath("//span[normalize-space()='Total Hours']");
		By right_arrow_click = By.xpath("(//a[@title='Next'])[2]");
		By over_time = By.xpath("//span[normalize-space()='Over Time']");
		List<WebElement> total_dial = driver.findElements(By.xpath("//div[@id='scrollId']//div[@class='col dailDiv s4']"));

		// right arrow check
		for (int i = 0; i < total_dial.size(); i++) {
			if (driver.findElement(over_time).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(over_time)));
				//over time check
				Assert.assertEquals(driver.findElement(over_time).getText(), "Over Time","Test Failed-overhours not present");
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(right_arrow_click)));
				new Actions(driver).click(driver.findElement(right_arrow_click)).build().perform();
			}
		}

		// left arrow check
		for (int i = 0; i < total_dial.size(); i++) {
			if (driver.findElement(total_hours).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(total_hours)));
				Assert.assertEquals(driver.findElement(total_hours).getText(), "Total Hours","Test Failed-total_hours not present");
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(left_arrow_click)));
				new Actions(driver).click(driver.findElement(left_arrow_click)).build().perform();
			}
		}

	}

	public void right_Arrow_Click_In_Time_Summary() {

		/*
		 * This method is used to click Right Arrow Click In Time Summary
		 */
		By right_arrow_click = By.xpath("(//a[@title='Next'])[2]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(right_arrow_click)));
		driver.findElement(right_arrow_click).click();
	}

	public void mouse_Hover_In_Overtime_Check() {

		/*
		 * This method is used to check Mouse hover in Overtime Check
		 */
		By Mouse_hover_in_Overtime_Check = By.xpath("//div[@id='exceptionUIValue']//div[@id='toatlBalanceIicon']");
		By Mouse_hover_in_Overtime_Check_data_displaying = By.xpath("//div[@id='exceptionUIValue']//div[@class='timeTooltiptextOT']");
		By right_arrow_click = By.xpath("(//a[@title='Next'])[2]");
		By over_time = By.xpath("//span[normalize-space()='Over Time']");
		List<WebElement> total_dial = driver.findElements(By.xpath("//div[@id='scrollId']//div[@class='col dailDiv s4']"));

		for (int i = 0; i < total_dial.size(); i++) {

			if (driver.findElement(over_time).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(over_time)));
				// i hover value check
				Assert.assertEquals(driver.findElement(over_time).getText(), "Over Time","Test Failed-overhours not present");
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(right_arrow_click)));
				new Actions(driver).click(driver.findElement(right_arrow_click)).build().perform();
			}
		}

		for (int i = 0; i < 10; i++) {

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(Mouse_hover_in_Overtime_Check)));
			action.click(driver.findElement(Mouse_hover_in_Overtime_Check)).build().perform();
			action.moveToElement(driver.findElement(Mouse_hover_in_Overtime_Check));
			if (driver.findElement(Mouse_hover_in_Overtime_Check).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(Mouse_hover_in_Overtime_Check_data_displaying)));
				String I_icon_check_data = driver.findElement(Mouse_hover_in_Overtime_Check_data_displaying).getText();
				System.out.println(I_icon_check_data);
				// i hover value check
				Assert.assertTrue(I_icon_check_data.contains("Approved"),"test failed - the tab is not open after hover on I icon");
				break;
			} else {
				action.click(driver.findElement(Mouse_hover_in_Overtime_Check)).build().perform();
				action.moveToElement(driver.findElement(Mouse_hover_in_Overtime_Check));
			}
		}

	}

	public void loader_Wait() {

		/*
		 * This method is used to make wait until the loader image gets disappear
		 */

		List<WebElement> heading_check = driver.findElements(By.xpath("//div//img[contains(@src,'gif')]"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
	}

	public void table_Visibility_Wait() {

		/*
		 * This method is used to make wait until the table gets appear
		 */
		List<WebElement> heading_check = driver.findElements(By.xpath("//table[@id='ss']"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
	}

	public void loader_Wait_Toaster() {

		/*
		 * This method is used to make wait until the toaster image gets disappear
		 */

		List<WebElement> loader_wait_Toaster = driver.findElements(By.xpath("//div[@id='toast-container']"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(loader_wait_Toaster));
	}

	public void time_Record_Click() {

		/*
		 * This method is used to click the time record tab
		 */
		
		By Time_Record_Click = By.xpath("//div[@class='col s12 tlcustom-sidenavbarmenu']//img[contains(@src,'timeRecordsMenu') and (not(@hidden))]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Time_Record_Click)));
		driver.findElement(Time_Record_Click).click();
		
/*
		try {
		changeWaitTime(5);
		By Time_Record_Click = By.xpath("//div[@class='col s12 tlcustom-sidenavbarmenu']//img[contains(@src,'/tl_timeRecordsMenuBlue.svg')]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Time_Record_Click)));
		driver.findElement(Time_Record_Click).click();
		changeWaitTime(15);
		}
		catch (Exception e) {
			try {
			By Time_Record_Click = By.xpath("//div[@class='col s12 tlcustom-sidenavbarmenu']//img[contains(@src,'/tl_timeRecordsMenuWhite.svg')]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(Time_Record_Click)));
			driver.findElement(Time_Record_Click).click();
			changeWaitTime(15);
			} catch (Exception e1) {
				changeWaitTime(5);
				By Time_Record_Click = By.xpath("//div[@class='col s12 tlcustom-sidenavbarmenu']//img[contains(@src,'/tl_timeRecordsMenuBlue.svg')]");
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(Time_Record_Click)));
				driver.findElement(Time_Record_Click).click();
				changeWaitTime(15);
			}
		}
		*/
		loader_Wait();
	}

	public void home_Click() throws InterruptedException {

		/*
		 * This method is used to click the Home tab
		 */
		try {
		By Home_Click = By.xpath("//div[@class=\"col s12 tlcustom-sidenavbarmenu\"]//img[contains(@src,\"clockMenu\") and (not(@hidden))]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Home_Click)));
		driver.findElement(Home_Click).click();
		}  catch (Exception e2) {
			 loader_Wait();
			 By Home_Click = By.xpath("//div[@class=\"col s12 tlcustom-sidenavbarmenu\"]//img[contains(@src,\"clockMenu\") and (not(@hidden))]");
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(Home_Click)));
				driver.findElement(Home_Click).click();
		}
		
		/*
		try {
			changeWaitTime(5);
			By Home_Click = By.xpath("(//img[@alt='blueClock' and @title='Home'])[1]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(Home_Click)));
			driver.findElement(Home_Click).click();
			changeWaitTime(15);
		}
		 catch (Exception e) {
			 try {
			 changeWaitTime(2);
			 By Home_Click = By.xpath("(//div[contains(@class,'tlDashboardIconContainer')]//a//img[@alt='whiteClock' and @title='Home'])[1]"); 
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(Home_Click)));
				driver.findElement(Home_Click).click();
				changeWaitTime(15);
			 } catch (Exception e2) {
				 loader_Wait();
				 By Home_Click = By.xpath("(//div[contains(@class,'tlDashboardIconContainer')]//a//img[@alt='whiteClock' and @title='Home'])[1]"); 
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(Home_Click)));
					driver.findElement(Home_Click).click();
			}
		}
		*/
	}

	public void clicking_Filter_IN_Time_Records() {
		/*
		 * This method is used to click the filter icon in the time record page
		 */
		By clicking_Filter_IN_Time_records = By.xpath("//span[@title='Filter']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_Filter_IN_Time_records)));
		driver.findElement(clicking_Filter_IN_Time_records).click();
	}

	public void clicking_Pay_Period_Month_IN_Time_Records() {

		/*
		 * This method is used to click the pay period month in the time record page
		 */
		By clicking_pay_period_month_IN_Time_records = By.xpath("//div[@class='col payperiodWrap s12']//input[@class='select-dropdown dropdown-trigger']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_pay_period_month_IN_Time_records)));
		driver.findElement(clicking_pay_period_month_IN_Time_records).click();
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

	public void filter_Close() {

		/*
		 * This method is used to click the filter close icon in the time record page
		 */
		By filter_close = By.xpath("(//img[@class='listview_filterClose' and @title='Close'])[2]");

		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(filter_close)));
			driver.findElement(filter_close).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(filter_close)));
			driver.findElement(filter_close).click();
		}
		

		loader_Wait();
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

	public void configure_Column_Exception_Type_Click() {

		/*
		 * This method is used to click the configure column exception type icon in the time record page
		 */
		By configure_column_exception_type_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Exception Type']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_exception_type_click)));
		driver.findElement(configure_column_exception_type_click).click();

	}

	public void configure_Column_Display_Status_Click() {

		/*
		 * This method is used to click the configure column display status icon in the  time record page
		 */
		By configure_Column_Display_Status_Click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Display Status']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Column_Display_Status_Click)));
		driver.findElement(configure_Column_Display_Status_Click).click();

	}

	public void configure_Column_Total_Time_Click() {

		/*
		 * This method is used to click the configure column total time icon in the  timer record page
		 */
		By configure_column_total_time_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Total Time']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_total_time_click)));
		driver.findElement(configure_column_total_time_click).click();
	}

	public void configure_Column_Work_Hours_Click() {

		/*
		 * This method is used to click the configure column work hours icon in the time record page
		 */
		By configure_column_Work_hours_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Work Hours']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_Work_hours_click)));
		driver.findElement(configure_column_Work_hours_click).click();
	}

	public void configure_Column_Break_Hours_Click() {

		/*
		 * This method is used to click the configure column break hours icon in the time record page
		 */
		By configure_column_break_hours_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[contains(@title,'Break Hour')]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_break_hours_click)));
		driver.findElement(configure_column_break_hours_click).click();
	}

	public void configure_Column_Over_Time_Hours_Click() {

		/*
		 * This method is used to click the configure column over time hours icon in the time record page
		 */
		By configure_column_OT_hours_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='OT Hours']");

		try {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_OT_hours_click)));
		driver.findElement(configure_column_OT_hours_click).click();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed - OT check box missing");
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
	}

	public void configure_Column_Special_Hours_Click() {

		/*
		 * This method is used to click the configure column special hours icon in the
		 * time record page
		 */
		/*
		By configure_column_special_hours_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class=\"listview_marLeft\"]//span[@title=\"OT Hours\"]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_special_hours_click)));
		driver.findElement(configure_column_special_hours_click).click();
		*/
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

	public String total_Time_Add() {

		/*
		 * This method is used to all the all time of respective hours and it return  back in hours and minutes
		 */

		ArrayList<String> total_time_hours = new ArrayList<String>();
		ArrayList<String> total_time_minutes = new ArrayList<String>();

		//parameter pass
		List<WebElement> total_time_add = driver.findElements(By.xpath("//tbody//tr//td[@id='taEmployeeSummaryViewUniqueCodescrollId']//span//span//span"));

		int Sum = 0;
		int Sums = 0;

		for (int i = 0; i < total_time_add.size(); i++) {
			String temp_message = total_time_add.get(i).getText();
			String[] time = temp_message.split(":");

			try {
				total_time_hours.add(time[0]);
				int a = Integer.parseInt(total_time_hours.get(i));
				Sum = Sum + a;

				System.out.println(a);
				total_time_minutes.add(time[1]);
				int b = Integer.parseInt(total_time_minutes.get(i));
				Sums = Sums + b;
			} catch (Exception e) {

				System.out.println("Empty value is there");

			}
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

	public void my_Statistics_Navigation_Check() {

		/*
		 * This method is used to check My statistics navigation check
		 */

		By left_arrow_click_2 = By.xpath("(//a[@title='Previous'])[2]");
		By right_arrow_click_2 = By.xpath("(//a[@title='Next'])[3]");
		By half_day = By.xpath("//div//span[@class='lateInSpan' and normalize-space()='Half Day']");
		By late_in = By.xpath("//span[normalize-space()='Late In']");

		List<WebElement> total_dial = driver.findElements(By.xpath("//div[@id='scrollId']//div[@class='col dailDiv s4']"));

		// right arrow check
		for (int i = 0; i < total_dial.size(); i++) {
			if (driver.findElement(half_day).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(half_day)));
				//half day visibility
				Assert.assertEquals(driver.findElement(half_day).getText(), "Half Day", "Test Failed-overhours not present");
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(right_arrow_click_2)));
				new Actions(driver).click(driver.findElement(right_arrow_click_2)).build().perform();
			}
		}

		// left arrow check
		for (int i = 0; i < total_dial.size(); i++) {
			if (driver.findElement(late_in).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(late_in)));
				//late in visibility
				Assert.assertEquals(driver.findElement(late_in).getText(),"Late In","Test Failed-late_in not present");
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(left_arrow_click_2)));
				new Actions(driver).click(driver.findElement(left_arrow_click_2)).build().perform();
			}
		}
	}

	public void apply_Leave() {

		/*
		 * This method is used to check apply leave button is working and its page is getting open or not
		 */
		By Apply_leave = By.xpath("//button[@title='Apply Leave']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Apply_leave)));
		String button_check = driver.findElement(Apply_leave).getText();
		//Apply leave page opening check
		Assert.assertEquals(button_check, "Apply Leave", "test failed - button not available");
		driver.findElement(Apply_leave).click();

		try {
		By Apply_leave_window = By.xpath("//div//b[normalize-space()='Apply Leave']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Apply_leave_window)));
		String window_check = driver.findElement(Apply_leave_window).getText();
		//Apply leave page opening check
		Assert.assertEquals(window_check, "Apply Leave", "test failed - window not available");

		By Apply_leave_window_close = By.xpath("//i[@title='Close']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Apply_leave_window_close)));
		driver.findElement(Apply_leave_window_close).click();
		} 
		catch (NoSuchElementException e) {
            Assert.assertTrue(false, "Test failed page is not openend properly");
        }
		catch (Exception e) {
			 e.printStackTrace();
		}
	}

	public void show_Time_Exception_Toggle_On() {

		/*
		 * This method is used to click the toggle on for show exception in time records page
		 */
		By show_exception_toggle_on = By.xpath("//label[@for='timeShowExceptions']//span");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(show_exception_toggle_on)));
		driver.findElement(show_exception_toggle_on).click();
		loader_Wait();
	}

	public void my_Statistics_Absent_Count_Check(String count) throws Exception {

		/*
		 * This method is used to check the absent count in home page
		 */
		By right_arrow_click_2 = By.xpath("(//a[@title='Next'])[3]");
		By My_statistics_absent_count_check = By.xpath("//div[@id='absentBar']//div//span[@class='lateInCountCss']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(right_arrow_click_2)));
		driver.findElement(right_arrow_click_2).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(My_statistics_absent_count_check)));
		Thread.sleep(1000);
		String day_check = driver.findElement(My_statistics_absent_count_check).getText();
		//absent count checking 
		Assert.assertEquals(day_check, count, "test failed - count of absent is not same");

	}

	public String exception_Count_Check() {

		/*
		 * This method is used to adding all the values in the list view and validating exception count
		 */

		List<WebElement> Exception_count_check = driver.findElements(By.xpath("//span[contains(@id,\"taEmployeeSummaryViewUniqueCodetableDataColumn\")]//span"));
		wait.until(ExpectedConditions.visibilityOfAllElements(Exception_count_check));
		Integer final_an = Exception_count_check.size();
		String final_ans = "" + final_an + "";

		System.out.println("absent count  is    -    " + final_ans);
		return final_ans;
	}

	public void time_Summary_Bank_Hours_Check_Current_Month(String total_time_adds) {

		/*
		 * This method is used to check Time Summary bank Hours Check
		 */
		By Bank_hours = By.xpath("//span[normalize-space()='Bank Hours']//parent::div//parent::div//div[@id='contBankHours']");
		By Next_Arrow_Button = By.xpath("(//div[@class='col arrowsActive s1']//a[@title='Next']//i[normalize-space()='chevron_right'])[1]");
		List<WebElement> total_dial = driver.findElements(By.xpath("//div[@id='scrollId']//div[contains(@class,'col dailDiv')]"));

		for (int i = 0; i < total_dial.size(); i++) {
			if (driver.findElement(Bank_hours).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(Bank_hours)));
				String Time_summary_value = driver.findElement(Bank_hours).getAttribute("data-pct");
				//bank hours check
				Assert.assertTrue(Time_summary_value.contains(total_time_adds),"Test failed - bank hours is not showing properly in time summary");
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(Next_Arrow_Button)));
				new Actions(driver).click(driver.findElement(Next_Arrow_Button)).build().perform();
			}
		}
	}

	public void my_Statistics_Right_Arrow_Click() {

		/*
		 * This method is used to click My Statistics right arrow
		 */
		By right_arrow_click_2 = By.xpath("(//a[@title='Next'])[3]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(right_arrow_click_2)));
		driver.findElement(right_arrow_click_2).click();

	}

	public ArrayList<String> absent_Dates_Extraction_In_Time_Records() {

		/*
		 * This method is used to extract absent dates in time records and it returns the date numbers as array list
		 */

		ArrayList<String> dates = new ArrayList<String>();

		List<WebElement> total_time_add = driver.findElements(By.xpath("//table//tbody//tr//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span//span//span[contains(normalize-space(),'Apr')]"));

		for (int i = 0; i < total_time_add.size(); i++) {
			String temp_message = total_time_add.get(i).getText();
			String[] time = temp_message.split("-Apr");

			dates.add(time[0]);
		}
		System.out.println("days  - " + dates);

		return dates;
	}

	public void configure_Column_Dates_Click() {

		/*
		 * This method is used to click the configure column dates icon in time records page
		 */
		By configure_column_dates_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Date']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_dates_click)));
		driver.findElement(configure_column_dates_click).click();
	}

	public void configure_Column_Leave_Type_Click() {

		/*
		 * This method is used to click the configure column leave type icon in time
		 * records page
		 */
		By configure_column_leave_Type_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Leave Type']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_leave_Type_click)));
		driver.findElement(configure_column_leave_Type_click).click();
	}

	public void configure_Processing_From_Click() {

		/*
		 * This method is used to click the configure column processing from in time records page
		 */
		By configure_processing_from_click = By.xpath("//ul[@class='universalConfigColumnClass dropdown-content listview_tipView']//label[@class='listview_marLeft']//span[@title='Processing From']");

		try {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_processing_from_click)));
		driver.findElement(configure_processing_from_click).click();
		} catch (Exception e) {
			Assert.fail("test failed processing from is missing");
		}
	}

	public void configure_Payment_Name_Click() {

		/*
		 * This method is used to click the configure column payment name in time records page
		 */

		By configure_payment_name_click = By.xpath("//ul[@class='universalConfigColumnClass dropdown-content listview_tipView']//label[@class='listview_marLeft']//span[@title='Payment Name']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_payment_name_click)));
		driver.findElement(configure_payment_name_click).click();
	}

	public void configure_Paid_Hours_Click() {

		/*
		 * This method is used to click the configure column paid hours in time records page
		 */
		By configure_Paid_Hours_Click = By.xpath("//ul[@class=\"universalConfigColumnClass dropdown-content listview_tipView\"]//label[@class=\"listview_marLeft\"]//span[@title=\"Paid Hours\"]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Paid_Hours_Click)));
		driver.findElement(configure_Paid_Hours_Click).click();
	}

	public void configure_Column_Exception_Types_Click() {

		/*
		 * This method is used to click the configure column exception types icon in  time records page
		 */
		By configure_column_exception_types_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Exception Type']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_exception_types_click)));
		driver.findElement(configure_column_exception_types_click).click();
	}

	public void search_Absent() {

		/*
		 * This method is used to click the configure column exception types icon in time records page
		 */
		By search_absent = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_absent)));
		driver.findElement(search_absent).click();
		driver.findElement(search_absent).sendKeys("Absent");
	}

	public void my_Statistics_Absent_Click() throws Exception {

		/*
		 * This method is used to click absent in My Statistics
		 */
		By My_Statistics_absent_click = By.xpath("//span[@class='lateInSpan' and normalize-space()='Absent']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(My_Statistics_absent_click)));
		Thread.sleep(1500);
		driver.findElement(My_Statistics_absent_click).click();
		Thread.sleep(2000);

	}

	public void absent_Dates_Check_In_Exception_Dates(ArrayList<String> absent_date) {

		/*
		 * This method is used to check the absent dates in exception date in home page
		 */

		ArrayList<String> dates = new ArrayList<String>();
		List<WebElement> absent_days = driver.findElements(By.xpath("//div[normalize-space()='Exception Dates']//parent::div//div[contains(@id,'activeid')]"));
		for (int i = 0; i < absent_days.size(); i++) {
			String temp_message = absent_days.get(i).getText();
			dates.add(temp_message);
		}
		System.out.println("days  in dash board  - " + dates);
		Assert.assertEquals(dates, absent_date, "Test failed - absent dates are not showing correnctly");
		
		 for(int q=0;q<11;q++) {
             my_Statistics_Left_Arrow_Click();
         }
	}

	public void my_Statistics_Late_In_Check() {

		/*
		 * This method is used to check the late in dates in exception date in home page
		 */
		By My_statistics_late_in_check = By.xpath("//div//span[@class='lateInSpan' and normalize-space()='Late In']//parent::div//parent::div//span[@class='lateInCountCss']");
		By data_prenet_check = By.xpath("//div[normalize-space()='Exception Dates']//parent::div//div[contains(@id,'activeid')]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(My_statistics_late_in_check)));
		new Actions(driver).click(driver.findElement(My_statistics_late_in_check)).build().perform();

		String a = driver.findElement(My_statistics_late_in_check).getText();
		System.out.println("value -  " + a);

		int b = Integer.parseInt(a);

		if (b > 0) {

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(data_prenet_check)));
			Assert.assertEquals(driver.findElement(data_prenet_check).isDisplayed(), false," test failed -exception dates field not working");

		} else {
			//Assert.assertTrue(true);
			Assert.assertTrue(false);
		}

	}

	public void my_Statistics_Left_Arrow_Click() {

		/*
		 * This method is used to click My Statistics right arrow
		 */
		By My_Statistics_left_arrow_click = By.xpath("(//a[@title='Previous'])[2]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(My_Statistics_left_arrow_click)));
		driver.findElement(My_Statistics_left_arrow_click).click();

	}

	public void my_Statistics_All_Widget_Visible_Check() throws InterruptedException {
		
		/*
		 * This method is used to click and check all the icons in my statistics is  visible or not
		 */
		
		List<WebElement> total_dial = driver.findElements(By.xpath("//div[contains(@class,'col dailDivc')]//div//div//following-sibling::div//span"));
		String dial_name[]= {"Late In","Early Out","Short Hours","Absent","Half Day" };   
		for(int i=0;i<dial_name.length;i++) {
			System.out.println(dial_name[i]);
			WebElement dial = driver.findElement(By.xpath("//div//span[@class='lateInSpan' and normalize-space()='"+dial_name[i]+"']"));
			try {
				wait.until(ExpectedConditions.visibilityOf(dial));
				String late_in_actual = dial.getText();
				String late_in_expected = dial_name[i];
				//checking the widget
				Assert.assertEquals(late_in_actual, late_in_expected,"Test failed -" +dial_name[i]+ "not showing");
			} catch (Exception e) {

				for (int j = 0; j < total_dial.size(); j++) {
					if (dial.isDisplayed()) {
						String late_in_actual = dial.getText();
						String late_in_expected = dial_name[i];
						//checking the widget
						Assert.assertEquals(late_in_actual, late_in_expected,"Test failed -"+dial_name[i]+" not showing");
						break;
					} else {
						my_Statistics_Right_Arrow_Click();
					}
				}
			}

			for(int k=0;k<dial_name.length;k++) {
				my_Statistics_Left_Arrow_Click();
			}
		}
		}

	public void exception_Symbol_Check_No_Exception() {

		/*
		 * This method is used to check exception symbol check for no exception
		 */
		By no_exception = By.xpath("//img[@alt='No Exception']");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(no_exception)));
		//exception symbol check
		Assert.assertEquals(driver.findElement(no_exception).getAttribute("alt"), "No Exception","test failed - no exception symbol is not showing");
		
	}

	public void exception_Symbol_Check_Short_Hours() {

		/*
		 * This method is used to check exception symbol check for short hours
		 */
		By exception_Symbol_Check_Short_Hours = By.xpath("//img[@alt='Absent']");

		my_Statistics_Short_Hours_Click_Date_Select();

		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(exception_Symbol_Check_Short_Hours)));
		//short hours symbol it will show as absent
		Assert.assertEquals(driver.findElement(exception_Symbol_Check_Short_Hours).getAttribute("alt"), "Absent","test failed - no exception symbol is not showing");

	}

	public void my_Statistics_Short_Hours_Click_Date_Select() {

		/*
		 * This method is used to click My statistics short hours click date select
		 */
		By short_hours_date = By.xpath("(//div[normalize-space()='Exception Dates']//parent::div//div[contains(@id,'activeid')])[1]");

		WebElement short_hours = driver.findElement(By.xpath("//div//span[normalize-space()='Short Hours']"));
		wait.until(ExpectedConditions.visibilityOf(short_hours));
		action.click(short_hours).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(short_hours_date)));
		action.click(driver.findElement(short_hours_date)).build().perform();
	}

	// By exception_Symbol_Absent = By.xpath("//img[@alt='Absent']");

	public void exception_Symbol_Absent() {

		/*
		 * This method is used to check exception symbol check for absent
		 */
		By exception_Symbol_Absent = By.xpath("//img[@alt='Absent']");

		my_Statistics_Absent_Click_Date_Select();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(exception_Symbol_Absent)));
		//absent symbol check
		Assert.assertEquals(driver.findElement(exception_Symbol_Absent).getAttribute("alt"), "Absent","test failed - no exception symbol is not showing");

	}

	public void my_Statistics_Absent_Click_Date_Select() {

		/*
		 * This method is used to click My statistics absent click date select
		 */
		By Absent_date = By.xpath("(//div[normalize-space()='Exception Dates']//parent::div//div[contains(@id,'activeid')])[1]");

		WebElement Absent = driver.findElement(By.xpath("//div//span[normalize-space()='Absent']"));
		wait.until(ExpectedConditions.visibilityOf(Absent));
		action.click(Absent).build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Absent_date)));
		action.click(driver.findElement(Absent_date)).build().perform();

	}

	public void my_Statistics_Short_Hours_Dates_Check_With_Dash_Board() {

		/*
		 * This method is used to click My statistics short hours check with dash board
		 */
		By pay_cycle = By.xpath("//div[@id=\"payPeriodDetailsTab\"]");
		By date_in_dash_board = By.xpath("//div[@class='col selectPayMonth s12']//input");
		By short_hours_date = By.xpath("(//div[normalize-space()='Exception Dates']//parent::div//div[contains(@id,'activeid')])[1]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(pay_cycle)));

		String[] a = driver.findElement(pay_cycle).getText().split(" to ");
		String value = a[0];
		String[] month_year_split = value.split("1 ");
		String month_year = month_year_split[1];
		System.out.println(month_year);
		String date_in_exception = "";

		try {

			new Actions(driver).click(driver.findElement(short_hours_date)).build().perform();
			date_in_exception = driver.findElement(short_hours_date).getText();

		} catch (StaleElementReferenceException e) {

			wait.until(
					ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(short_hours_date))));
			new Actions(driver).click(driver.findElement(short_hours_date)).build().perform();
			date_in_exception = driver.findElement(By.xpath(
					"(//div[normalize-space()='Exception Dates']//parent::div//div[contains(@id,'activeid')])[1]"))
					.getText();

		}

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(date_in_dash_board)));
		 System.out.println(driver.findElement(date_in_dash_board).getText());
		 System.out.println(driver.findElement(date_in_dash_board).getAttribute("value"));

		String date_final = driver.findElement(date_in_dash_board).getAttribute("value");
		String dashBoard[] = date_final.split(" ");
		String month_year_dashboard = "" + dashBoard[1] + " " + dashBoard[2] + "";
		System.out.println(month_year_dashboard);
		String date_dashboard = dashBoard[0];

		// processing month check
		Assert.assertEquals(month_year_dashboard, month_year, "Test failed - month and year is not same for the selected exception");
		//dates check in dash board
		Assert.assertEquals(date_in_exception, date_dashboard, "Test failed - viewing date is not same for the selected exception");

	}

	public void shift_Hour_Check() {

		/*
		 * This method is used to check the shift by hovering on i icon
		 */
		By shift_hour_check = By.xpath("(//div[text()='Shift Time']//parent::div//div[@id=\"toatlBalanceIicon\"]//a//i[normalize-space()='info_outline'])[1]");
		By shift_hour_check_I_icon = By.xpath("(//div[text()='Shift Time']//parent::div//div[@id=\"toatlBalanceIicon\"]//div[@class=\"timeTooltiptext\"]//div)[1]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(shift_hour_check)));
		new Actions(driver).click(driver.findElement(shift_hour_check)).build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(shift_hour_check_I_icon)));
		String shift = driver.findElement(shift_hour_check_I_icon).getText();

		//shift check
		Assert.assertEquals(shift, "Shift : Morning Shift(10:00 to 18:00)", "Test failed - shift is not showing properly");

	}

	public void shift_Drop_Down_Click() {

		/*
		 * This method is used to click the shift drop down
		 */
		//By shift_drop_down_click = By.xpath("//div[@class=\"col hide-on-med-and-down s12\"]//div[@class=\"col selectTeamMembers selectShift shiftName s7\"]//input");
		By shift_drop_down_click = By.xpath("(//div[@role='combobox']//input)[2]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(shift_drop_down_click)));
		new Actions(driver).click(driver.findElement(shift_drop_down_click)).build().perform();

	}


	public void flexi_Shift_Selection() throws InterruptedException {

		/*
		 * This method is used to click the flexi shift
		 */
		By morning_shift_selection = By.xpath("//span[normalize-space()='General Shift']");

		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(morning_shift_selection)));
		Thread.sleep(1500);
		driver.findElement(morning_shift_selection).click();
	}

	public void shift_Selection_Check() throws InterruptedException {

		/*
		 * This method is used to check shift selection
		 */
		Thread.sleep(1500);

		By shift_drop_down_click = By.xpath("(//span[normalize-space()='General Shift'])[1]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(shift_drop_down_click)));
		String shift = driver.findElement(shift_drop_down_click).getText();
		
		//shift selection check
		Assert.assertEquals(shift, "General Shift", "Test failed - shift not selected or changed");

	}


	public void getting_Work_Hours_Check() {

		/*
		 * This method is used to check work hours is in green color
		 */
		By getting_work_hours_check = By.xpath("//*[local-name()='rect' and @fill='#13ae8b']");

		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(getting_work_hours_check)));
			String color = driver.findElement(getting_work_hours_check).getAttribute("fill");
			System.out.println(color);

			//work hours  colour visibility
			Assert.assertEquals(color, "#13ae8b", "Test failed - work hours is not in green color");

		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed - work hours is not in green color");
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
	}

	public void past_Day_From_Today() {

		/*
		 * This method is used to select past date from today
		 */
		By calendar_click_left_arrow = By.xpath("//a[@class='scrollDateArrowsBorder']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(calendar_click_left_arrow)));
		driver.findElement(calendar_click_left_arrow).click();

	}


	public void clicking_In_Time_Giving_Values() {

		/*
		 * This method is used to select the month
		 */

		By in_time_click = By.xpath("//div[normalize-space()='In Time']//parent::div//div[@class=\"col greenText s6\"]//div[@class=\"timeDiv\"]//input[@placeholder=\"In Time\"]");
		By clicking_set = By.xpath("//span[normalize-space()='Set']");
		By in_time_hours_giving = By.xpath("//div[@id=\"cdk-overlay-0\"]//button[@aria-label=\"Add a hour\"]//following-sibling::label//input");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(in_time_click)));
		driver.findElement(in_time_click).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(in_time_hours_giving)));
		driver.findElement(in_time_hours_giving).click();
		driver.findElement(in_time_hours_giving).clear();
		driver.findElement(in_time_hours_giving).sendKeys("09");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_set)));
		new Actions(driver).click(driver.findElement(clicking_set)).build().perform();

	}

	public void reset_Check() {

		/*
		 * This method is used to check the reset functionality
		 */

		By reset_click = By.xpath("(//div[@class=\"col timePart timemobBor s8\"]//img[contains(@src,\"reset\")])[2]");
		By reset_check = By.xpath("//div[normalize-space()='In Time']//parent::div//div[@class='col greenText s6']//div[@class='timeDiv']//input[@placeholder='In Time']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reset_click)));
		driver.findElement(reset_click).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reset_check)));
		String actual = driver.findElement(reset_check).getAttribute("value");
		System.out.println(actual);

		//reset check
		Assert.assertEquals(actual , "00:00", "Test failed - reset not working");

	}

	public void date_Selection_In_Calendar(String Day, String Month, String Year) throws InterruptedException {

		/*
		 * This method is used to select the date in calendar (Dynamic)
		 */
		By calendar_click = By.xpath("//input[@value='selectedDate']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(calendar_click)));
		driver.findElement(calendar_click).click();

		By calendar_click_month_tab = By.xpath("//button[@aria-label='Choose month and year']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(calendar_click_month_tab)));
		driver.findElement(calendar_click_month_tab).click();

		// WebElement calendar_click_Year =
		// driver.findElement(By.xpath("//td[@aria-label='2023']"));
		By calendar_click_Year = By.xpath("//td[@aria-label='" + Year + "']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(calendar_click_Year)));
		driver.findElement(calendar_click_Year).click();

		// WebElement calendar_click_Month =
		// driver.findElement(By.xpath("//td[@aria-label='March 2023']"));
		String month_Year = "" + Month + " " + Year + "";
		By calendar_click_Month = By.xpath("//td[@aria-label='" + month_Year + "']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(calendar_click_Month)));
		driver.findElement(calendar_click_Month).click();

		// WebElement calendar_click_date =
		// driver.findElement(By.xpath("//td[@aria-label='March 14, 2023']"));
		String month_day_Year = "" + Month + " " + Day + ", " + Year + "";
		By calendar_click_date = By.xpath("//td[@aria-label='" + month_day_Year + "']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(calendar_click_date)));
		driver.findElement(calendar_click_date).click();

		Thread.sleep(2000);

	}

	public void show_Variance_Records_Toggle_On() {

		/*
		 * This method is used to click the toggle on for show variance records in time
		 * records page
		 */
		By show_variance_records_toggle_on = By.xpath("//label[@for='timeRequestShowExceptions']//span");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(show_variance_records_toggle_on)));
		new Actions(driver).click(driver.findElement(show_variance_records_toggle_on)).build().perform();

		loader_Wait();

	}

	public void search_Value_Passing_For_Meal_Allowance() {

		/*
		 * This method is used to search Value passing for meal allowance
		 */
		By search_Value_passing_for_meal_allowance = By.xpath("//universal-list-view[@appcode=\"time\"]//div[@class=\"universalViewSearch ng-star-inserted\"]//input[@name=\"universalListSearch\"]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_Value_passing_for_meal_allowance)));
		new Actions(driver).click(driver.findElement(search_Value_passing_for_meal_allowance)).build().perform();
		driver.findElement(search_Value_passing_for_meal_allowance).clear();
		driver.findElement(search_Value_passing_for_meal_allowance).sendKeys("00:30");
		By search_get = By.xpath("//span[@id=\"taMyRecordsOTSHApprovalViewUniqueCodetableDataColumn00\"]//span");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_get)));
		String value1 = driver.findElement(search_get).getText();
		driver.findElement(search_Value_passing_for_meal_allowance).clear();
		driver.findElement(search_Value_passing_for_meal_allowance).sendKeys(value1);

	}

	public void checking_For_Meal_Allowance() {

		/*
		 * This method is used to check the meal allowance
		 */
		By checking_meal_allowance_Time = By.xpath("//tr[contains(@class,\"sub-container table\")]//td[normalize-space()='Meal Allowance']//following-sibling::td//span//span//span");
		By checking_allowance = By.xpath("//tr[contains(@class,\"sub-container table\")]//td[normalize-space()='Meal Allowance']//span//span//span");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(checking_meal_allowance_Time)));
		String Time = driver.findElement(checking_meal_allowance_Time).getText();

		//meal allowance time check 
		Assert.assertEquals(Time, "00:30","Test failed - meal allowance time is wrong");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(checking_allowance)));
		String allowance = driver.findElement(checking_allowance).getText();

		//allowance name check
		Assert.assertEquals(allowance, "Meal Allowance","Test failed - allowance mismatch");
	}

	public void past_Month_Selection() {

		/*
		 * This method is used to select the month
		 */

		WebElement calendar_click = driver.findElement(By.xpath("//input[@value=\"selectedDate\"]"));
		wait.until(ExpectedConditions.visibilityOf(calendar_click));
		calendar_click.click();

		WebElement calendar_click_month_tab = driver.findElement(By.xpath("//button[@aria-label=\"Choose month and year\"]"));
		wait.until(ExpectedConditions.visibilityOf(calendar_click_month_tab));
		calendar_click_month_tab.click();

		WebElement calendar_click_Year = driver.findElement(By.xpath("//td[@aria-label=\"2023\"]"));
		wait.until(ExpectedConditions.visibilityOf(calendar_click_Year));
		calendar_click_Year.click();

		WebElement calendar_click_Month = driver.findElement(By.xpath("//td[@aria-label=\"March 2023\"]"));
		wait.until(ExpectedConditions.visibilityOf(calendar_click_Month));
		calendar_click_Month.click();

		WebElement calendar_click_date = driver.findElement(By.xpath("//td[@aria-label=\"March 14, 2023\"]"));
		wait.until(ExpectedConditions.visibilityOf(calendar_click_date));
		calendar_click_date.click();

	}


	public void in_Time_Click(String start_Time_Hours, String start_Time_Minutes) throws InterruptedException {

		/*
		 * This method is used to click the in time
		 */
		By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
		By clicking_set = By.xpath("//span[normalize-space()='Set']");
		By In_time = By.xpath("//div[normalize-space()='In Time']//parent::div//div//input[@id='manualKeyInOut_InTimeID']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(In_time)));
		Thread.sleep(1200);
		action.click(driver.findElement(In_time)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
		driver.findElement(Start_time_hours_giving).click();
		driver.findElement(Start_time_hours_giving).clear();
		driver.findElement(Start_time_hours_giving).sendKeys(start_Time_Hours);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
		driver.findElement(Start_time_minutes_giving).click();
		driver.findElement(Start_time_minutes_giving).clear();
		driver.findElement(Start_time_minutes_giving).sendKeys(start_Time_Minutes);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_set)));
		new Actions(driver).click(driver.findElement(clicking_set)).build().perform();

	}

	public void out_Time_Click(String start_Time_Hours, String start_Time_Minutes) {

		/*
		 * This method is used to click the out time
		 */
		By out_time = By.xpath("(//div[normalize-space()='Out Time']//parent::div//parent::div//div//input[@placeholder='Out Time'])[2]");
		By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
		By clicking_set = By.xpath("//span[normalize-space()='Set']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(out_time)));
		new Actions(driver).click(driver.findElement(out_time)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
		driver.findElement(Start_time_hours_giving).click();
		driver.findElement(Start_time_hours_giving).clear();
		driver.findElement(Start_time_hours_giving).sendKeys(start_Time_Hours);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
		driver.findElement(Start_time_minutes_giving).click();
		driver.findElement(Start_time_minutes_giving).clear();
		driver.findElement(Start_time_minutes_giving).sendKeys(start_Time_Minutes);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_set)));
		new Actions(driver).click(driver.findElement(clicking_set)).build().perform();

	}

	public void edit_Button_Click() {

		/*
		 * This method is used to click the edit button
		 */

		By edit_click = By.xpath("//button[contains(@class,'editTime') and @title='Edit Time']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(edit_click)));
		new Actions(driver).click(driver.findElement(edit_click)).build().perform();
	}

	public void tick_Icon_Click() {

		/*
		 * This method is used to click the tick icon
		 */

		By tick_click = By.xpath("//div[@class=\"col s4 show\"]//a[@title=\"Save\"]//img");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(tick_click)));
		new Actions(driver).click(driver.findElement(tick_click)).build().perform();
	}

	public void giving_Comment() {

		/*
		 * This method is used to give comment
		 */

		By giving_Comment = By.xpath("(//textarea[@placeholder='Enter Your Comment here'])[1]");
		By send = By.xpath("//div[@title='Send']//a//img");
		By submit = By.xpath("//div[@class='modal-footer']//div[@title='Submit']//a//parent::div");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(giving_Comment)));
		new Actions(driver).click(driver.findElement(giving_Comment)).build().perform();
		driver.findElement(giving_Comment).clear();
		driver.findElement(giving_Comment).sendKeys("test");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(send)));
		new Actions(driver).click(driver.findElement(send)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(submit)));
		new Actions(driver).click(driver.findElement(submit)).build().perform();

		loader_Wait();
	}
	
	public void giving_Manager_Comment() {

		/*
		 * This method is used to give comment
		 */

		By giving_Comment = By.xpath("(//textarea[@placeholder='Enter Your Comment here'])[1]");
		By send = By.xpath("//div//a[@title='Send' and not(@class) and not(@id=\"sendingIcon\")]//img");
		By submit = By.xpath("//div//button[@id=\"submitApproveHover\"]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(giving_Comment)));
		new Actions(driver).click(driver.findElement(giving_Comment)).build().perform();
		driver.findElement(giving_Comment).clear();
		driver.findElement(giving_Comment).sendKeys("test");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(send)));
		new Actions(driver).click(driver.findElement(send)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(submit)));
		new Actions(driver).click(driver.findElement(submit)).build().perform();

		loader_Wait();
	}

	public void toaster_Message_Check_Time_Entry() {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = "Entry added Successfully";
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			// toaster message check
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void toaster_Message_Check_OT_Approval() {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = "Approved Successfully";
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			// toaster message check
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
	}

	public void toaster_Message_Check_Time_Entry_Partial_Save() {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = "Partially saved the record";
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			// toaster message check
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	public void summary_Edit() throws InterruptedException {

		/*
		 * This method is used to do Summary Editt
		 */

		try {
			By reasontype = By.xpath("(//div[@class='ng-placeholder' and normalize-space()='Select Reason Type'])[2]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype)));
			new Actions(driver).click(driver.findElement(reasontype)).build().perform();

		} catch (Exception e) {
			By clearselection = By.xpath("(//ng-select[@placeholder='Select Reason Type']//parent::div//span[@title='Clear all'])[2]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(clearselection)));
			new Actions(driver).click(driver.findElement(clearselection)).build().perform();

			By reasontype = By.xpath("(//div[@class='ng-placeholder' and normalize-space()='Select Reason Type'])[2]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype)));
			new Actions(driver).click(driver.findElement(reasontype)).build().perform();
		}

		By optionselect = By.xpath("//div[@role='option']//span[normalize-space()='Special Working Hours']");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(optionselect)));
		new Actions(driver).click(driver.findElement(optionselect)).build().perform();

	}

	public void in_Time_Edit(String start_Time_Hours, String start_Time_Minutes) {

		/*
		 * This method is used to edit in time
		 */

		By intimeclick = By.xpath("//input[@id='timeLiteInTimeId']");
		By in_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By in_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
		By clicking_set = By.xpath("//span[normalize-space()='Set']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		new Actions(driver).click(driver.findElement(intimeclick)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(in_time_hours_giving)));
		driver.findElement(in_time_hours_giving).click();
		driver.findElement(in_time_hours_giving).clear();
		driver.findElement(in_time_hours_giving).sendKeys(start_Time_Hours);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(in_time_minutes_giving)));
		driver.findElement(in_time_minutes_giving).click();
		driver.findElement(in_time_minutes_giving).clear();
		driver.findElement(in_time_minutes_giving).sendKeys(start_Time_Minutes);

		new Actions(driver).click(driver.findElement(clicking_set)).build().perform();
	}
	
	public void reset_Checking(){
		//Checking all fields empty or not
		By intimeclick = By.xpath("//input[@id='timeLiteInTimeId']");
		By outtimeclick = By.xpath("//input[@id='timeLiteOutTimeId']");
		By reasontype = By.xpath("(//div[normalize-space()='Reason Type']//parent::div//div[@id=\"recordType\"])[2]");
		By resetclick = By.xpath("(//div//button[@title='Reset'])[1]");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype)));
		String before_reasontype =driver.findElement(reasontype).getText();
		System.out.println(  before_reasontype  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		String before_in =driver.findElement(intimeclick).getAttribute("value");
		System.out.println(  before_in  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(outtimeclick)));
		String before_out =driver.findElement(outtimeclick).getAttribute("value");
		System.out.println(  before_out  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(resetclick)));
		action.click(driver.findElement(resetclick)).build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype)));
		String after_reasontype =driver.findElement(reasontype).getText();
		System.out.println(  after_reasontype  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		String after_in =driver.findElement(intimeclick).getAttribute("value");
		System.out.println(  after_in  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(outtimeclick)));
		String after_out =driver.findElement(outtimeclick).getAttribute("value");
		System.out.println(  after_out  );
		
		Assert.assertNotEquals(before_reasontype,  after_reasontype , "Test failed - reason type entry not removed");
		Assert.assertNotEquals(before_in,  after_in ,"Test failed - in time not removed");
		Assert.assertNotEquals(before_out,  after_out ,"Test failed - out time not removed");
		
		Assert.assertEquals(  after_reasontype, "Select Reason Type" , "Test failed - reason type entry not removed");
		//AssertassertTrue() change to is empty // input
		Assert.assertEquals( after_in,"" ,"Test failed - in time not removed");
		Assert.assertEquals(  after_out,"" ,"Test failed - out time not removed");
	}
	

	public void out_Time_Edit(String start_Time_Hours, String start_Time_Minutes) {

		/*
		 * This method is used to edit out time
		 */

		By intimeclick = By.xpath("//input[@id='timeLiteOutTimeId']");
		By in_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By in_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
		By clicking_set = By.xpath("//span[normalize-space()='Set']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		new Actions(driver).click(driver.findElement(intimeclick)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(in_time_hours_giving)));
		driver.findElement(in_time_hours_giving).click();
		driver.findElement(in_time_hours_giving).clear();
		driver.findElement(in_time_hours_giving).sendKeys(start_Time_Hours);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(in_time_minutes_giving)));
		driver.findElement(in_time_minutes_giving).click();
		driver.findElement(in_time_minutes_giving).clear();
		driver.findElement(in_time_minutes_giving).sendKeys(start_Time_Minutes);

		new Actions(driver).click(driver.findElement(clicking_set)).build().perform();
	}

	public void save_Click() {

		/*
		 * This method is used to click save
		 */

		By saveclick = By.xpath("//div[contains(@class,'summaryTimeEditCommonAction')]//button[@title='Save']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(saveclick)));
		new Actions(driver).click(driver.findElement(saveclick)).build().perform();
	}

	public void toaster_Message_Check() {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = "Updated Successfully";
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			// toaster message check
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	public void time_Edit_Page_Close() {

		/*
		 * This method is used to close edit page
		 */

		try {
		By close = By.xpath("(//div//a[@title='Close']//img[contains(@src,'widgetClose.svg')])[1]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(close)));
		new Actions(driver).click(driver.findElement(close)).build().perform();

		loader_Wait();
		} catch (Exception e) {
			
		}

	}

	public void out_Time_Click_Bod(String Day, String Month, String Year, String start_Time_Hours,
			String start_Time_Minutes) {

		/*
		 * This method is used to click the out time
		 */

		By out_time = By.xpath("(//div[normalize-space()='Out Time']//parent::div//parent::div//div//input[@placeholder='Out Time'])[2]");
		By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
		By clicking_set = By.xpath("//span[normalize-space()='Set']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(out_time)));
		new Actions(driver).click(driver.findElement(out_time)).build().perform();

		By calendar_click_month_tab = By.xpath("//button[@aria-label='Choose month and year']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(calendar_click_month_tab)));
		driver.findElement(calendar_click_month_tab).click();

		// WebElement calendar_click_Year =
		// driver.findElement(By.xpath("//td[@aria-label='2023']"));
		By calendar_click_Year = By.xpath("//td[@aria-label='" + Year + "']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(calendar_click_Year)));
		driver.findElement(calendar_click_Year).click();

		// WebElement calendar_click_Month =
		// driver.findElement(By.xpath("//td[@aria-label='March 2023']"));
		String month_Year = "" + Month + " " + Year + "";
		By calendar_click_Month = By.xpath("//td[@aria-label='" + month_Year + "']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(calendar_click_Month)));
		driver.findElement(calendar_click_Month).click();

		// WebElement calendar_click_date =
		// driver.findElement(By.xpath("//td[@aria-label='March 14, 2023']"));
		String month_day_Year = "" + Month + " " + Day + ", " + Year + "";
		By calendar_click_date = By.xpath("//td[@aria-label='" + month_day_Year + "']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(calendar_click_date)));
		driver.findElement(calendar_click_date).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
		driver.findElement(Start_time_hours_giving).click();
		driver.findElement(Start_time_hours_giving).clear();
		driver.findElement(Start_time_hours_giving).sendKeys(start_Time_Hours);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
		driver.findElement(Start_time_minutes_giving).click();
		driver.findElement(Start_time_minutes_giving).clear();
		driver.findElement(Start_time_minutes_giving).sendKeys(start_Time_Minutes);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_set)));
		new Actions(driver).click(driver.findElement(clicking_set)).build().perform();

	}
	
	public ArrayList<String> collect_Time() {
		ArrayList<String> total_time_hours = new ArrayList<String>();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE M/d/yyy hh:mm a");
        LocalDateTime now = LocalDateTime.now();
        String date_and_time = dtf.format(now);
        //System.out.println(date_and_time);
        
        String a[] = date_and_time.split(" ");
        String b[] = a[2].split(":");
        
        String hour = b[0];
        String am_or_pm = a[3];
        String minutes = b[1];
        
        total_time_hours.add( hour );
        total_time_hours.add( am_or_pm );
        total_time_hours.add( minutes );
        return total_time_hours;
		
	}
	
	  public void changeWaitTime(int time) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	    }

	public void check_Exception_Date_Reflect_In_Calendar() throws InterruptedException {

		changeWaitTime(10);
        By exception_date = By.xpath("//div[@id='activeid0']");
        By calender_exception_date = By.xpath("//div//input[@value='selectedDate']");
        By next_arrow_button = By.xpath("(//div[@class='col arrowsActive s1']//a[@title='Next']//i[normalize-space()='chevron_right'])[2]");

        String dial_name[] = {"Late In", "Early Out", "Short Hours", "Absent", "Half Day"};
        for (int i = 0; i < dial_name.length; i++) {
            System.out.println(dial_name[i]);
            WebElement dial = driver.findElement(By.xpath("//div//span[@class='lateInSpan' and normalize-space()='" + dial_name[i] + "']"));

            try {
                wait.until(ExpectedConditions.visibilityOf(dial));
            } catch (Exception e) {
                for (int m = 0; m < dial_name.length; m++){
                    if (dial.isDisplayed()) {
                        Assert.assertTrue(true);
                        break;
                    } else {
                    	/*
                    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(next_arrow_button)));
                    	Thread.sleep(1500);
                        driver.findElement(next_arrow_button).click();
                        */
                    	my_Statistics_Right_Arrow_Click();
                    	
                    }
                }


            }

            String dials_value[] = {"lateInBar", "earlyOutBar", "shortHoursBar", "absentBar", "halfDayBar"};
            for (int j = 0; j < dials_value.length; j++) {
                System.out.println(dials_value[i]);
                WebElement total_dials_exception = driver.findElement(By.xpath("//div[@id='" + dials_value[i] + "']//span[@class='lateInCountCss']"));
                wait.until(ExpectedConditions.visibilityOf((dial)));
                String dials_count = total_dials_exception.getText();
                System.out.println(dials_count);
                int dials_counts = Integer.parseInt(dials_count);
                System.out.println(dials_count);

                if (dials_counts > 0) {

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" MMM YYYY");
                    LocalDateTime now = LocalDateTime.now();
                    String date_and_time = dtf.format(now);
                    System.out.println(date_and_time);

                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(exception_date)));
                    String exceptiondate = driver.findElement(exception_date).getText();
                    System.out.println(exceptiondate);
                    try {
                        driver.findElement(exception_date).click();
                    } catch (Exception e) {
                        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(exception_date))));
                        driver.findElement(exception_date).click();
                    }

                    String exceptiondate_value = exceptiondate + date_and_time;

                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(calender_exception_date)));
                    String calendardate = driver.findElement(calender_exception_date).getAttribute("value");
                    System.out.println(calendardate);
                    Assert.assertEquals(exceptiondate_value, calendardate, "Test Failed- Values are not matching");
                    break;
                } else {
                    break;
                }
            }
            Assert.assertFalse(false);
            for(int q=0;q<11;q++) {
                my_Statistics_Left_Arrow_Click();
            }

        }


        changeWaitTime(15);
    }


    public void check_Exception_Symbol_Reflect_In_Calendar() throws Exception {
    	changeWaitTime(10);

        By exception_date = By.xpath("//div[@id='activeid0']");
        By calender_exception_date = By.xpath("//div//input[@value='selectedDate']");
        By next_arrow_button = By.xpath("(//div[@class='col arrowsActive s1']//a[@title='Next']//i[normalize-space()='chevron_right'])[2]");

        String dial_name[] = {"Late In", "Early Out", "Short Hours", "Absent", "Half Day"};
        for (int i = 0; i < dial_name.length; i++) {
            System.out.println(dial_name[i]);
            WebElement dial = driver.findElement(By.xpath("//div//span[@class='lateInSpan' and normalize-space()='" + dial_name[i] + "']"));

            try {
                wait.until(ExpectedConditions.visibilityOf(dial));
            } catch (Exception e) {
                for (int m = 0; m < dial_name.length; m++){
                    if (dial.isDisplayed()) {
                        Assert.assertTrue(true);
                        break;
                    } else {
                    	/*
                    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(next_arrow_button)));
                    	Thread.sleep(1500);
                        driver.findElement(next_arrow_button).click();
                        */
                    	my_Statistics_Right_Arrow_Click();
                    }
                }
            }

            String dials_value[] = {"lateInBar", "earlyOutBar", "shortHoursBar", "absentBar", "halfDayBar"};
            String symbol[] = {"Late In", "Early Out", "Absent", "Absent", "Half Day"};
            for (int j = 0; j < dials_value.length; j++) {
                System.out.println(dials_value[i]);
                WebElement total_dials_exception = driver.findElement(By.xpath("//div[@id='" + dials_value[i] + "']//span[@class='lateInCountCss']"));
                wait.until(ExpectedConditions.visibilityOf((dial)));
                String dials_count = total_dials_exception.getText();
                System.out.println(dials_count);
                int dials_counts = Integer.parseInt(dials_count);
                System.out.println(dials_count);

                if (dials_counts > 0) {

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" MMM YYYY");
                    LocalDateTime now = LocalDateTime.now();
                    String date_and_time = dtf.format(now);
                    System.out.println(date_and_time);

                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(exception_date)));
                    String exceptiondate = driver.findElement(exception_date).getText();
                    System.out.println(exceptiondate);
                    try {
                        driver.findElement(exception_date).click();
                    } catch (Exception e) {
                        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(exception_date))));
                        driver.findElement(exception_date).click();
                    }

                    String exceptiondate_value = exceptiondate + date_and_time;

                    wait.until(ExpectedConditions.visibilityOf(driver.findElement(calender_exception_date)));
                    String calendardate = driver.findElement(calender_exception_date).getAttribute("value");
                    System.out.println(calendardate);

                    for (int k = 0; k < symbol.length; k++) {

                        k = i;
                        WebElement dial_click = driver.findElement(By.xpath("//div//span[normalize-space()='" + dial_name[k] + "']"));
                        Thread.sleep(1500);
                        wait.until(ExpectedConditions.visibilityOf(dial_click));
                        action.click(dial_click).build().perform();

                        Thread.sleep(1500);

                        WebElement date_click = driver.findElement(By.xpath("(//div[normalize-space()='Exception Dates']//parent::div//div[contains(@id,'activeid')])[1]"));
                        wait.until(ExpectedConditions.visibilityOf(date_click));
                        action.click(date_click).build().perform();

                        WebElement exception_Symbol = driver.findElement(By.xpath("//img[@alt='" + symbol[k] + "']"));

                        if (exception_Symbol.isDisplayed()) {
                            String Symbols = exception_Symbol.getAttribute("alt");
                            Assert.assertEquals(Symbols, symbol[k], "test failed - no exception symbol is not showing");
                            break;
                        } else {

                        }
                    }
                    Assert.assertEquals(exceptiondate_value, calendardate, "Test Failed- Values are not matching");
                    break;
                } else {
                    break;
                }
            }
            Assert.assertFalse(false);
            for(int q=0;q<11;q++) {
                my_Statistics_Left_Arrow_Click();
            }
        }

        changeWaitTime(15);

    }
    public void configure_Action_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column action icon in the time
		 */
		By configure_action_click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Action']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_action_click)));
		Thread.sleep(1000);
		driver.findElement(configure_action_click).click();

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
    
    public void selection() throws InterruptedException {
		configure_Column_Click();
		configure_Column_Select_All_Click();
		configure_Action_Click();
		configure_Column_Date_Click();
		configure_Column_Save_Click();

    }


}