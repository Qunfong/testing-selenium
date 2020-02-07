package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {
    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().setSize(new Dimension(375, 812));

        //Returns first found element in DOM
        //WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        //inputsLink.click();

        //Returns link elements found
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        System.out.println(driver.getTitle());
        driver.quit(); //closes the session vs close()
    }

    public static void main(String args[]){
        BaseTests baseTests = new BaseTests();
        baseTests.setUp();
    }
}
