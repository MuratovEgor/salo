package ru.aviasales.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPopup {
    SelenideElement loginPopup = $(".login-popup");

    @Step("The login popup is shown")
    public void isShown() {
        loginPopup.shouldBe(visible);
    }
}
