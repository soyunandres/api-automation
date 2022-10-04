package runner;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.plugin.table.LoopRowTableRenderPolicy;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Clase runner donde se configuran algunos aspectos de cucumber
 * @author J. Andrés Vázquez González <stroudanders@gmail.com>
 * @version 0.2.0
 * Se agrega archivo de los resultados de ejecución en JSON para la integración
 * de Zephyr Scale de Jira con Cucumber
 * @version 0.1.0
 * Se agrega tag @API y se documenta con base en JAVADOC
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "steps",
        tags = "@API",
        /*
          @since 0.2.0
         * Se agrega la configuración para habilitar la salida de tipo JSON y XML
        */
        plugin = {"junit:target/cucumber/result.xml", "json:target/cucumber/APITest.json"}

)

public class runner {











}

