package time_application.pages.manual_key_in_and_out_mss_pages;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mss_Neosuite_Login {

    public WebDriver driver;
    public Properties prop;
    public WebDriverWait wait;
    public Actions action;
    public JavascriptExecutor javascriptexecutor;


    public Mss_Neosuite_Login (WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
    	this.driver = driver;
        this.prop = prop;
        this.wait = wait;
        this.action = action;
        this.javascriptexecutor = javascriptexecutor;
    }

    public void Time_Login() throws AWTException, InterruptedException {

        String loginPassword = prop.getProperty("passcode_MSS");
        String loginId = prop.getProperty("id_MSS");
        String url = prop.getProperty("URL_MSS");

        driver.get(url);
        driver.manage().window().maximize();

        WebElement heading = driver.findElement(By.xpath("//div[@id='kc-header-wrapper']"));
        wait.until(ExpectedConditions.visibilityOf(heading));
        //String a = heading.getText();

        //Assert.assertEquals(a,message);

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(loginId);

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(loginPassword);

        WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
        wait.until(ExpectedConditions.visibilityOf(login));
        login.click();

    }

}
