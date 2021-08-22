package ru.aviasales.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Widgets {
    SelenideElement TITLE_WIDGET = $("[data-selene-widget='prices'] h2[data-test-element='text']");

    @Step("Widget title has text: {widgetTitle}")
    public void checkWidgetTitle(String widgetTitle) {
        TITLE_WIDGET.shouldHave(text(widgetTitle));
    }
}
