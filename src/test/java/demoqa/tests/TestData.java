package demoqa.tests;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker();

    String userName = faker.name().firstName();
    String userLastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = faker.options().option("Male", "Female", "Other");
    String userPhoneNumber = faker.phoneNumber().subscriberNumber(10);
    String day = setDay(faker.number().numberBetween(1, 28) + "");
    String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    String year = faker.number().numberBetween(1940, 2004) + "";
    String[] dayMonthYear = getRandomDate();
    String dateOfBirth = String.format("%s %s,%s", dayMonthYear[0], dayMonthYear[1], dayMonthYear[2]);
    String subject1 = faker.options().option("Maths", "Economics", "English", "Physics", "Chemistry");
    String subject2 = faker.options().option("History", "Arts", "Biology", "Maths", "Commerce");
    String subject3 = faker.options().option("Social Studies", "Civics", "Hindi");
    String hobbie = faker.options().option("Music", "Reading", "Sports");
    String picture = "cat.jpg";
    String address = faker.address().fullAddress();
    String state = faker.options().option("Haryana", "NCR", "Uttar Pradesh", "Rajasthan");
    String city = setRandomCity(state);



    public String setDay(String day) {
        if (day.toCharArray().length < 2) {
            return "0" + day;
        } else {
            return day;
        }
    }
    public String setRandomCity(String state) {
        switch (state) {
            case ("Haryana"):
                city = faker.options().option("Karnal", "Panipat");
                break;
            case ("NCR"):
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case ("Uttar Pradesh"):
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case ("Rajasthan"):
                city = faker.options().option("Jaipur", "Jaiselmer");
        }
        return city;
    }

    private String[] getRandomDate() {
        return new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).format(faker.date().birthday(18, 70)).split(" ");
    }
}