package automation.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class WikipediaTests {
    static WebDriver driver;
    static Properties props;
    @BeforeClass
    public void setUp() throws Exception {
        FileReader fileReadObj  =
                new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\app.properties");
        props = new Properties();
        props.load(fileReadObj);
        // Setup chromedriver path and launch chrome
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyHomePage() {
        try {
            driver.get(props.getProperty("appUrl"));
            Thread.sleep(2000);

            String pageTitle = driver.getTitle();
            WebElement element = driver.findElement(By.xpath("//a//strong[.='English']/.."));

            if(pageTitle.equals(props.getProperty("appTitle")) && element.isDisplayed()){ //false && true = false
                System.out.println("Wikipedia title verified");
            }
            else {
                Assert.fail("wikipedia title is not verified");
            }
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }

    @Test
    public void verifySearchResults() throws IOException {
        try {
            driver.get(props.getProperty("appUrl"));
            Thread.sleep(2000);

            WebElement searchFieldElement = driver.findElement(By.id("searchInput"));
            searchFieldElement.clear();
            searchFieldElement.sendKeys(props.getProperty("searchKey"));

            WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
            searchButton.click();
            Thread.sleep(2000);

            //List<WebElement> searchResultElements = driver.findElements(By.xpath("//text()[.='Selenium']"));
            List<WebElement> searchResultElements = driver.findElements(By.xpath("//*[.='Selenium']"));
            if(searchResultElements.size() > 2){ //false && true = false
                System.out.println("Wikipedia search results verified");
            }
            else {
                //Capture full page screenshot
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destFullPage = new File(System.getProperty("user.dir") + "/screenshots/wikipediaFailure.png");
                FileHandler.copy(src, destFullPage);
                Assert.fail("wikipedia search results not verified");
            }
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFullPage = new File(System.getProperty("user.dir") + "/screenshots/wikipediaFailure.png");
            FileHandler.copy(src, destFullPage);
            Assert.fail("wikipedia search results not verified");
        }
    }

    @AfterClass
    public void tearDown(){
        // Closing the chrome
        driver.close();
        driver.quit();
    }
}
