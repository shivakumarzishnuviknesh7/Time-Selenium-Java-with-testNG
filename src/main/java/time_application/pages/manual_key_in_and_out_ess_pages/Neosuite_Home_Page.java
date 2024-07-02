package time_application.pages.manual_key_in_and_out_ess_pages;

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

public class Neosuite_Home_Page {

    public WebDriver driver;
    public Properties prop;
    public WebDriverWait wait;
    public Actions action;
    public JavascriptExecutor javascriptexecutor;

    public Neosuite_Home_Page (WebDriver driver, Actions action, Properties prop, WebDriverWait wait, JavascriptExecutor javascriptexecutor) {
        this.driver = driver;
        this.prop = prop;
        this.wait = wait;
        this.action = action;
        this.javascriptexecutor = javascriptexecutor;
    }

    public void time_Widget_Click(String widget_name , String heading) {
        /*
         *This method is used to click the Time widget
         */

        WebElement Time_Widget_click = driver.findElement(By.xpath("//div[@title='" + widget_name + "']"));
        wait.until(ExpectedConditions.visibilityOf(Time_Widget_click));
        wait.until(ExpectedConditions.elementToBeClickable(Time_Widget_click));
        Time_Widget_click.click();
        loader_Wait();

        try {
        	WebElement heading_check = driver.findElement(By.xpath("//span[text()='"+heading+"']"));
            wait.until(ExpectedConditions.visibilityOf(heading_check));
            String actual = heading;
            String expected = heading_check.getText();
            //page opening check
            Assert.assertEquals(actual , expected , "Test case failed - Time  page didn't opened properly");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(false, "Test failed page is not openend properly");
        } catch (Exception e) {
        	 e.printStackTrace();
		}
        
    }

    public void loader_Wait() {

        /*
         * This method is used to make wait until the loader image gets disappear
         */

        List<WebElement> heading_check = driver.findElements(By.xpath("//div//img[contains(@src,'gif')]"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
    }

    public void loader_Wait2() {

        /*
         * This method is used to make wait until the loader image gets disappear
         */
        List<WebElement> heading_check = driver.findElements(By.xpath("//div"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(heading_check));
    }


    public void click_On_AppRole_Icon_Employee(String role) {

        /*
         * This method is used to change app role
         */
    	
    	By click_AppRole = By.xpath("//a[text()=' App Roles ']");
        By Time_Click = By.xpath("//span[text()='Time']");
        By employee_Role_Click = By.xpath("//div[@class='collapsible-body']//ul[@id='appRole_Collapsible']//span[text()='Time']//parent::div//parent::div//parent::li//span[@title='"+role+"']//parent::div//parent::div//label//parent::div//span");
        By click_Save_Approle = By.xpath("//div//a[text()='Save App Role']");

        WebElement sidebar = driver.findElement(By.xpath("//a[@data-target='setting_SideBar_out']"));
        wait.until(ExpectedConditions.elementToBeClickable(sidebar));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sidebar);


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(click_AppRole)));
        driver.findElement(click_AppRole).click();

        driver.findElement(Time_Click).click();

        driver.findElement(employee_Role_Click).click();

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(click_Save_Approle));
        javascriptexecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(click_Save_Approle));
        driver.findElement(click_Save_Approle).click();

        loader_Wait2();
    }

    public void click_On_AppRole_Icon_And_Log_Out() {

    	By sidebar = By.xpath("//a[@data-target='setting_SideBar_out']");
        By click_logout = By.xpath("//a[text()=' Logout ']");
        
        /*
         * This method is used to log out
         */

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(sidebar)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(sidebar));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(click_logout)));
        driver.findElement(click_logout).click();

        loader_Wait2();
    }

    public void login_2nd_Time() {

    	By login_2nd_Time = By.xpath("//a[normalize-space()='Login']");
    	
        /*
         * This method is used to login 2nd time
         */
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(login_2nd_Time)));
        driver.findElement(login_2nd_Time).click();
    }

    public void click_On_AppRole_Icon_Manager() {

        /*
         * This method is used to change app role in manager
         */
    	By sidebar = By.xpath("//a[@data-target='setting_SideBar_out']");
        By click_AppRole = By.xpath("//a[text()=' App Roles ']");
        By Time_Click = By.xpath("//span[text()='Time']");
        By click_Save_Approle = By.xpath("//div//a[text()='Save App Role']");
        By manager_Role_Click = By.xpath("//div[@class='collapsible-body']//ul[@id='appRole_Collapsible']//span[text()='Time']//parent::div//parent::div//parent::li//span[@title='Reporting Manager']//parent::div//parent::div//label//parent::div//span");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(sidebar)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(sidebar));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(click_AppRole)));
        driver.findElement(click_AppRole).click();

        driver.findElement(Time_Click).click();

        driver.findElement(manager_Role_Click).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(click_Save_Approle));
        driver.findElement(click_Save_Approle).click();

        loader_Wait2();
    }

    

    public void absence_Widget_Click() {

        /*
         *This method is used to click the absence widget
         */
    	By Absence_Widget_click = By.xpath("//div[@title='Absence']");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Absence_Widget_click)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Absence_Widget_click)));
        driver.findElement(Absence_Widget_click).click();
        loader_Wait();

        WebElement heading_check = driver.findElement(By.xpath("//span[normalize-space()='Home Page']"));
        wait.until(ExpectedConditions.visibilityOf(heading_check));

        String actual = "Home Page";
        String expected = heading_check.getText();

        //page opening check
        Assert.assertEquals(actual , expected, "Test case failed - Time  page didn't opened properly");

    }

    public String total_Leave_Balance_Before() {
        /*
         *This method is used to check total leave balance before
         */
    	By Total_leave_balance_before = By.xpath("(//a[normalize-space()='Total Leave Balance']//parent::div//parent::div//parent::div//a[contains(normalize-space(),'200')])[2]");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Total_leave_balance_before)));
        String hours = driver.findElement(Total_leave_balance_before).getText();
        return hours;
    }

    public void home_Click_In_Absence() {

        /*
         *This method is used to Home click in Absence
         */
    	By Home_click_in_Absence = By.xpath("//img[contains(@src,\"home.svg\")]");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Home_click_in_Absence)));
        driver.findElement(Home_click_in_Absence).click();
    }

    public void total_Leave_Balance_After(String before_hours) {
        /*
         *This method is used to check total leave balance after approval and assetion check
         */
    	By Total_leave_balance_after = By.xpath("(//a[normalize-space()='Total Leave Balance']//parent::div//parent::div//parent::div//a[contains(normalize-space(),'200')])[2]");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Total_leave_balance_after)));
        String After_hours = driver.findElement(Total_leave_balance_after).getText();
        //leave balance checking gets reflected or changes
        Assert.assertNotEquals(After_hours, before_hours, "Test failed date is not updated after approval");
    }


}
