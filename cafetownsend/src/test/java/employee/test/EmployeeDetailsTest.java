package employee.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LocatorMethodDefination;
import static web.browser.Browser.launchBrowser;

public class EmployeeDetailsTest extends LocatorMethodDefination {

    WebDriver driver;

    WebDriverWait wait;

    /* The method after logged in the application
     * view the detail of an input employee
     *
     * @throws Exception
     *
     * @Parameters validUsername, validPassword, webAppUrl, employeesUrl, employeeNameDetails
     *
     */

    @Test
    @Parameters({ "validUsername", "validPassword", "webAppUrl", "employeesUrl", "employeeNameDetails"})
    public void employeeDetails(String validUsername,String validPassword, String webAppUrl, String employeesUrl,
                                String employeeNameDetails) throws Exception {

        try {

            EmployeeDetailsTest def = new EmployeeDetailsTest();

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

            //scroll the employees list to find the input employee
            def.scrollElement(driver,employeeNameDetails);
            Thread.sleep(500);

            //select with double click the input employee in the list
            def.scrollListDoubleClick(driver,employeeNameDetails);
            Thread.sleep(3000);

            //check that the employee details is displayed
            def.elementVisibility(wait,def.byEmployeeDetails);
            Thread.sleep(500);

            //select in the employee details the back button
            def.selectBackButton(driver);
            Thread.sleep(500);

            //check that the list of employees is displayed
            def.elementVisibility(wait,def.byEmployeeList);
            Thread.sleep(500);

        }catch(Exception e){

            //exception handling statements employees
            throw new Exception(e.getMessage());

        }finally{

            //close the opened browser window
            driver.quit();

        }

    }
}