package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    private WebDriver driver;

    private By usernameLocator = By.id("username");
    private By firstNameLocator = By.id("firstName");
    private By lastNameLocator = By.id("lastName");
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("password");
    private By confirmPasswordLocator = By.id("confirmPassword");
    private By submitLocator = By.xpath("//button[text()='Register']");
    private By successMessageLocator = By.xpath("//p[text()=' You have been successfully registered, now you can login. ']");

    public Register(WebDriver driver) {
        this.driver = driver;
        waitForPageToLoad(driver);
    }

    private void waitForPageToLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#authHeader h1"), "Register"));
    }

    public void registerUser(String username, String firstName, String lastName, String email, String password) {
        fillUsername(username);
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmail(email);
        fillPassword(password);
        confirmPassword(password);
        completeRegistration();
    }

    private void fillUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    private void fillFirstName(String firstName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

    private void fillLastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }

    private void fillEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    private void fillPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    private void confirmPassword(String password) {
        driver.findElement(confirmPasswordLocator).sendKeys(password);
    }

    private void completeRegistration() {
        driver.findElement(submitLocator).click();
    }

    public void waitUntilSuccessMessageDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(successMessageLocator));
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            waitUntilSuccessMessageDisplayed();
        } catch (TimeoutException e) {
            return false;
        }

        return true;
    }
}
