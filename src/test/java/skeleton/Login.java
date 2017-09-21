package skeleton;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class Login {

    private final WebDriver driver = new WebDriverFactory().Create();
    private final URL AcqoUrl = new URL("http://dev.acuo.com");

    @Given("^I am on the login page$")
    public void I am_on_the_login_page() throws Throwable {

        driver.get(AcqoUrl.toString());
        driver.findElement(By.cssSelector("form div.Login__input___3nbxz input[type='text']"));
    }

}
