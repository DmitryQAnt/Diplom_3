package EnvConfig;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class DriverRule extends ExternalResource {
    WebDriver driver;
    @Override
    protected void before() throws Throwable{
        if ("yandex".equals(System.getProperty("browser")))
            setUpYandex();
        else
            setUpChrome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    protected void setUpChrome() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Users/murashevdmitri/WebDriver/bin/chromedriver"))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")
                .addArguments("--remote-allow-origins=*");


        driver = new ChromeDriver(service, options);
    }
    protected void setUpYandex() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Users/murashevdmitri/WebDriver/chromedriver_for_yandex/chromedriver"))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary("/Applications/QA/Yandex.app/Contents/MacOS/Yandex");

        driver = new ChromeDriver(service, options);
    }

    @Override
    public void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}


