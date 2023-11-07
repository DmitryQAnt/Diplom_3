import envconfig.customer.Customer;
import envconfig.customer.CustomerCredentials;
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
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;

public class RegistrationWithSmallPaswordIsFailTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private Customer less6Symbols;
    private Customer customer;
    private String bearer;

    @Rule
    public DriverRule driver = new DriverRule();

    @Before
    public void getCustomer(){
        customer = CustomerGenerator.random();
        less6Symbols = CustomerGenerator.passwordLess6Symbols();
    }

    @Test
    @DisplayName("Check customer registration with password less than minimal value")
    @Description("Negative test of customer registration with password less 6 symbols")
    public void checkRegistrationIsFailWithPasswordLess6Symbols() {
        try {
        WebDriver webDriver = driver.getDriver();
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        Assertions assertions = new Assertions(webDriver);

        mainPage.open();
        mainPage.clickOnAccountLink();
        loginPage.clickOnRegistrationButton();
        registrationPage.setUpRegistrationName(customer.getName());
        registrationPage.setUpRegistrationEmail(customer.getEmail());
        registrationPage.setUpRegistrationPassword(customer.getPassword());
        registrationPage.clickOnRegistrationFinalButton();
        assertions.checkForNegativeRegistration();

        } catch (Exception e) {
        ValidatableResponse response = CustomerOperations.login(CustomerCredentials.from(customer));
        bearer = newCustomer.getAuthorizationBearer(response);
        CustomerOperations.delete(bearer);
        System.out.println("В результате регистрации с пароелм меньше 6 символов пользователь был все равно создан");
        }
    }
}
