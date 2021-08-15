package base;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.thefork.com.ar/");

        Dimension size = new Dimension(375, 812);
        driver.manage().window().setSize(size);
        System.out.println(driver.getTitle());
        driver.quit();
    }

    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }

}
