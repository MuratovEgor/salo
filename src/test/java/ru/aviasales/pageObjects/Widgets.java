package ru.aviasales.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Widgets {
    SelenideElement TITLE_WIDGET = $("[data-selene-widget='prices'] h2[data-test-element='text']"),
            BEST_PRICES_WIDGET = $("._2wmn1JOfb2XJiFOJBD0YW7"),
            CHART_PRICE_WIDGET = $(".Uh7BQmB2_eE9Q2mA0gswy"),
            TICKET_RESTRICTION_WIDGET = $("._2KYqwzIfhBhINPDwB93AJW");

    @Step("Widget title has text: {widgetTitle}")
    public void checkWidgetTitle(String widgetTitle) {
        TITLE_WIDGET.shouldHave(text(widgetTitle));
    }

    @Step("The Best Prices widget was shown")
    public void checkBestPricesWidgetIsVisible() {
        BEST_PRICES_WIDGET.shouldBe(visible);
    }

    @Step("The Price Chart widget was shown")
    public void checkPriceChartWidgetIsVisible() {
        CHART_PRICE_WIDGET.shouldBe(visible);
    }

    @Step("The Ticket Restriction widget was shown")
    public void checkTicketRestrictionWidgetIsVisible() {
        TICKET_RESTRICTION_WIDGET.shouldBe(visible);
    }
}
