package cloud.autotests.tests;

import cloud.autotests.config.App;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Authorization")
public class LoginTests extends TestBase {
    @Test
    @AllureId("5166")
    @Description("Soon to be implemented by you (or QA.GURU engineers)")
    @DisplayName("Successful login")
    void loginTest() {
        step("Open login page", () ->
                open("/login"));

        step("Fill login form", () -> {
            $("[data-name=logInEmailAddress]").setValue(App.config.userLogin());
            $("[data-name=logInPassword]").setValue(App.config.userPassword())
                    .pressEnter();
        });

        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(App.config.userLogin())));

    }
}
