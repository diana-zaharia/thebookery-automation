package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddBook {
    private WebDriver driver;

    private By titleLocator = By.id("title");
    private By authorLocator = By.id("author");
    private By editionLocator = By.id("edition");
    private By pagesLocator = By.id("pages");
    private By addLocator = By.name("add");

    public AddBook(WebDriver driver) {
        this.driver = driver;
    }

    public void addBookWithDetails(String title, String author, String edition, int pages) {
        fillTitle(title);
        fillAuthor(author);
        fillEdition(edition);
        fillPages(pages);
        addBook();
    }

    private void fillTitle(String title) {

    }

    private void fillAuthor(String author) {
        // add your code here
    }

    private void fillEdition(String edition) {
        // add your code here
    }

    private void fillPages(int pages) {
        // add your code here
    }

    private void addBook() {
        // add your code here
    }
}
