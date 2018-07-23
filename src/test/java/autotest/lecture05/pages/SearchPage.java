package autotest.lecture05.pages;

import autotest.lecture05.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    By FieldInput = By.id("text");
    By searchButton = By.cssSelector(".search2__button button");
    By firstLink = By.cssSelector(".serp-item:nth-child(3)  .organic__url");

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void search(String text) {
        clearFieldByElement(FieldInput);
        sendKeysByElement(FieldInput, text);
        clickByElement(searchButton);
    }

    public String getResult() {
        return driver.findElement(firstLink).getText();
    }
}