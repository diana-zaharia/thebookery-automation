package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
    private WebDriver driver;

    public Dashboard(WebDriver driver){
        this.driver = driver;
    }

    private By dashboardLocator = By.linkText("Dashboard");
    private By addBookLocator = By.linkText("Add book");

    public void navigateToAddBook() {
        //add your code here
    }

    private void waitUntilDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(dashboardLocator));
    }

    public boolean isDisplayed() {
        try {
            waitUntilDisplayed();
        } catch (TimeoutException e) {
            return false;
        }

        return true;
    }
}