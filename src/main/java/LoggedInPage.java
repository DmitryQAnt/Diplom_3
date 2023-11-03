import EnvConfig.EnvConfig;
import Locators.LoggedInLocatorsPage;
import Locators.MainLocatorsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggedInPage {
    WebDriver driver;

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on the logout button")
    public void clickOnLogoutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoggedInLocatorsPage.LOG_OUT))).click();
    }
    @Step("Click on the constructor  button")
    public void clickOnConstructorButton() {
        driver.findElement(By.xpath(LoggedInLocatorsPage.CONSTRUCTOR_BUTTON)).click();}
    @Step("Click on the logo link")
    public void clickOnLogoLink() {
        driver.findElement(By.xpath(LoggedInLocatorsPage.LOGO_LINK)).click();}

}
