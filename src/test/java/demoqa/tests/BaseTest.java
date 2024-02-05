package demoqa.tests;
import com.codeborne.selenide.Configuration;
import demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    public static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 90000;
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("TEST COMPLETED");
    }
}