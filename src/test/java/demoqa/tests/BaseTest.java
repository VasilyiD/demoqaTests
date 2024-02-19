package demoqa.tests;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.pages.RegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Map;
import demoqa.helpers.Attach;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @BeforeAll
    public static void beforeAll() {

        baseUrl = "https://demoqa.com";
        pageLoadTimeout = 90000;
        browser = System.getProperty("browser", "chrome");
        browserSize = System.getProperty("browserSize", "1920x1080");
        browserVersion = System.getProperty("browserVersion", "100.0");
        remote = System.getProperty("remote","https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("TEST COMPLETED");
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}