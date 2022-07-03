package qa.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumAllMethods {
    static WebDriver driver;

    @Test
    @Parameters({"browser"})
    public static void launchApp(String browser) { //Chrome
        try {
            String path = System.getProperty("user.dir");
            //Setup chromedriver path and launch chrome
            System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            // Maximize browser
            driver.manage().window().maximize();
			System.out.println("browser maximized");

            // Search for results
            driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			System.out.println("App Launched");


            System.out.println("Page Title: " + driver.getTitle());
			System.out.println("page title printed on console");

            driver.findElement(By.id("login1")).sendKeys("Kumar QA");
			System.out.println("entered text into textfiled Username");

            Thread.sleep(1000);
            driver.findElement(By.name("proceed")).click();
			System.out.println("clicked on siin button");
            Thread.sleep(1000);

            Alert alert = driver.switchTo().alert();
            alert.accept();
			System.out.println("Closed the Alert");

            Thread.sleep(1000);
            driver.navigate().back();
			System.out.println("navigate back");

            Thread.sleep(1000);
            driver.navigate().forward();
			System.out.println("navigate forward");

            Thread.sleep(1000);
            driver.navigate().refresh();
			System.out.println("page has been refreshed");
            Thread.sleep(1000);

            System.out.println("printing text using getText() " + driver.findElement(By.id("remember")).getText());
			System.out.println("Label or Text on on the locator printed");

            System.out.println("priting attribute value of a tag using getAttribute() " + driver.findElement(By.id("login1")).getAttribute("class"));
			System.out.println("attribute value printed");

            //get the windowID of the current window
            Thread.sleep(1000);
            String firstTab = driver.getWindowHandle();
			System.out.println("window ID captured");

            //Open a new window using Selenium 4 as shown below
            driver.switchTo().newWindow(WindowType.TAB);
			System.out.println("new window launched");

            driver.get("https://facebook.com");
			System.out.println("facebook launched in newly opned window");

            //loop among the all opened windows using for loop
            Set<String> windoTabs = driver.getWindowHandles();
            for (String myWindow : windoTabs) {
                driver.switchTo().window(myWindow);
                Thread.sleep(1000);
                System.out.println("print title " + driver.getTitle());
            }

            //Switch to the first window
			Thread.sleep(1000);
			driver.switchTo().window(firstTab);
			System.out.println("switched back to original rediff window");
			Thread.sleep(1000);

            //Capture screenshot at element level
            WebElement SignInEle  = driver.findElement(By.name("proceed"));
            File source = SignInEle.getScreenshotAs(OutputType.FILE);
            File dest = new File(System.getProperty("user.dir") + "/screenshots/rediffScreenshot.png");
            FileHandler.copy(source, dest);

            ////Capture full page screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFullPage = new File(System.getProperty("user.dir") + "/screenshots/fullPage.png");
            FileHandler.copy(src, destFullPage);


            //isDisplayed() used to check whether ele displayed on the page
            WebElement RediffLabel  = driver.findElement(By.xpath("//div[text()='rediff']"));
            System.out.println("is rediffLabel displayed? "+RediffLabel.isDisplayed());

            WebElement SignInButton  = driver.findElement(By.name("proceed"));
            System.out.println("Is SignIn button enabled? "+ SignInButton.isEnabled());

            //isEnabled() used to check whether button enabled on the page
            if(SignInButton.isEnabled()) {
                SignInButton.click();
                alert = driver.switchTo().alert();
                alert.accept();
            }

            //Selecting element from a dropdown with 3 ways as shown below
            driver.get("https://demo.guru99.com/test/newtours/register.php");
            Thread.sleep(1000);
            Select countryDropdown = new Select(driver.findElement(By.name("country")));
            Thread.sleep(1000);
            countryDropdown.selectByIndex(3);
            Thread.sleep(1000);
            countryDropdown.selectByValue("ALGERIA");
            Thread.sleep(1000);
            countryDropdown.selectByVisibleText("AUSTRALIA");
            Thread.sleep(1000);

            //Close browser
            driver.close();
            driver.quit();
            System.out.println("closed the browser");


        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }
}
