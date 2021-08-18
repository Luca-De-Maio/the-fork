package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesLoader;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//button[@data-test='user-space']")
    private  WebElement loginButton;

    @FindBy(id = "identification_email")
    private  WebElement emailField;

    @FindBy(id = "password")
    private  WebElement passwordField;

    @FindBy(xpath = "//*[@data-testid='checkout-submit-email']")
    private  WebElement continueEmailSubmitButton ;

    @FindBy(xpath = "//*[@data-testid='submit-password']")
    private  WebElement continuePasswordSubmitButton;

    @FindBy(id = "_evidon-accept-button")
    private  WebElement acceptCookies;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage login() {
        waitUntilVisibilityOfElement(driver, acceptCookies);
        acceptCookies.click();

        waitUntilVisibilityOfElement(driver, loginButton);
        loginButton.click();

        waitUntilVisibilityOfElement(driver, emailField);
        emailField.click();
        emailField.sendKeys(PropertiesLoader.getProperty("login.email"));

        waitUntilVisibilityOfElement(driver, continueEmailSubmitButton);
        continueEmailSubmitButton.click();

        waitUntilVisibilityOfElement(driver, passwordField);
        passwordField.sendKeys(PropertiesLoader.getProperty("login.password"));

        waitUntilVisibilityOfElement(driver, continuePasswordSubmitButton);
        continuePasswordSubmitButton.click();

        return new HomePage(driver);
    }


}
