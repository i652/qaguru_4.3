package PackageBaseSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {
    private static final String
            BASEURL = "https://github.com/",
            OWNER = "i652",
            REPOSITORY = "/qaguru_4.3";

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open(BASEURL);
    }

    @Step("Ищем репозиторий " + REPOSITORY)
    public void searchRepo() {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(OWNER + REPOSITORY);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepo() {
        $(byLinkText(OWNER + REPOSITORY)).click();
    }

    @Step("Переходим в раздел Insights")
    public void goToRepoInsights() {
        $(withText("Insights")).click();
    }

    @Step("Переходим в раздел Contributors")
    public void goToRepoContributors() {
        $(withText("Contributors")).click();
    }

    @Step("Убеждаемся, что автор {author}")
    public void authorShouldBe() {
        $(withText(OWNER)).should(Condition.exist);
    }
}
