package co.com.sofka.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/Get_Delete.feature"},
        glue = {"co.com.sofka.stepdefinition"}
)

public class Get_DeleteTest {
}
