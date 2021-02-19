import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {
    private static final String
            BASEURL = "https://github.com/",
            OWNER = "i652",
            REPOSITORY = "/qaguru_4.3";
    @Test
    public void ContributorsCheck() {
        //Открываем Гитхаб
        step("Открываем Гитхаб", ()-> {
            open(BASEURL);
        });
        //Ищем репозиторий
        step("Ищем репозиторий " + REPOSITORY, ()-> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(OWNER + REPOSITORY);
            $(".header-search-input").submit();
        });
        //Переходим в репозиторий
        step("Переходим в репозиторий " + REPOSITORY, ()-> {
            $(byLinkText(OWNER + REPOSITORY)).click();
        });
        //Переходим в раздел Insights
        step("Переходим в раздел Insights", ()-> {
            $(withText("Insights")).click();
        });
        //Переходим в раздел Contributors
        step("Переходим в раздел Contributors", ()-> {
            $(withText("Contributors")).click();
        });
        //Убеждаемся в авторстве
        step("Убеждаемся, что автор " + OWNER, ()-> {
            $(withText(OWNER)).should(Condition.exist);
        });
    }
}
