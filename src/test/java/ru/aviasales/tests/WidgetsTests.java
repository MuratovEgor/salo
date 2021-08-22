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

import static com.codeborne.selenide.Selenide.sleep;

public class WidgetsTests {

    Widgets widgets = new Widgets();
    CommonSteps commonSteps = new CommonSteps();


    @BeforeAll
    static void configureBaseUrl() {
        Configuration.baseUrl = Project.config.baseUrl();
    }

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("AE-2")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Best Prices widget was shown")
    void showWidgetBestPrices() {
        commonSteps.openPage("/?depart_date=2021-09-08&destination=MOW&origin=KRR");
        commonSteps.setCookie("auid", Cookie.config.auid());
        sleep(100000000);
        widgets.checkWidgetTitle("Лучшие цены");
        widgets.checkBestPricesWidgetIsVisible();
    }

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("AE-3")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Price Chart widget was shown")
    @Disabled("test")
    void showWidgetPriceChart() {
        commonSteps.openPage("/?destination=MOW&origin=KRR");
        commonSteps.setCookie("auid", Cookie.config.auid());
        widgets.checkWidgetTitle("График цен ");
        widgets.checkPriceChartWidgetIsVisible();
    }

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("AE-4")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Ticket Restriction widget was shown")
    @Disabled("test")
    void showWidgetTicketRestriction() {
        commonSteps.openPage("/?destination=IST&origin=KRR");
        commonSteps.setCookie("auid", Cookie.config.auid());
        widgets.checkTicketRestrictionWidgetIsVisible();
    }
}
