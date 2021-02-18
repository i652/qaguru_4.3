import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

    public class AllureSteps {
        @Test
    void AllureBaseSteps() {
            final String repo = "i652/qaguru_4.3";
            open("https://github.com/");

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repo);
            $(".header-search-input").submit();

            $(byLinkText(repo)).click();
            $(withText("Insights")).click();
            $(withText("Contributors")).click();
            $(withText("i652")).should(Condition.exist);
        }
    }