package time_application.pages.manual_key_in_and_out_mss_pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mss_Team_Requests {
	
	public WebDriver driver;
    public Properties prop;
    public WebDriverWait wait;
    public Actions action;
    public JavascriptExecutor javascriptexecutor;


    public Mss_Team_Requests (WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
    	this.driver = driver;
        this.prop = prop;
        this.wait = wait;
        this.action = action;
        this.javascriptexecutor = javascriptexecutor;
    }
    
    public void clicking_Team_Requests() {
		
    	/*
		 * This method is used to click the team requests
		 */
    	
		By clicking_Team_Requests = By.xpath("//div[normalize-space()='Team Requests']");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(clicking_Team_Requests)));
		driver.findElement(clicking_Team_Requests).click();
	}

}
