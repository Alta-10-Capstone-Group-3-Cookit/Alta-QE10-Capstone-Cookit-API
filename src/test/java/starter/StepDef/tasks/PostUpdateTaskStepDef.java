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

public class PostUpdateTaskStepDef {

    @Steps
    TodoistAPI todoistAPI;

    //valid name key available id path
    @Given("Request body for update a task with name key is Buy Coffee and an available id path")
    public void requestBodyForUpdateATaskWithNameKeyIsBuyCoffeeAndAnAvailableIdPath() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postUpdate/ValidNameKeyAvailableIdPath.json");
        todoistAPI.postUpdate(Constants.AVAILABLE_ID_PATH, json);
    }

    @When("Send VALID POST request for update a task")
    public void sendVALIDPOSTRequestForUpdateATask() {
        todoistAPI.sendValidPostCreate(Constants.TASKS_POST_UPDATE_URL);
    }

    @Then("API response for update a task should return {int} OK status code")
    public void apiResponseForUpdateATaskShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate update a task response body JSON Schema")
    public void validateUpdateATaskResponseBodyJSONSchema() {
        File json = new File(Constants.TASKS_JSON_SCHEMA_DIR + "postUpdate/AvailableIdPathSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body id key for update a task should be same as available id path")
    public void validateResponseBodyIdKeyForUpdateATaskShouldBeSameAsAvailableIdPath() {
        SerenityRest.and().body(TodoistResponses.ID, equalTo(Constants.AVAILABLE_ID_PATH));
    }

    // unavailable id path

    @Given("Request body for update a task with name key is Buy Coffee and {string} as an unavailable id path")
    public void requestBodyForUpdateATaskWithNameKeyIsBuyCoffeeAndAsAnUnavailableIdPath(String id) {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postUpdate/ValidNameKeyAvailableIdPath.json");
        todoistAPI.postUpdate(id, json);
    }

    @When("Send POST request for Update a task")
    public void sendPOSTRequestForUpdateATask() {
        SerenityRest.when().post(Constants.TASKS_POST_UPDATE_URL+ Constants.ID_PATH);
    }
    @Then("API response for update a task should return {int} Not Found status code")
    public void apiResponseForUpdateATaskShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    //invalid id path
    @Given("Request body for update a task with name key is Buy Coffee and {string} as an invalid id path with special char")
    public void requestBodyForUpdateATaskWithNameKeyIsBuyCoffeeAndAsAnInvalidIdPathWithSpecialChar(String id) {
        todoistAPI.getSingle(id);
    }

    @Then("API response for update a task should return {int} Bad Request status code")
    public void apiResponseForUpdateATaskShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    //empty content available id path
    @Given("Request body for update a task with empty content key and an available id path")
    public void requestBodyForUpdateATaskWithEmptyContentKeyAndAnAvailableIdPath() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postUpdate/EmptyContentKeyAvailableIdPath.json");
        todoistAPI.postUpdate(Constants.AVAILABLE_ID_PATH, json);
    }

//number data content key
    @Given("Request body for update a task with number data type of content key and an available id path")
    public void requestBodyForUpdateATaskWithNumberDataTypeOfContentKeyAndAnAvailableIdPath() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postUpdate/NumberDataContentKeyAvailableIdPath.json");
        todoistAPI.postUpdate(Constants.AVAILABLE_ID_PATH, json);
    }

    //without content key available id path
    @Given("Request body for update a task without content key and an available id path")
    public void requestBodyForUpdateATaskWithoutContentKeyAndAnAvailableIdPath() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postUpdate/WithoutContentKeyAvailableIdPath.json");
        todoistAPI.postUpdate(Constants.AVAILABLE_ID_PATH, json);
    }

}
