package demoqa;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static demoqa.pages.MainPage.*;

public class RegistrationFormTests extends BaseTest {

    @Test
    void registrationValidData() {

        $(NAMEFIELD).setValue(NAME);
        $(LASTNAMEFIELD).setValue(LASTNAME);
        $(EMAILFIELD).setValue(EMAIL);
        $(byText("Male")).click();
        $(MOBILENUMBERFIELD).setValue(PHONE);
        $(DATEOFBIRTHINPUTFIELD).click();
        $(MONTHLIST).selectOptionContainingText("January");
        $(YEARSLIST).selectOptionContainingText("1990");
        $x("//*[@class='react-datepicker__day react-datepicker__day--020 react-datepicker__day--weekend']").click();
        $(SUBJECTSFIELD).setValue(SUBJECT1).pressEnter().setValue(SUBJECT2).pressEnter()
                .setValue(SUBJECT3).pressEnter();
        $(HOBBIESCHECKBOX).click();
        uploadCatPicture();
        $(CURRENTADRESSFIELD).setValue(ADRESS);
        $(STATELIST).click();
        $(HARYANASTATE).click();
        $(CITYLIST).click();
        $(KARNALCITY).click();
        $(SUBMITBUTTON).click();

        $(".modal-body").shouldBe(text("Student Name")).shouldHave(text(NAME + " " + LASTNAME));
        $(".modal-body").shouldBe(text("Student Email")).shouldHave(text(EMAIL));
        $(".modal-body").shouldBe(text("Student Email")).shouldHave(text(EMAIL));
        $(".modal-body").shouldBe(text("Gender")).shouldHave(text("Male"));
        $(".modal-body").shouldBe(text("Mobile")).shouldHave(text(PHONE));
        $(".modal-body").shouldBe(text("Date of Birth")).shouldHave(text("20 January,1990"));
        $(".modal-body").shouldBe(text("Subjects")).shouldHave(text("Maths, English, Economics"));
        $(".modal-body").shouldBe(text("Hobbies")).shouldHave(text("Music"));
        $(".modal-body").shouldBe(text("Picture")).shouldHave(text("cat.jpg"));
        $(".modal-body").shouldBe(text("Address")).shouldHave(text("Bosser-city, Smith st., 33"));
        $(".modal-body").shouldBe(text("State and City")).shouldHave(text("Haryana Karnal"));
    }
}