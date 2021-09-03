package ru.aviasales.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;
import ru.aviasales.annotations.Layer;
import ru.aviasales.config.Project;
import ru.aviasales.helpers.CommonSteps;
import ru.aviasales.helpers.DriverUtils;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Layer("Web")
@Owner("egormuratov")
public class ConsoleTests extends TestBase {

    @BeforeAll
    static void configureBaseUrl() {
        Configuration.baseUrl = Project.config.baseUrl();
    }

    @Test
    @Description("Console test")
    @Story("Page console log should not have errors")
    @Tags({@Tag("web"), @Tag("regress")})
    @JiraIssues({@JiraIssue("HOM-231")})
    @DisplayName("Home Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        new CommonSteps().openPage("");
        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}