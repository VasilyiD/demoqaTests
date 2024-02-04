package demoqa.pages;


import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public static final String NAMEFIELD = "#firstName";
    public static final String LASTNAMEFIELD = "#lastName";
    public static final String EMAILFIELD = "#userEmail";
    public static final String WRAPPERFIELD = "#genterWrapper";
    public static final String MALERADIO = "#gender-radio-1";
    public static final String MOBILENUMBERFIELD = "#userNumber";
    public static final String DATEOFBIRTHINPUTFIELD = "#dateOfBirthInput";
    public static final String MONTHLIST = ".react-datepicker__month-select";
    public static final String YEARSLIST = ".react-datepicker__year-select";
    public static final String DAYSLIST = ".react-datepicker__month";
    public static final String SUBJECTSFIELD = "#subjectsInput";
    public static final String HOBBIESCHECKBOX = "[for =hobbies-checkbox-3]";
    public static final String UPPLOADPICTUREBUTTON = "#uploadPicture";
    public static final String CURRENTADRESSFIELD = "#currentAddress";
    public static final String STATELIST = "#state";
    public static final String HARYANASTATE = "#react-select-3-option-2";
    public static final String CITYLIST = "#city";
    public static final String KARNALCITY = "#react-select-4-option-0";
    public static final String SUBMITBUTTON = "#submit";

    public static void uploadCatPicture() {
        File file = new File("src/test/resources/cat.jpg");
        $("#uploadPicture").uploadFile(file);
    }





}