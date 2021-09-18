package ru.aviasales.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;
import ru.aviasales.annotations.Layer;
import ru.aviasales.helpers.DriverUtils;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Layer("Web")
@Owner("egormuratov")
public class ConsoleTests extends TestBase {

    @Test
    @Description("Console test")
    @Story("Page console log should not have errors")
    @Tags({@Tag("web"), @Tag("smoke")})
    @JiraIssues({@JiraIssue("HOM-231")})
    @DisplayName("Home Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        open("");
        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}