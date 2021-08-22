package ru.aviasales.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CommonSteps {
    @Step("Open page {url}")
    public void openPage(String url) {
        open(url);
    }


    @Step("Set Cookie: {cookieName}: {cookieValue}")
    public void setCookie(String cookieName, String cookieValue) {
        Cookie cookie = getWebDriver().manage().getCookieNamed(cookieName);
        sleep(1000);
        getWebDriver().manage().deleteCookie(cookie);
        sleep(1000);
        getWebDriver().manage().addCookie(new Cookie(cookieName, cookieValue));
        refresh();
    }
}
