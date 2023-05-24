package starter.StepDef.projects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Todoist.TodoistAPI;
import starter.Utils.Constants;

public class DeleteProjectStepDef {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Available id path for delete a project")
    public void availableIdPathForDeleteAProject() {
        todoistAPI.deleteSomething(Constants.AVAILABLE_ID_PATH);
    }

    @When("Send DELETE request for delete a project")
    public void sendDELETERequestForDeleteAProject() {
        SerenityRest.when().delete(Constants.PROJECT_DELETE_URL + Constants.ID_PATH);
    }

    @Then("API response for delete a project should return {int} No Content status code")
    public void apiResponseForDeleteAProjectShouldReturnNoContentStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("{string} as an unavailable id path for delete a project")
    public void asAnUnavailableIdPathForDeleteAProject(String id) {
        todoistAPI.deleteSomething(id);
    }

    @Then("API response for delete a project should return {int} Not Found status code")
    public void apiResponseForDeleteAProjectShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
