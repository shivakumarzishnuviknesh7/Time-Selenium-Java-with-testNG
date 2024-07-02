package time_application.pages.manual_key_in_and_out_ess_pages;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Time_Records_Page {

	public WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	public Actions action;
	public JavascriptExecutor javascriptexecutor;

	public Time_Records_Page(WebDriver driver, Actions action, Properties prop, WebDriverWait wait,
			JavascriptExecutor javascriptexecutor) {
		this.driver = driver;
		this.prop = prop;
		this.wait = wait;
		this.action = action;
		this.javascriptexecutor = javascriptexecutor;
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

	public void configure_Column_Intime_Click() {

		By configure_Column_Intime_Click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='In Time']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Column_Intime_Click)));
		driver.findElement(configure_Column_Intime_Click).click();
	}

	public void configure_Column_outtime_Click() {

		By configure_Column_outtime_Click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Out Time']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Column_outtime_Click)));
		driver.findElement(configure_Column_outtime_Click).click();
	}

	public void search_Validation() {

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

		By search_value_check = By.xpath("//span//span//span[normalize-space()='"+value1+"']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_value_check)));
		String value = driver.findElement(search_value_check).getText();

		Assert.assertEquals(value, value1, "Test failed search not  working");
		driver.findElement(search_validation).clear();

	}

	public void detail_Download_Click() throws InterruptedException {

		/*
		 * This method is used to click the detail download icon in the time record page
		 */
		
		
		By detail_download_click = By.xpath("//div[@id='taEmployeeSummaryViewUniqueCodeadvanceFilter31']//img");

		try {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(detail_download_click)));
		Thread.sleep(2000);
		driver.findElement(detail_download_click).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Test failed - download button is not in web");
		}

	}
	
	public void download_Click() throws InterruptedException {

		/*
		 * This method is used to click the detail download icon in the time record page
		 */
		
		
		By download_click = By.xpath("//div//img[contains(@src,\"stp_Download.svg\")]");

		try {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(download_click)));
		Thread.sleep(2000);
		driver.findElement(download_click).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Test failed - download button is not in web");
		}

	}

	public void configure_Column_Pay_Group_Click() {

		/*
		 * This method is used to click the configure column pay group icon in the time
		 * record page
		 */
		By configure_column_pay_group_click = By.xpath(
				"//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Pay Groups']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_pay_group_click)));
		driver.findElement(configure_column_pay_group_click).click();

	}

	public void configure_Status_Click() {

		/*
		 * This method is used to click the configure column status icon in the time
		 * record page
		 */
		By configure_Status_Click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Status']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Status_Click)));
		driver.findElement(configure_Status_Click).click();

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

	public void configure_Column_Payment_Name_Click() {

		/*
		 * This method is used to click the configure column payment name icon in the
		 * time record page
		 */
		By configure_Column_Payment_Name_Click = By
				.xpath("//ul//label[@class='listview_marLeft']//span[@title='Payment Name']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Column_Payment_Name_Click)));
		driver.findElement(configure_Column_Payment_Name_Click).click();

	}

	public void configure_Processing_From_Click() {

		/*
		 * This method is used to click the configure column processing from icon in the
		 * time record page
		 */
		By configure_Processing_From_Click = By
				.xpath("//ul//label[@class='listview_marLeft']//span[@title='Processing From']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Processing_From_Click)));
		driver.findElement(configure_Processing_From_Click).click();

	}

	public void configure_Date_Click() {

		/*
		 * This method is used to click the configure column processing from icon in the
		 * time record page
		 */
		By configure_Date_Click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Date']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Date_Click)));
		driver.findElement(configure_Date_Click).click();

	}

	public void check_The_Selected_Column_Is_Coming_Or_Not_In_Configurecolumn() {

		/*
		 * This method is used to check_the_selected_colum_is_coming_or_not_in_configurecolumn
		 */
		By check_the_selected_colum_is_coming_or_not_in_configurecolumn = By.xpath("//span//b[normalize-space()='Pay Groups']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(check_the_selected_colum_is_coming_or_not_in_configurecolumn)));
		String value = driver.findElement(check_the_selected_colum_is_coming_or_not_in_configurecolumn).getText();
		//pay group is showing or not check
		Assert.assertEquals(value, "Pay Groups", "Test failed the selected column is not showing");

	}

	public void reset_Click() throws Exception {

		/*
		 * This method is used to click the reset
		 */
		By reset_click = By.xpath("(//img[contains(@src,'reset.svg')])[2]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reset_click)));
		Thread.sleep(1500);
		new Actions(driver).click(driver.findElement(reset_click)).build().perform();
	}

	public void reset_Click_Yes() throws Exception {

		/*
		 * This method is used to click the reset and give yes
		 */
		By reset_click_yes = By.xpath("(//button[@name='action' and  normalize-space()='Yes'])[2]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reset_click_yes)));
		Thread.sleep(1500);
		new Actions(driver).click(driver.findElement(reset_click_yes)).build().perform();
		loader_Wait();

	}

	public void loader_Wait() {

		/*
		 * This method is used to make wait until the loader image gets disappear
		 */

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		List<WebElement> heading_check = driver.findElements(By.xpath("//div//img[contains(@src,'gif')]"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
	}

	public void loader_Wait_Toaster() {

		/*
		 * This method is used to make wait until the toaster image gets disappear
		 */

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		List<WebElement> loader_wait_Toaster = driver.findElements(By.xpath("//div[@id='toast-container']"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(loader_wait_Toaster));
	}

	public void reset_Click_Close() {

		/*
		 * This method is used to click the reset and give yes and close
		 */
		By reset_click_close = By.xpath("(//img[@class=\"stp_closeImg\"])[2]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reset_click_close)));
		new Actions(driver).click(driver.findElement(reset_click_close)).build().perform();
		loader_Wait();

	}

	public void configure_Column_Display_Status_Click() {

		/*
		 * This method is used to click the configure column display status icon in the
		 * time record page
		 */
		By configure_column_display_status_click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Display Status']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_display_status_click)));
		driver.findElement(configure_column_display_status_click).click();
	}

	public void configure_Column_Drop_Down_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column drop down
		 */
		By configure_column_drop_down_click = By.xpath("//span[normalize-space()='Display Status']//parent::div//img[contains(@src,\"down_arrow.svg\")]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_drop_down_click)));
		Thread.sleep(1500);
		new Actions(driver).doubleClick(driver.findElement(configure_column_drop_down_click)).build().perform();

	}

	public void configure_Column_Drop_Down_Exception_Type_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column drop down
		 */
		By configure_column_drop_down_exception_type_click = By.xpath("//span[normalize-space()='Exception Type']//parent::div//img[contains(@src,\"down_arrow.svg\")]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_drop_down_exception_type_click)));
		driver.findElement(configure_column_drop_down_exception_type_click).click();
		Thread.sleep(1000);

	}

	public void a_To_Z_Sort_Click() throws InterruptedException {

		/*
		 * This method is used to click a to z sort
		 */

		By a_to_z_sort_click = By.xpath("(//div[normalize-space()='Sort A - Z'])[1]");
		By a_to_z_sort_check = By.xpath("//span[@id=\"taEmployeeSummaryViewUniqueCodetableDataColumn00\"]//span");

		configure_Column_Drop_Down_Click();

		Thread.sleep(1000);
		try {
			action.doubleClick(driver.findElement(a_to_z_sort_click)).build().perform();

		} catch (StaleElementReferenceException e) {
			wait.until(ExpectedConditions
					.refreshed(ExpectedConditions.stalenessOf(driver.findElement(a_to_z_sort_click))));
			WebElement a_to_Z_sort_click = driver.findElement(By.xpath("(//div[normalize-space()='Sort A - Z'])[1]"));
			new Actions(driver).doubleClick(a_to_Z_sort_click).build().perform();
		}

		Thread.sleep(1000);
		String value = driver.findElement(a_to_z_sort_check).getText();
		//sorting is check a to z
		Assert.assertEquals(value, "Approved", "Test failed - sort is not working for A to Z");

	}

	public void z_To_A_Sort_Click() throws InterruptedException {

		/*
		 * This method is used to click z to a sort
		 */
		By z_to_a_sort_click = By.xpath("//div[@class=\"listview_sortTxt\"]//div[normalize-space()='Sort Z - A' and @title=\"Sort Z-A\"]");
		By z_to_a_sort_check = By.xpath("//span[@id=\"taEmployeeSummaryViewUniqueCodetableDataColumn00\"]//span");

		configure_Column_Drop_Down_Click();
		Thread.sleep(1000);
		action.doubleClick(driver.findElement(z_to_a_sort_click)).build().perform();
		// new Actions(driver).doubleClick(z_to_a_sort_click).build().perform();
		Thread.sleep(2000);

		String value = driver.findElement(z_to_a_sort_check).getText();
		//sorting is check z to a
		Assert.assertEquals(value, "Waiting for Approval", "Test failed - sort is not working for z to a");

	}

	public void configure_Paygroup_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column date icon in the time
		 */

		By configure_paygroup_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Paygroup']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_paygroup_click)));
		Thread.sleep(1000);
		driver.findElement(configure_paygroup_click).click();

	}

	public void configure_Exception_Type_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column Exception type icon in the
		 * time
		 */
		By configure_exception_type_click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Exception Type']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_exception_type_click)));
		Thread.sleep(1000);
		driver.findElement(configure_exception_type_click).click();

	}
	
	public void time_Entry_Status_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column Time Entry Status icon in the
		 * time
		 */
		By time_Entry_Status_Click = By.xpath("//ul[@id=\"taEmployeeSummaryViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Time Entry Status']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(time_Entry_Status_Click)));
		Thread.sleep(1000);
		driver.findElement(time_Entry_Status_Click).click();

	}

	public void week_Off_Validation(String date) {

		/*
		 * This method is used to validate the week off
		 */
		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		System.out.println(date);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(date);

		WebElement search_value_check = driver.findElement(By.xpath("//span//span//span[normalize-space()='Weekoff']"));
		wait.until(ExpectedConditions.visibilityOf(search_value_check));
		String value = search_value_check.getText();
		
		//week off check
		Assert.assertEquals(value, "Weekoff", "Test failed - week off is not available or mapped ");

		driver.findElement(search_validation).clear();

	}

	public void holiday_Validation(String date) {

		/*
		 * This method is used to validate the holiday
		 */

		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(date);

		By search_value_check = By.xpath("//span//span//span[normalize-space()='Holiday']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_value_check)));
		String value = driver.findElement(search_value_check).getText();

		//Holiday check
		Assert.assertEquals(value, "Holiday", "Test failed -holiday is not available or mapped ");

		driver.findElement(search_validation).clear();

	}

	public void absent_Validation(String date) {

		/*
		 * This method is used to validate the absent
		 */
		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(date);

		By search_value_check = By.xpath("//span//span//span[normalize-space()='Absent']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_value_check)));
		String value = driver.findElement(search_value_check).getText();
		//Absent check
		Assert.assertEquals(value, "Absent", "Test failed - absent is not available or mapped ");

		driver.findElement(search_validation).clear();

	}

	public void leave_Applied_Validation(String Date) {

		/*
		 * This method is used to validate the Leave Applied
		 */
		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		// searching the date

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(Date);

		WebElement search_value_check = driver.findElement(By.xpath("//span//span//span[normalize-space()='Leave Applied']"));
		wait.until(ExpectedConditions.visibilityOf(search_value_check));
		String value = search_value_check.getText();
		
		//Leave Applied check
		Assert.assertEquals(value, "Leave Applied", "Test failed -  Leave Applied is not available or mapped ");

		driver.findElement(search_validation).clear();

	}

	public void leave_Type_Validation(String Date ) {

		/*
		 * This method is used to validate the Leave type
		 */
		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(Date);

		// checking the leave type
		By search_value_check = By.xpath("//span//span//span[normalize-space()='SE_Personal Leave']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_value_check)));
		String value = driver.findElement(search_value_check).getText();
		//SE_Personal Leave check
		Assert.assertEquals(value, "SE_Personal Leave", "Test failed - Leave type is not available or mapped ");

		driver.findElement(search_validation).clear();

	}

	public void display_Status_Validation() {
		
		/*
		 * This method is used to validate the display status
		 */
	
		
		List<WebElement> all_exceptions = driver.findElements(By.xpath("//td[contains(@id,'ta')]//span//span//span"));
		ArrayList<String> exceptions_list = new ArrayList<String>();

		for (int i = 0; i < all_exceptions.size(); i++) {
			String temp_message = all_exceptions.get(i).getText();
			exceptions_list.add(temp_message);
		}
		System.out.println(exceptions_list);
		if (exceptions_list.contains("Regularization Cancelled") || exceptions_list.contains("Approved") || exceptions_list.contains("Waiting for Approval") || exceptions_list.contains("Cancelled")) {
			//exception list checking
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Test failed - status are not showing");
		}	
	
	}

	public void week_Off_Overtime_Check(Integer Date) {

		/*
		 * This method is used to validate week off overtime
		 */
		By display_Status_Validation = By.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");

		int year = 2023;
		int month = Calendar.MARCH;
		Calendar cal = new GregorianCalendar(year, month, 1);
		ArrayList<Integer> dates = new ArrayList<Integer>();
		do {
			// get the day of the week for the current day
			int day = cal.get(Calendar.DAY_OF_WEEK);
			// check if it is a Saturday or Sunday
			if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
				// print the day - but you could add them to a list or whatever
				System.out.println(cal.get(Calendar.DAY_OF_MONTH));
				int a = cal.get(Calendar.DAY_OF_MONTH);
				dates.add(a);
			}
			// advance to the next day
			cal.add(Calendar.DAY_OF_YEAR, 1);
		} while (cal.get(Calendar.MONTH) == month);

		System.out.println("dates  -  " + dates);

		if (dates.contains(Date)) {
			System.out.println("its a week off");
		} else {
			System.out.println("its a not");
			Assert.assertTrue(false, "Test failed - its not a week off date");
		}

		// searching the date

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys("" + Date + "-Mar-2023");

		// checking the leave type
		By search_value_check = By.xpath("//span//span//span[normalize-space()='OverTime3']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_value_check)));
		String value = driver.findElement(search_value_check).getText();
		
		//over time checking
		Assert.assertEquals(value, "OverTime3", "Test failed - overtime  is wrong ");

		driver.findElement(display_Status_Validation).clear();

	}

	public void working_Day_Overtime_Check(Integer Date) {

		/*
		 * This method is used to validate working day overtime
		 */
		By display_Status_Validation = By
				.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");

		int year = 2023;
		int month = Calendar.MARCH;
		Calendar cal = new GregorianCalendar(year, month, 1);
		ArrayList<Integer> dates = new ArrayList<Integer>();
		do {
			// get the day of the week for the current day
			int day = cal.get(Calendar.DAY_OF_WEEK);
			// check if it is a working day
			if (day == Calendar.MONDAY || day == Calendar.TUESDAY || day == Calendar.WEDNESDAY
					|| day == Calendar.THURSDAY || day == Calendar.FRIDAY) {
				// print the day - but you could add them to a list or whatever
				System.out.println(cal.get(Calendar.DAY_OF_MONTH));
				int a = cal.get(Calendar.DAY_OF_MONTH);
				dates.add(a);
			}
			// advance to the next day
			cal.add(Calendar.DAY_OF_YEAR, 1);
		} while (cal.get(Calendar.MONTH) == month);

		System.out.println("dates  -  " + dates);

		if (dates.contains(Date)) {
			System.out.println("its a working day ");
		} else {
			System.out.println("its a not");
			Assert.assertTrue(false, "Test failed - its not a working day date");
		}

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys("" + Date + "-Mar-2023");

		// checking the leave type
		By search_value_check = By.xpath("//span//span//span[normalize-space()='OverTime1']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_value_check)));
		String value = driver.findElement(search_value_check).getText();
		
		//over time checking
		Assert.assertEquals(value, "OverTime1", "Test failed - overtime  is wrong ");

		driver.findElement(display_Status_Validation).clear();

	}

	public void holiday_Day_Overtime_Check(String Date) {

		/*
		 * This method is used to validate holiday day overtime
		 */
		By display_Status_Validation = By.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");
/*
		int Dates = Integer.parseInt(Date);
		Integer dates = 9;

		if (dates.equals(Dates)) {
			System.out.println("its a Holiday day ");
		} else {
			System.out.println("its a not a holiday");
			Assert.assertTrue(false, "Test failed - its not a holiday day date");
		}
*/
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(Date);

		// checking the leave type
		WebElement search_value_check = driver.findElement(By.xpath("//span//span//span[normalize-space()='OverTime4']"));
		wait.until(ExpectedConditions.visibilityOf(search_value_check));
		String value = search_value_check.getText();
		
		//over time checking
		Assert.assertEquals(value, "OverTime4", "Test failed - overtime  is wrong ");

		driver.findElement(display_Status_Validation).clear();

	}

	public String[] processing_Period_Check() {

		/*
		 * This method is used to check the processing period check
		 */
		By current_processing_period_check = By.xpath("//div[@id='payPeriodDetailsTab']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(current_processing_period_check)));
		String current_processing_period = driver.findElement(current_processing_period_check).getText();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
		LocalDateTime now = LocalDateTime.now();
		String year = dtf.format(now);

		String first_half[] = current_processing_period.split(" to ");

		System.out.println(first_half[0]);
		String date_1[] = first_half[0].split(" ");
		System.out.println(date_1[0]);
		String date_number_first_half = date_1[0];
		System.out.println(date_1[1]);
		String month_number_first_half = date_1[1];

		System.out.println(first_half[1]);
		String date_2[] = first_half[1].split(" ");
		System.out.println(date_2[0]);
		String date_number_second_half = date_2[0];
		System.out.println(date_2[1]);
		String month_number_second_half = date_2[1];

		String first_side = date_number_first_half + "-" + month_number_first_half + "-" + year + "";
		System.out.println("Splited value first half    -                " + first_side);

		String second_side = date_number_second_half + "-" + month_number_second_half + "-" + year + "";
		System.out.println("Splited value second half    -                " + second_side);

		String processing_period[] = new String[2];
		processing_period[0] = first_side;
		processing_period[1] = second_side;

		return processing_period;
	}

	public void configure_Processing_Start_Date_Click() {

		/*
		 * This method is used to click the configure column processing start date in
		 * the time record page
		 */
		By configure_Processing_Start_Date_Click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Processing Start Date']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Processing_Start_Date_Click)));
		driver.findElement(configure_Processing_Start_Date_Click).click();

	}

	public void configure_Processing_End_Date_Click() {

		/*
		 * This method is used to click the configure column processing end date in the
		 * time record page
		 */
		By configure_Processing_End_Date_Click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Processing End Date']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Processing_End_Date_Click)));
		driver.findElement(configure_Processing_End_Date_Click).click();

	}

	public void processing_Start_And_End_Check(String value[]) {

		/*
		 * This method is used to validate the processing start and end date
		 */
		By start_date = By.xpath("//tr//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[@id=\"taEmployeeSummaryViewUniqueCodetableDataColumn00\"]//span");
		By end_date = By.xpath("//tr//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[@id=\"taEmployeeSummaryViewUniqueCodetableDataColumn10\"]//span");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(start_date)));
		String Start_date = driver.findElement(start_date).getText();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(end_date)));
		String End_date = driver.findElement(end_date).getText();

		//processing start date check
		Assert.assertEquals(Start_date, value[0], "Test failed - processing start date is wrong");
		//processing end date check
		Assert.assertEquals(End_date, value[1], "Test failed - processing end date is wrong");
		System.out.println(value[0]);
		System.out.println(value[1]);
	}

	public void pay_Group_Check() {

		/*
		 * This method is used to check the pay group
		 */
		By start_date = By.xpath("//tr//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[@id=\"taEmployeeSummaryViewUniqueCodetableDataColumn00\"]//span");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date_and_time = dtf.format(now);
		System.out.println(date_and_time);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(start_date)));
		String Start_date = driver.findElement(start_date).getText();
		//pay group check
		Assert.assertEquals(Start_date, date_and_time, "Test failed pay group is wrong");

	}

	public void configure_Pay_Group_Click() {

		/*
		 * This method is used to click the configure column pay group in the time
		 * record page
		 */
		By configure_Pay_Group_Click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Pay Groups']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Pay_Group_Click)));
		driver.findElement(configure_Pay_Group_Click).click();
	}

	public void automatic_Allowance_Check(String date) {

		/*
		 * This method is used to check the automatic allowance
		 */
		
		By display_Status_Validation = By.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");
		By automatic_Allowance_Check = By.xpath("//td[@id=\"taMyRecordsOTSHApprovalViewUniqueCodescrollId\"]//span[contains(@id,\"taMyRecordsOTSHApprovalViewUniqueCodetableDataColumn\")]//span[normalize-space()='Meal Allowance']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(date);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(automatic_Allowance_Check)));
		String allowance = driver.findElement(automatic_Allowance_Check).getText();

		//meal allowance checking
		Assert.assertEquals(allowance, "Meal Allowance", "Test failed automatic allowance is poping up properly");

	}

	public void manual_Allowance_Check(String Date) {

		/*
		 * This method is used to check the manual allowance
		 */
		By display_Status_Validation = By.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");
		By manual_Allowance_Check = By.xpath("//td[@id=\"taMyRecordsOTSHApprovalViewUniqueCodescrollId\"]//span[contains(@id,\"taMyRecordsOTSHApprovalViewUniqueCodetableDataColumn\")]//span[normalize-space()='Travel Allowance']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(Date);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(manual_Allowance_Check)));
		String allowance = driver.findElement(manual_Allowance_Check).getText();

		Assert.assertEquals(allowance, "Travel Allowance", "Test failed automatic allowance is poping up properly");

	}

	public void exceptions_Check() {

		/*
		 * This method is used to check the exceptions displayed or not
		 */

		List<WebElement> all_exceptions = driver.findElements(By.xpath("//td[@id='taEmployeeSummaryViewUniqueCodescrollId']//span//span//span"));
		ArrayList<String> exceptions_list = new ArrayList<String>();

		for (int i = 0; i < all_exceptions.size(); i++) {
			String temp_message = all_exceptions.get(i).getText();
			exceptions_list.add(temp_message);
		}
		System.out.println(exceptions_list);
		if (exceptions_list.contains("Holiday") || exceptions_list.contains("Absent") || exceptions_list.contains("Weekoff")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Test failed - exceptions are not showing");
		}

	}

	public void configure_Entry_Type_Click() throws InterruptedException {

		/*
		 * This method is used to click the configure column Entry type icon in the time
		 */
		By configure_entry_type_click = By.xpath("//ul[@id=\"taMyRecordsOTSHApprovalViewUniqueCode+'ConfigColumnTarget'\"]//label[@class='listview_marLeft']//span[@title='Entry Type']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_entry_type_click)));
		Thread.sleep(1000);
		driver.findElement(configure_entry_type_click).click();

	}

	public void overtime_Check() {

		/*
		 * This method is used to check the overtime displayed or not
		 */
		By display_Status_Validation = By.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys("Over Time");

		List<WebElement> all_entry_type = driver
				.findElements(By.xpath("//td[@id='taMyRecordsOTSHApprovalViewUniqueCodescrollId']//span//span//span"));
		ArrayList<String> entry_Type_list = new ArrayList<String>();

		for (int i = 0; i < all_entry_type.size(); i++) {
			String temp_message = all_entry_type.get(i).getText();
			entry_Type_list.add(temp_message);
		}
		System.out.println(entry_Type_list);
		if (entry_Type_list.contains("Over Time")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Test failed - overtime details are not showing");
		}

		driver.findElement(display_Status_Validation).clear();

	}

	public void allowance_Check() {

		/*
		 * This method is used to check the allowance displayed or not
		 */
		By display_Status_Validation = By.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys("Allowance");

		List<WebElement> all_entry_type = driver.findElements(By.xpath("//td[@id='taMyRecordsOTSHApprovalViewUniqueCodescrollId']//span//span//span"));
		ArrayList<String> entry_Type_list = new ArrayList<String>();

		for (int i = 0; i < all_entry_type.size(); i++) {
			String temp_message = all_entry_type.get(i).getText();
			entry_Type_list.add(temp_message);
		}
		System.out.println(entry_Type_list);
		if (entry_Type_list.contains("Allowance")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Test failed - Allowance details are not showing");
		}

		driver.findElement(display_Status_Validation).clear();

	}

	public void short_Hours_Check() {

		/*
		 * This method is used to check the short hours displayed or not
		 */
		By display_Status_Validation = By
				.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys("Short Hours");

		List<WebElement> all_entry_type = driver
				.findElements(By.xpath("//td[@id='taMyRecordsOTSHApprovalViewUniqueCodescrollId']//span//span//span"));
		ArrayList<String> entry_Type_list = new ArrayList<String>();

		for (int i = 0; i < all_entry_type.size(); i++) {
			String temp_message = all_entry_type.get(i).getText();
			entry_Type_list.add(temp_message);
		}
		System.out.println(entry_Type_list);
		if (entry_Type_list.contains("Short Hours")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Test failed - Short Hours details are not showing");
		}

		driver.findElement(display_Status_Validation).clear();

	}

	public void night_Hours_Check() {

		/*
		 * This method is used to check the night hours displayed or not
		 */
		By display_Status_Validation = By
				.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys("Night Hours");

		List<WebElement> all_entry_type = driver
				.findElements(By.xpath("//td[@id='taMyRecordsOTSHApprovalViewUniqueCodescrollId']//span//span//span"));
		ArrayList<String> entry_Type_list = new ArrayList<String>();

		for (int i = 0; i < all_entry_type.size(); i++) {
			String temp_message = all_entry_type.get(i).getText();
			entry_Type_list.add(temp_message);
		}
		System.out.println(entry_Type_list);
		if (entry_Type_list.contains("Night Hours")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Test failed - Night Hours details are not showing");
		}

		driver.findElement(display_Status_Validation).clear();

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
			changeWaitTime(3);
			By first_value_in_filter = By.xpath("(//div[normalize-space()='"+value+"']//label//input)[1]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(first_value_in_filter)));
			driver.findElement(first_value_in_filter).click();

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(Filtered_value)));
			String actual = driver.findElement(Filtered_value).getText();
			String expected = value;
			
			//filter value check
			Assert.assertEquals(actual, expected, "Test failed - filter is not working");
			changeWaitTime(15);

		} catch (Exception e) {
			
			Thread.sleep(1500);
			changeWaitTime(3);
			try {
			By first_value_in_filter = By.xpath("(//div[normalize-space()='"+value+"']//label//input)[1]");
			action.click(driver.findElement(first_value_in_filter)).build().perform();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(Filtered_value)));
			String actual = driver.findElement(Filtered_value).getText();
			String expected = value;
			
			//filter value check
			Assert.assertEquals(actual, expected, "Test failed - filter is not working");
			changeWaitTime(15);
			} catch (NoSuchElementException e2) {
				Assert.fail("Test failed - the value is not came to filter");
			}
		}
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

	public void search_Data_For_Summary_Edit(String Day, String Month) throws InterruptedException {

		/*
		 * This method is used to search Data For Summary Editt
		 */

		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(data);

		By edit = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span//button[@title=\"Edit\"]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(edit)));
		driver.findElement(edit).click();

		try {
			By reasontype = By.xpath("(//div[@class='ng-placeholder' and normalize-space()='Select Reason Type'])[2]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype)));
			new Actions(driver).click(driver.findElement(reasontype)).build().perform();
		} catch (Exception e) {
			By clearselection = By
					.xpath("(//div[normalize-space()='Reason Type']//parent::div//span[@title=\"Clear all\"])[2]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(clearselection)));
			new Actions(driver).click(driver.findElement(clearselection)).build().perform();

			By reasontype = By.xpath("(//div[@class='ng-placeholder' and normalize-space()='Select Reason Type'])[2]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype)));
			new Actions(driver).click(driver.findElement(reasontype)).build().perform();
		}

		Thread.sleep(1500);
		By optionselect = By.xpath("//div[@role=\"option\"]//span[normalize-space()='Over Time']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(optionselect)));
		Thread.sleep(1500);
		new Actions(driver).click(driver.findElement(optionselect)).build().perform();

		// driver.findElement(search_validation).clear();

	}

	public void in_Time_Edit(String start_Time_Hours, String start_Time_Minutes) {

		By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");

		/*
		 * This method is used to edit in time
		 */

		By intimeclick = By.xpath("//input[@id='timeLiteInTimeId']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		new Actions(driver).click(driver.findElement(intimeclick)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
		driver.findElement(Start_time_hours_giving).click();
		driver.findElement(Start_time_hours_giving).clear();
		driver.findElement(Start_time_hours_giving).sendKeys(start_Time_Hours);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
		driver.findElement(Start_time_minutes_giving).click();
		driver.findElement(Start_time_minutes_giving).clear();
		driver.findElement(Start_time_minutes_giving).sendKeys(start_Time_Minutes);

		By clicking_set = By.xpath("//span[normalize-space()='Set']");
		new Actions(driver).click(driver.findElement(clicking_set)).build().perform();

	}

	public void save_Time_Edit() {
		By saveclick = By.xpath("(//button[@title=\"Save\"])[1]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(saveclick)));
		new Actions(driver).click(driver.findElement(saveclick)).build().perform();
	}

	public void out_Time_Edit(String start_Time_Hours, String start_Time_Minutes) {

		/*
		 * This method is used to click the out time
		 */
		By out_time = By.xpath("//input[@id=\"timeLiteOutTimeId\"]");
		By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By Start_time_minutes_giving = By
				.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
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

	public void search_Detail_Data_For_Summary_Edit( String Day, String Month ) {

		/*
		 * This method is used to search Data For Summary Editt
		 */
		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(data);

		By edit = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span//button[@title=\"Edit\"]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(edit)));
		driver.findElement(edit).click();

		try {
			By reasontype = By.xpath("(//div[@class='ng-placeholder' and normalize-space()='Select Reason Type'])[3]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype)));
			new Actions(driver).click(driver.findElement(reasontype)).build().perform();

		} catch (Exception e) {
			
			By clearselection = By.xpath("(//ng-select[@placeholder=\"Select Reason Type\"]//parent::div//span[@title=\"Clear all\"])[1]");
			if (driver.findElement(clearselection).isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(clearselection)));
				new Actions(driver).click(driver.findElement(clearselection)).build().perform();
			} else {
				By clearselection2 = By.xpath("(//ng-select[@placeholder=\"Select Reason Type\"]//parent::div//span[@title=\"Clear all\"])[3]");
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(clearselection2)));
				new Actions(driver).click(driver.findElement(clearselection2)).build().perform();
			}
			

			By reasontype = By.xpath("(//div[@class='ng-placeholder' and normalize-space()='Select Reason Type'])[3]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype)));
			new Actions(driver).click(driver.findElement(reasontype)).build().perform();
		}

		//By optionselect = By.xpath("//div[@role=\"option\"]//span[normalize-space()='Special Working Hours']");
		By optionselect = By.xpath("//div[@role='option']//span[normalize-space()='Over Time']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(optionselect)));
		try {
			new Actions(driver).click(driver.findElement(optionselect)).build().perform();
		} catch (Exception e) {
			new Actions(driver).click(driver.findElement(optionselect)).build().perform();
		}
		

		// driver.findElement(search_validation).clear();

	}

	public void in_Detail_Time_Edit() {

		/*
		 * This method is used to edit in time
		 */

		By intimeclick = By.xpath("(//input[@id=\"detailInTimePicker0\"])[1]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		new Actions(driver).click(driver.findElement(intimeclick)).build().perform();

		By in_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(in_time_hours_giving)));
		driver.findElement(in_time_hours_giving).click();
		driver.findElement(in_time_hours_giving).clear();
		driver.findElement(in_time_hours_giving).sendKeys("09");
		By clicking_set = By.xpath("//span[normalize-space()='Set']");

		new Actions(driver).click(driver.findElement(clicking_set)).build().perform();

		By saveclick = By.xpath("(//button[@title=\"Save\"])[1]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(saveclick)));
		new Actions(driver).click(driver.findElement(saveclick)).build().perform();

		// driver.findElement(search_validation).clear();

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
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,
					"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			time_Edit_Page_Close();
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
			
		}
	}
	
	public void toaster_Message_Bulk_Edit_Check() {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = "Updated Successfully";
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,
					"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			try {
				time_Bulk_Edit_Page_Close();

				loader_Wait();
				} catch (Exception e1) {
					// TODO: handle exception
				}
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
			
		}
	}

	public void time_Edit_Page_Close() {

		/*
		 * This method is used to close edit page
		 */

		try {
		By close = By.xpath("(//div//a[@title='Close']//img[contains(@src,'widgetClose.svg')])[5]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(close)));
		new Actions(driver).click(driver.findElement(close)).build().perform();

		loader_Wait();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void close() {
		try {
			By close = By.xpath("(//div//a[@title='Close']//img[contains(@src,'widgetClose.svg')])[5]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(close)));
			new Actions(driver).click(driver.findElement(close)).build().perform();
		} catch (Exception e) {
			
		}
		
	}
	
	

	public void search_Data_Click_Cancel( String Day, String Month ) {

		/*
		 * This method is used to search Data and
		 */
		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(data);
	
		By cancel = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span//button[@title=\"Regularization Cancel\"]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(cancel)));
		driver.findElement(cancel).click();
	
	}

	public void toaster_Message_Check_Cancel_Regularization() {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = "Regularization Cancelled Successfully";
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,"Test failed toaster message not came properly");
			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void search_Data_After_Approval_Click_Cancel(String Day, String Month) {
		/*
		 * This method is used to search Data click cancel for approved data
		 */
		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(data);

		By cancel = By
				.xpath("//td[@id='taEmployeeSummaryViewUniqueCodescrollId']//span//button[contains(@title,'Cancel')]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(cancel)));
		driver.findElement(cancel).click();
	}

	public void toaster_Message_Check_Cancel_After_Approval() {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = "Timeentry Cancelled Successfully";
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,
					"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void toaster_Message_Check_Cancel_After_Approval_OT() {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = "Cancelled Successfully";
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,
					"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selecting_Two_Check_Box_Record() {

		/*
		 * This method is used to select 2 data
		 */

		try {
		By first_data = By
				.xpath("//tr//td//input[(@id='taEmployeeSummaryViewUniqueCodeselectedRow0')]//parent::label//span");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(first_data)));
		new Actions(driver).click(driver.findElement(first_data)).build().perform();

		By second_data = By
				.xpath("//tr//td//input[(@id='taEmployeeSummaryViewUniqueCodeselectedRow1')]//parent::label//span");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(second_data)));
		action.click(driver.findElement(second_data)).build().perform();
		}
		catch (Exception e) {
			Assert.fail("Test failed no data is there to select");
		}
	}

	public void clicking_Bulk_Edit() {

		/*
		 * This method is used to click bulk edit
		 */

		By clicking_Bulk_Edit = By.xpath("//div//img[@title='Bulk Edit']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_Bulk_Edit)));
		action.click(driver.findElement(clicking_Bulk_Edit)).build().perform();
	}

	public void in_Time_Click(String start_Time_Hours, String start_Time_Minutes) throws InterruptedException {

		/*
		 * This method is used to click the in time
		 */

		By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
		By clicking_set = By.xpath("//span[normalize-space()='Set']");
		By In_time = By.xpath("//input[@id='timeLiteBulkInTimeId' and @name='timeLiteBulkInTimeId']");

		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(In_time)));
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
		By out_time = By.xpath("//input[@id='timeLiteBulkOutTimeId' and @name='timeLiteBulkOutTimeId']");
		By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By Start_time_minutes_giving = By
				.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
		By clicking_set = By.xpath("//span[normalize-space()='Set']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(out_time)));
		action.click(driver.findElement(out_time)).build().perform();

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

	public void clicking_Submit() {

		/*
		 * This method is used to click submit
		 */

		By clicking_Submit = By
				.xpath("//div[normalize-space()='Bulk Time Edit']//parent::div//div//button[@title='Submit']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_Submit)));
		action.click(driver.findElement(clicking_Submit)).build().perform();
	}

	public void clicking_Shift() {

		/*
		 * This method is used to select shift
		 */

		By clicking_Shift = By.xpath("//div//ng-select[@bindlabel='shiftConfigurationName']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_Shift)));
		action.click(driver.findElement(clicking_Shift)).build().perform();

		By clicking_flexi_Shift = By.xpath("//div[@title='Flexi Shift']//label");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_flexi_Shift)));
		action.click(driver.findElement(clicking_flexi_Shift)).build().perform();
	}

	public void selecting_Record_Type() {

		/*
		 * This method is used to select record type
		 */

		By selecting_Record_Type = By
				.xpath("//label[normalize-space()='Record Type']//parent::div//div//div[@title='Work from Home']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(selecting_Record_Type)));
		action.doubleClick(driver.findElement(selecting_Record_Type)).build().perform();
	}

	public void giving_Comment() {

		/*
		 * This method is used to give comment
		 */

		By giving_Comment = By.xpath("//textarea[@name='message']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(giving_Comment));
		action.doubleClick(driver.findElement(giving_Comment)).build().perform();
		driver.findElement(giving_Comment).click();
		driver.findElement(giving_Comment).clear();
		driver.findElement(giving_Comment).sendKeys("test");

	}
	
	public void bulk_Edit_Reset_Click_Check() {

		/*
		 * This method is used to check reset in bulk edit tab
		 */
		
		By In_time = By.xpath("//input[@id='timeLiteBulkInTimeId' and @name='timeLiteBulkInTimeId']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(In_time));
		
		By out_time = By.xpath("//input[@id='timeLiteBulkOutTimeId' and @name='timeLiteBulkOutTimeId']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(out_time));
		
		By clicking_Shift = By.xpath("//div//ng-select[@bindlabel='shiftConfigurationName']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(clicking_Shift));
		
		By giving_Comment = By.xpath("//textarea[@name='message']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(giving_Comment));
		
		String actual_intime = driver.findElement(In_time).getAttribute("value");
		System.out.println(actual_intime);
		String actual_out_time = driver.findElement(In_time).getAttribute("value");
		System.out.println(actual_out_time);
		String actual_shift = driver.findElement(clicking_Shift).getText();
		System.out.println(actual_shift);
		String actual_comment = driver.findElement(giving_Comment).getAttribute("value");
		System.out.println(actual_comment);
		
		By resetclick = By.xpath("//div//button[@title=\"Reset\"]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(resetclick));
		action.click(driver.findElement(resetclick)).build().perform();
		
		String expected_intime = driver.findElement(In_time).getAttribute("value");
		System.out.println(expected_intime);
		String expected_out_time = driver.findElement(In_time).getAttribute("value");
		System.out.println(expected_out_time);
		String expected_shift = driver.findElement(clicking_Shift).getText();
		System.out.println(expected_shift);
		String expected_comment = driver.findElement(giving_Comment).getAttribute("value");
		System.out.println(expected_comment);
		
		Assert.assertNotEquals(actual_intime,expected_intime,"Test failed in time is not removed");
		//Assert.assertTrue(expected_intime.isEmpty(), "Test failed in time is not removed");
		Assert.assertNotEquals(actual_out_time,expected_out_time,"Test failed out time is not removed");
		//Assert.assertTrue(expected_out_time.isEmpty(), "Test failed out time is not removed");
		Assert.assertNotEquals(actual_shift,expected_shift,"Test failed in shift is not removed");
		Assert.assertNotEquals(actual_comment,expected_comment,"Test failed in comment is not removed");
	}

	public void time_Bulk_Edit_Page_Close() {

		/*
		 * This method is used to close bulk edit page
		 */

		By close = By.xpath(
				"//div[normalize-space()='Bulk Time Edit']//div//a[@title='Close']//img[contains(@src,'widgetClose.svg')]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(close)));
		new Actions(driver).click(driver.findElement(close)).build().perform();

		loader_Wait();

	}
	
	 public void changeWaitTime(int time) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	    }

	public void search_Initial_Entry_Data_Before_Approval_Click_Cancel(  String Day, String Month ) {
 
		/*
		 * This method is used to search initial time entryData click cancel for
		 * approved data
		 */

		
		By search_validation = By.xpath("//input[@id='taEmployeeSummaryViewUniqueCode+universalListSearchId']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(data);

		
		By cancel = By.xpath("//td[@id='taEmployeeSummaryViewUniqueCodescrollId']//span//button[contains(@title,'Cancel')]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(cancel)));
		driver.findElement(cancel).click();
		
		
	}

	public void configure_Display_Status() throws InterruptedException {

		/*
		 * This method is used to click the configure display Status icon in the time
		 */

		By configure_Display_Status = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Display Status']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Display_Status)));
		Thread.sleep(1000);
		driver.findElement(configure_Display_Status).click();

	}

	public void configure_Regularization_Status() throws InterruptedException {

		/*
		 * This method is used to click the configure Regularization Status icon in the  time
		 */

		By configure_Regularization_Status = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Regularization Status']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Regularization_Status)));
		Thread.sleep(1000);
		driver.findElement(configure_Regularization_Status).click();

	}

	public void edited_Entry_Status_Check() {

		/*
		 * This method is used to check the edited entry status
		 */

		By search_validation = By.xpath("//input[@id='taEmployeeSummaryViewUniqueCode+universalListSearchId']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys("23-May-2023");

		By status = By.xpath("//td//span//span//span[contains(normalize-space(),'Wait')]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(status)));
		String actual = driver.findElement(status).getText();
		System.out.println(actual);
		
		//checking status
	    Assert.assertEquals(actual, "Waiting for Approval", "Test failed edit status is poping up properly");
	}

	public void short_Hours_Check_Payment_Name() {
		
		ArrayList<String> total_values = new ArrayList<String>();

		List<WebElement> total_time_add = driver.findElements(
				By.xpath("//tbody//tr//td[@id=\"taMyRecordsOTSHApprovalViewUniqueCodescrollId\"]//span//span//span"));

		for (int i = 0; i < total_time_add.size(); i++) {
			String temp_message = total_time_add.get(i).getText();
			try {
				total_values.add(temp_message);

			} catch (Exception e) {

				System.out.println("Empty value is there");

			}
		}
		System.out.println(total_values);

		if (total_values.contains("ShortHour1")) {
			Assert.assertTrue(true );
		} else {
			Assert.assertTrue(false,"Test failed -  no short hours showing");
		}

		/*
		 * This method is used to check short hours is showing or not
		 */
		
	}

	public void search_Data_Click_Allowance_Cancel() {

		/*
		 * This method is used to search Data and
		 */
		By search_validation = By.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");
		By yes = By.xpath("(//button[normalize-space()='Yes'])[3]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys("Meal Allowance");

		By cancel = By.xpath("(//td//span//button[@title='Cancel'])[1]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(cancel)));
		driver.findElement(cancel).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(yes)));
		driver.findElement(yes).click();
		loader_Wait();

	}

	public void toaster_Message_Check_allowance_cancel() {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = "Cancelled Successfully";
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,
					"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void total_Visibility_Check() {

		/*
		 * This method is used to check the status are showing or not
		 */

		ArrayList<String> total_values = new ArrayList<String>();

		List<WebElement> total_time_add = driver.findElements(By.xpath("//tbody//tr//td[@id='taEmployeeSummaryViewUniqueCodescrollId']//span//span//span"));

		for (int i = 0; i < total_time_add.size(); i++) {
			String temp_message = total_time_add.get(i).getText();
			try {
				total_values.add(temp_message);
			} catch (Exception e) {
				System.out.println("Empty value is there");
			}
		}
		System.out.println(total_values);
		if (total_values.contains("Approved") || total_values.contains("Regularization Cancelled")) {
			Assert.assertTrue(true, "Test failed -  no status showing");
		} else {
			Assert.assertTrue(false, "Test failed -  no status showing");
		}
	}

	public void alowance_Check(String Day, String Month) {

		/*
		 * This method is used to check the allowance
		 */
		By display_Status_Validation = By.xpath("//input[@id='taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId']");
		By manual_Allowance_Check = By.xpath("//td[@id=\"taMyRecordsOTSHApprovalViewUniqueCodescrollId\"]//span[contains(@id,\"taMyRecordsOTSHApprovalViewUniqueCodetableDataColumn\")]//span[normalize-space()='Approved']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);
		driver.findElement(display_Status_Validation).sendKeys(Keys.ENTER);

		try {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(manual_Allowance_Check)));
		String allowance = driver.findElement(manual_Allowance_Check).getText();

		Assert.assertEquals(allowance, "Approved", "Test failed automatic allowance is poping up properly");
		} catch (NoSuchElementException e) {
			Assert.fail("test failed status is wrong");
		}

	}

	public void entry_Check(String Day, String Month) {

		/*
		 * This method is used to check the entry
		 */
		By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");
		By status_Check = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[contains(@id,\"taEmployeeSummaryViewUnique\")]//span[normalize-space()='Waiting for Approval']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(status_Check)));
		String status = driver.findElement(status_Check).getText();

		//checking status
		Assert.assertEquals(status, "Waiting for Approval", "Test failed status poping up wrongly");
		
		driver.findElement(display_Status_Validation).clear();

	}
	
	
	
	public void entry_Cancel_Check(String Day, String Month) {

		/*
		 * This method is used to check the cancelled entry
		 */
		By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");
		By status_Check = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[contains(@id,\"taEmployeeSummaryViewUnique\")]//span[normalize-space()='Time Entry Cancelled']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(status_Check)));
		String status = driver.findElement(status_Check).getText();

		//checking status
		Assert.assertEquals(status, "Time Entry Cancelled", "Test failed status poping up wrongly");
		
		driver.findElement(display_Status_Validation).clear();

	}
	
	public void entry_OT_Check(String Day, String Month) {

		/*
		 * This method is used to check the cancelled entry
		 */
		By display_Status_Validation = By.xpath("//input[@id=\"taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId\"]");
		By status_Check = By.xpath("//td//span[contains(@id,\"taMy\")]//span[contains(normalize-space(),'Over')]");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(status_Check)));
		String status = driver.findElement(status_Check).getText();

		//checking status
		Assert.assertTrue(status.contains("OverTime"), "Test failed status poping up wrongly");
		
		driver.findElement(display_Status_Validation).clear();

	}
	
	public void entry_Short_Hour_Check(String Day, String Month) {

		
		By display_Status_Validation = By.xpath("//input[@id=\"taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId\"]");
		By status_Check = By.xpath("//td//span[contains(@id,\"taMy\")]//span[contains(normalize-space(),'Short')]");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(status_Check)));
		String status = driver.findElement(status_Check).getText();

		//checking status
		Assert.assertTrue(status.contains("ShortHour"), "Test failed status poping up wrongly");
		
		driver.findElement(display_Status_Validation).clear();

	}

	public void edit_Check(String Day, String Month) {

		/*
		 * This method is used to check the edited entry
		 */
		By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");
		By value = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[contains(@id,\"taEmployeeSummaryViewUnique\")]//span[normalize-space()='Waiting For Action']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		try {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(value)));
		String actual_status = driver.findElement(value).getText();
		//checking status
				Assert.assertEquals(actual_status, "Waiting For Action","Test failed automatic allowance is poping up properly");
		} catch (NoSuchElementException e) {
			
			Assert.fail("Status not reflected properly");
			
		}

		

	}
	
	public void edit_Cancel_Check(String Day, String Month) {

		/*
		 * This method is used to check the edited entry
		 */
		By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");
		By value = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[contains(@id,\"taEmployeeSummaryViewUnique\")]//span[normalize-space()='Regularization Cancelled']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		try {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(value)));
		String actual_status = driver.findElement(value).getText();
		//checking status
		Assert.assertEquals(actual_status, "Regularization Cancelled","Test failed status  is poping up properly");
		} catch (NoSuchElementException e) {
			
			Assert.fail("Status not reflected properly");
			
		}

		

	}

	public void time_Mss_Record_Click() {

		/*
		 * This method is used to click the time record tab
		 */
		By Time_Record_Click = By.xpath("(//div[@class=\"tlDashboardIconContainer col s9 secondary-class\"]//a//img[contains(@src,'timeRecordsMenuWhite.svg')])[1]");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Time_Record_Click)));
		driver.findElement(Time_Record_Click).click();

		loader_Wait();
	}

	public void edit_Check_In_Manager(String Day, String Month) {

		/*
		 * This method is used to check the edited entry
		 */
		By display_Status_Validation = By.xpath("//input[@id=\"taTeamRequestViewUniqueCode+universalListSearchId\"]");
		By value = By.xpath("//td[@id=\"taTeamRequestViewUniqueCodescrollId\"]//span[contains(@id,\"taTeamRequestViewUniqueCodetableData\")]//span[normalize-space()='Waiting For Action']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(value)));
		String actual_status = driver.findElement(value).getText();

		Assert.assertEquals(actual_status, "Waiting For Action","Test failed automatic allowance is poping up properly");

	}

	public void approve_Click_In_Manager() throws InterruptedException {

		/*
		 * This method is used to click the approve button
		 */

		WebElement approve_click = driver.findElement(By.xpath("(//img[contains(@src,'Approve')])[1]"));
		wait.until(ExpectedConditions.visibilityOf(approve_click));
		new Actions(driver).click(approve_click).perform();

		loader_Wait();
		
	}

	public void edit_Manager_Approve_Check(String Day, String Month) {

		/*
		 * This method is used to check the edited entry
		 */
		By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");
		By value = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[contains(@id,\"taEmployeeSummaryViewUnique\")]//span[normalize-space()='Approved']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(value)));
		String actual_status = driver.findElement(value).getText();

		//checking status
		Assert.assertEquals(actual_status, "Approved", "Test failed automatic allowance is poping up properly");

	}

	public void edit_Manager_Approve_In_And_Out_Check(String in_hour, String in_min, String out_hour, String out_min) {

		By in_time = By.xpath("//td//span//span[@id=\"taEmployeeSummaryViewUniqueCodetableDataColumn10\"]//span");
		By out_time = By.xpath("//td//span//span[@id=\"taEmployeeSummaryViewUniqueCodetableDataColumn20\"]//span");

		String in_Expected = "" + in_hour + ":" + in_min + "";
		String out_Expected = "" + out_hour + ":" + out_min + "";

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(in_time)));
		String in_time_actual = driver.findElement(in_time).getText();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(out_time)));
		String out_time_actual = driver.findElement(out_time).getText();

		//checking in time 
		Assert.assertEquals(in_time_actual, in_Expected, "Test failed in time is wrong");
		//checking out time 
		Assert.assertEquals(out_time_actual, out_Expected, "Test failed out time is wrong");
	}

	public void cancel_Approved_Edit(String Day, String Month) {

		/*
		 * This method is used to cancel approved edit
		 */
		By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");
		By value = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span[contains(@id,\"taEmployeeSummaryViewUnique\")]//span[normalize-space()='Regularization Cancelled']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(value)));
		String actual_status = driver.findElement(value).getText();

		//checking status
		Assert.assertEquals(actual_status, "Regularization Cancelled", "Test failed automatic allowance is poping up properly");
	}

	public void edited_Entry_Data_Approval_Click_Cancel() {

		/*
		 * This method is used to cancel edited entry after approval
		 */

		By cancel = By.xpath("//td[@id='taEmployeeSummaryViewUniqueCodescrollId']//span//button[contains(@title,'Cancel')]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(cancel)));
		driver.findElement(cancel).click();
	}

	public void search_Data_For_Detail_Edit(String Day, String Month) throws Exception {

		/*
		 * This method is used to search Data For detail Editt
		 */

		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(data);

		By edit = By.xpath("//td[@id=\"taEmployeeSummaryViewUniqueCodescrollId\"]//span//button[@title=\"Edit\"]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(edit)));
		action.click(driver.findElement(edit)).build().perform();
		
		Thread.sleep(1500);
		By reset = By.xpath("(//button[@title=\"Reset\"])[2]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reset)));
		action.click(driver.findElement(reset)).build().perform();

		Thread.sleep(1500);
		By plus = By.xpath("//div//div//i[@title='Add Row']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(plus)));
		action.doubleClick(driver.findElement(plus)).build().perform();

		By reasontype_1 = By.xpath("(//div[@class='ng-placeholder' and normalize-space()='Select Reason Type'])[3]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype_1)));
		action.click(driver.findElement(reasontype_1)).build().perform();

		Thread.sleep(1500);
		By optionselect_1 = By.xpath("//div[@role=\"option\"]//span[normalize-space()='Over Time']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(optionselect_1)));
		action.click(driver.findElement(optionselect_1)).build().perform();
		
		
		Thread.sleep(1500);
		By reasontype_2 = By.xpath("(//div[@class='ng-placeholder' and normalize-space()='Select Reason Type'])[4]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype_2)));
		action.click(driver.findElement(reasontype_2)).build().perform();

		Thread.sleep(1500);
		By optionselect_2 = By.xpath("//div[@role=\"option\"]//span[normalize-space()='Others']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(optionselect_2)));
		action.click(driver.findElement(optionselect_2)).build().perform();

	}
	
	public void in_Time_Edit_Detail(String start_Time_Hours_1, String start_Time_Minutes_1,String start_Time_Hours_2, String start_Time_Minutes_2) throws InterruptedException {

		By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");

		/*
		 * This method is used to edit in time
		 */

		By intimeclick = By.xpath("//input[@id='detailInTimePicker0']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		new Actions(driver).click(driver.findElement(intimeclick)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
		driver.findElement(Start_time_hours_giving).click();
		driver.findElement(Start_time_hours_giving).clear();
		driver.findElement(Start_time_hours_giving).sendKeys(start_Time_Hours_1);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
		driver.findElement(Start_time_minutes_giving).click();
		driver.findElement(Start_time_minutes_giving).clear();
		driver.findElement(Start_time_minutes_giving).sendKeys(start_Time_Minutes_1);

		Thread.sleep(1000);
		By clicking_set = By.xpath("//span[normalize-space()='Set']//parent::button");
		//driver.findElement(clicking_set).click();
		new Actions(driver).doubleClick(driver.findElement(clicking_set)).build().perform();
		
		//2nd
		By outtimeclick = By.xpath("//div[@id='detailOutTimePicker0']//input");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(outtimeclick)));
		new Actions(driver).click(driver.findElement(outtimeclick)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
		driver.findElement(Start_time_hours_giving).click();
		driver.findElement(Start_time_hours_giving).clear();
		driver.findElement(Start_time_hours_giving).sendKeys(start_Time_Hours_2);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
		driver.findElement(Start_time_minutes_giving).click();
		driver.findElement(Start_time_minutes_giving).clear();
		driver.findElement(Start_time_minutes_giving).sendKeys(start_Time_Minutes_2);

		Thread.sleep(1000);
		//driver.findElement(clicking_set).click();
		new Actions(driver).doubleClick(driver.findElement(clicking_set)).build().perform();

	}
	public void save() {
		By saveclick = By.xpath("//button[@title=\"Save\"]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(saveclick)));
		new Actions(driver).click(driver.findElement(saveclick)).build().perform();
	}
	
	public void in_Time_Edit_Detail_2nd_Value(String start_Time_Hours_1, String start_Time_Minutes_1,String start_Time_Hours_2, String start_Time_Minutes_2) {

		By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
		By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");

		/*
		 * This method is used to edit in time
		 */

		By intimeclick = By.xpath("(//input[@id='detailInTimePicker1'])[1]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		new Actions(driver).click(driver.findElement(intimeclick)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
		driver.findElement(Start_time_hours_giving).click();
		driver.findElement(Start_time_hours_giving).clear();
		driver.findElement(Start_time_hours_giving).sendKeys(start_Time_Hours_1);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
		driver.findElement(Start_time_minutes_giving).click();
		driver.findElement(Start_time_minutes_giving).clear();
		driver.findElement(Start_time_minutes_giving).sendKeys(start_Time_Minutes_1);

		By clicking_set = By.xpath("//span[normalize-space()='Set']");
		new Actions(driver).click(driver.findElement(clicking_set)).build().perform();
		
		//2nd
		By outtimeclick = By.xpath("(//div[@id=\"detailOutTimePicker1\"]//input)[1]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(outtimeclick)));
		new Actions(driver).click(driver.findElement(outtimeclick)).build().perform();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
		driver.findElement(Start_time_hours_giving).click();
		driver.findElement(Start_time_hours_giving).clear();
		driver.findElement(Start_time_hours_giving).sendKeys(start_Time_Hours_2);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
		driver.findElement(Start_time_minutes_giving).click();
		driver.findElement(Start_time_minutes_giving).clear();
		driver.findElement(Start_time_minutes_giving).sendKeys(start_Time_Minutes_2);

		
		new Actions(driver).click(driver.findElement(clicking_set)).build().perform();

	}
	
	public void toaster_Message_Detail_Edit_Check() {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = "Saved Successfully";
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,
					"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
		}
	}
	
	public void ot_Entry_Check_In_Manager(String Day, String Month) {

		/*
		 * This method is used to check the ot entry
		 */
		
		By display_Status_Validation = By.xpath("//input[@id=\"taTeamRequestViewUniqueCode+universalListSearchId\"]");
		By value = By.xpath("//td[@id=\"taTeamRequestViewUniqueCodescrollId\"]//span[contains(@id,\"taTeamRequestViewUniqueCodetableData\")]//span[normalize-space()='Waiting for Approval']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		try {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(value)));
		String actual_status = driver.findElement(value).getText();

		//checking status
		Assert.assertEquals(actual_status, "Waiting for Approval","Test failed automatic allowance is poping up properly");
		} catch (NoSuchElementException e) {
			Assert.fail("Test failed - entry not came to manager approval");
		}

	}
	
	public void ot_Approve_In_Manager(String Day, String Month) {

		
		By display_Status_Validation = By.xpath("//input[@id=\"taTeamOTSHApprovalViewUniqueCode+universalListSearchId\"]");
		By approve = By.xpath("(//td//div//button[@title=\"Approve\"])[1]");
		

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(approve)));
		action.click(driver.findElement(approve)).build().perform();

	}
	
	
	public void search_Data_Click_Cancel_OT(String Day, String Month) {

		/*
		 * This method is used to search Data and cancel OT
		 */
		By search_validation = By.xpath("//input[@id=\"taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId\"]");
		


		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(data);

		By cancel = By.xpath("(//td//span//button[contains(@title,\"Cancel\")])[1]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(cancel)));
		driver.findElement(cancel).click();
		
		By Yes = By.xpath("(//div//button[@title=\"Yes\" and @name=\"action\"])[3]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Yes)));
		driver.findElement(Yes).click();
		
		
	}
	
	public void search_Data_Click_Cancel_Short_Hour(String Day, String Month) {

		/*
		 * This method is used to search Data and cancel OT
		 */
		By search_validation = By.xpath("//input[@id=\"taMyRecordsOTSHApprovalViewUniqueCode+universalListSearchId\"]");
		


		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(data);

		By cancel = By.xpath("(//td//span//button[contains(@title,\"Cancel\")])[2]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(cancel)));
		driver.findElement(cancel).click();
		
		By Yes = By.xpath("(//div//button[@title=\"Yes\" and @name=\"action\"])[3]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Yes)));
		driver.findElement(Yes).click();
		
		
	}
	
	public void search_Data_Click_Cancel_Short_Hours(String Day, String Month) {

		/*
		 * This method is used to search Data and cancel short hours
		 */
		By search_validation = By.xpath("//input[@id=\"taEmployeeSummaryViewUniqueCode+universalListSearchId\"]");


		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(data);

		By cancel = By.xpath("//td[@id='taEmployeeSummaryViewUniqueCodescrollId']//span//button[@title='Time Entry Cancel']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(cancel)));
		driver.findElement(cancel).click();
	}
	
	public void short_Hours_Entry_Check_In_Manager(String Day, String Month) {

		/*
		 * This method is used to check the short hours  entry
		 */
		
		By display_Status_Validation = By.xpath("//input[@id=\"taTeamRequestViewUniqueCode+universalListSearchId\"]");
		By value = By.xpath("//td[@id=\"taTeamRequestViewUniqueCodescrollId\"]//span[contains(@id,\"taTeamRequestViewUniqueCodetableData\")]//span[normalize-space()='Waiting for Approval']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
		driver.findElement(display_Status_Validation).click();
		driver.findElement(display_Status_Validation).clear();
		driver.findElement(display_Status_Validation).sendKeys(data);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(value)));
		String actual_status = driver.findElement(value).getText();

		//checking status
		Assert.assertEquals(actual_status, "Waiting for Approval","Test failed automatic allowance is poping up properly");
	}
	
	public void toaster_Message_Check(String message) {

		/*
		 * This method is used to check the toaster message
		 */

		try {
			By toaster = By.xpath("//div[@id='toast-container']//span[@class='black-text left']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(toaster)));
			String toaster_message_expected = message;
			String toaster_message_actual[] = driver.findElement(toaster).getText().split("outline ");
			Assert.assertEquals(toaster_message_actual[1], toaster_message_expected,"Test failed toaster message not came properly");

			loader_Wait_Toaster();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Test failed because toaster message didn't come");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reset_Checking() throws InterruptedException{
		//Checking all fields empty or not
		
		By intimeclick = By.xpath("(//div[@id=\"detailInTimePicker0\"]//input[@id=\"detailInTimePicker0\"])[1]");
		By outtimeclick = By.xpath("(//div[@id=\"detailOutTimePicker0\"]//input)[1]");
		By reasontype = By.xpath("(//div[normalize-space()='Reason Type']//parent::div//div[@id=\"recordType\"])[2]");
		By resetclick = By.xpath("(//div//button[@title='Reset'])[2]");
		
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
		
		Thread.sleep(1500);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		String after_in =driver.findElement(intimeclick).getAttribute("value");
		System.out.println(  after_in  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(outtimeclick)));
		String after_out =driver.findElement(outtimeclick).getAttribute("value");
		System.out.println(  after_out  );
		
		//Assert.assertNotEquals(before_reasontype,  after_reasontype , "Test failed - reason type entry not removed");
		Assert.assertNotEquals(before_in,  after_in ,"Test failed - in time not removed");
		Assert.assertNotEquals(before_out,  after_out ,"Test failed - out time not removed");
		
		Assert.assertEquals(after_in,"","Test failed - in time not removed");
		Assert.assertEquals(after_out,"" ,"Test failed - out time not removed");
		
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
	
	
	 public void selection() throws InterruptedException {
			configure_Column_Click();
			configure_Column_Select_All_Click();
			configure_Action_Click();
			configure_Column_Date_Click();
			configure_Column_Save_Click();

	    }
	
	public void search_Initial_Entry_Data_Before_Run_Click_Cancel(  String Day, String Month ) throws InterruptedException {
		
		selection();
		 
		By search_validation = By.xpath("//input[@id='taEmployeeSummaryViewUniqueCode+universalListSearchId']");

		String month = Month.substring(0, 3);
		String data = "" + Day + "-" + month + "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
		driver.findElement(search_validation).click();
		driver.findElement(search_validation).clear();
		driver.findElement(search_validation).sendKeys(data);

		
		By cancel = By.xpath("//td[@id='taEmployeeSummaryViewUniqueCodescrollId']//span//button[contains(@title,'Cancel')]");
		Thread.sleep(1500);
		try {
		if (driver.findElement(cancel).isDisplayed()) {
		driver.findElement(cancel).click();
		loader_Wait_Toaster();
		} else {
			
		}
		}catch (NoSuchElementException e) {
		}
		
	}


}
