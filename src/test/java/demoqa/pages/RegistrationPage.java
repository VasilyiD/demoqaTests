package demoqa.pages;
import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.RegistrationResultModal;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private static final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateCityInput = $("#stateCity-wrapper"),
            stateList = $("#state"),
            cityList = $("#city"),
            submitButton = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".fc-button-label").shouldHave(text("Consent")).click();

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setSubjects(String subject1, String subject2) {
        subjectsInput.setValue(subject1).pressEnter()
                .setValue(subject2).pressEnter();

        return this;
    }

    public RegistrationPage setSubjects(String subject1, String subject2, String subject3) {
        subjectsInput.setValue(subject1).pressEnter().setValue(subject2).pressEnter()
                .setValue(subject3).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String hobbie) {
        hobbiesInput.$(byText(hobbie)).click();

        return this;
    }

    public RegistrationPage setHobbies(String hobbie1, String hobbie2) {
        hobbiesInput.$(byText(hobbie1)).click();
        hobbiesInput.$(byText(hobbie2)).click();

        return this;
    }

    public RegistrationPage setHobbies(String hobbie1, String hobbie2, String hobbie3) {
        hobbiesInput.$(byText(hobbie1)).click();
        hobbiesInput.$(byText(hobbie2)).click();
        hobbiesInput.$(byText(hobbie3)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String picture) {
        uploadPictureButton.uploadFromClasspath(picture);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateList.click();
        stateCityInput.$(byText(state)).click();
        cityList.click();
        stateCityInput.$(byText(city)).click();

        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();

        return null;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);

        return this;
    }
}