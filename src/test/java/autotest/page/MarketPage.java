package autotest.page;

import autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;

public class MarketPage extends BasePage {

    By testElement = cssSelector("option[value='12']");

    By computersLink = cssSelector("li[data-department='Компьютеры'] a[href='/catalog/54425?hid=91009&track=menu']");
    By laptopLink = cssSelector("a[href='/catalog/54544/list?hid=91013&track=fr_ctlg']");
    By elementsOnPage = cssSelector(".n-snippet-card2__title");
    By quantityButton = className(".select__button");
//    By selectFortyEightElements = id("uniq15329538197232");
    By selectTwelveElements = className("select__control");
    By firstElementList = cssSelector("n-snippet-card2:nth-child(1)");
    By secondElementList = cssSelector(".n-snippet-card2:nth-child(2)");
    By compareCheckBoxOneItem = cssSelector(".n-snippet-card2:nth-child(1) .n-user-lists_type_compare");
    By compareCheckBoxTwoItem = cssSelector(".n-snippet-card2:nth-child(2) .n-user-lists_type_compare");
    By compareButton = cssSelector("a[href='/compare?track=head']");
    By comparedItems = cssSelector(".n-compare-content__line_js_inited");
    By removeItenCompared = cssSelector(".n-compare-toolbar__action .link");
    By notItemCompared = className("title_size_18");
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
        clickByElement(testElement);
        selectByElement(selectTwelveElements, "Показывать по 12");
//        clickByElement(selectTwelveElements);
    }

    public void compareElementPage() {
        clickByElement(computersLink);
        clickByElement(laptopLink);
        moveByElement(firstElementList);
        clickByElement(compareCheckBoxOneItem);
        clickByElement(compareCheckBoxTwoItem);
        clickByElement(compareButton);
    }

    public void removeElementsCopared() {
        clickByElement(removeItenCompared);
    }

    public int getComparedItemOnPage() {
        List<WebElement> comparedItemsCatalog = driver.findElements(comparedItems);
        return comparedItemsCatalog.size();
    }

    public String notItemCompared() {
        return driver.findElement(notItemCompared).getText();
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


