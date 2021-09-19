package ru.aviasales.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;
import ru.aviasales.annotations.Layer;

import static com.codeborne.selenide.Selenide.open;

@Layer("Web")
@Owner("egormuratov")
public class SearchFormTests extends TestBase {

    @Test
    @Story("Negative test for Search form")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("A warning should be displayed if the Departure field is empty")
    void checkWarningDepartureDataIsEmptyTest() {
        open("/?destination=MOW&origin=KRR");
        searchForm.submitForm();
        searchForm.checkWarningDepartureDataIsEmpty();
    }

    @Test
    @Story("Hotel search form")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("Show hotel search form")
    void showHotelSearchForm() {
        open("");
        searchForm.clickTabHotel();
        searchForm.hotelSearchFormIsDisplayed();
    }

    @Test
    @Story("Successful search")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("Successful search if checkbox booking unchecked")
    void successfulSearchWithoutBookingCheckBox() {
        cookiesHelper.setCookie("uncheck_hotel_cookie", "true");

        open("");
        searchForm.typeOrigin("MOW");
        searchForm.typeDestination("NYC");
        searchForm.selectTodayDepartureDate();
        searchForm.clickBtnNoReturnTicketNeeded();
        searchForm.submitForm();
        searchForm.searchHasBegun();
    }
}