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

public class PostCreateNewProjectStepDef {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Request body for create a new project with name key is Shopping List")
    public void requestBodyForCreateANewProjectWithNameKeyIsShoppingList() {
        File json = new File(Constants.PROJECT_REQ_BODY_DIR + "postCreate/ValidNameKey.json");
        todoistAPI.postCreate(json);
    }

    @When("Send VALID POST request for create a new project")
    public void sendVALIDPOSTRequestForCreateANewProject() {
        todoistAPI.sendValidPostCreate(Constants.PROJECT_POST_CREATE_URL);
    }

    @Then("API response for create a new project should return {int} OK status code")
    public void apiResponseForCreateANewProjectShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate create a new project response body JSON schema")
    public void validateCreateANewProjectResponseBodyJSONSchema() {
        File json = new File(Constants.PROJECT_JSON_SCHEMA_DIR + "postCreate/ValidNameKeySchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body name key for create a new project should be {string}")
    public void responseBodyNameKeyForCreateANewProjectShouldBe(String name) {
        SerenityRest.and().body(TodoistResponses.NAME, equalTo(name));
    }

    @Given("Empty request body for create a new project")
    public void emptyRequestBodyForCreateANewProject() {
        File json = new File(Constants.PROJECT_REQ_BODY_DIR + "postCreate/EmptyRequest.json");
        todoistAPI.postCreate(json);
    }

    @When("Send POST request for create a new project")
    public void sendPOSTRequestForCreateANewProject() {
        SerenityRest.when().post(Constants.PROJECT_POST_CREATE_URL);
    }

    @Then("API response for create a new project should return {int} Bad Request status code")
    public void apiResponseForCreateANewProjectShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Request body for create a new project with empty name key")
    public void requestBodyForCreateANewProjectWithEmptyNameKey() {
        File json = new File(Constants.PROJECT_REQ_BODY_DIR + "postCreate/EmptyName.json");
        todoistAPI.postCreate(json);
    }

    @Given("Request body for create a new project with number data type of name key")
    public void requestBodyForCreateANewProjectWithNumberDataTypeOfNameKey() {
        File json = new File(Constants.PROJECT_REQ_BODY_DIR + "postCreate/NumberName.json");
        todoistAPI.postCreate(json);
    }
}
