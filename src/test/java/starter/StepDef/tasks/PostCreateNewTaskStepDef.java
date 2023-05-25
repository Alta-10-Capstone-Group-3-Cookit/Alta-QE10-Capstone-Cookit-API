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

public class PostCreateNewTaskStepDef {

    @Steps
    TodoistAPI todoistAPI;

    //valid request body
    @Given("Valid request body for create a new task")
    public void validRequestBodyForCreateANewTask() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postCreate/ValidContentKey.json");
        todoistAPI.postCreate(json);
    }

    //untuk positive case
    @When("Send VALID POST request for create a new task")
    public void sendVALIDPOSTRequestForCreateANewTask() {
        todoistAPI.sendValidPostCreate(Constants.TASKS_POST_CREATE_URL);
    }

    //untuk negative case
    @When("Send POST request for create a new task")
    public void sendPOSTRequestForCreateANewTask() {
        SerenityRest.when().post(Constants.TASKS_POST_CREATE_URL);
    }

    @Then("API response for create a new task should return {int} OK status code")
    public void apiResponseForCreateANewTaskShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate create a new task response body JSON Schema")
    public void validateCreateANewTaskResponseBodyJSONSchema() {
        File json = new File(Constants.TASKS_JSON_SCHEMA_DIR + "postCreate/ValidContentKeySchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body content key for create a new task should be {string}")
    public void responseBodyContentKeyForCreateANewTaskShouldBe(String content) {
        SerenityRest.and().body(TodoistResponses.CONTENT, equalTo(content));
    }


    //empty content key
    @Given("Request body for create a new task with empty content key")
    public void requestBodyForCreateANewTaskWithEmptyContentKey() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postCreate/EmptyContentKey.json");
        todoistAPI.postCreate(json);
    }

    @Then("API response for create a new task should return {int} Bad Request status code")
    public void apiResponseForCreateANewTaskShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }


    //number data content key
    @Given("Request body for create a new task with number data type of content key")
    public void requestBodyForCreateANewTaskWithNumberDataTypeOfContentKey() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postCreate/NumberDataTypeContentKey.json");
        todoistAPI.postCreate(json);
    }


    //without content key
    @Given("Request body for create a new task without content key")
    public void requestBodyForCreateANewTaskWithoutContentKey() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postCreate/WithoutContentKey.json");
        todoistAPI.postCreate(json);
    }


    //empty due_string
    @Given("Request body for create a new task with empty due_string key")
    public void requestBodyForCreateANewTaskWithEmptyDue_stringKey() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postCreate/EmptyDueStringKey.json");
        todoistAPI.postCreate(json);
    }


    //number data due_string
    @Given("Request body for create a new task with number data type of due_string key")
    public void requestBodyForCreateANewTaskWithNumberDataTypeOfDue_stringKey() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postCreate/NumberDataTypeDueStringKey.json");
        todoistAPI.postCreate(json);
    }


    //without due_string
    @Given("Request body for create a new task without due_string key")
    public void requestBodyForCreateANewTaskWithoutDue_stringKey() {
        File json = new File(Constants.TASKS_REQ_BODY_DIR + "postCreate/WithoutDueStringKey.json");
        todoistAPI.postCreate(json);
    }


}
