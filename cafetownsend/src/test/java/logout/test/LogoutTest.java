package logout.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LocatorMethodDefination;
import static web.browser.Browser.launchBrowser;

public class LogoutTest extends LocatorMethodDefination {

    WebDriver driver;

    WebDriverWait wait;

    /* Method to log out an user from the application.
     *
     * @throws Exception
     *
     * @Parameters validUsername, validPassword, webAppUrl, loggedUrl, loginUrl
     *
     */

    @Test
    @Parameters({ "validUsername", "validPassword", "webAppUrl", "loggedUrl", "loginUrl"})
    public void logoutWebApp(String validUsername,String validPassword, String webAppUrl, String loggedUrl, String loginUrl)
            throws Exception {

        try {

            LogoutTest def = new LogoutTest();

            driver = launchBrowser();

            //web application launched
            driver.navigate().to(webAppUrl);

            wait = new WebDriverWait(driver, 10);

            //checks if the login form is present and also visible
            def.elementVisibility(wait,def.byLoginForm);
            Thread.sleep(500);

            //fill username field
            def.fillUsernameField(driver,validUsername);

            //fill password field
            def.fillPasswordField(driver,validPassword);

            //select login button
            def.selectLoginButton(driver);
            Thread.sleep(2000);

            //check that the user is redirected to employees web page
            Assert.assertEquals(loggedUrl,driver.getCurrentUrl());

            //select logout button
            def.selectLogoutButton(driver);

            //check that the user is redirected to login web page
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

