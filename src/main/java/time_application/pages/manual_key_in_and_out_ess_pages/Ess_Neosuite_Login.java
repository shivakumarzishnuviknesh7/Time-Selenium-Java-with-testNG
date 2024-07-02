package time_application.pages.manual_key_in_and_out_ess_pages;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Ess_Neosuite_Login {

	public WebDriver driver;
    public Properties prop;
    public WebDriverWait wait;
    public Actions action;
    public JavascriptExecutor javascriptexecutor;

    public Ess_Neosuite_Login (WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
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

    public void eSS_Login() throws AWTException, InterruptedException {
    	
    	By heading = By.xpath("//div[@id='kc-header-wrapper']");
        By username = By.xpath("//input[@name='username']");
        By password = By.xpath("//input[@name='password']");
        By login = By.xpath("//input[@name='login']");

        String loginPassword = prop.getProperty("passcode_ESS");
        String loginId = prop.getProperty("id_ESS");
        String url = prop.getProperty("URL_ESS");
        String heading_value = prop.getProperty("heading_ESS");

        driver.get(url);
        
        try {
        	wait.until(ExpectedConditions.visibilityOf(driver.findElement(heading)));
            String actual = driver.findElement(heading).getText();
            //heading check
            Assert.assertEquals(actual , heading_value,"Test failed heading missmatch");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(false, "Test failed page is not openend properly");
        } catch (Exception e) {
        	 e.printStackTrace();
		}
        

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(username)));
        driver.findElement(username).sendKeys(loginId);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(password)));
        driver.findElement(password).sendKeys(loginPassword);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(login)));
        driver.findElement(login).click();

    }

}
