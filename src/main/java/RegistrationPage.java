import locators.RegistrationLocatorsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on the registration approve button")
    public void clickOnRegistrationFinalButton() {
        driver.findElement(By.xpath(RegistrationLocatorsPage.REGISTRATION_APPROVE_BUTTON)).click();
    }
    @Step("Click on the enter button on registration page")
    public void clickOnEnterButton() {
        driver.findElement(By.xpath(RegistrationLocatorsPage.LINK_TO_LOGIN_PAGE)).click();
    }
    @Step("Tap Password")
    public void setUpRegistrationPassword(String registrationPassword) {
        driver.findElement(By.xpath(RegistrationLocatorsPage.REGISTRATION_PASSWORD_FIELD)).sendKeys(registrationPassword);
    }
    @Step("Tap email")
    public void setUpRegistrationEmail(String registrationEmail) {
        driver.findElement(By.xpath(RegistrationLocatorsPage.REGISTRATION_EMAIL_FIELD)).sendKeys(registrationEmail);
    }
    @Step("Tap name")
    public void setUpRegistrationName(String registrationName) {
        driver.findElement(By.xpath(RegistrationLocatorsPage.REGISTRATION_NAME_FIELD)).sendKeys(registrationName);
    }
}
