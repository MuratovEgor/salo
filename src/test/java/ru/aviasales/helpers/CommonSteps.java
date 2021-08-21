package ru.aviasales.helpers;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class CommonSteps {
    @Step("Open page {url}")
    public void openPage(String url) {
        open(url);
    }
}
