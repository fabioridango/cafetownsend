package login.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LocatorMethodDefination;
import static web.browser.Browser.launchBrowser;

public class LoginValidUsernameInvalidPasswordTest extends LocatorMethodDefination {

    WebDriver driver;

    WebDriverWait wait;

    /* The method check in the log in form that in case of username field with valid value and password field with
     * invalid value the log in to application fail.
     *
     * @throws Exception
     *
     * @Parameters validPassword, invalidUsername, webAppUrl, loginUrl
     *
     */

    @Test
    @Parameters({ "validUsername", "invalidPassword", "webAppUrl", "loginUrl"})
    public void loginWithValidUsernameInvalidPassword(String validUsername,String invalidPassword, String webAppUrl,
                                                      String loginUrl) throws Exception {

        try {

            LoginValidUsernameInvalidPasswordTest def = new LoginValidUsernameInvalidPasswordTest();

            driver = launchBrowser();

            //web application launched
            driver.navigate().to(webAppUrl);

            wait = new WebDriverWait(driver, 10);

            //checks to see if the login form is present and also visible
            def.elementVisibility(wait,def.byLoginForm);
            Thread.sleep(500);

            //fill username field
            def.fillUsernameField(driver,validUsername);

            //fill password field
            def.fillPasswordField(driver,invalidPassword);

            //select login button
            def.selectLoginButton(driver);
            Thread.sleep(2000);

            //check that the user is redirected to employees web page
            Assert.assertEquals(loginUrl,driver.getCurrentUrl());

        }catch(Exception e){

            //exception handling statements employees
            throw new Exception(e.getMessage());

        }finally{

            //close the opened browser window
            driver.quit();

        }

    }
}

