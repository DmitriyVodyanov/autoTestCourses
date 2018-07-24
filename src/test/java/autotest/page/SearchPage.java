package autotest.page;

import autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private By FieldInput = By.id("text");
    private By searchButton = By.cssSelector(".search2__button button");
    private By firstLink = By.cssSelector(".serp-item:nth-child(3)  .organic__url");
    private By moreButton = By.cssSelector("a[data-statlog='tabs.more']");
    private By locationLink = By.cssSelector("a[data-statlog='head.region.setup']");
    private By more = By.className("home-tabs__more-item");

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void searchWeather(String text) {
        clearFieldByElement(FieldInput);
        sendKeysByElement(FieldInput, text);
        clickByElement(searchButton);
    }

    public String getResult() {
        return driver.findElement(firstLink).getText();
    }

    public void selectLocationMainPage() {
        clickByElement(locationLink);
    }

    public void openMoreCatalog() {
        clickByElement(moreButton);
    }
}
