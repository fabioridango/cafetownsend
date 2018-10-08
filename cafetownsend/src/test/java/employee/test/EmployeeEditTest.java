package employee.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LocatorMethodDefination;
import static web.browser.Browser.launchBrowser;

public class EmployeeEditTest extends LocatorMethodDefination {

    WebDriver driver;

    WebDriverWait wait;

    WebElement element;

    /* The method after logged in the application
     * change the data of an input employee
     *
     * @throws Exception
     *
     * @Parameters validUsername, validPassword, webAppUrl, employeesUrl, employeeFirstNameUpdate,
     *             employeeLastNameUpdate, employeeStartDateUpdate, employeeEmailUpdate, employeeNameEdit
     *
     */

    @Test
    @Parameters({ "validUsername", "validPassword", "webAppUrl", "employeesUrl", "employeeFirstNameUpdate",
            "employeeLastNameUpdate", "employeeStartDateUpdate", "employeeEmailUpdate", "employeeNameEdit"})
    public void employeeEdit(String validUsername,String validPassword, String webAppUrl, String employeesUrl,
                                String employeeFirstNameUpdate, String employeeLastNameUpdate, String employeeStartDateUpdate
            , String employeeEmailUpdate, String employeeNameEdit) throws Exception {


        try {

            EmployeeEditTest def = new EmployeeEditTest();

            driver = launchBrowser();

            //web application launched
            driver.navigate().to(webAppUrl);

            wait = new WebDriverWait(driver, 10);

            //check that the login form is  visible
            def.elementVisibility(wait,def.byLoginForm);
            Thread.sleep(500);

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
            Thread.sleep(500);

            //scroll the employees list to find the employee
            def.scrollElement(driver,employeeNameEdit);
            Thread.sleep(2000);

            //select in the employees list the employee to edit
            driver.findElement(By.xpath("//li[contains(text()," + "'" + employeeNameEdit + "'" + " )]")).click();
            Thread.sleep(500);

            //select in the employees list the edit button
            def.selectEditButton(driver);
            Thread.sleep(500);

            //check that the employee form is displayed
            def.elementVisibility(wait,def.byEmployeeForm);
            Thread.sleep(500);

            //employee edit
            //fill first name field
            element = driver.findElement(By.xpath(def.byFirstName));
            element.clear();
            element.sendKeys(employeeFirstNameUpdate);

            //fill last name field
            element = driver.findElement(By.xpath(def.byLastName));
            element.clear();
            element.sendKeys(employeeLastNameUpdate);

            //fill start date field
            element = driver.findElement(By.xpath(def.byStartDate));
            element.clear();
            element.sendKeys(employeeStartDateUpdate);

            //fill email field
            element = driver.findElement(By.xpath(def.byEmail));
            element.clear();
            element.sendKeys(employeeEmailUpdate);

            //select update button
            def.selectUpdateButton(driver);

            //check that the list of employees is displayed
            def.elementVisibility(wait,def.byEmployeeList);
            Thread.sleep(1000);

            //scroll the employees list to find the updated employee
            String employeeNameUpdate =  employeeFirstNameUpdate + " " + employeeLastNameUpdate;
            def.scrollElement(driver,employeeNameUpdate);
            Thread.sleep(2000);

            //select the udpated employee name
            def.scrollListDoubleClick(driver,employeeNameUpdate);
            Thread.sleep(2000);

            //check that employee form is displayed
            def.elementVisibility(wait,def.byEmployeeForm);

            //check that the employee is properly updated
            String firstName= driver.findElement(By.xpath(def.byFirstName)).getAttribute("value");
            Assert.assertEquals(firstName,employeeFirstNameUpdate);

            String lastName= driver.findElement(By.xpath(def.byLastName)).getAttribute("value");
            Assert.assertEquals(lastName,employeeLastNameUpdate);

            String startDate= driver.findElement(By.xpath(def.byStartDate))
                    .getAttribute("value");
            Assert.assertEquals(startDate,employeeStartDateUpdate);

            String email= driver.findElement(By.xpath(def.byEmail)).getAttribute("value");
            Assert.assertEquals(email,employeeEmailUpdate);

        }catch(Exception e){

            //exception handling statements employees
            throw new Exception(e.getMessage());

        }finally{

            //close the opened browser window
            driver.quit();

        }
    }
}

