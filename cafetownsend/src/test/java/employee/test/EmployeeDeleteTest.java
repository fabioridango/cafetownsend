package employee.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LocatorMethodDefination;
import static web.browser.Browser.launchBrowser;

public class EmployeeDeleteTest extends LocatorMethodDefination {

    WebDriver driver;

    WebDriverWait wait;

    WebElement element;

    /* The method after logged in the application
     * delete the input employee
     *
     * @throws Exception
     *
     * @Parameters validUsername, validPassword, webAppUrl, employeesUrl, employeeNameDetails
     *
     */

    @Test
    @Parameters({ "validUsername", "validPassword", "webAppUrl", "employeesUrl", "employeeNameDelete"})
    public void employeeDelete(String validUsername,String validPassword, String webAppUrl, String employeesUrl,
                                 String employeeNameDelete) throws Exception {

        try {

            EmployeeDeleteTest def = new EmployeeDeleteTest();

            driver = launchBrowser();

            //web application launched
            driver.navigate().to(webAppUrl);

            wait = new WebDriverWait(driver, 10);

            //checks if the login form is also visible
            def.elementVisibility(wait,def.byLoginForm);
            Thread.sleep(500);

            //fill username field
            def.fillUsernameField(driver,validUsername);

            //fill password field
            def.fillPasswordField(driver,validPassword);

            //select login button
            def.selectLoginButton(driver);
            Thread.sleep(500);

            //check that the user is redirected to employees web page
            Assert.assertEquals(employeesUrl,driver.getCurrentUrl());

            //check that the list of employees is displayed
            def.elementVisibility(wait,def.byEmployeeList);
            Thread.sleep(500);

            //scroll the employees list to find the employee to delete
            def.scrollElement(driver,employeeNameDelete);
            Thread.sleep(2000);

            //select in the employees list the employee to delete
            driver.findElement(By.xpath("//li[contains(text()," + "'" + employeeNameDelete + "'" + " )]")).click();
            Thread.sleep(2000);

            //select in the employees list the delete button
            def.selectDeleteButton(driver);
            Thread.sleep(1000);

            //select "ok" in the alert pop-up
            driver.switchTo().alert().accept();
            Thread.sleep(2000);

            //select logout button
            def.selectLogoutButton(driver);

            //checks that the login form is  visible
            def.elementVisibility(wait,def.byLoginForm);
            Thread.sleep(1000);

            //fill first name field
            element = driver.findElement(By.xpath(def.byUsername));
            element.clear();
            element.sendKeys(validUsername);

            //fill last name field
            element = driver.findElement(By.xpath(def.byPassword));
            element.clear();
            element.sendKeys(validPassword);

            //select login button
            def.selectLoginButton(driver);
            Thread.sleep(1000);

            //check that the user is redirected to employees web page
            Assert.assertEquals(employeesUrl,driver.getCurrentUrl());

            try {

                //scroll the employees list to check that the employee has been deleted
                def.scrollElement(driver, employeeNameDelete);

            }catch(NoSuchElementException e){

            }

        }catch(Exception e){

            //exception handling statements employees
            throw new Exception(e.getMessage());

        }finally{

            //close the opened browser window
            driver.quit();

        }

    }
}

