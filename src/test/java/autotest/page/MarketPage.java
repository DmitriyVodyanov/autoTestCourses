package autotest.page;

import autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.linkText;

public class MarketPage extends BasePage {


    By computersLink = cssSelector("li[data-department='Компьютеры'] a[href='/catalog/54425?hid=91009&track=menu']");
    By laptopLink = cssSelector("a[href='/catalog/54544/list?hid=91013&track=fr_ctlg']");
    By elementsOnPage = cssSelector(".n-snippet-card2__title");
    By quantityButton = cssSelector("button[role='listbox']");
    By selectTwelveElements = cssSelector(".select__text:nth-child(1)");
    //    By selectFortyEightElements = cssSelector(".select__text:nth-child(2)");
    By firstElementList = cssSelector("n-snippet-card2:nth-child(1)");
    By secondElementList = cssSelector(".n-snippet-card2:nth-child(2)");
    By compareCheckBoxOneItem = cssSelector(".n-snippet-card2:nth-child(1) .n-user-lists_type_compare");
    By compareCheckBoxTwoItem = cssSelector(".n-snippet-card2:nth-child(2) .n-user-lists_type_compare");
    By compareButton = cssSelector("a[href='/compare?track=head']");
    By comparedItems = cssSelector(".n-compare-content__line_js_inited");
    By removeItenCompared = cssSelector(".n-compare-toolbar__action .link");
    By notItemCompared = className("title_size_18");
    By priceItem = cssSelector(".n-snippet-list div[class ='price']");
    By sortToPriceButton = linkText("по цене");
    By sortToPriceButtonBeforeClick = className("n-filter-sorter i-bem n-filter-sorter_js_inited");
    By sortToPriceButtonAfterClick = className("n-filter-sorter_state_select");




    public MarketPage(WebDriver driver) {
        super(driver);
    }

    public void selectCompLaptop() {
        clickByElement(computersLink);
        clickByElement(laptopLink);
    }

    public void computerTwelveElementsPage() {
        clickByElement(quantityButton);
        clickByElement(selectTwelveElements);
        waitForElement(elementsOnPage);
    }

    public void compareElementPage() {
        moveByElement(firstElementList);
        clickByElement(compareCheckBoxOneItem);
        moveByElement(secondElementList);
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
        driver.navigate().refresh();
        List<WebElement> computerCatalog = driver.findElements(elementsOnPage);
        return computerCatalog.size();
    }


    public List<String> sortByPrice() {
        driver.get("https://market.yandex.ru");
        selectCompLaptop();
        clickByElement(sortToPriceButton);
        driver.navigate().refresh();
        List<WebElement> priceItemPars = driver.findElements(priceItem);
        List<String> priceItemParsHelp = new ArrayList<String>();
//        List<Integer> convertPriceList = new ArrayList();
        for (int i = 0; i < priceItemPars.size(); i++) {
            priceItemParsHelp.add(priceItemPars.get(i).getText());
//            convertPriceList = Collections.singletonList(Integer.parseInt(priceItemParsHelp.get(i).replaceAll("[от \\s \u20BD]", "")));
//            for (int count = 0; count < priceItemParsHelp.size(); count ++ ){
//                convertPriceList = Collections.singletonList(Integer.parseInt(priceItemParsHelp.get(count).replaceAll("[от \\s \u20BD]", "")));
//            }
        }

        return priceItemParsHelp;
    }

    public String clearingPriceExtraCharacters(String str) {
        str = str.replaceAll("\\s+", "");
        str = str.replaceAll("\\u20BD", "");
        str = str.replaceAll("от", "");
        return str;
    }






    public Boolean convertNumericFormatAndComparison(List<String> text) {
        for (int i = 0; i < text.size() - 1; i++) {
            if (!(Integer.parseInt(text.get(i)) <= Integer.parseInt(text.get(i + 1)))) {
                return false;
            }
        }
        return true;
    }

}


