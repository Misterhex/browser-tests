package skeleton;

import cucumber.api.java.After;
import cucumber.api.java.bs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginSteps {

    private final URL AcqoSite = new URL("http://dev.acuo.com/");

    private final WebDriver driver = WebDriverFactory.CreateNew();

    public LoginSteps() throws MalformedURLException {
    }

    @Given("^I am on Acqo login page")
    public void I_am_on_Acqo_login_page() {

        driver.manage().window().maximize();
        
        driver.get(AcqoSite.toString());
    }

    @When("^I enter (.*) and (.*) in the form$")
    public void I_enter_username_and_password_in_the_form(String username, String password) throws InterruptedException {
        System.out.println(String.format("logging in with username: %s and password: %s", username, password));


        String usernameSelector = "form div.Login__input___3nbxz input[type=\"text\"]";
        WebElement webElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(usernameSelector)));
        Thread.sleep(5000);
        webElement.clear();
        webElement.sendKeys(username);

        String passwordSelector = "form div.Login__input___3nbxz input[type=\"password\"]";
        webElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(passwordSelector)));
        Thread.sleep(1000);
        webElement.clear();
        webElement.sendKeys(password);

        String formSelector = "form";
        webElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(formSelector)));
        webElement.submit();
    }

    @And("^I enter (.*) code on the mfa screen$")
    public void I_enter_2fa_code_on_the_mfa_screen(String twoFactorCode) {
        System.out.println(String.format("twoFactorCode: %s", twoFactorCode));

        String selector;

        WebElement webElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("TwoFA__label___2vhfk")));
        String labelText = webElement.getText();
        System.out.println(String.format("labelText: %s", labelText));

        selector = "input[type=\"password\"]";
        webElement = driver.findElement(By.cssSelector(selector));
        webElement.clear();
        webElement.sendKeys(twoFactorCode);

        selector = "button";
        webElement = driver.findElement(By.cssSelector(selector));
        webElement.click();
    }

    @Then("^I am redirected to the dashboard page$")
    public void I_am_redirected_to_the_dashboard_page() {

        String selector = "div.Dashboard__filterGraphContainer___WnxN5";

        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

    @After()
    public void closeBrowser() {
        System.out.println("quitting driver");
        driver.quit();
    }
}
