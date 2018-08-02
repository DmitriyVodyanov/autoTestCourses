package autotest.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public void initializeDriver() {
        String OS = System.getProperty("os.name");
        if (OS.toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); //initializing the driver in the operating system for Antichrists
        } else
            System.setProperty("webdriver.chrome.driver", "./toolsLinux/chromedriver"); //initializing the driver in the operating system for Orthodox
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}



