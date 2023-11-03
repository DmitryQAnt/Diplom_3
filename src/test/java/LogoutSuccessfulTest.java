import EnvConfig.Customer.Customer;
import EnvConfig.Customer.CustomerGenerator;
import EnvConfig.Customer.CustomerOperations;
import EnvConfig.DriverRule;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LogoutSuccessfulTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private Customer customer;
    private String bearer;

    @Rule
    public DriverRule driver = new DriverRule();

    @Before
    public void getCustomer() {
        customer = CustomerGenerator.random();
        ValidatableResponse response = CustomerOperations.create(customer);
        bearer = newCustomer.getAuthorizationBearer(response);
    }

    @Test
    @DisplayName("Check logout customer")
    @Description("Positive test of logout customer")
    public void checkLogoutIsSuccessful() {
        MainPage mainPage = new MainPage(driver.getDriver());
        LoginPage loginPage = new LoginPage(driver.getDriver());
        LoggedInPage loggedInPage = new LoggedInPage(driver.getDriver());
        Assertions assertions = new Assertions(driver.getDriver());

        mainPage.open();
        mainPage.clickOnAccountLink();
        loginPage.signInEmail(customer.getEmail());
        loginPage.signInPassword(customer.getPassword());
        loginPage.clickOnEnterButton();
        mainPage.clickOnAccountLink();
        loggedInPage.clickOnLogoutButton();
        assertions.checkForPositiveRegistration();
    }

}
