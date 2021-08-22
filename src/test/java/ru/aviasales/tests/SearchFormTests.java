package ru.aviasales.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;
import ru.aviasales.annotations.Layer;
import ru.aviasales.config.Cookie;
import ru.aviasales.config.Project;
import ru.aviasales.helpers.CommonSteps;
import ru.aviasales.pageObjects.SearchForm;
import ru.aviasales.pageObjects.Widgets;

@Layer("Web")
@Owner("egormuratov")
public class SearchFormTests {
    SearchForm searchForm = new SearchForm();
    CommonSteps commonSteps = new CommonSteps();
    Widgets widgets = new Widgets();


    @BeforeAll
    static void configureBaseUrl() {
        Configuration.baseUrl = Project.config.baseUrl();
    }


    @Test
    @Story("Negative test for Search form")
    @JiraIssues({@JiraIssue("AE-1")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("A warning should be displayed if the Departure field is empty")
    void checkWarningDepartureDataIsEmptyTest() {
        commonSteps.openPage("/?destination=MOW&origin=KRR");
        searchForm.submitForm();

        searchForm.checkWarningDepartureDataIsEmpty();
    }

    @Test
    @Story("Successful search")
    @JiraIssues({@JiraIssue("AE-2")})
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

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("AE-2")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Best Prices widget was shown")
    void showWidgetBestPrices() {
        commonSteps.openPage("/?depart_date=2021-09-08&destination=MOW&origin=KRR");
        commonSteps.setCookie("auid", Cookie.config.auid());
        widgets.checkWidgetTitle("Лучшие цены");
        widgets.checkBestPricesWidgetIsVisible();
    }

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("AE-3")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Price Chart widget was shown")
    void showWidgetPriceChart() {
        commonSteps.openPage("/?destination=MOW&origin=KRR");
        commonSteps.setCookie("auid", Cookie.config.auid());
        widgets.checkWidgetTitle("График цен ");
        widgets.checkPriceChartWidgetIsVisible();
    }



}
