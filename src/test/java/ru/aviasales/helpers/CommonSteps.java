package ru.aviasales.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonSteps {
    @Step("Open page {url}")
    public void openPage(String url) {
        open(url);
    }

    @Step("Set Cookie: {cookieName}: {cookieValue}")
    public void setCookie(String cookieName, String cookieValue) {
        getWebDriver().manage().deleteCookie(
                getWebDriver().manage().getCookieNamed(cookieName)
        );
        getWebDriver().manage().addCookie(new Cookie(cookieName, cookieValue));
        refresh();
    }
}
