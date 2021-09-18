package ru.aviasales.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    SelenideElement profilePage = $(".--user-account");

    @Step("The 'user account' block is shown")
    public void userAccountBlockIsShown() {
        profilePage.shouldBe(visible);
    }
}
