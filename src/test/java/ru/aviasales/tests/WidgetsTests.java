package ru.aviasales.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;
import ru.aviasales.config.Cookie;
import ru.aviasales.config.Project;
import ru.aviasales.helpers.CommonSteps;
import ru.aviasales.pageObjects.Widgets;

public class WidgetsTests {

    static CommonSteps commonSteps = new CommonSteps();
    Widgets widgets = new Widgets();

    @BeforeAll
    static void configureBaseUrl() {
        Configuration.baseUrl = Project.config.baseUrl();
        commonSteps.editCookie("auid", Cookie.config.auid());
    }

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("EM-102")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Best Prices widget was shown")
    void showWidgetBestPrices() {
        commonSteps.openPage("/?depart_date=2021-09-08&destination=MOW&origin=KRR");
        widgets.checkWidgetTitle("Лучшие цены");
        widgets.checkBestPricesWidgetIsVisible();
    }

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("EM-103")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Price Chart widget was shown")
    void showWidgetPriceChart() {
        commonSteps.openPage("/?destination=MOW&origin=KRR");
        widgets.checkWidgetTitle("График цен ");
        widgets.checkPriceChartWidgetIsVisible();
    }

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("EM-104")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Ticket Restriction widget was shown")
    void showWidgetTicketRestriction() {
        commonSteps.openPage("/?destination=IST&origin=KRR");
        widgets.checkTicketRestrictionWidgetIsVisible();
    }
}
