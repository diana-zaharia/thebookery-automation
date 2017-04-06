package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login {
    private WebDriver driver;

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginLocator = By.xpath("//button[text()='Sign in']");
    private By registerLinkLocator = By.xpath("//a[text()='Register']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void loginWith(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        submitLogin();
    }

    private void fillUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    private void fillPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    private void submitLogin() {
        driver.findElement(loginLocator).click();
    }

    public void goToRegisterPage() {
        driver.findElement(registerLinkLocator).click();
    }
}