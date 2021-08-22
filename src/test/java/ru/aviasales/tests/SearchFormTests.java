package ru.aviasales.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;
import ru.aviasales.annotations.Layer;
import ru.aviasales.config.Project;
import ru.aviasales.helpers.CommonSteps;
import ru.aviasales.pageObjects.SearchForm;

@Layer("Web")
@Owner("egormuratov")
public class SearchFormTests {
    SearchForm searchForm = new SearchForm();
    CommonSteps commonSteps = new CommonSteps();


    @BeforeAll
    static void configureBaseUrl() {
        Configuration.baseUrl = Project.config.baseUrl();
    }


    @Test
    @Story("Negative test for Search form")
    @JiraIssues({@JiraIssue("EM-100")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("A warning should be displayed if the Departure field is empty")
    void checkWarningDepartureDataIsEmptyTest() {
        commonSteps.openPage("/?destination=MOW&origin=KRR");
        searchForm.submitForm();
        searchForm.checkWarningDepartureDataIsEmpty();
    }

    @Test
    @Story("Successful search")
    @JiraIssues({@JiraIssue("EM-101")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("Successful search if checkbox booking unchecked")
    @Disabled("Test not finished")
    void successfulSearchWithoutBookingCheckBox() {
        commonSteps.openPage("");
        commonSteps.setCookie("uncheck_hotel_cookie", "true");
        searchForm.typeOrigin("MOW");
        searchForm.typeDestination("NYC");
        searchForm.selectTodayDepartureDate();
        searchForm.clickBtnNoReturnTicketNeeded();

        searchForm.submitForm();
    }
}
