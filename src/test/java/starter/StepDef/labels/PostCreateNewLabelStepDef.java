package starter.StepDef.labels;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import net.thucydides.core.annotations.Steps;
import starter.Todoist.TodoistAPI;
import starter.Todoist.TodoistResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateNewLabelStepDef {
    @Steps
    TodoistAPI todoistAPI;

    // Post Create Valid Name
    @Given("Request body for create a new personal label with name is Tomato")
    public void requestBodyForCreateANewPersonalLabelWithNameIsApple(){
        File json = new File(Constants.LABELS_REQ_BODY_DIR + "postCreate/ValidCreateReqBody.json");
        todoistAPI.postCreate(json);
    }

    @When("Send POST request for create a new personal label")
    public void sendPOSTRequestForCreateANewPersonalLabel() {
        todoistAPI.sendValidPostCreate(Constants.LABELS_POST_CREATE_URL);
    }

    @Then("API response should return {int} OK status code")
    public void apiResponseShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate create a new personal label response body JSON schema")
    public void validateCreateANewPersonalLabelResponseBodyJSONSchema() {
        File json = new File(Constants.LABELS_JSON_SCHEMA_DIR + "postCreate/ValidCreateJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body name for create a new personal label should be {string}")
    public void responseBodyNameForCreateANewPersonalLabelShouldBe(String name) {
        SerenityRest.and().body(TodoistResponses.NAME, equalTo(name));
    }

    // Post Create Empty Request Body
    @Given("Empty request body for create a new project label")
    public void emptyRequestBodyForCreateANewProjectLabel() {
        File json = new File(Constants.LABELS_REQ_BODY_DIR + "postCreate/EmptyCreateReqBody.json");
        todoistAPI.postCreate(json);
    }

    @When("Send POST request with empty body for create a new personal label")
    public void sendPOSTRequestWithEmptyBodyForCreateANewPersonalLabel() {
        SerenityRest.when().post(Constants.LABELS_POST_CREATE_URL);
    }

    @Then("API response should return {int} Bad Request status code")
    public void apiResponseShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    // Post Create With Registeren Name
    @Given("Request body with registered name for create a new project label")
    public void requestBodyWithRegisteredNameForCreateANewProjectLabel() {
        File json = new File(Constants.LABELS_REQ_BODY_DIR + "postCreate/ValidCreateReqBody.json");
        todoistAPI.postCreate(json);
    }

    @When("Send POST request registered name for create a new personal label")
    public void sendPOSTRequestRegisteredNameForCreateANewPersonalLabel() {
        SerenityRest.when().post(Constants.LABELS_POST_CREATE_URL);
    }

    // Post Create Invalid Key
    @Given("{string} as invalid key on request body for create a new personal label")
    public void asInvalidKeyOnRequestBodyForCreateANewPersonalLabel(String key) {
        File json = new File(Constants.LABELS_REQ_BODY_DIR + "postCreate/InvalidKeyReqBody.json");
        todoistAPI.postCreate(json);
    }

    @When("Send POST request for invalid body create a new personal label")
    public void sendPOSTRequestForInvalidBodyCreateANewPersonalLabel() {
        SerenityRest.when().post(Constants.LABELS_POST_CREATE_URL);

    }

    // Post Create Empty Name Key
    @Given("Empty name key for create a new personal label")
    public void emptyNameKeyForCreateANewPersonalLabel() {
        File json = new File(Constants.LABELS_REQ_BODY_DIR + "postCreate/EmptyNameKeyReqBody.json");
        todoistAPI.postCreate(json);
    }

    @When("Send POST request with empty name key for create a new personal label")
    public void sendPOSTRequestWithEmptyNameKeyForCreateANewPersonalLabel() {
        SerenityRest.when().post(Constants.LABELS_POST_CREATE_URL);
    }
}
