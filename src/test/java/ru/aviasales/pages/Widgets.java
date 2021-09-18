package ru.aviasales.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Widgets {
    SelenideElement titleWidget = $("[data-selene-widget='prices'] h2[data-test-element='text']"),
            bestPricesWidget = $("._2wmn1JOfb2XJiFOJBD0YW7"),
            chartPriceWidget = $(".Uh7BQmB2_eE9Q2mA0gswy"),
            ticketRestrictionWidget = $("._2KYqwzIfhBhINPDwB93AJW");

    @Step("Widget title has text: {widgetTitle}")
    public void checkWidgetTitle(String widgetTitle) {
        titleWidget.shouldHave(text(widgetTitle));
    }

    @Step("The Best Prices widget was shown")
    public void checkBestPricesWidgetIsVisible() {
        bestPricesWidget.shouldBe(visible);
    }

    @Step("The Price Chart widget was shown")
    public void checkPriceChartWidgetIsVisible() {
        chartPriceWidget.shouldBe(visible);
    }

    @Step("The Ticket Restriction widget was shown")
    public void checkTicketRestrictionWidgetIsVisible() {
        ticketRestrictionWidget.shouldBe(visible);
    }
}
