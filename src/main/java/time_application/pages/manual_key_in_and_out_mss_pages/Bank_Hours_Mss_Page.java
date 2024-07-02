package time_application.pages.manual_key_in_and_out_mss_pages;

import java.time.Duration;
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

public class Bank_Hours_Mss_Page {


	public WebDriver driver;
    public Properties prop;
    public WebDriverWait wait;
    public Actions action;
    public JavascriptExecutor javascriptexecutor;

    public Bank_Hours_Mss_Page (WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
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


    public void team_Requests_Click() throws InterruptedException {

        /*
         * This method is used to click the Team_requests
         */

      
        WebElement Team_Requests_Click = driver.findElement(By.xpath("//div[normalize-space()='Team Requests']"));
        wait.until(ExpectedConditions.visibilityOf(Team_Requests_Click));
        Thread.sleep(2000);
        new Actions(driver).click(Team_Requests_Click).perform();

    }

    public void approve_Click() throws InterruptedException {

        /*
         * This method is used to click the approve button
         */

        try {
        WebElement approve_click = driver.findElement(By.xpath("(//img[contains(@src,'Approve')])[1]"));
        wait.until(ExpectedConditions.visibilityOf(approve_click));
        new Actions(driver).click(approve_click).perform();
        } catch (NoSuchElementException e) {
			Assert.fail("Test failed - data didn't come for manager approval");
		}

        WebElement approve_click_check = driver.findElement(By.xpath("//div[normalize-space()='Are you sure you want to Approve this Bank hour request?' and @class=\"col s12 text_lightColor\"]"));
        wait.until(ExpectedConditions.visibilityOf(approve_click_check));
        String value = approve_click_check.getText();
        String text = "Are you sure you want to Approve this Bank hour request?";
        Assert.assertEquals(value, text, "Test failed - approve is not working");
    }

    public void approve_Click_Yes() throws InterruptedException {

        /*
         * This method is used to click the approve buttonand selecting yes
         */

     
        WebElement Approve_Click_Yes = driver.findElement(By.xpath("//button[@class='buttonyes']"));
        wait.until(ExpectedConditions.visibilityOf(Approve_Click_Yes));
        new Actions(driver).click(Approve_Click_Yes).perform();

    }


    public void configure_Column_Select_All_Click() {

        /*
         * This method is used to click configure column select all
         */

      
        WebElement configure_column_select_all_click = driver.findElement(By.xpath("(//div[@class='configColumnScrollBar']//label//span//p[text()='Select All'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(configure_column_select_all_click));
        configure_column_select_all_click.click();
        configure_column_select_all_click.click();
    }


    public void filter_Close() {

        /*
         * This method is used to click the filter close in bank hours page
         */

       
        WebElement filter_close = driver.findElement(By.xpath("(//img[@class='listview_filterClose' and @title='Close'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(filter_close));
        filter_close.click();
    }

    public void configure_Column_Click() {

        /*
         * This method is used to click the configure column icon in bank hours page
         */

      
        WebElement configure_column_click = driver.findElement(By.xpath("(//img[@title='Configure column'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(configure_column_click));
        configure_column_click.click();
    }

    public void loader_Wait_Toaster() {

        /*
         * This method is used to make wait until the toaster image gets disappear
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        List<WebElement> loader_wait_Toaster = driver.findElements(By.xpath("//div[@id='toast-container']"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader_wait_Toaster));
    }


    public void configure_Column_Save_Click() {

        /*
         * This method is used to click the save button in configure column in bank hours page
         */

       

        WebElement configure_column_save_click = driver.findElement(By.xpath("(//div[@class=\"saveBox\"])[1]"));
        wait.until(ExpectedConditions.visibilityOf(configure_column_save_click));
        configure_column_save_click.click();

        loader_Wait_Toaster();
    }

}
