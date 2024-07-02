package time_application.pages.manual_key_in_and_out_mss_pages;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

public class Mss_Home_Page {

	public WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	public Actions action;
	public JavascriptExecutor javascriptexecutor;

	public Mss_Home_Page(WebDriver driver, Actions action, Properties prop, WebDriverWait wait,
			JavascriptExecutor javascriptexecutor) {
		this.driver = driver;
		this.prop = prop;
		this.wait = wait;
		this.action = action;
		this.javascriptexecutor = javascriptexecutor;
	}

	public void my_Statistics_All_Widget_Visible_Check() throws InterruptedException {

		/*
		 * This method is used to click and check all the icons in my statistics is
		 * visible or not
		 */

		List<WebElement> total_dial = driver.findElements(
				By.xpath("//div[contains(@class,'col dailDivc')]//div//div//following-sibling::div//span"));
		String dial_name[] = { "Late In", "Early Out", "Absent", "Half Day" };
		for (int i = 0; i < dial_name.length; i++) {
			System.out.println(dial_name[i]);
			WebElement dial = driver.findElement(
					By.xpath("//div//span[@class='lateInSpan' and normalize-space()='" + dial_name[i] + "']"));
			try {
				wait.until(ExpectedConditions.visibilityOf(dial));
				String late_in_actual = dial.getText();
				String late_in_expected = dial_name[i];
				// checking the widget
				Assert.assertEquals(late_in_actual, late_in_expected, "Test failed -" + dial_name[i] + "not showing");
			} catch (Exception e) {

				for (int j = 0; j < total_dial.size(); j++) {
					if (dial.isDisplayed()) {
						String late_in_actual = dial.getText();
						String late_in_expected = dial_name[i];
						// checking the widget
						Assert.assertEquals(late_in_actual, late_in_expected,
								"Test failed -" + dial_name[i] + " not showing");
						break;
					} else {
						my_Statistics_Right_Arrow_Click();
					}
				}
			}

			for (int k = 0; k < dial_name.length; k++) {
				my_Statistics_Left_Arrow_Click();
			}
		}
	}
	
	public void reset_Checking(){
		//Checking all fields empty or not
		By intimeclick = By.xpath("//input[@id='timeLiteInTimeId']");
		By outtimeclick = By.xpath("//input[@id='timeLiteOutTimeId']");
		By reasontype = By.xpath("(//div[normalize-space()='Reason Type']//parent::div//div[@id=\"recordType\"])[2]");
		By resetclick = By.xpath("(//div//button[@title='Reset' and contains(@class,\"timeEditSave\")])[1]");
		
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
		
		Assert.assertEquals( after_in,"" ,"Test failed - in time not removed");
		Assert.assertEquals(  after_out,"" ,"Test failed - out time not removed");
	}
	


	public void my_Statistics_Right_Arrow_Click() {

		/*
		 * This method is used to click My Statistics right arrow
		 */
		By right_arrow_click_2 = By.xpath("(//a[@title='Next'])[3]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(right_arrow_click_2)));
		driver.findElement(right_arrow_click_2).click();

	}

	public void my_Statistics_Left_Arrow_Click() {

		/*
		 * This method is used to click My Statistics right arrow
		 */
		By My_Statistics_left_arrow_click = By.xpath("(//a[@title='Previous'])[2]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(My_Statistics_left_arrow_click)));
		driver.findElement(My_Statistics_left_arrow_click).click();

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

			// work hours colour visibility
			Assert.assertEquals(color, "#13ae8b", "Test failed - work hours is not in green color");

		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed - work hours is not in green color");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shift_Hour_Check() {

		/*
		 * This method is used to check the shift by hovering on i icon
		 */
		By shift_hour_check = By.xpath(
				"(//div[text()='Shift Time']//parent::div//div[@id=\"toatlBalanceIicon\"]//a//i[normalize-space()='info_outline'])[1]");
		By shift_hour_check_I_icon = By.xpath(
				"(//div[text()='Shift Time']//parent::div//div[@id=\"toatlBalanceIicon\"]//div[@class=\"timeTooltiptext\"]//div)[1]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(shift_hour_check)));
		new Actions(driver).click(driver.findElement(shift_hour_check)).build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(shift_hour_check_I_icon)));
		String shift = driver.findElement(shift_hour_check_I_icon).getText();

		// shift check
		Assert.assertEquals(shift, "Shift : Flexi Shift", "Test failed - shift is not showing properly");

	}

	public void shift_Selection_Check() throws InterruptedException {

		/*
		 * This method is used to check shift selection
		 */
		Thread.sleep(1500);

		By shift_drop_down_click = By.xpath("(//span[normalize-space()='General Shift'])[1]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(shift_drop_down_click)));
		String shift = driver.findElement(shift_drop_down_click).getText();

		// shift selection check
		Assert.assertEquals(shift, "General Shift", "Test failed - shift not selected or changed");

	}

	public void morning_Shift_Selection() throws InterruptedException {

		/*
		 * This method is used to click the flexi shift
		 */
		
		By morning_shift_selection = By.xpath("//span[normalize-space()='Morning Shift(10:00 to 18:00)']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(morning_shift_selection)));
		
		action.click(driver.findElement(morning_shift_selection)).build().perform();
		//driver.findElement(morning_shift_selection).click();
		
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

	public void shift_Drop_Down_Click() throws Exception {

		/*
		 * This method is used to click the shift drop down
		 */
		Thread.sleep(1500);
		By shift_drop_down_click = By.xpath("(//div[@role='combobox']//input)[3]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(shift_drop_down_click)));
		Thread.sleep(1500);
		new Actions(driver).click(driver.findElement(shift_drop_down_click)).build().perform();

	}

	public void Time_Zone_Check() {

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Clicking_Back_And_Front_Calendar_Navigation() {

		/*
		 * This method is used to check date is getting changed when we use navigation
		 * arrows
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
		Assert.assertEquals(date_and_time, current_date, "Test failed today button not working");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(back_arrow_click)));
		driver.findElement(back_arrow_click).click();

		String past_date = driver.findElement(Date).getAttribute("value");
		System.out.println("value is  -- " + past_date);

		// checking the date gets changes
		Assert.assertNotEquals(current_date, past_date, "Test failed because date didn't get changed");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(forward_arrow_click)));
		driver.findElement(forward_arrow_click).click();

		String current_date_present = driver.findElement(Date).getAttribute("value");
		System.out.println("value is  -- " + current_date_present);

		// checking the date gets changes
		Assert.assertEquals(current_date, current_date_present, "Test failed because date didn't get changed");

	}

	public void Today_Click_Validate() {

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
		Assert.assertEquals(date_and_time, current_date, "Test failed today button not working");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(back_arrow_click)));
		driver.findElement(back_arrow_click).click();

		String past_date = driver.findElement(Date).getAttribute("value");
		System.out.println("value is  -- " + past_date);

		// checking the date gets changes
		Assert.assertNotEquals(current_date, past_date, "Test failed because date didn't get changed");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Today_button_click)));
		driver.findElement(Today_button_click).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Today_button_click_Date)));
		String Today_button_click_date = driver.findElement(Date).getAttribute("value");

		// checking the date gets changes
		Assert.assertEquals(current_date, Today_button_click_date, "Test failed because date didn't get changed");

	}

	public void loader_wait() {

		/*
		 * This method is used to make wait until the loader image gets disappear
		 */

		List<WebElement> heading_check = driver.findElements(By.xpath("//div//img[contains(@src,'gif')]"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
	}

	public void loader_wait_Toaster() {

		/*
		 * This method is used to make wait until the toaster image gets disappear
		 */

		List<WebElement> loader_wait_Toaster = driver.findElements(By.xpath("//div[@id='toast-container']"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(loader_wait_Toaster));
	}

	public void configure_column_save_click() {

		/*
		 * This method is used to click the configure column save icon in the time
		 * record page
		 */

		WebElement configure_column_save_click = driver.findElement(By.xpath("(//div[@class=\"saveBox\"])[2]"));
		wait.until(ExpectedConditions.visibilityOf(configure_column_save_click));
		configure_column_save_click.click();

		loader_wait_Toaster();
	}

	public void Apply_leave() {

		/*
		 * This method is used to check apply leave button is working and its page is
		 * getting open or not
		 */
		By Apply_leave = By.xpath("//button[@title='Apply Leave']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Apply_leave)));
		String button_check = driver.findElement(Apply_leave).getText();
		// Apply leave page opening check
		Assert.assertEquals(button_check, "Apply Leave", "test failed - button not available");
		driver.findElement(Apply_leave).click();

		try {
			By Apply_leave_window = By.xpath("//div//b[normalize-space()='Apply Leave']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(Apply_leave_window)));
			String window_check = driver.findElement(Apply_leave_window).getText();
			// Apply leave page opening check
			Assert.assertEquals(window_check, "Apply Leave", "test failed - window not available");

			By Apply_leave_window_close = By.xpath("//i[@title='Close']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(Apply_leave_window_close)));
			driver.findElement(Apply_leave_window_close).click();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed page is not openend properly");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void date_selection_in_calendar(String Day, String Month, String Year) {

		/*
		 * This method is used to select the date in calendar
		 */

		WebElement calendar_click = driver.findElement(By.xpath("//input[@value='selectedDate']"));
		wait.until(ExpectedConditions.visibilityOf(calendar_click));
		calendar_click.click();

		WebElement calendar_click_month_tab = driver
				.findElement(By.xpath("//button[@aria-label='Choose month and year']"));
		wait.until(ExpectedConditions.visibilityOf(calendar_click_month_tab));
		calendar_click_month_tab.click();

		// WebElement calendar_click_Year =
		// driver.findElement(By.xpath("//td[@aria-label='2023']"));
		WebElement calendar_click_Year = driver.findElement(By.xpath("//td[@aria-label='" + Year + "']"));
		wait.until(ExpectedConditions.visibilityOf(calendar_click_Year));
		calendar_click_Year.click();

		// WebElement calendar_click_Month =
		// driver.findElement(By.xpath("//td[@aria-label='March 2023']"));
		String month_Year = "" + Month + " " + Year + "";
		WebElement calendar_click_Month = driver.findElement(By.xpath("//td[@aria-label='" + month_Year + "']"));
		wait.until(ExpectedConditions.visibilityOf(calendar_click_Month));
		calendar_click_Month.click();

		// WebElement calendar_click_date =
		// driver.findElement(By.xpath("//td[@aria-label='March 14, 2023']"));
		
		String month_day_Year = "" + Month + " " + Day + ", " + Year + "";
		WebElement calendar_click_date = driver.findElement(By.xpath("//td[@aria-label='" + month_day_Year + "']"));
		wait.until(ExpectedConditions.visibilityOf(calendar_click_date));
		calendar_click_date.click();
		
		

	}
	
	public ArrayList<String> absent_Dates_Extraction_In_Time_Records() {

		/*
		 * This method is used to extract absent dates in time records and it returns the date numbers as array list
		 */

		ArrayList<String> dates = new ArrayList<String>();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM");
	    LocalDateTime now2 = LocalDateTime.now();
	    String date_and_time2 = dtf.format(now2);
	    System.out.println(date_and_time2 );

		List<WebElement> total_time_add = driver.findElements(By.xpath("//table//tbody//tr//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span//span//span[contains(normalize-space(),'"+date_and_time2+"')]"));

		String value = "-"+date_and_time2+"";
		for (int i = 0; i < total_time_add.size(); i++) {
			String temp_message = total_time_add.get(i).getText();
			String[] time = temp_message.split(value);

			dates.add(time[0]);
		}
		System.out.println("days  - " + dates);

		return dates;
	}
	
	 public void changeWaitTime(int time) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	    }

	
	public void check_Exception_Symbol_Reflect_In_Calendar() throws Exception {
		 for(int q=0;q<3;q++) {
         	Thread.sleep(500);
             my_Statistics_Left_Arrow_Click();
         }
		 
    	changeWaitTime(10);

        By exception_date = By.xpath("//div[@id='activeid0']");
        By calender_exception_date = By.xpath("//div//input[@value='selectedDate']");
        By next_arrow_button = By.xpath("(//div[@class='col arrowsActive s1']//a[@title='Next']//i[normalize-space()='chevron_right'])[2]");

        String dial_name[] = {"Late In", "Early Out", "Absent", "Half Day"};
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

            String dials_value[] = {"lateInBar", "earlyOutBar", "absentBar", "halfDayBar"};
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
            for(int q=0;q<3;q++) {
            	Thread.sleep(500);
                my_Statistics_Left_Arrow_Click();
            }
        }

        changeWaitTime(15);

    }



}
