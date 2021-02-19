import io.qaguru.eroshenkoam.BaseSteps;
import org.junit.jupiter.api.Test;

public class MethodStepTest {

    public BaseSteps steps = new BaseSteps();

    @Test
    public void ContributorsCheck() {
        steps.openMainPage();
        steps.searchRepo();
        steps.goToRepo();
        steps.goToRepoInsights();
        steps.goToRepoContributors();
        steps.authorShouldBe();
    }
}
