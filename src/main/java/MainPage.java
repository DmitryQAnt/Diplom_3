import EnvConfig.EnvConfig;
import Locators.MainLocatorsPage;
import Locators.RegistrationLocatorsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Locators.MainLocatorsPage.*;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        open();
    }

    public void open() {
        driver.get(EnvConfig.BASE_URL);
    }

    public void clickOnAccountLink() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MainLocatorsPage.ACCOUNT_LINK_BUTTON))).click();
    }
    @Step("Click on the login button on main page")
    public void clickOnTheLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }
    @Step("Click on the filling  button")
    public void clickOnFillingButton() {
        driver.findElement(By.cssSelector(FILLINGS_BUTTON)).click();
    }
    @Step("Click on the Bun  button")

    public void clickOnBunsButton() {
        driver.findElement(By.cssSelector(BUNS_BUTTON)).click();
    }
    @Step("Click on the sauces  button")

    public void clickOnSaucesButton() {
        driver.findElement(By.cssSelector(SAUCES_BUTTON)).click();
    }

}
