package employee.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LocatorMethodDefination;
import static web.browser.Browser.launchBrowser;

public class EmployeeAddTest extends LocatorMethodDefination {

    WebDriver driver;

    WebDriverWait wait;

    /* The method after logged in the application
     * add the input employee
     *
     * @throws Exception
     *
     * @Parameters validUsername, validPassword, webAppUrl, employeesUrl, employeeFirstNameAdd, employeeLastNameAdd
     *             employeeStartDateAdd, employeeEmailAdd, employeesAddUrl
     *
     */

    @Test
    @Parameters({ "validUsername", "validPassword", "webAppUrl", "employeesUrl", "employeeFirstNameAdd", "employeeLastNameAdd"
                , "employeeStartDateAdd", "employeeEmailAdd", "employeesAddUrl"})
    public void employeeAdd(String validUsername,String validPassword, String webAppUrl, String employeesUrl,
                                String employeeFirstNameAdd, String employeeLastNameAdd, String employeeStartDateAdd
                                , String employeeEmailAdd, String employeesAddUrl) throws Exception {

        try {

            EmployeeAddTest def = new EmployeeAddTest();

            driver = launchBrowser();

            //web application launched
            driver.navigate().to(webAppUrl);

            wait = new WebDriverWait(driver, 10);

            //checks that the login form is  visible
            def.elementVisibility(wait,def.byLoginForm);
            Thread.sleep(1000);

            //fill username field
            def.fillUsernameField(driver,validUsername);

            //fill password field
            def.fillPasswordField(driver,validPassword);

            //select login button
            def.selectLoginButton(driver);
            Thread.sleep(1000);

            //check that the user is redirected to employees web page
            Assert.assertEquals(employeesUrl,driver.getCurrentUrl());

            //check that the list of employees is displayed
            def.elementVisibility(wait,def.byEmployeeList);
            Thread.sleep(1000);

            //select create button
            def.selectCreateButton(driver);

            //check that the user is redirected to add employees web page
            Assert.assertEquals(employeesAddUrl,driver.getCurrentUrl());

            //check that employee form is displayed
            def.elementVisibility(wait,def.byEmployeeForm);

            //fill first name field in the employee form
            def.fillFirstNameField(driver,employeeFirstNameAdd);

            //fill last name field in the employee form
            def.fillLastNameField(driver,employeeLastNameAdd);

            //fill start date field in the employee form
            def.fillStartDateField(driver,employeeStartDateAdd);

            //fill email field in the employee form
            def.fillEmailField(driver,employeeEmailAdd);
            Thread.sleep(1000);

            //check that the employee details is displayed
            def.elementVisibility(wait,def.byEmployeeDetails);
            Thread.sleep(1000);

            //select add button in the employee form
            def.selectAddButton(driver);
            Thread.sleep(2000);

            //scroll the employees list to find the added employee
            String employeeName =  employeeFirstNameAdd + " " + employeeLastNameAdd;
            def.scrollElement(driver,employeeName);
            Thread.sleep(2000);

            //select with double click the added employee in the list
            def.scrollListDoubleClick(driver,employeeName);
            Thread.sleep(2000);

            //check that all the employee details are properly added
            String firstName= driver.findElement(By.xpath(byFirstName)).getAttribute("value");
            Assert.assertEquals(firstName,employeeFirstNameAdd);

            String lastName= driver.findElement(By.xpath(byLastName)).getAttribute("value");
            Assert.assertEquals(lastName,employeeLastNameAdd);

            String startDate= driver.findElement(By.xpath(byStartDate)).getAttribute("value");
            Assert.assertEquals(startDate,employeeStartDateAdd);

            String email= driver.findElement(By.xpath(byEmail)).getAttribute("value");
            Assert.assertEquals(email,employeeEmailAdd);

        }catch(Exception e){

            //exception handling statements employees
            throw new Exception(e.getMessage());

        }finally{

            //close the opened browser window
            driver.quit();

        }
    }
}




