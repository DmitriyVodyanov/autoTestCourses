package autotest.test;

import autotest.base.BaseTest;
import autotest.page.SearchPage;
import autotest.page.SpamPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class TestExemple extends BaseTest {

    private SearchPage searchPage;
    private SpamPage spamPage;

    @BeforeClass
    public void beforeTest() {
        spamPage = PageFactory.initElements(driver, SpamPage.class);
    }

    @Test
    public void SearchWeather() {
        driver.get("https://www.vk.com/");
        spamPage.loginAccount(spamPage.getPASSWORD(), spamPage.getLOGIN());
    }

    @Test
    public void sendSpamMessage() {
        driver.get("https://vk.com/goosewtf");
//        spamPage.sendMessage(spamPage.getSPAM_MESSAGE());
    }

    @Ignore
    @Test
    public void postCommentOnWall () {
        spamPage.commentOnWall(spamPage.getSPAM_MESSAGE());

    }



    @Ignore
    @Test
    public void compareListMoreTest() {
        driver.get("https://www.yandex.ru/");
        searchPage.selectLocation("лондон");
        List<String> moreListCityOne = searchPage.getMoreCatalog();
        moreListCityOne.set(5,"asdfasd");
        System.out.println(moreListCityOne);
        searchPage.selectLocation("париж ");
        List<String> moreListCityTwo = searchPage.getMoreCatalog();
        System.out.println(moreListCityTwo);
        if (moreListCityOne.size() != moreListCityTwo.size()) {
            System.out.println("Списки не равны по длине");
        }
        if (moreListCityOne.size() == moreListCityTwo.size()) {
            for (int i = 0; i < moreListCityOne.size(); i++) {
                Assert.assertEquals(moreListCityOne.get(i), moreListCityTwo.get(i));
            }
        }
    }
}
