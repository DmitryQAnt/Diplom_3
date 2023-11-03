package EnvConfig.Customer;

import org.apache.commons.lang3.RandomStringUtils;

public class ClientData {
    public static final String REGISTRATION_RANDOM_NAME = RandomStringUtils.randomAlphabetic(5);
    public static final String REGISTRATION_RANDOM_EMAIL = RandomStringUtils.randomAlphabetic(6) + "@test.ru";
    public static final String REGISTRATION_PASSWORD_6NUMBERS = "123456";
    public static final String REGISTRATION_PASSWORD_LESS_6NUMBERS = "123";
}
