package autotest.page;

import autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import static org.openqa.selenium.By.*;

public class SearchPage extends BasePage {

    private final WebDriver driver;

    private By FieldInput = id("text");
    private By searchButton = cssSelector(".search2__button button");
    private By firstLink = cssSelector(".serp-item:nth-child(3)  .organic__url");
    private By moreButton = cssSelector("a[data-statlog='tabs.more']");
    private By locationLink = cssSelector("a[data-statlog='head.region.setup']");
    private By more = className("home-tabs__more-item");
    private By inputLocation = id("city__front-input");
    private By inputlocationCity = cssSelector("li:nth-child(1)");

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

    public void selectLocation(String text) {
        clickByElement(locationLink);
        clearFieldByElement(inputLocation);
        sendKeysByElement(inputLocation, text);
        clickByElement(inputlocationCity);
    }

    public List<String> getMoreCatalog() {
        clickByElement(moreButton);
        List<WebElement> moreCatalog = driver.findElements(more);
        List<String> moreCatalogName = new ArrayList<String>();
        for (int i = 0; i < moreCatalog.size(); i++) {
            moreCatalogName.add(moreCatalog.get(i).getText());
        }
        return moreCatalogName;
    }

}

