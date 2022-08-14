package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Clase runner donde se configuran algunos aspectos de cucumber
 * @author J. Andrés Vázquez González <stroudanders@gmail.com>
 * @version 0.1.0
 * Se agrega tag @API y se documenta con base en JAVADOC
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "steps",
        tags = "@API"

)

public class runner {


}

