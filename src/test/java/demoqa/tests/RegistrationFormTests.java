package demoqa.tests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class RegistrationFormTests extends BaseTest {


    @Test
    @Tag("remote")
    void registrationValidDataTest() {

        registrationPage.openPage()
                .setFirstName(testData.userName)
                .setLastName(testData.userLastName)
                .setEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setPhoneNumber(testData.userPhoneNumber)
                .setBirthDate(testData.day, testData.month, testData.year)
                .setSubjects(testData.subject1, testData.subject2, testData.subject3)
                .setHobbies(testData.hobbie)
                .uploadPicture(testData.picture)
                .setAddress(testData.address)
                .setStateAndCity(testData.state, testData.city)
                .clickSubmitButton();


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.userName + " " + testData.userLastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.userGender)
                .verifyResult("Mobile", testData.userPhoneNumber)
                .verifyResult("Date of Birth",String.format("%s %s,%s",testData.day, testData.month, testData.year))
                .verifyResult("Subjects", testData.subject1 + ", " + testData.subject2 + ", " + testData.subject3)
                .verifyResult("Hobbies", testData.hobbie)
                .verifyResult("Picture", testData.picture)
                .verifyResult("Address", testData.address)
                .verifyResult("State and City", testData.state + " " + testData.city);
    }
}