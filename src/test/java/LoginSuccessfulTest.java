import envconfig.DriverRule;
import envconfig.customer.Customer;
import envconfig.customer.CustomerGenerator;
import envconfig.customer.CustomerOperations;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LoginSuccessfulTest {
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
    @DisplayName("Check login customer from main page")
    @Description("Positive test of customer login from login page")
    public void checkLoginFromMainPageIsSuccessful () {
        MainPage mainPage = new MainPage(driver.getDriver());
        LoginPage loginPage = new LoginPage(driver.getDriver());
        Assertions assertions = new Assertions(driver.getDriver());

        mainPage.open();
        mainPage.clickOnTheLoginButton();
        loginPage.signInEmail(customer.getEmail());
        loginPage.signInPassword(customer.getPassword());
        loginPage.clickOnEnterButton();
        assertions.checkLoginIsDone();
        }

    @Test
    @DisplayName("Check login customer from login page")
    @Description("Positive test of login customer from login page")
    public void checkLoginFromLoginPageIsSuccessful() {
        MainPage mainPage = new MainPage(driver.getDriver());
        LoginPage loginPage = new LoginPage(driver.getDriver());
        Assertions assertions = new Assertions(driver.getDriver());

        mainPage.open();
        mainPage.clickOnAccountLink();
        loginPage.signInEmail(customer.getEmail());
        loginPage.signInPassword(customer.getPassword());
        loginPage.clickOnEnterButton();
        assertions.checkLoginIsDone();
    }
    @Test
    @DisplayName("Check login customer from recovery page")
    @Description("Positive test of customer login from recovery page")
    public void checkLoginFromPersonalAccountIsSuccessful() {
        MainPage mainPage = new MainPage(driver.getDriver());
        LoginPage loginPage = new LoginPage(driver.getDriver());
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver.getDriver());
        Assertions assertions = new Assertions(driver.getDriver());

        mainPage.open();
        mainPage.clickOnTheLoginButton();
        loginPage.clickOnRecoveryPasswordLink();
        forgotPasswordPage.clickOnBackToLoginPageLink();
        loginPage.signInEmail(customer.getEmail());
        loginPage.signInPassword(customer.getPassword());
        loginPage.clickOnEnterButton();
        assertions.checkLoginIsDone();
    }

    @Test
    @DisplayName("Check login customer from registration page")
    @Description("Positive test of customer login from registration page")
    public void checkLoginFromRegistrationFormIsSuccessful() {
        MainPage mainPage = new MainPage(driver.getDriver());
        LoginPage loginPage = new LoginPage(driver.getDriver());
        RegistrationPage registrationPage  = new RegistrationPage(driver.getDriver());
        Assertions assertions = new Assertions(driver.getDriver());

        mainPage.open();
        mainPage.clickOnAccountLink();
        loginPage.clickOnRegistrationButton();
        registrationPage.clickOnEnterButton();
        loginPage.signInEmail(customer.getEmail());
        loginPage.signInPassword(customer.getPassword());
        assertions.checkLoginIsDone();
    }
        @After
        public void clearData() {
            CustomerOperations.delete(bearer);
        }
    }

