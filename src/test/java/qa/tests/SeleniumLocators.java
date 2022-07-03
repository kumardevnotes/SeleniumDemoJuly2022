package qa.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class SeleniumLocators {
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

            //id locator
            WebElement usernameField = driver.findElement(By.id("login1"));

            //name locator
            usernameField = driver.findElement(By.name("login"));

            //className locator
            WebElement signInBtn = driver.findElement(By.className("signinbtn"));

            //xpath locator
            signInBtn = driver.findElement(By.xpath("//input[@value='Sign in']"));
            System.out.println(signInBtn.isDisplayed());

            //xpath
            signInBtn = driver.findElement(By.xpath("//input[@title='Sign in']"));
            System.out.println(signInBtn.isDisplayed());

            //xpath
            signInBtn = driver.findElement(By.xpath("//input[@class='signinbtn']"));
            System.out.println(signInBtn.isDisplayed());

            //xpath
            WebElement userNameLabel = driver.findElement(By.xpath("//p[.='Username']"));
            System.out.println(userNameLabel.isDisplayed());

        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }
}
