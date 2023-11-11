package envconfig.customer;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class CustomerOperations extends GeneralURL{
    public static final String CUSTOMER_PATH = "/auth";

    @Step("Creation of new customer account")
    public static ValidatableResponse create(Customer customer){
        return getRequestSpecification()
                .log().all()
                .body(customer)
                .when()
                .post(CUSTOMER_PATH + "/register")
                .then();
    }
    @Step("Extraction of authorization bearer")
    public String getAuthorizationBearer(ValidatableResponse bearerResponse) {
        String responseBody = bearerResponse.extract().body().asString();
        String fullAccessToken = JsonPath.from(responseBody).get("accessToken");
        String accessToken = fullAccessToken.replace("Bearer ", "").trim();
        return accessToken;
    }
    @Step("Customer login")
    public static ValidatableResponse login(CustomerCredentials creds) {
        return getRequestSpecification()
                .log().all()
                .body(creds)
                .when()
                .post(CUSTOMER_PATH + "/login")
                .then();
    }

    @Step("Delete customer")
    public static ValidatableResponse delete(String loggedInCustomerBearer) {
        return getRequestSpecification()
                .log().all()
                .auth().oauth2(loggedInCustomerBearer)
                .when()
                .delete(CUSTOMER_PATH + "/user")
                .then();
    }
}
