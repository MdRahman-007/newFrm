

import Report.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by mdrahman on 12/15/18.
 * Spring 2018
 */


@Listeners(TestListenerAdapter.class)

public class TestRun {

    Reporter reporter = new Reporter();


    @Test
    public void testRun () throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/mdrahman/Downloads/Selenium/Chrome/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("facebook.com");

        reporter.reportTest("testRun","SS","dd");


        driver.quit();
    }
    @Test
    public void testRun1 () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/mdrahman/Downloads/Selenium/Chrome/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");

        driver.quit();
    }




}
