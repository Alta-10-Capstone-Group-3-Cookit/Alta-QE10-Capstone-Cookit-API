package starter.StepDef.projects;

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

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class GetProjectStepDef {

    @Steps
    TodoistAPI todoistAPI;

    @Given("Available id path for get a project")
    public void availableIdPathForGetAProject() {
        todoistAPI.getSingle(Constants.AVAILABLE_ID_PATH);
    }

    @When("Send GET request for get a project")
    public void sendGETRequestForGetAProject() {
        SerenityRest.when().get(Constants.PROJECT_GET_URL + Constants.ID_PATH);
    }

    @Then("API response for get a project should return {int} OK status code")
    public void apiResponseForGetAProjectShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate get a project response body JSON Schema")
    public void validateGetAProjectResponseBodyJSONSchema() {
        File json = new File(Constants.PROJECT_JSON_SCHEMA_DIR + "get/AvailableIdPathSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body id key for get a project should be same as available id path")
    public void validateResponseBodyIdKeyForGetAProjectShouldBeSameAsAvailableIdPath() {
        SerenityRest.and().body(TodoistResponses.ID, equalTo(Constants.AVAILABLE_ID_PATH));
    }

    @Given("{string} as an unavailable id path for get a project")
    public void asAnUnavailableIdPathForGetAProject(String id) {
        todoistAPI.getSingle(id);
    }

    @Then("API response for get a project should return {int} Not Found status code")
    public void apiResponseForGetAProjectShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("{string} as an invalid id path for get a project")
    public void asAnInvalidIdPathForGetAProject(String id) {
        todoistAPI.getSingle(id);
    }

    @Then("API response for get a project should return {int} Bad Request status code")
    public void apiResponseForGetAProjectShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
