package ru.aviasales.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;
import ru.aviasales.annotations.Layer;
import ru.aviasales.config.Cookie;
import ru.aviasales.helpers.CommonSteps;
import ru.aviasales.pages.Widgets;

@Layer("Web")
@Owner("egormuratov")
public class WidgetsTests extends TestBase {
    CommonSteps commonSteps = new CommonSteps();
    Widgets widgets = new Widgets();

    @BeforeEach
    void configureBaseUrl() {
        commonSteps.editCookie("auid", Cookie.config.auid());
    }

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Best Prices widget was shown")
    void showWidgetBestPrices() {
        commonSteps.openPage("/?depart_date=2021-09-08&destination=MOW&origin=KRR");
        widgets.checkWidgetTitle("Лучшие цены");
        widgets.checkBestPricesWidgetIsVisible();
    }

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Price Chart widget was shown")
    void showWidgetPriceChart() {
        commonSteps.openPage("/?destination=MOW&origin=KRR");
        widgets.checkWidgetTitle("График цен ");
        widgets.checkPriceChartWidgetIsVisible();
    }

    @Test
    @Story("Widgets")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("The Ticket Restriction widget was shown")
    void showWidgetTicketRestriction() {
        commonSteps.openPage("/?destination=IST&origin=KRR");
        widgets.checkTicketRestrictionWidgetIsVisible();
    }
}
