package io.qaguru.eroshenkoam;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {
    private static final String
            BASEURL = "https://github.com/";

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open(BASEURL);
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepo(final String author, final String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(author + repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepo(final String author, final String repository) {
        $(byLinkText(author + repository)).click();
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
    public void authorShouldBe(final String author) {
        $(withText(author)).should(Condition.exist);
    }
}
