package envconfig;

public class EnvConfig {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final int DEFAULT_TIMEOUT = 20;
    public static final String CHROME_DRIVER = System.getProperty("user.dir") + "/src/main/resources/chromedriver";
    public static final String CHROME_BINARY = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
    public static final String YANDEX_DRIVER = System.getProperty("user.dir") + "/src/main/resources/yandexdriver";
    public static final String YANDEX_BINARY = "/Applications/QA/Yandex.app/Contents/MacOS/Yandex";
}
