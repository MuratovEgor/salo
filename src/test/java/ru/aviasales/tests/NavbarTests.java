package ru.aviasales.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;
import ru.aviasales.annotations.Layer;

import static com.codeborne.selenide.Selenide.open;

@Layer("Web")
@Owner("egormuratov")
public class NavbarTests extends TestBase {

    @BeforeEach
    void openHomePage() {
        open("");
    }

    @Test
    @Story("Navbar")
    @Feature("Login popup")
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
    @Feature("Navbar profile")
    @JiraIssues({@JiraIssue("HOM-231")})
    @Tags({@Tag("web"), @Tag("regress"), @Tag("UI")})
    @DisplayName("Open the setting page via the navbar profile")
    void openSettingPage() {
        navbar.openProfileDropdown();
        navbar.clickSettingLink();
        profilePage.userAccountBlockIsShown();
    }
}
