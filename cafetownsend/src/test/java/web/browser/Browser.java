package web.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Browser {

    /* The method configure the web browser
     *
     * @throws Exception
     *
     */

    public static WebDriver launchBrowser() throws Exception
    {
        WebDriver driver;

        //get current working directory
        String currentDirectory = System.getProperty("user.dir");

        //set geckodriver path
        System.setProperty("webdriver.gecko.driver", currentDirectory + "/src/main/resources/geckodriver");

        driver = new FirefoxDriver();

        //maximize the browser window
        driver.manage().window().maximize();

        //implicitly wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }
}