
package steps;

import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.Rows;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.junit.Cucumber;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pages.BasePage;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



/**
 * Creamos los step definitions y sus respectivos métodos para validar la API
 *
 * @author J. Andrés Vázquez González <stroudanders@gmail.com>
 * @version 0.1.0
 * Se agregan nuevos métodos para los escenarios  y se documenta con base en JAVADOC
 */

public class APITestSteps extends BasePage {
    Scenario scenario;


    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    /**
     * Se hace un request sobre una URI y se espera una respuesta de tipo JSON
     *
     * @param URI {String}
     */
    @Dado("^I send a Get request to the (.+) URI")
    public void i_send_a_request(String URI) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        request = given()
                .baseUri(URI)
                .contentType(ContentType.JSON);
        rows.put("Dado", Rows.of("Imagen  1 ", "Imagen 2").create());
        rows.put("Dado_Descripción", Rows.of("Envío una solicitud GET hacia el URI", "Obtengo un código de respuesta de servicio").create());
        System.out.println(scenario.getName());

    }

    /**
     * Se hace un request con una nueva ruta o endpoint y espera una respuesta con status code
     *
     * @param expectedStatusCode {int}
     */
    @Entonces("^I get a (\\d+) status code$")
    public void i_get_a_list_of_users(int expectedStatusCode) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        response = request
                .when()
                .get("/users/TheFreeRangeTester/repos");
        json = response
                .then()
                .statusCode(expectedStatusCode);
        stepReport(rows.get("Dado"), rows.get("Dado_Descripción"));


    }

    /**
     * Se hace un request con una nueva ruta o endpoint y espera una respuesta que se guarda
     * en una lista la cual debe tener un tamaño definido
     *
     * @param expectedSize {int}
     * @param endpoint     {string}
     * @since 0.1.0
     * Se agrega método
     */
    @Entonces("^I validate there are (\\d+) items on the (.+) endpoint$")
    public void i_validate_there_are_items_on_the_users_endpoint(int expectedSize, String endpoint) {
        // Write code here that turns the phrase above into concrete actions
        response = request
                .when()
                .get(endpoint);
        List<String> jsonResponse = response.jsonPath().getList("$");
        int actualSize = jsonResponse.size();
        assertEquals(expectedSize, actualSize);

    }

    /**
     * Se hace un request con una nueva ruta o endpoint y espera una respuesta que se guarda
     * en una lista la cual debe tener en el elemento cero dentro del campo username un valor de tipo String
     * definido
     *
     * @param expectedValue {string}
     * @param endpoint      {string}
     * @since 0.1.0
     * Se agrega método
     */
    @Entonces("^I validate there are value: (.+) in the response at (.+ )endpoint$")
    public void i_validate_there_are_value_brent_in_the_response_at_users_endpoint(String expectedValue, String endpoint) {
        // Write code here that turns the phrase above into concrete actions
        response = request
                .when()
                .get(endpoint);
        List<String> jsonResponse = response.jsonPath().getList("username");
        String actualValue = jsonResponse.get(0);
        assertEquals(expectedValue, actualValue);
    }

    /**
     * Se hace un request con una nueva ruta o endpoint y espera una respuesta que se guarda
     * en una lista la cual debe tener en alguno de sus campos username un valor de tipo String
     * definido
     *
     * @param expectedValue {string}
     * @param endpoint      {string}
     * @since 0.1.0
     * Se agrega método
     */
    @Entonces("^I validate there are other value: (.+) in the response at (.+ )endpoint$")
    public void i_validate_there_are_other_value_brent_in_the_response_at_users_endpoint(String expectedValue, String endpoint) {
        // Write code here that turns the phrase above into concrete actions
        response = request
                .when()
                .get(endpoint);
        List<String> jsonResponse = response.jsonPath().getList("username");
        assertTrue("El valor " + expectedValue + " no se encuentra en la lista", jsonResponse.contains(expectedValue));
    }

    /**
     * Se hace un request con una nueva ruta o endpoint y espera una respuesta que se guarda
     * en un String el cual debe tener en alguno de sus campos addres.street un valor de tipo String
     * definido
     *
     * @param expectedStreet {string}
     * @param endpoint       {string}
     * @since 0.1.0
     * Se agrega método
     */
    @Entonces("^I can validate the nested value: (.+)  on the response at (.+) endpoint$")
    public void i_can_validate_the_nested_value_kattie_turnpike_on_the_response_at_users_endpoint(String expectedStreet, String endpoint) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        response = request
                .when()
                .get(endpoint);
        String jsonResponse = response.jsonPath().getString("addres.street");
        assertTrue("La calle " + expectedStreet + " no pertenece a ningún usuario", jsonResponse.contains(expectedStreet));

    }



}
