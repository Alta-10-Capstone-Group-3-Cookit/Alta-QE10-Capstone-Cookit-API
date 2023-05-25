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

public class GetPersonalLabelStepDef {
    @Steps
    TodoistAPI todoistAPI;

    // Get Available Id
    @Given("As an available id path for get a personal label")
    public void asAnAvailableIdPathForGetAPersonalLabel(){
        todoistAPI.getSingle(Constants.AVAILABLE_ID_PATH);
    }

    @When("Send GET request for get a personal label")
    public void sendGETRequestForGetAPersonalLabel() {
        SerenityRest.when().get(Constants.LABELS_GET_URL + Constants.ID_PATH);
    }

    @Then("API response for get a personal label should return {int} OK status code")
    public void apiResponseForGetAPersonalLabelShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate get a personal label response body JSON Schema")
    public void validateGetAPersonalLabelResponseBodyJSONSchema() {
        File json = new File(Constants.LABELS_JSON_SCHEMA_DIR + "get/ValidIdGetJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body id key for get a personal label should be same as available id path")
    public void validateResponseBodyIdKeyForGetAPersonalLabelShouldBeSameAsAvailableIdPath() {
        SerenityRest.and().body(TodoistResponses.ID, equalTo(Constants.AVAILABLE_ID_PATH));
    }

    // Get Unavailable Id
    @Given("unavailable {string} path for get a personal labels")
    public void unavailablePathForGetAPersonalLabels(String id) {
        todoistAPI.getSingle(id);
    }

    @When("Send GET request with unavailable id path for get a personal labels")
    public void sendGETRequestWithUnavailableIdPathForGetAPersonalLabels() {
        SerenityRest.when().get(Constants.LABELS_GET_URL + Constants.ID_PATH);
    }

    @Then("API response for get a personal label  should return {int} Not Found status code")
    public void apiResponseForGetAPersonalLabelShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    // Get Invalid Id
    @Given("invalid {string} path for get a personal label")
    public void invalidPathForGetAPersonalLabel(String id) {
        todoistAPI.getSingle(id);
    }

    @When("Send GET request with invalid id path for get a personal label")
    public void sendGETRequestWithInvalidIdPathForGetAPersonalLabel() {
        SerenityRest.when().get(Constants.LABELS_GET_URL + Constants.ID_PATH);
    }

    @Then("API response for get a personal label  should return {int} Bad Request status code")
    public void apiResponseForGetAPersonalLabelShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
