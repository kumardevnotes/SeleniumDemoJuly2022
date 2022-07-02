package qa.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoClass1 {
    public static void main(String args[]) {
        launchSpeakEnglish();
        launchWikipedia();
    }

    public static void launchSpeakEnglish() {
        try {
            // Setup chromedriver path and launch chrome
            String path = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.manage().window().setSize(new Dimension(800, 800));

            // Search for results
            driver.get("https://www.speaklanguages.com/english/");
            // DOM - document object model
            Thread.sleep(1000);

            // Closing the chrome
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }

    }
    public static void launchWikipedia(){
            try {
                // Setup chromedriver path and launch chrome
                String path = System.getProperty("user.dir");
                System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");

                WebDriver driver = new ChromeDriver();

                // Maximize browser
                driver.manage().window().maximize();

                // Search for results
                driver.get("https://www.wikipedia.org/");
                // DOM - document object model
                Thread.sleep(1000);

                // Closing the chrome
                driver.close();
                driver.quit();
            } catch (Exception e) {
                System.out.println("Caught an exception: " + e);
            }
    }
}
