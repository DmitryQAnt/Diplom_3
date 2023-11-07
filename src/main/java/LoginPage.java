import locators.LoginLocatorsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static locators.LoginLocatorsPage.*;

public class LoginPage {
    final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on the registration  button on login page")
    public void clickOnRegistrationButton() {
        driver.findElement(By.xpath(LoginLocatorsPage.REGISTRATION_BUTTON_LOGIN_PAGE)).click();}
    @Step("Click on the enter button on login page")
    public void clickOnEnterButton() {
        driver.findElement(By.xpath(FINAL_LOGIN_BUTTON)).click();
    }
    @Step("Click on the recovery password link")
    public void clickOnRecoveryPasswordLink() {
        driver.findElement(By.xpath(LINK_RECOVERY_PASSWORD)).click();
    }
    @Step("Tap password")
    public void signInPassword(String password) {
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(password);
    }
    @Step("Tap email")
    public void signInEmail(String email) {
        driver.findElement(By.xpath(LOGIN_FIELD)).sendKeys(email);
    }

}
