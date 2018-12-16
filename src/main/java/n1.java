import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by mdrahman on 12/6/18.
 * Spring 2018
 */
public class n1 {

    @Test
    public void nn1(){
        System.setProperty("webdriver.chrome.driver","/Users/mdrahman/Downloads/Selenium/Chrome/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");


        driver.quit();
    }










}
