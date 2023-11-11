import envconfig.customer.Customer;
import envconfig.customer.CustomerGenerator;
import envconfig.customer.CustomerOperations;
import envconfig.DriverRule;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ClickOnLogoFromPersonalAccountSuccessfulTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private Customer customer;
    private String bearer;

    @Rule
    public DriverRule driver = new DriverRule();

    @Before
    public void getCustomer(){
        customer = CustomerGenerator.random();
        ValidatableResponse response = CustomerOperations.create(customer);
        bearer = newCustomer.getAuthorizationBearer(response);
    }

    @Test
    @DisplayName("Check pass after click on logo from account page to main page")
    @Description("Positive test of logged customer from account page on main page by click on logo ")
    public void checkLoginPersonalAccountIsSuccessful() {
        MainPage mainPage = new MainPage(driver.getDriver());
        LoginPage loginPage = new LoginPage(driver.getDriver());
        LoggedInPage loggedInPage = new LoggedInPage(driver.getDriver());
        Assertions assertions = new Assertions(driver.getDriver());

        mainPage.open();
        mainPage.clickOnTheLoginButton();
        loginPage.signInEmail(customer.getEmail());
        loginPage.signInPassword(customer.getPassword());
        loginPage.clickOnEnterButton();
        loggedInPage.clickOnLogoLink();
        assertions.checkLoginIsDone();
    }
    @After
    public void clearData() {
        CustomerOperations.delete(bearer);
    }
}
