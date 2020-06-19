package regression;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}

)
public class MyTestRunner
{
    static WebDriver driver;
    public static final String USERNAME = "namitayelwande1";
    public static final String AUTOMATE_KEY = "QMwzWAjayFDsWNpHPZsb";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @BeforeClass
    public static void startBrowser() throws InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
      /* caps.setCapability("browser", "Edge");
        caps.setCapability("browser_version", "84.0 beta");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "namita Test");
*/

        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "84.0 beta");
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Catalina");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");




        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Thread.sleep(10000);


    }
    @AfterClass
    public static void stopBrowser()
    {
        driver.quit();
    }


}
