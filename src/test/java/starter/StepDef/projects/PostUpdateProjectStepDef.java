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

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostUpdateProjectStepDef {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Request body for update a project with name key is Things To Buy and an available id path")
    public void requestBodyForUpdateAProjectWithNameKeyIsThingsToBuyAndAnAvailableIdPath() {
        File json = new File(Constants.PROJECT_REQ_BODY_DIR + "postUpdate/ValidNameKey.json");
        todoistAPI.postUpdate(Constants.AVAILABLE_ID_PATH, json);
    }

    @When("Send POST request for update a project")
    public void sendPOSTRequestForUpdateAProject() {
        SerenityRest.when().post(Constants.PROJECT_POST_UPDATE_URL + Constants.ID_PATH);
    }

    @Then("API response for update a project should return {int} OK status code")
    public void apiResponseForUpdateAProjectShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate update a project response body JSON Schema")
    public void validateUpdateAProjectResponseBodyJSONSchema() {
        File json = new File(Constants.PROJECT_JSON_SCHEMA_DIR + "postUpdate/ValidNameKeySchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body name key for update a project should be {string}")
    public void validateResponseBodyNameKeyForUpdateAProjectShouldBe(String name) {
        SerenityRest.and().body(TodoistResponses.NAME, equalTo(name));
    }

    @Given("Request body for update a project with name key is Things to Buy and {string} as an unavailable id path")
    public void requestBodyForUpdateAProjectWithNameKeyIsThingsToBuyAndAsAnUnavailableIdPath(String id) {
        File json = new File(Constants.PROJECT_REQ_BODY_DIR + "postUpdate/ValidNameKey.json");
        todoistAPI.postUpdate(id, json);
    }

    @Then("API response for update a project should return {int} Not Found")
    public void apiResponseForUpdateAProjectShouldReturnNotFound(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Request body for update a project with name key is Things To Buy and {string} as an invalid id path")
    public void requestBodyForUpdateAProjectWithNameKeyIsThingsToBuyAndAsAnInvalidIdPath(String id) {
        File json = new File(Constants.PROJECT_REQ_BODY_DIR + "postUpdate/ValidNameKey.json");
        todoistAPI.postUpdate(id, json);
    }

    @Then("API response for update a project should return {int} Bad Request status code")
    public void apiResponseForUpdateAProjectShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Empty request body for update a project and an available id path")
    public void emptyRequestBodyForUpdateAProjectAndAnAvailableIdPath() {
        File json = new File(Constants.PROJECT_REQ_BODY_DIR + "postUpdate/EmptyRequest.json");
        todoistAPI.postUpdate(Constants.AVAILABLE_ID_PATH, json);
    }

    @Given("Request body for update a project with empty name key and an available id path")
    public void requestBodyForUpdateAProjectWithEmptyNameKeyAndAnAvailableIdPath() {
        File json = new File(Constants.PROJECT_REQ_BODY_DIR + "postUpdate/EmptyName.json");
        todoistAPI.postUpdate(Constants.AVAILABLE_ID_PATH, json);
    }

    @Given("Request body for update a project with number data type of name key and an available id path")
    public void requestBodyForUpdateAProjectWithNumberDataTypeOfNameKeyAndAnAvailableIdPath() {
        File json = new File(Constants.PROJECT_REQ_BODY_DIR + "postUpdate/NumberName.json");
        todoistAPI.postUpdate(Constants.AVAILABLE_ID_PATH, json);
    }
}
