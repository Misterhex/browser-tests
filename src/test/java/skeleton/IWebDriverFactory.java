package skeleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public interface IWebDriverFactory {

    WebDriver Create() throws MalformedURLException;
}

public class WebDriverFactory implements IWebDriverFactory {

    @Override
    public WebDriver Create() throws MalformedURLException {
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());

    }
}