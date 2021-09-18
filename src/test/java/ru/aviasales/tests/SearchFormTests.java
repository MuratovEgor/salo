package ru.aviasales.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;
import ru.aviasales.annotations.Layer;
import ru.aviasales.helpers.CommonSteps;
import ru.aviasales.pages.SearchForm;

@Layer("Web")
@Owner("egormuratov")
public class SearchFormTests extends TestBase {
    SearchForm searchForm = new SearchForm();
    CommonSteps commonSteps = new CommonSteps();

    @Test
    @Story("Negative test for Search form")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("A warning should be displayed if the Departure field is empty")
    void checkWarningDepartureDataIsEmptyTest() {
        commonSteps.openPage("/?destination=MOW&origin=KRR");
        searchForm.submitForm();
        searchForm.checkWarningDepartureDataIsEmpty();
    }

    @Disabled("Test not finished")
    @Test
    @Story("Successful search")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("Successful search if checkbox booking unchecked")
    void successfulSearchWithoutBookingCheckBox() {
        commonSteps.openPage("");
        commonSteps.setCookie("uncheck_hotel_cookie", "true");
        searchForm.typeOrigin("MOW");
        searchForm.typeDestination("NYC");
        searchForm.selectTodayDepartureDate();
        searchForm.clickBtnNoReturnTicketNeeded();
        //NEED TO DO SOMETHING ELSE
        searchForm.submitForm();
    }
}