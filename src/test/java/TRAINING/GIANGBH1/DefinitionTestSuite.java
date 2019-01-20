package TRAINING.GIANGBH1;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features= {"src/test/resources/features/fontend.feature",
		"src/test/resources/features/backend_BE05.feature",
		"src/test/resources/features/backend_BE05_01.feature",
		"src/test/resources/features/backend_BE06_01.feature",
		"src/test/resources/features/backend_BE06_02.feature"}
)
public class DefinitionTestSuite {}
