package qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumXPathLocator {
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
            WebElement myElement = driver.findElement(By.xpath("//input[@name='proceed']"));
            System.out.println(myElement.isDisplayed());
            myElement = driver.findElement(By.xpath("//input[@value='Sign in']"));
            System.out.println(myElement.isDisplayed());
            myElement = driver.findElement(By.xpath("(//input)[3]"));
            System.out.println(myElement.isDisplayed());
            myElement = driver.findElement(By.xpath("//label[text()='Keep me signed in']"));
            System.out.println(myElement.isDisplayed());
            myElement = driver.findElement(By.xpath("//p[.='Username']"));
            System.out.println(myElement.isDisplayed());
            myElement = driver.findElement(By.xpath("//p[contains(text(),'User')]"));
            System.out.println(myElement.isDisplayed());

            Thread.sleep(1000);

            driver.close();
            driver.quit();

        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }
}
