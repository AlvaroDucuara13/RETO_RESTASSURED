package co.com.sofka.stepdefinition;

import co.com.sofka.model.DatosModel;
import co.com.sofka.stepdefinition.setup.services.ServiceSetUp;
import co.com.sofka.util.ReadFileJson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateLoginStep extends ServiceSetUp {
    public static final Logger LOGER = Logger.getLogger(UpdateLoginStep.class);
    private Response response;
    private RequestSpecification request;
    private ReadFileJson readFileJson;
    private DatosModel datosModel;

    @Given("el usuario accede a iniciar sesion con el correo de usuario")
    public void elUsuarioAccedeAIniciarSesionConElCorreoDeUsuario() {

        try{
            generalSetUp();
            datosModel = new DatosModel();
            datosModel.setEMAIL();
            readFileJson = new ReadFileJson(datosModel.getEMAIL());
            String SaveEmailPassword = readFileJson.Convert();

            request = given()
                    .contentType(ContentType.JSON)
                    .log()
                    .all()
                    .body(SaveEmailPassword);
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @When("el usuario logra iniciar sesion")
    public void elUsuarioLograIniciarSesion() {
        try{
            response = request.when()
                    .post(LOGIN_RESOURCE);
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @Then("el usuario debera ver un codigo de respuesta erronea")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaErronea() {
        try{
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body("error", notNullValue());
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }


    }
    @Given("el usuario ingresa las credenciales nombre de usuario y el trabajo que desempena")
    public void elUsuarioIngresaLasCredencialesNombreDeUsuarioYElTrabajoQueDesempena() {
        try{
            generalSetUp();
            datosModel = new DatosModel();
            datosModel.setUSERNAME();
            datosModel.setEMPLOY();
            readFileJson = new ReadFileJson(datosModel.getUSERNAME(), datosModel.getEMPLOY());
            String SaveNameJob = readFileJson.Convert2();

            request = given()
                    .contentType(ContentType.JSON)
                    .log()
                    .all()
                    .body(SaveNameJob);
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }

    @When("el usuario logra actualizar sus datos")
    public void elUsuarioLograActualizarSusDatos() {
        try{
            response = request.when()
                    .post(USER_DIRECCTION);
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @Then("el usuario debera ver un codigo de respuesta exitosa")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaExitosa() {

        try{
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body("name", notNullValue(),
                            "job",notNullValue());
        } catch (Exception e){
            LOGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }


    }

}
