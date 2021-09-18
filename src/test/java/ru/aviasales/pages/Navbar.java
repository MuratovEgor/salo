package ru.aviasales.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Navbar {

    SelenideElement btnProfile = $(".navbar__control button"),
            profileDropdown = $("[data-test-element='dropdown']"),
            linkSetting = $("[href='/my/settings']"),
            btnLogin = $("[data-test-element='dropdown'] button");

    @Step("Open profile dropdown")
    public void openProfileDropdown() {
        btnProfile.click();
        profileDropdown.shouldBe();
    }

    @Step("Click the Setting link")
    public void clickSettingLink() {
        linkSetting.click();
    }

    @Step("Click the Login button")
    public void clickLogInBtn() {
        btnLogin.click();
    }

}
