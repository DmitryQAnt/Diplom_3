import Locators.ForgotPasswordLocatorsPage;
import Locators.LoginLocatorsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on the return to yhe login page link")
    public void clickOnBackToLoginPageLink() {
        driver.findElement(By.xpath(ForgotPasswordLocatorsPage.BACK_TO_LOGIN_PAGE_LINK)).click();}
}
