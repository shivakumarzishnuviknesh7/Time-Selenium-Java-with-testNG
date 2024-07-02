package time_application.pages.manual_key_in_and_out_ess_pages;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Outlook_Page {

	public WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	public Actions action;
	public JavascriptExecutor javascriptexecutor;

	public Outlook_Page(WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
		this.driver = driver;
		this.prop = prop;
		this.wait = wait;
		this.action = action;
		this.javascriptexecutor = javascriptexecutor;
	}
	
	  public void changeWaitTime(int time) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	    }


	public void outlook_Login() throws Exception {
		changeWaitTime(50);

		By username = By.xpath("//input[@type='email']");
		By password = By.xpath("//input[@name='passwd']");
		By login = By.xpath("//input[@type='submit']");
		By no = By.xpath("//div//input[@value='No']");

		String loginPassword = prop.getProperty("outlook_password");
		String loginId = prop.getProperty("outlook_id");
		String url = prop.getProperty("outlook_url");

		driver.get(url);

		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(username)));
		driver.findElement(username).sendKeys(loginId);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(login)));
		driver.findElement(login).click();

		Thread.sleep(1000);
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(password)));
			driver.findElement(password).sendKeys(loginPassword);
		} catch (Exception e) {
        	wait.until(ExpectedConditions.visibilityOf(driver.findElement(password)));
			driver.findElement(password).sendKeys(loginPassword);
		}

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(login)));
		driver.findElement(login).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(no)));
		driver.findElement(no).click();

		changeWaitTime(15);
	}
	
	public void filtering() {
		changeWaitTime(50);
		By filter_Click = By.xpath("//div//i[@data-icon-name='FilterRegular']");
		By sort_Click = By.xpath("//button[@role='menuitem']");
		By sort_newest_on_top_click = By.xpath("//button[@role=\"menuitemcheckbox\"]//span[normalize-space()='Newest on top']");
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(filter_Click)));
		action.click(driver.findElement(filter_Click)).build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(sort_Click)));
		action.click(driver.findElement(sort_Click)).build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(sort_newest_on_top_click)));
		action.click(driver.findElement(sort_newest_on_top_click)).build().perform();
		changeWaitTime(15);
	}
	
	public void mail_Check( ArrayList<String> time) {
		
		changeWaitTime(50);
		
		System.out.println(  time  );
		
		String hour_before = time.get(0);
		System.out.println(hour_before);
		String am_or_pm_before = time.get(1);
		System.out.println(am_or_pm_before);
		String minutes_before = time.get(2);
		System.out.println(minutes_before);

		DateTimeFormatter date = DateTimeFormatter.ofPattern("EEE M/d/yyy hh:mm a");
        LocalDateTime now = LocalDateTime.now();
        String date_and_time = date.format(now);
        System.out.println(date_and_time);

        String a[] = date_and_time.split(" ");

        System.out.println(a[2]);
        System.out.println(a[3]);
        String b[] = a[2].split(":");
        System.out.println(b[0]);
        System.out.println(b[1]);

        String hour = b[0];
        String am_or_pm = a[3];

        String minutes = b[1];
        int num1 = Integer.parseInt(minutes);
        int time_minute = Integer.parseInt(minutes_before);
        
        //minutes validation based on generation time
        if (num1 > time_minute && num1 <= time_minute + 7) {
            Assert.assertTrue(true);
        } else {
        	Assert.assertTrue(false , "Test failed - wrong timing ");
        }

       //hours validation based on generation time
        if (hour.contains(hour_before)) {
        	Assert.assertTrue(true);
        } else {
        	Assert.assertTrue(false , "Test failed - wrong timing ");
        }

       //am_or_pm validation based on generation time
        if (am_or_pm.contains(am_or_pm_before)) {
        	Assert.assertTrue(true);
        } else {
        	Assert.assertTrue(false , "Test failed - wrong timing ");
        }
		
		By mail_Click = By.xpath("(//div//span[@title='time.support@neeyamo.com'])[1]");
		By date_time_check = By.xpath("//div[@data-testid='SentReceivedSavedTime']");
		By subject_check = By.xpath("//span[normalize-space()='TimeEntry Submitted Successfully']//span//span");
		String expected_subject="TimeEntry Submitted Successfully";
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(mail_Click)));
		action.click(driver.findElement(mail_Click)).build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(date_time_check)));
		String actual =driver.findElement(date_time_check).getText();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE M/d/yyy");
        LocalDateTime nows = LocalDateTime.now();
        String date_and_times = dtf.format(nows);
        System.out.println( date_and_times  );
        
        try {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(subject_check)));
		
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false ,"Test failed - subject line mismatch" );
		}
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(subject_check)));
		String actual_subject =driver.findElement(subject_check).getText();
		
		//date and month check
        Assert.assertTrue(actual.contains(date_and_times),"Test failed - mail not generated today");
        
        //mail subject check
        Assert.assertTrue(actual_subject.contains(expected_subject),"Test failed - mail not generated properly");
        
        By date_Check = By.xpath("//span[normalize-space()='Date']//parent::td//parent::tr//td[2]//strong");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(date_Check)));
		String date_and_time_check =driver.findElement(date_Check).getText();
		
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyy-MM-dd");
 	    LocalDateTime now1 = LocalDateTime.now().minusDays( 1 );
 	    String actual_date_Check = dtf1.format(now1);
        
        //date checking in the body
		Assert.assertEquals(actual_date_Check,date_and_time_check.trim(), "Test failed - mail not generated today");
		changeWaitTime(15);
	}
	
	

}
