package starter.StepDef.tasks;

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

public class GetActiveTaskStepDef {

    @Steps
    TodoistAPI todoistAPI;
    @Given("Available id path for get an active task")
    public void availableIdPathForGetAnActiveTask() {
        todoistAPI.getSingle(Constants.AVAILABLE_ID_PATH);
    }

    @When("Send GET request for get an active task")
    public void sendGETRequestForGetAnActiveTask() {
        SerenityRest.when().get(Constants.TASKS_GET_URL + Constants.ID_PATH);
    }

    @Then("API response should return {int} OK status code")
    public void apiResponseShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate get an active task response body JSON Schema")
    public void validateGetAnActiveTaskResponseBodyJSONSchema() {
        File json = new File(Constants.TASKS_JSON_SCHEMA_DIR + "get/AvailableIdPathSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body id key for get an active task should be same as available id path")
    public void validateResponseBodyIdKeyForGetAnActiveTaskShouldBeSameAsAvailableIdPath() {
        SerenityRest.and().body(TodoistResponses.ID, equalTo(Constants.AVAILABLE_ID_PATH));
    }

    @Given("{string} as an unavailable id path")
    public void asAnUnavailableIdPath(String id) {
        todoistAPI.getSingle(Constants.AVAILABLE_ID_PATH);
    }

    @Then("API response for get an active task should return {int} Not Found status code")
    public void apiResponseForGetAnActiveTaskShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("{string} as an invalid id path with special char")
    public void asAnInvalidIdPathWithSpecialChar(String id) {
        todoistAPI.getSingle(Constants.AVAILABLE_ID_PATH);
    }

    @Then("API response for get an active task should return {int} Bad Request status code")
    public void apiResponseForGetAnActiveTaskShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
