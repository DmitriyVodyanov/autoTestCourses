package autotest.page;

import autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;

public class MarketPage extends BasePage {

    By testElement = cssSelector("a[href='/compare?track=head']");

    By computersLink = cssSelector("li[data-department='Компьютеры'] a[href='/catalog/54425?hid=91009&track=menu']");
    By laptopLink = cssSelector("a[href=\'/catalog/54544/list?hid=91013&track=menuleaf\']");
    By elementsOnPage = cssSelector(".n-snippet-card2__title");
    By searchButton = cssSelector(".search2__button .button2");
    By changeRegion = className(".n-region-notification__ok");


    public MarketPage(WebDriver driver) {
        super(driver);
    }

    public void computerPage() {
        clickByElement(changeRegion);
//        moveByElement(computersLink);
//        clickByElement(laptopLink);
    }

//    public List<WebElement> getCatalogComputers() {
//        List<WebElement> computerCatalog = driver.findElements(elementsOnPage);
//        List<String> computerCatalogStr = new ArrayList<String>();
//        for (int i = 0; i < computerCatalog .size(); i++) {
//            computerCatalogStr.add(String.valueOf(computerCatalog .get(i).getSize()));
//        return computerCatalog;
//        }

    }


