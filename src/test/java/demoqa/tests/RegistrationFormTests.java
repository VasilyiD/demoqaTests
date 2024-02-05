package demoqa.tests;
import org.junit.jupiter.api.Test;
public class RegistrationFormTests extends BaseTest {

    @Test
    void registrationValidDataTest() {

        String userName = "Jared";
        String userLastName = "Leto";
        String userEmail = "itsajoke@gmail.com";
        String userGender = "Male";
        String userPhoneNumber = "9123456788";
        String day = "20",
                month = "January",
                year = "1990";
        String subject1 = "Maths",
                subject2 = "English",
                subject3 = "Economics";
        String hobbie = "Music";
        String picture = "cat.jpg";
        String address = "Bosser-city, Smith st., 33";
        String state = "Haryana";
        String city = "Karnal";


        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhoneNumber(userPhoneNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subject1, subject2, subject3)
                .setHobbies(hobbie)
                .uploadPicture(picture)
                .setAddress(address)
                .setStateAndCity(state, city)
                .clickSubmitButton();


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhoneNumber)
                .verifyResult("Date of Birth", "20 January,1990")
                .verifyResult("Subjects", subject1 + ", " + subject2 + ", " + subject3)
                .verifyResult("Hobbies", hobbie)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }
}