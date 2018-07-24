package autotest.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}



