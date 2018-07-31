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

    By FieldInput = id("text");
    By searchButton = cssSelector(".search2__button button");
    By firstLink = cssSelector(".serp-item:nth-child(3) .organic__url");
    By moreButton = cssSelector("a[data-statlog='tabs.more']");
    By locationLink = cssSelector("a[data-statlog='head.region.setup']");
    By more = className("home-tabs__more-item");
    By inputLocation = id("city__front-input");
    By locationCity = cssSelector("li:nth-child(1)");
    By videoLink = cssSelector("a[data-id='video']");
    By imagesLink = cssSelector("a[data-id='images']");
    By newsLink = cssSelector("a[data-id='news']");
    By mapsLink = cssSelector("a[data-id='maps']");
    By marketLink = cssSelector("a[data-id='market']");
    By translateLink = cssSelector("a[data-id='translate']");
    By musicLink = cssSelector("a[data-id='music']");
    By tvonlineLink = cssSelector("a[data-id='tvonline']");


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
        clickByElement(locationCity);
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

    public void navigation() {
        clickByElement(videoLink);
        backToPage();
        clickByElement(imagesLink);
    }
}




