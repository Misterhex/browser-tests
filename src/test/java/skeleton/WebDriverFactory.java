package skeleton;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class WebDriverFactory {

    private static final String HUB_URL = "HUB_URL";

    public static WebDriver CreateNew() throws MalformedURLException {

        String browser = System.getProperty("browser", "chrome");

        DesiredCapabilities cap = DesiredCapabilities.chrome();

        RemoteWebDriver driver =  new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),cap);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        return driver;
    }
}
