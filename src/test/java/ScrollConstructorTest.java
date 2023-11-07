import envconfig.DriverRule;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;

public class ScrollConstructorTest {

    @Rule
    public DriverRule driver = new DriverRule();

    @Test
    @DisplayName("Check scroll between ingredients in constructor")
    @Description("Positive test of scroll between all 3  ingredients (Buns, Fillings, Sauces) in constructor")
    public void checkScrollToIngredients() {
        MainPage mainPage = new MainPage(driver.getDriver());
        Assertions assertions = new Assertions(driver.getDriver());

        mainPage.open();
        mainPage.clickOnFillingButton();
        assertions.checkFillingsIsScrolling();
        mainPage.clickOnBunsButton();
        assertions.checkBunsIsScrolling();
        mainPage.clickOnSaucesButton();
        assertions.checkSaucesIsScrolling();
    }
}
