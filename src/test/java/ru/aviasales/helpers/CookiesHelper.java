package ru.aviasales.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CookiesHelper {
    @Step("Set Cookie: {cookieName}: {cookieValue}")
    public void setCookie(String cookieName, String cookieValue) {
        open("/404");
        getWebDriver().manage().addCookie(new Cookie(cookieName, cookieValue));
        refresh();
    }
}
