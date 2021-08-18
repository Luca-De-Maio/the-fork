package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {

    @FindBy(css = "label.css-8irbms:nth-child(1) > span:nth-child(2)")
    private static WebElement maleCheck;

    @FindBy(xpath = "//input[@name='firstName']")
    private static WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    private static WebElement lastNameField;

    @FindBy(id = "PHONE_CODE_FIELD")
    private static WebElement codePhoneField;

    @FindBy(xpath = "//input[@data-testid='phone-input-number']")
    private static WebElement phoneField;

    @FindBy(xpath = "//input[@name='birthDate.day']")
    private static WebElement dayField;

    @FindBy(css = "birthDate.month")
    private static WebElement monthField;

    @FindBy(xpath = "//input[@name='birthDate.year']")
    private static WebElement yearField;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean getMaleCheck() {
        waitUntilVisibilityOfElement(driver, maleCheck);
        return maleCheck.isSelected();
    }

    public String getFirstNameField() {
        waitUntilVisibilityOfElement(driver, firstNameField);
        return firstNameField.getAttribute("value");
    }

    public String getLastNameField() {
        waitUntilVisibilityOfElement(driver, lastNameField);
        return lastNameField.getAttribute("value");
    }

    public String getCodePhoneField() {
        return codePhoneField.getText();
    }

    public String getPhoneField() {
        waitUntilVisibilityOfElement(driver, phoneField);
        return phoneField.getAttribute("value");
    }

    public String getDayField() {
        waitUntilVisibilityOfElement(driver, dayField);
        return dayField.getAttribute("value");
    }

    public String getMonthField() {
        waitUntilVisibilityOfElement(driver, monthField);
        return monthField.getAttribute("value");
    }

    public String getYearField() {
        waitUntilVisibilityOfElement(driver, yearField);
        return yearField.getAttribute("value");
    }


}
