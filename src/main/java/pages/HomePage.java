package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h1[@class='_1nt-Y']")
    private static WebElement nameAccount;

    @FindBy(xpath = "//button[@aria-controls='user-space-user-information']")
    private static WebElement personalInformationButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getNameAccount(){
        return nameAccount.getText();
    }

    public ProfilePage clickPersonalInformation(){
        waitUntilVisibilityOfElement(driver, personalInformationButton);
        personalInformationButton.click();
        return new ProfilePage(driver);
    }

}
