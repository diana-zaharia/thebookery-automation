import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class StepImplementation {
    private WebDriver driver;

    @BeforeScenario
    public void setup() {
        System.setProperty("webdriver.gecko.driver", Paths.get(System.getProperty("user.dir"), "drivers", "geckodriver.exe").toString());
        DesiredCapabilities firefoxCapability = DesiredCapabilities.firefox();
        firefoxCapability.setCapability("marionette", true);
        driver = new MarionetteDriver(firefoxCapability);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterScenario
    public void teardown() {
        driver.quit();
    }

    @Step("Navigate to <url>")
    public void navigate_to(String url) {
        driver.get(url);
    }

    @Step("Log in with credentials <username> and <password>")
    public void login_with(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
        loginButton.click();
    }

    @Step("The dashboard should be displayed")
    public void check_dashboard_displayed() {
        WebElement dashboard = driver.findElement(By.linkText("Dashboard"));
        Assert.assertTrue(dashboard.isDisplayed());
    }
}