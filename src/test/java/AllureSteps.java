import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AllureSteps {
        @Test
    void AllureBaseSteps() {
            final String
                    author = "i652",
                    repo = author + "/qaguru_4.3";
            step("Открываем Гитхаб", ()-> {
                open("https://github.com/");
            });

            step("Ищем репозиторий " + repo, ()-> {
                $(".header-search-input").click();
                $(".header-search-input").sendKeys(repo);
                $(".header-search-input").submit();
            });

            step("Переходим в репозиторий " + repo, ()-> {
                $(byLinkText(repo)).click();
            });

            step("Переходим в раздел Insights", ()-> {
                $(withText("Insights")).click();
            });

            step("Переходим в раздел Contributors", ()-> {
                $(withText("Contributors")).click();
            });

            step("Убеждаемся, что автор " + author, ()-> {
                $(withText(author)).should(Condition.exist);
            });
            sleep(1000);
        }
    }