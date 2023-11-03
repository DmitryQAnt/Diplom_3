import EnvConfig.Customer.*;
import EnvConfig.DriverRule;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class RegistrationSuccessfulTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private Customer customer;
    private String bearer;

    @Rule
    public DriverRule driver = new DriverRule();

    @Before
    public void getCustomer(){
        customer = CustomerGenerator.random();
    }

    @Test
    @DisplayName("Check customer registration")
    @Description("Positive test of customer registration")
    public void checkRegistrationIsSuccessfulWithRightData() {
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
        assertions.checkForPositiveRegistration();
    }
    @After
    public void clearData(){
        ValidatableResponse response = CustomerOperations.login(CustomerCredentials.from(customer));
        bearer = newCustomer.getAuthorizationBearer(response);
        CustomerOperations.delete(bearer);
    }
}
