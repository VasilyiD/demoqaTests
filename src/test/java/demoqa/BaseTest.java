package demoqa;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 90000;
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
  //      executeJavaScript("$('#fixedban').remove()");
  //      executeJavaScript("$('footer').remove()");

    }

    @AfterAll
    public static void afterAll() {
        System.out.println("TEST COMPLETED");
    }

    public static final String NAME = "Jared";
    public static final String LASTNAME = "Leto";
    public static final String EMAIL = "itsajoke@gmail.com";
    public static final String PHONE = "9123456788";
    public static final String SUBJECT1 = "Maths";
    public static final String SUBJECT2 = "English";
    public static final String SUBJECT3 = "Economics";
    public static final String ADRESS = "Bosser-city, Smith st., 33";
}