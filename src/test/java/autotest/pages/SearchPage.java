package autotest.pages;

import autotest.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BaseTest {

    By FieldInput = By.id("text");
    By searchButton = By.cssSelector(".search2__button button");
    By firstLink = By.cssSelector(".serp-item:nth-child(3)  .organic__url");

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void search(String text) {
        clearFielByElement(FieldInput);
        sendKeysByElement(FieldInput, text);
        clickByElement(searchButton);
    }

    public String getResult() {
        return driver.findElement(firstLink).getText();
    }
}
