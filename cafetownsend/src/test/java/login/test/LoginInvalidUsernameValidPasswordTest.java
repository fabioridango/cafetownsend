package login.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LocatorMethodDefination;
import static web.browser.Browser.launchBrowser;

public class LoginInvalidUsernameValidPasswordTest extends LocatorMethodDefination {

    WebDriver driver;

    WebDriverWait wait;

    /* The method check in the log in form that in case of username field with invalid value and password field with
     * valid value the log in to application fail.
     *
     * @throws Exception
     *
     * @Parameters invalidUsername, validPassword, webAppUrl, loginUrl
     *
     */

    @Test
    @Parameters({ "invalidUsername", "validPassword", "webAppUrl", "loginUrl"})
    public void loginWithInvalidUsernameValidPassword(String invalidUsername, String validPassword, String webAppUrl,
                                                      String loginUrl) throws Exception {

        try {

            LoginInvalidUsernameValidPasswordTest def = new LoginInvalidUsernameValidPasswordTest();

            driver = launchBrowser();

            //web application launched
            driver.navigate().to(webAppUrl);

            wait = new WebDriverWait(driver, 10);

            //checks to see if the login form is present and also visible
            def.elementVisibility(wait,def.byLoginForm);
            Thread.sleep(500);

            //fill username field
            def.fillUsernameField(driver,invalidUsername);

            //fill password field
            def.fillPasswordField(driver,validPassword);

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




