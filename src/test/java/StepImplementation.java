import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageobjects.Dashboard;
import pageobjects.Login;
import pageobjects.Register;

import java.nio.file.Paths;

public class StepImplementation {
    private WebDriver driver;

    //SETUP

    @BeforeScenario
    public void setup() {
        System.setProperty("webdriver.gecko.driver", Paths.get(System.getProperty("user.dir"), "drivers", "geckodriver.exe").toString());
        DesiredCapabilities firefoxCapability = DesiredCapabilities.firefox();
        firefoxCapability.setCapability("marionette", true);
        driver = new MarionetteDriver(firefoxCapability);

        driver.manage().window().maximize();
    }

    @AfterScenario
    public void teardown() {
        if (driver != null) driver.quit();
    }

    @Step("Navigate to The Bookery app")
    public void navigate_to() {
        driver.get(System.getenv("thebookery_url"));
    }

    //LOGIN Steps

    @Step("Log in with credentials <user> <password>")
    public void login_with(String username, String password) {
        Login loginPage = new Login(driver);
        loginPage.loginWith(username, password);
    }

    @Step("Go to Register page")
    public void go_to_register() {
        Login loginPage = new Login(driver);
        loginPage.goToRegisterPage();
    }

    //DASHBOARD steps

    @Step("The dashboard should be displayed")
    public void is_dashboard_displayed() {
        Dashboard dashboard = new Dashboard(driver);
        Assert.assertTrue(dashboard.isDisplayed());
    }

    @Step("Navigate to Add Book page")
    public void navigate_add_book() {
        // add your code here
    }

    //REGISTER steps

    @Step("Register new user <username> having fullname <firstname> <lastname>, email <email> and password <password>")
    public void register_user(String username, String firstName, String lastName, String email, String password) {
        Register registerPage = new Register(driver);
        registerPage.registerUser(username, firstName, lastName, email, password);
    }

    @Step("Success message is displayed after completing registration")
    public void verify_successful_registration() {
        Register registerPage = new Register(driver);
        Assert.assertTrue("Success message was not displayed upon completing registration", registerPage.isSuccessMessageDisplayed());
    }

    //ADD BOOK steps

    @Step("Add new book with title <title>, author <author>, edition <edition> and <pages> number of pages")
    public  void add_book_with_details(String title, String author, String edition, int pages){
        // add your code here
    }
}