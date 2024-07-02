package time_application.pages.manual_key_in_and_out_ess_pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Add_Allowance_Page {

	  	public WebDriver driver;
	    public Properties prop;
	    public WebDriverWait wait;
	    public Actions action;
	    public JavascriptExecutor javascriptexecutor;

    public Add_Allowance_Page  (WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
    	this.driver = driver;
        this.prop = prop;
        this.wait = wait;
        this.action = action;
        this.javascriptexecutor = javascriptexecutor;
    }

    public void add_Allowance_Click() {

        /*
         * This method is used to click add allowance  in home page
         */
    	By Add_allowance_click = By.xpath("//button[normalize-space()='Add Allowance']");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Add_allowance_click)));
        driver.findElement(Add_allowance_click).click();
    }

    public void selecting_Allowance() throws InterruptedException {

        /*
         * This method is used to click select allowance  in allowance page
         */
    	By select_allowance_click = By.xpath("//ng-select[@placeholder='Select Allowance' or @bindlabel='allowanceName']");
        By Travel_allowance_click = By.xpath("//div[@role='option']//div[normalize-space()='Travel Allowance']");
        By Clicking_Add_allowance = By.xpath("//button[normalize-space()='Reset']//following-sibling::button[normalize-space()='Add Allowance']");
        By clicking_minus_button = By.xpath("(//a//i[@class='material-icons time_removeIcon'])[1]");

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(select_allowance_click)));
        driver.findElement(select_allowance_click).click();

        try {
        	
        	Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(Travel_allowance_click)));
            action.click(driver.findElement(Travel_allowance_click)).build().perform();

        } catch (Exception e) {
        	

        	Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(Clicking_Add_allowance)));
            action.click(driver.findElement(Clicking_Add_allowance)).build().perform();

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_minus_button)));
            action.click(driver.findElement(clicking_minus_button)).build().perform();

            loader_Wait_Toaster();

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(select_allowance_click)));
            driver.findElement(select_allowance_click).click();

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(Travel_allowance_click)));
            action.click(driver.findElement(Travel_allowance_click)).build().perform();

        }

    }

    By Start_time = By.xpath("//input[@placeholder='Start Time']");
    By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
    By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
    By clicking_set = By.xpath("//span[normalize-space()='Set']");

    public void start_Time(String start_Time_Hours, String start_Time_Minutes) throws InterruptedException {

        /*
         * This method is used to provide start time
         */

    	  By Start_time = By.xpath("//input[@placeholder='Start Time']");
    	    By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
    	    By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
    	    By clicking_set = By.xpath("//span[normalize-space()='Set']");


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time)));
        driver.findElement(Start_time).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
        driver.findElement(Start_time_hours_giving).click();
        driver.findElement(Start_time_hours_giving).clear();
        driver.findElement(Start_time_hours_giving).sendKeys(start_Time_Hours);


        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
        driver.findElement(Start_time_minutes_giving).click();
        driver.findElement(Start_time_minutes_giving).clear();
        driver.findElement(Start_time_minutes_giving).sendKeys(start_Time_Minutes);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_set)));
        action.click(driver.findElement(clicking_set)).build().perform();
        
    }

    
    public void end_Time(String end_Time_Hours, String end_Time_Minutes) throws InterruptedException {

        /*
         * This method is used to provide End time
         */

    	By End_time = By.xpath("//input[@placeholder='End Time']");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(End_time)));
        driver.findElement(End_time).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
        driver.findElement(Start_time_hours_giving).click();
        driver.findElement(Start_time_hours_giving).clear();
        driver.findElement(Start_time_hours_giving).sendKeys(end_Time_Hours);

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
        driver.findElement(Start_time_minutes_giving).click();
        driver.findElement(Start_time_minutes_giving).clear();
        driver.findElement(Start_time_minutes_giving).sendKeys(end_Time_Minutes);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_set)));
        action.click(driver.findElement(clicking_set)).build().perform();
    }

   

    public void reset_Check() throws InterruptedException {
		By intimeclick = By.xpath("//input[@placeholder=\"Start Time\"]");
		By Unit_Kilometer = By.xpath("//input[@placeholder='Kilometer(s)']");
		By End_time = By.xpath("//input[@placeholder='End Time']");
		By allowance = By.xpath("//th[normalize-space()='Allowance']//parent::tr//parent::thead//parent::table//parent::div//ng-select");
		By reset = By.xpath("//div//button[@title=\"Reset\"]");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(allowance)));
		String before_allowance = driver.findElement(allowance).getText();
		System.out.println( before_allowance  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		String before_start = driver.findElement(intimeclick).getAttribute("value");
		System.out.println( before_start  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(End_time)));
		String before_end = driver.findElement(End_time).getAttribute("value");
		System.out.println( before_end  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Unit_Kilometer)));
		String before_Unit_Kilometer = driver.findElement(Unit_Kilometer).getAttribute("value");
		System.out.println( before_Unit_Kilometer  );
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(reset)));
		action.click(driver.findElement(reset)).build().perform();
		Thread.sleep(3500);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(allowance)));
		String after_allowance = driver.findElement(allowance).getText();
		System.out.println( after_allowance  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(intimeclick)));
		String after_start = driver.findElement(intimeclick).getAttribute("value");
		System.out.println( after_start  );
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(End_time)));
		String after_end = driver.findElement(End_time).getAttribute("value");
		System.out.println( after_end  );
		/*
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Unit_Kilometer)));
		String after_Unit_Kilometer = driver.findElement(Unit_Kilometer).getAttribute("value");
		System.out.println( after_Unit_Kilometer  );
		*/
		Assert.assertNotEquals( before_allowance,  after_allowance);
		Assert.assertNotEquals( before_start,  after_start);
		Assert.assertNotEquals( before_end,  after_end);
		//Assert.assertNotEquals( before_Unit_Kilometer,  after_Unit_Kilometer);

    }
    public void kilometer_Providing(String Kilometer) {
    	 By Unit_Kilometer = By.xpath("//input[@placeholder='Kilometer(s)']");
        /*
         * This method is used to provide End time
         */

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Unit_Kilometer)));
        driver.findElement(Unit_Kilometer).click();
        driver.findElement(Unit_Kilometer).clear();
        driver.findElement(Unit_Kilometer).sendKeys(Kilometer);

    }

    By clicking_submit = By.xpath("//button[normalize-space()='Submit']");

    public void clicking_Submit() {

        /*
         * This method is used to click the submit button
         */

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_submit)));
        action.click(driver.findElement(clicking_submit)).build().perform();
    }

    By clicking_close = By.xpath("//div[@id=\"textplaceHoldermodal1\"]//div[@class=\"col s12 modal-header\"]//img[contains(@src,'tl_widgetClose.svg')]");

    public void clicking_Close() {

        /*
         * This method is used to click the close icon
         */

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_close)));
        action.click(driver.findElement(clicking_close)).build().perform();
    }

    public void clicking_Add_Allowance() {

        /*
         * This method is used to click the Add allowance button in allowance page
         */
    	By Clicking_Add_allowance = By.xpath("//button[normalize-space()='Reset']//following-sibling::button[normalize-space()='Add Allowance']");

        List<WebElement> allowance_size_before = driver.findElements(By.xpath("//ng-select[@bindlabel=\"allowanceName\"]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(allowance_size_before));
        Integer before = allowance_size_before.size();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Clicking_Add_allowance)));
        action.click(driver.findElement(Clicking_Add_allowance)).build().perform();

        List<WebElement> allowance_size_after = driver.findElements(By.xpath("//ng-select[@bindlabel=\"allowanceName\"]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(allowance_size_after));
        Integer after = allowance_size_after.size();

        //allowance adding check
        Assert.assertNotEquals(before, after, "Test failed  - allowance not added");

        By clicking_minus_button = By.xpath("(//a//i[@class='material-icons time_removeIcon'])[2]");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_minus_button)));
        action.click(driver.findElement(clicking_minus_button)).build().perform();

        List<WebElement> allowance_size_final = driver.findElements(By.xpath("//ng-select[@bindlabel=\"allowanceName\"]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(allowance_size_final));
        Integer final_value = allowance_size_final.size();

        //allowance removing check
        Assert.assertEquals(before, final_value, "Test failed  - allowance not removed ");

    }

    //By Clicking_Add_allowance = By.xpath("//button[normalize-space()='Reset']//following-sibling::button[normalize-space()='Add Allowance']");
    public void add_Allowance_Button_Click() throws InterruptedException {

        /*
         * This method is used to click the Add allowance button in allowance page
         */
    	By Clicking_Add_allowance = By.xpath("//button[normalize-space()='Reset']//following-sibling::button[normalize-space()='Add Allowance']");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Clicking_Add_allowance)));
       Thread.sleep(1000);
        action.click(driver.findElement(Clicking_Add_allowance)).build().perform();
    }

    

    public void selecting_Allowance_Two() {

        /*
         * This method is used to click select allowance  2  in allowance page
         */
    	By select__2nd_allowance_click = By.xpath("(//ng-select[@bindlabel='allowanceName'])[2]");
    	
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(select__2nd_allowance_click)));
        driver.findElement(select__2nd_allowance_click).click();
    }

    //By Travel_allowance_click = By.xpath("//div[@role='option']//div[normalize-space()='Travel Allowance']");
    public void selecting_Travel_Allowance_Two() {

        /*
         * This method is used to click select travel allowance  2  in allowance page
         */
    	By Travel_allowance_click = By.xpath("//div[@role='option']//div[normalize-space()='Travel Allowance']");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Travel_allowance_click)));
        action.click(driver.findElement(Travel_allowance_click)).build().perform();
    }
    
    public void start_Time_2nd_Time(String start_Time_Hours, String start_Time_Minutes) {

        /*
         * This method is used to provide start time for 2nd time
         */
    	By Start_time_2 = By.xpath("(//input[@placeholder='Start Time'])[2]");
        By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
        By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
        By clicking_set = By.xpath("//span[normalize-space()='Set']");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_2)));
        driver.findElement(Start_time_2).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
        driver.findElement(Start_time_hours_giving).click();
        driver.findElement(Start_time_hours_giving).clear();
        driver.findElement(Start_time_hours_giving).sendKeys(start_Time_Hours);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
        driver.findElement(Start_time_minutes_giving).click();
        driver.findElement(Start_time_minutes_giving).clear();
        driver.findElement(Start_time_minutes_giving).sendKeys(start_Time_Minutes);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_set)));
        action.click(driver.findElement(clicking_set)).build().perform();
    }

    
    public void end_Time_2nd_Time(String end_Time_Hours, String end_Time_Minutes) {

        /*
         * This method is used to provide End time
         */
    	By End_time_2 = By.xpath("(//input[@placeholder='End Time'])[2]");
        By Start_time_hours_giving = By.xpath("//button[@aria-label='Add a hour']//following-sibling::label//input");
        By Start_time_minutes_giving = By.xpath("//button[@aria-label='Add a minute']//following-sibling::label//input");
        By clicking_set = By.xpath("//span[normalize-space()='Set']");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(End_time_2)));
        driver.findElement(End_time_2).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_hours_giving)));
        driver.findElement(Start_time_hours_giving).click();
        driver.findElement(Start_time_hours_giving).clear();
        driver.findElement(Start_time_hours_giving).sendKeys(end_Time_Hours);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Start_time_minutes_giving)));
        driver.findElement(Start_time_minutes_giving).click();
        driver.findElement(Start_time_minutes_giving).clear();
        driver.findElement(Start_time_minutes_giving).sendKeys(end_Time_Minutes);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_set)));
        action.click(driver.findElement(clicking_set)).build().perform();

    }

    public void assertion_Check(String message) throws InterruptedException {

       Thread.sleep(2000);

        /*
         * This method is used to check that toaster message is coming or not and it
         * will validate whether correct message is coming or not
         */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        ArrayList<String> messages_Actual = new ArrayList<String>();
        ArrayList<String> messages_Expected = new ArrayList<String>();

        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@id='toast-container']//span[@class='black-text left']"))));
        List<WebElement> toaster_message_save_record = driver.findElements(By.xpath("//div[@id='toast-container']//span[@class='black-text left']"));
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
        Assert.assertEquals(messages_Actual.equals(messages_Expected), true, " Test case failed - the toaster message is visible and expected and actual text is not same Actual:- " + toaster_message + "Expected:- " + message);
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
}
