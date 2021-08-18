package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected static WebDriver driver;
    private static Logger logger = Logger.getLogger(BasePage.class);


    public static boolean waitUntilVisibilityOfElement(WebDriver driver, WebElement element) {
        logger.info("Waiting for: " + element);
        return new WebDriverWait(driver, 60)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element)) != null;
    }

    public static WebElement waitUntilVisibilityOfElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }
}
