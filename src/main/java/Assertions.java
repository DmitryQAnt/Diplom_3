import EnvConfig.EnvConfig;
import Locators.MainLocatorsPage;
import Locators.RegistrationLocatorsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assertions {
    public static final String IS_VISIBLE = "current";
    public static final String CLASS_ATTRIBUTE = "class";
    WebDriver driver;
    public Assertions(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Assert is registration is successful")
    public void checkForPositiveRegistration() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RegistrationLocatorsPage.CONFIRMATION_REGISTRATION_FIELD)));
    }
    @Step("Assert is registration is fail")
    public void checkForNegativeRegistration() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RegistrationLocatorsPage.INCORRECT_PASSWORD_ALERT)));
    }
    @Step("Assert is login is successful")
    public void checkLoginIsDone() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector((MainLocatorsPage.START_ORDER))));
    }
    @Step("Assert is scrolling to Filling's set is successful")
    public void checkFillingsIsScrolling() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(By.cssSelector(MainLocatorsPage.FILLINGS_BUTTON), CLASS_ATTRIBUTE, IS_VISIBLE));
    }
    @Step("Assert is scrolling to Bun's set is successful")
    public void checkBunsIsScrolling() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(By.cssSelector(MainLocatorsPage.BUNS_BUTTON), CLASS_ATTRIBUTE, IS_VISIBLE));
    }
    @Step("Assert is scrolling to Sauce's set is successful")
    public void checkSaucesIsScrolling() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(By.cssSelector(MainLocatorsPage.SAUCES_BUTTON), CLASS_ATTRIBUTE, IS_VISIBLE));
    }
}


