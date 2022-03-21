package co.com.sofka.stepdefinition;

import co.com.sofka.stepdefinition.setup.services.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


public class GetDeleteStep extends ServiceSetUp {
    public static final Logger LOGER = Logger.getLogger(GetDeleteStep.class);
    private Response response;
    private RequestSpecification request;

    @Given("se desea requerir la lista de datos de un usuario")
    public void seDeseaRequerirLaListaDeDatosDeUnUsuario() {

        try{
            generalSetUp();

            request = given()
                    .log()
                    .all();
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @When("se obtiene la informacion")
    public void seObtieneLaInformacion() {
        try{
            response = request.when()
                    .get(SINGLE_RESOURCE);
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Then("se obtendra un mensaje como respuesta exitoso y ademas, los datos del usuario")
    public void seObtendraUnMensajeComoRespuestaExitosoYAdemasLosDatosDelUsuario() {
        try{

            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("page", notNullValue(),
                            "per_page", notNullValue(),
                            "total", notNullValue(),
                            "total_pages", notNullValue(),
                            "data", notNullValue(),
                            "support", notNullValue());
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Given("se desea eliminar los datos de un  usuario")
    public void seDeseaEliminarLosDatosDeUnUsuario() {
        try{
            generalSetUp();

            request = given()
                    .log()
                    .all();
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @When("se logra la accion requerida")
    public void seLograLaAccionRequerida() {
        try{
            response = request.when()
                    .delete(USER_DIRECCTION);
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Then("se obtendra un mensaje como respuesta exitosa")
    public void seObtendraUnMensajeComoRespuestaExitosa() {
        try{
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_NO_CONTENT);
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

}
