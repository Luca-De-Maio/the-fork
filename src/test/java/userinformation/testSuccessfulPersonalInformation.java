package userinformation;

import base.BaseTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import utils.PropertiesLoader;


public class testSuccessfulPersonalInformation extends BaseTest {
   private Logger logger = Logger.getLogger(testSuccessfulPersonalInformation.class);

   @Test
    public void personalInformation() {
       LoginPage loginPage = new LoginPage(driver);
       logger.info("Logging on The Fork");
       HomePage homePage = loginPage.login();

       logger.info("Home Page displayed.");
       homePage.clickPersonalInformation();

       logger.info("Assert name on Menu.");
       Assert.assertEquals(homePage.getNameAccount(), PropertiesLoader.getProperty("personalInformationMenu.name"));

       logger.info("Clicking Personal information module.");
       ProfilePage profilePage = homePage.clickPersonalInformation();

       logger.info("Assert first name " + PropertiesLoader.getProperty("personalInformation.name"));
       Assert.assertEquals(profilePage.getFirstNameField(), PropertiesLoader.getProperty("personalInformation.name"));

       logger.info("Assert last name " + PropertiesLoader.getProperty("personalInformation.lastName"));
       Assert.assertEquals(profilePage.getLastNameField(), PropertiesLoader.getProperty("personalInformation.lastName"));

       logger.info("Assert phone number " + PropertiesLoader.getProperty("personalInformation.phoneNumber"));
       Assert.assertEquals(profilePage.getPhoneField(), PropertiesLoader.getProperty("personalInformation.phoneNumber"));

       logger.info("Assert day of birth " + PropertiesLoader.getProperty("personalInformation.day"));
       Assert.assertEquals(profilePage.getDayField(), PropertiesLoader.getProperty("personalInformation.day"));

       logger.info("Assert year of birth " + PropertiesLoader.getProperty("personalInformation.year"));
       Assert.assertEquals(profilePage.getYearField(), PropertiesLoader.getProperty("personalInformation.year"));
   }

}
