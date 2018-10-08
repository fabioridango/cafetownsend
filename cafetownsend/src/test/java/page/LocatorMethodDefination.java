package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatorMethodDefination {

    //define the locators
    public String byUsername = "//input[@type='text']";
    public String byPassword = "//input[@type='password']";
    public String byLoginButton = "//button[@type='submit']";
    public String byLoginForm = "//form[@id='login-form']";
    public String byLogoutButton = "//p[@class='main-button']";
    public String byEmployeeList = "//div[@id='employee-list-container']";
    public String byEmployeeForm = "//form[@name='employeeForm']";
    public String byFirstName = "//fieldset//label[1]//input[1]";
    public String byLastName = "//fieldset//label[2]//input[1]";
    public String byStartDate = "//input[@title='Please enter a date formatting YYYY-MM-DD']\n";
    public String byEmail = "//input[@type='email']";
    public String byUpdate = "//button[contains(text(),'Update')]";
    public String byDeleteButton = "//a[@id='bDelete']";
    public String byCreateButton = "//a[@id='bAdd']";
    public String byAddButton = "//button[contains(text(),'Add')]";
    public String byEmployeeDetails = "//form[@name='employeeForm']";
    public String byEditButton = "//a[@id='bEdit']";
    public String byBackButton = "//a[@class='subButton bBack']";

    //checks if the element is present and also visible
    public void elementVisibility(WebDriverWait wait,String element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    //fill username field
    public void fillUsernameField(WebDriver driver,String validUsername){
        driver.findElement(By.xpath(byUsername)).sendKeys(validUsername);
    }

    //fill password field
    public void fillPasswordField(WebDriver driver,String validPassword){
        driver.findElement(By.xpath(byPassword)).sendKeys(validPassword);
    }

    //select login button
    public void selectLoginButton(WebDriver driver){
        driver.findElement(By.xpath(byLoginButton)).click();
    }

    //select logout button
    public void selectLogoutButton(WebDriver driver){
        driver.findElement(By.xpath(byLogoutButton)).click();
    }

    //select create button
    public void selectCreateButton(WebDriver driver){
        driver.findElement(By.xpath(byCreateButton)).click();
    }

    //fill first name field in the employee form
    public void fillFirstNameField(WebDriver driver,String employeeFirstNameAdd) {
        driver.findElement(By.xpath(byFirstName)).sendKeys(employeeFirstNameAdd);
    }

    //fill last name field in the employee form
    public void fillLastNameField(WebDriver driver,String employeeLastNameAdd) {
        driver.findElement(By.xpath(byLastName)).sendKeys(employeeLastNameAdd);
    }

    //fill start date field in the employee form
    public void fillStartDateField(WebDriver driver,String employeeStartDateAdd) {
        driver.findElement(By.xpath(byStartDate)).sendKeys(employeeStartDateAdd);
    }

    //fill email field in the employee form
    public void fillEmailField(WebDriver driver,String employeeEmailAdd) {
        driver.findElement(By.xpath(byEmail)).sendKeys(employeeEmailAdd);
    }

    //select add button in the employee form
    public void selectAddButton(WebDriver driver) {
        driver.findElement(By.xpath(byAddButton)).click();
    }

    //select in the employees list the delete button
    public void selectDeleteButton(WebDriver driver) {
        driver.findElement(By.xpath(byDeleteButton)).click();
    }

    //select in the employee details the back button
    public void selectBackButton(WebDriver driver) {
        driver.findElement(By.xpath(byBackButton)).click();
    }

    //scroll the employees list to find the employee
    public void scrollElement(WebDriver driver,String name) {
        WebElement element = driver.findElement(By.xpath("//li[contains(text()," + "'" + name + "'" + " )]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    //select in the employees list the edit button
    public void selectEditButton(WebDriver driver) {
        driver.findElement(By.xpath(byEditButton)).click();
    }

    //select update button in the employee form
    public void selectUpdateButton(WebDriver driver) {
        driver.findElement(By.xpath(byUpdate)).click();
    }

    //select with double click the input employee in the list
    public void scrollListDoubleClick(WebDriver driver,String element) {
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath("//li[contains(text()," + "'" + element + "'"
                + " )]"))).perform();
    }
}

