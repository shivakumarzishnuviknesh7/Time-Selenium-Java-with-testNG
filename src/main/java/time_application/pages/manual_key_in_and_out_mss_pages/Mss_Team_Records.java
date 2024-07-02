package time_application.pages.manual_key_in_and_out_mss_pages;

import java.time.Duration;
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

public class Mss_Team_Records {
	
	 public WebDriver driver;
	    public Properties prop;
	    public WebDriverWait wait;
	    public Actions action;
	    public JavascriptExecutor javascriptexecutor;


	    public Mss_Team_Records (WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
	    	this.driver = driver;
	        this.prop = prop;
	        this.wait = wait;
	        this.action = action;
	        this.javascriptexecutor = javascriptexecutor;
	    }
	    
	    public void reset_Checking(){
			//Checking all fields empty or not
			By intimeclick = By.xpath("//input[@id='timeLiteInTimeId']");
			By outtimeclick = By.xpath("//input[@id='timeLiteOutTimeId']");
			By reasontype = By.xpath("(//div[normalize-space()='Reason Type']//parent::div//div[@id=\"recordType\"])[2]");
			By resetclick = By.xpath("(//div//button[@title='Reset'])[2]");
			/*
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype)));
			String before_reasontype =driver.findElement(reasontype).getText();
			System.out.println(  before_reasontype  );
			*/
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
			String before_in =driver.findElement(intimeclick).getAttribute("value");
			System.out.println(  before_in  );
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(outtimeclick)));
			String before_out =driver.findElement(outtimeclick).getAttribute("value");
			System.out.println(  before_out  );
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(resetclick)));
			action.click(driver.findElement(resetclick)).build().perform();
		/*	
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(reasontype)));
			String after_reasontype =driver.findElement(reasontype).getText();
			System.out.println(  after_reasontype  );
			*/
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
			String after_in =driver.findElement(intimeclick).getAttribute("value");
			System.out.println(  after_in  );
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(outtimeclick)));
			String after_out =driver.findElement(outtimeclick).getAttribute("value");
			System.out.println(  after_out  );
			
	//		Assert.assertNotEquals(before_reasontype,  after_reasontype , "Test failed - reason type entry not removed");
			Assert.assertNotEquals(before_in,  after_in ,"Test failed - in time not removed");
			Assert.assertNotEquals(before_out,  after_out ,"Test failed - out time not removed");
			
	//		Assert.assertEquals(  after_reasontype, "Select Reason Type" , "Test failed - reason type entry not removed");
			//AssertassertTrue() change to is empty // input
			Assert.assertEquals( after_in,"" ,"Test failed - in time not removed");
			Assert.assertEquals(  after_out,"" ,"Test failed - out time not removed");
		}

	    
	    public void edit_Check_In_Manager(String Day, String Month) {

			/*
			 * This method is used to check the edited entry
			 */
			By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeTeamSummaryViewUniqueCode+universalListSearchId\"]");
			By value = By.xpath("//td//span[contains(@id,\"ta\")]//span[normalize-space()='Waiting For Action']");

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
	    
	    public void configure_Column_Dates_Click() {

			/*
			 * This method is used to click the configure column dates icon in time records page
			 */
			By configure_column_dates_click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Date']");

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_column_dates_click)));
			driver.findElement(configure_column_dates_click).click();
		}
	    
	    public void configure_Column_Display_Status_Click() {

			/*
			 * This method is used to click the configure column display status icon in the  time record page
			 */
			By configure_Column_Display_Status_Click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Display Status']");

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_Column_Display_Status_Click)));
			driver.findElement(configure_Column_Display_Status_Click).click();

		}
	    
	    public void search_Data_For_Summary_Edit(String Day, String Month) throws InterruptedException {

			/*
			 * This method is used to search Data For Summary Editt
			 */

			By search_validation = By.xpath("//input[@id=\"taEmployeeTeamSummaryViewUniqueCode+universalListSearchId\"]");

			String month = Month.substring(0, 3);
			String data = "" + Day + "-" + month + "";

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(search_validation)));
			driver.findElement(search_validation).click();
			driver.findElement(search_validation).clear();
			driver.findElement(search_validation).sendKeys(data);

			By edit = By.xpath("//td//span//button[@title=\"Edit\"]");
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

			Thread.sleep(1300);
			By optionselect = By.xpath("//div[@role=\"option\"]//span[normalize-space()='Over Time']");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(optionselect)));
			Thread.sleep(1300);
			new Actions(driver).click(driver.findElement(optionselect)).build().perform();

			// driver.findElement(search_validation).clear();

		}

	    
	    public void clicking_Team_Records() {
			
	    	/*
			 * This method is used to click the team records
			 */
	    	
			By clicking_Team_Records = By.xpath("//div[normalize-space()='Team Records']");

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_Team_Records)));
			driver.findElement(clicking_Team_Records).click();
		}
	    
	    public void configure_Entry_Type_Click() throws InterruptedException {

			/*
			 * This method is used to click the configure column Entry type icon in the time
			 */
			By configure_entry_type_click = By.xpath("//ul//label[@class='listview_marLeft']//span[@title='Entry Type']");

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(configure_entry_type_click)));
			Thread.sleep(1000);
			driver.findElement(configure_entry_type_click).click();

		}
	    public void show_Variance_Check() {


			List<WebElement> all_entry_type = driver
					.findElements(By.xpath("//td[contains(@id,'ta')]//span//span//span"));
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
	    
	    public void edit_Check(String Day, String Month) {

			/*
			 * This method is used to check the edited entry
			 */
	    	By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeTeamSummaryViewUniqueCode+universalListSearchId\"]");
			By value = By.xpath("//td[@id=\"taEmployeeTeamSummaryViewUniqueCodescrollId\"]//span//span[contains(@id,\"taEmployeeTeamSummaryViewUniqueCodetableDataColumn10\")]//span");

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
					Assert.assertEquals(actual_status, "Approved","Test failed status is poping up properly");
			} catch (NoSuchElementException e) {
				
				Assert.fail("Status not reflected properly");
				
			}

			

		}

	    
	    public void entry_Check(String Day, String Month) {

			/*
			 * This method is used to check the entry
			 */
			By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeTeamSummaryViewUniqueCode+universalListSearchId\"]");
			By status_Check = By.xpath("//td[@id=\"taEmployeeTeamSummaryViewUniqueCodescrollId\"]//span[contains(@id,\"taEmployee\")]//span[normalize-space()='Waiting for Approval']");

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
	    
	    public void entry_Check_Auto_Approved(String Day, String Month) {

			/*
			 * This method is used to check the entry
			 */
			By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeTeamSummaryViewUniqueCode+universalListSearchId\"]");
			By status_Check = By.xpath("//td[@id=\"taEmployeeTeamSummaryViewUniqueCodescrollId\"]//span[contains(@id,\"taEmployee\")]//span[normalize-space()='Approved']");

			String month = Month.substring(0, 3);
			String data = "" + Day + "-" + month + "";
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(display_Status_Validation)));
			driver.findElement(display_Status_Validation).click();
			driver.findElement(display_Status_Validation).clear();
			driver.findElement(display_Status_Validation).sendKeys(data);

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(status_Check)));
			String status = driver.findElement(status_Check).getText();

			//checking status
			Assert.assertEquals(status, "Approved", "Test failed status poping up wrongly");
			
			driver.findElement(display_Status_Validation).clear();

		}
	    
	    public void entry_Check_Late_In(String Day, String Month) {

			/*
			 * This method is used to check the entry
			 */
			By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeTeamSummaryViewUniqueCode+universalListSearchId\"]");
			By status_Check = By.xpath("//td//span[contains(@id,\"taEmployee\")]//span[normalize-space()='Late In']");

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
	    	By display_Status_Validation = By.xpath("//input[@id=\"taEmployeeTeamSummaryViewUniqueCode+universalListSearchId\"]");
			By status_Check = By.xpath("//td//span[contains(@id,\"taEmployee\")]//span[normalize-space()='Early Out']");

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
	    
	    public void selecting_Two_Check_Box_Record() {

			/*
			 * This method is used to select 2 data
			 */

			try {
			By first_data = By.xpath("//tr//td//input[contains(@id,'Row0')]//parent::label//span");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(first_data)));
			new Actions(driver).click(driver.findElement(first_data)).build().perform();

			By second_data = By
					.xpath("//tr//td//input[@id=\"taEmployeeTeamSummaryViewUniqueCodeselectedRow1\"]//parent::label//span");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(second_data)));
			action.click(driver.findElement(second_data)).build().perform();
			}
			catch (Exception e) {
				Assert.fail("Test failed no data is there to select");
			}
		}
	    
	    public void search_validation() {

	        /*
	         * This method is used to validate the search
	         */

	        By search_get = By.xpath("//span[@id=\"taEmployeeTeamSummaryViewUniqueCodetableDataColumn00\"]//span");
	        By search_validation = By.xpath("//input[@id=\"taEmployeeTeamSummaryViewUniqueCode+universalListSearchId\"]");


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
	    
	    public void changeWaitTime(int time) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	    }
	    
	    public void filtering_Check(String value) throws InterruptedException {

			/*
			 * This method is used to check the filter is working or not
			 */
			By Filtered_value = By.xpath("//td[@id=\"taEmployeeTeamSummaryViewUniqueCodescrollId\"]//span//span//span");

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


}
