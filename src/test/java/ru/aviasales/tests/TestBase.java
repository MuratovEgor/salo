package ru.aviasales.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.aviasales.config.Project;
import ru.aviasales.helpers.AllureAttachments;
import ru.aviasales.helpers.CookiesHelper;
import ru.aviasales.helpers.DriverSettings;
import ru.aviasales.helpers.DriverUtils;
import ru.aviasales.pages.LoginPopup;
import ru.aviasales.pages.Navbar;
import ru.aviasales.pages.ProfilePage;
import ru.aviasales.pages.SearchForm;

@ExtendWith({AllureJunit5.class})
public class TestBase {
    Navbar navbar = new Navbar();
    SearchForm searchForm = new SearchForm();
    ProfilePage profilePage = new ProfilePage();
    LoginPopup loginPopup = new LoginPopup();
    CookiesHelper cookiesHelper = new CookiesHelper();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
        Configuration.baseUrl = Project.config.baseUrl();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();
        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();
        Selenide.closeWebDriver();
        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
