package ru.aviasales.tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;

import static com.codeborne.selenide.Selenide.open;

public class NavbarTests extends TestBase {

    @BeforeEach
    void openHomePage() {
        open("");
    }

    @Test
    @Story("Navbar")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("Open Login popup")
    void openLoginPopup() {
        navbar.openProfileDropdown();
        navbar.clickLogInBtn();
        loginPopup.isShown();
    }

    @Test
    @Story("Navbar")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("Open the setting page via the navbar profile")
    void openSettingPage() {
        navbar.openProfileDropdown();
        navbar.clickSettingLink();
        profilePage.userAccountBlockIsShown();
    }
}
