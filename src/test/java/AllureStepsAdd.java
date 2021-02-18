import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AllureStepsAdd {
    private static final String
            BASEURL = "https://github.com/",
            OWNER = "i652",
            REPOSITORY = "/qaguru_4.3";

    @Test
    @Link(BASEURL + OWNER + REPOSITORY)
    @Tags({@Tag("web"), @Tag("critical")})
    @Feature("Contributors")
    @Story("Поиск авторов в репозитории")
    @Owner(OWNER)
    @DisplayName("Поиск репозитория " + REPOSITORY + " у автора " +OWNER)
    void AllureBaseSteps() {
        step("Открываем Гитхаб", ()-> {
            open(BASEURL);
        });

        step("Ищем репозиторий " + REPOSITORY, ()-> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(OWNER + REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий " + REPOSITORY, ()-> {
            $(byLinkText(OWNER + REPOSITORY)).click();
        });

        step("Переходим в раздел Insights", ()-> {
            $(withText("Insights")).click();
        });

        step("Переходим в раздел Contributors", ()-> {
            $(withText("Contributors")).click();
        });

        step("Убеждаемся, что автор " + OWNER, ()-> {
            $(withText(OWNER)).should(Condition.exist);
        });
    }
}