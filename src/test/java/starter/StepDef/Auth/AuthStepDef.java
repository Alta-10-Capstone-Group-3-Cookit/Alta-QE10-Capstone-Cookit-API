package starter.StepDef.Auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Auth.Auth;
import starter.Utils.Constants;

import java.io.File;

public class AuthStepDef {
    @Steps
    Auth auth;

    //Post Login User
    @Given("Post login user with valid path and valid json body")
    public void postLoginUserWithValidPathAndValidJsonBody() {
        auth.postLoginUserWithValidPath(Constants.USERNAME, Constants.PASSWORD);
    }

    @When("Send post login user")
    public void sendPostLoginUser() {
        Constants.BEARER_TOKEN = SerenityRest.when().post(Constants.LOGIN).jsonPath().getString("data.token");
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Validate post login for user JSON Schema")
    public void validatePostLoginForUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Auth/PostLoginUserPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Post Registration User
    @Given("Post register user with valid path and valid json body")
    public void postregisterUserWithValidPathAndValidJsonBody() {
        auth.postRegisterUserWithValidPathAndJsonBody(Constants.REG_USERNAME, Constants.REG_EMAIL, Constants.PASSWORD);
    }

    @When("Send post registration user")
    public void sendPostRegistrationUser() {
        SerenityRest.when().post(Constants.REGISTER);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Validate post registration user JSON Schema")
    public void validatePostRegistrationUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Auth/PostUserRegistrationPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("valid request body for login back to user")
    public void validRequestBodyForLoginBackToUser() {
        auth.loginBackToUser(Constants.USERNAME, Constants.PASSWORD);
    }

    @When("Send POST method for login back to user")
    public void sendPOSTMethodForLoginBackToUser() {
        Constants.BEARER_TOKEN = SerenityRest.when().post(Constants.LOGIN).jsonPath().getString("data.id");
    }

    @Then("Status code for login back to user should be {int} OK status code")
    public void statusCodeForLoginBackToUserShouldBeOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
