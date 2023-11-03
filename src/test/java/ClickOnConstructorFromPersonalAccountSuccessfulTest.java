import EnvConfig.Customer.Customer;
import EnvConfig.Customer.CustomerGenerator;
import EnvConfig.Customer.CustomerOperations;
import EnvConfig.DriverRule;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ClickOnConstructorFromPersonalAccountSuccessfulTest {
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
    @DisplayName("Check pass from personal account page to constructor")
    @Description("Positive test of passing from personal account page to constructor")
    public void checkPassFromPersonalAccountToConstructorIsSuccessful() {
        MainPage mainPage = new MainPage(driver.getDriver());
        LoginPage loginPage = new LoginPage(driver.getDriver());
        LoggedInPage loggedInPage = new LoggedInPage(driver.getDriver());
        Assertions assertions = new Assertions(driver.getDriver());

        mainPage.open();
        mainPage.clickOnTheLoginButton();
        loginPage.signInEmail(customer.getEmail());
        loginPage.signInPassword(customer.getPassword());
        loginPage.clickOnEnterButton();
        loggedInPage.clickOnConstructorButton();
        assertions.checkLoginIsDone();
    }
    @After
    public void clearData() {
        CustomerOperations.delete(bearer);
    }
}
