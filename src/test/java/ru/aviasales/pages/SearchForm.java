package ru.aviasales.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;

public class SearchForm {
    SelenideElement originField = $("[data-testid='origin-autocomplete-field']"),
            destinationField = $("[data-testid='destination-autocomplete-field']"),
            departureDateField = $(".trip-duration__field.--departure"),
            btnFormSubmit = $("[data-testid='form-submit']"),
            today = $(".calendar__day-cell.today"),
            btnNoReturnTicketNeeded = $(".trip-duration__cancel-departure");


    @Step("Enter in the field Origin: {origin}")
    public void typeOrigin(String origin) {
        originField.clear();
        originField.val(origin);
    }

    @Step("Enter in the field Destination: {destination}")
    public void typeDestination(String destination) {
        destinationField.clear();
        destinationField.val(destination);
    }

    @Step("Submit search form")
    public void submitForm() {
        btnFormSubmit.click();
    }

    @Step("Check that the warning 'Departure Data Field Is Empty' is displayed")
    public void checkWarningDepartureDataIsEmpty() {
        departureDateField.shouldHave(attribute("data-error-message"));
    }

    @Step("Select today as the departure date")
    public void selectTodayDepartureDate() {
        departureDateField.click();
        today.click();
    }

    @Step("Click by button no return ticket needed")
    public void clickBtnNoReturnTicketNeeded() {
        btnNoReturnTicketNeeded.click();
    }

}
