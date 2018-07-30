package autotest.page;

import autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class MarketPage extends BasePage {

    By testElement = cssSelector("option[value='12']");

    By computersLink = cssSelector("li[data-department='Компьютеры'] a[href='/catalog/54425?hid=91009&track=menu']");
    By laptopLink = cssSelector("a[href='/catalog/54544/list?hid=91013&track=fr_ctlg']");
    By elementsOnPage = cssSelector(".n-snippet-card2__title");
    By quantityElementButton = className("select__button");
//    By selectFortyEightElements = id("uniq15329538197232");
    By selectTwelveElements = className("select__control");
//    By selectTwelveElements = className("select__control");



    public MarketPage(WebDriver driver) {
        super(driver);
    }

    public void computerFortyEightElementsPage() {
        clickByElement(computersLink);
        clickByElement(laptopLink);
//        clickByElement(selectTwelveElements);
    }

    public void computerTwelveElementsPage() {
        clickByElement(computersLink);
        clickByElement(laptopLink);
//        scrollByElement(quantityElementButton);
        clickByElement(quantityElementButton);
        clickByElement(testElement);
        selectByElement(selectTwelveElements, "Показывать по 12");
//        clickByElement(selectTwelveElements);
    }

    public int getCatalogComputers() {
        List<WebElement> computerCatalog = driver.findElements(elementsOnPage);
//        List<String> computerCatalogStr = new ArrayList<String>();
//        for (int i = 0; i < computerCatalog.size(); i++) {
//            computerCatalogStr.add(String.valueOf(computerCatalog.get(i).getSize()));
//        }
        return computerCatalog.size();
    }

}


