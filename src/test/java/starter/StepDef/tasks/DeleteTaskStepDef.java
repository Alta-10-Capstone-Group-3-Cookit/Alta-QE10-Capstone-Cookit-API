package starter.StepDef.tasks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jnr.constants.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Todoist.TodoistAPI;
import starter.Utils.Constants;

public class DeleteTaskStepDef {

    @Steps
    TodoistAPI todoistAPI;

    // available id
    @Given("Available id path for delete a task")
    public void availableIdPathForDeleteATask() {
        todoistAPI.deleteSomething(Constants.AVAILABLE_ID_PATH);
    }

    @When("Send GET request for delete a task")
    public void sendGETRequestForDeleteATask() {
        SerenityRest.when().delete(Constants.TASKS_DELETE_URL + Constants.ID_PATH);
    }

    @Then("API response for delete a task should return {int} No Content status code")
    public void apiResponseForDeleteATaskShouldReturnNoContentStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }


    //unavailable id
    @Given("{string} as an unavailable id path for delete a task")
    public void asAnUnavailableIdPathForDeleteATask(String id){
        todoistAPI.deleteSomething(id);
    }

    @Then("API response for delete a task should return {int} Not Found status code")
    public void apiResponseForDeleteATaskShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    //invalid id
    @Given("{string} as an invalid id path for delete a task")
    public void asAnInvalidIdPathForDeleteATask(String id) {
        todoistAPI.deleteSomething(id);
    }

    @Then("API response for delete a task should return {int} Bad Request status code")
    public void apiResponseForDeleteATaskShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
