package envconfig.customer;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class CustomerGenerator {
    @Step("Generating of random customer login")
    public static Customer random() {
        return new Customer(RandomStringUtils.randomAlphanumeric(5, 10) + "@yandex.ru", RandomStringUtils.randomAlphabetic(6), "murachka");
    }
    @Step("Generating of random customer with login less 6 symbols")
    public static Customer passwordLess6Symbols() {
        return new Customer(RandomStringUtils.randomAlphanumeric(5, 10) + "@yandex.ru", RandomStringUtils.randomAlphabetic(4), "murachka");
    }
}
