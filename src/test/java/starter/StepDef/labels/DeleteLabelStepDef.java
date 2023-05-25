package starter.StepDef.labels;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import starter.Todoist.TodoistAPI;
import starter.Utils.Constants;

import java.io.File;

public class DeleteLabelStepDef {
    @Steps
    TodoistAPI todoistAPI;

    // Delete Available Id
    @Given("An available id path for delete a personal label")
    public void anAvailableIdPathForDeleteAPersonalLabel() {
        todoistAPI.deleteSomething(Constants.AVAILABLE_ID_PATH);
    }

    @When("Send DELETE request a personal label")
    public void sendDELETERequestAPersonalLabel() {
        SerenityRest.when().delete(Constants.LABELS_DELETE_URL + Constants.ID_PATH);
    }

    @Then("API response should return {int} No Content status code")
    public void apiResponseShouldReturnNoContentStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    // Delete Unavailable Id
    @Given("{string} as an unavailable id path for delete a personal label")
    public void asAnUnavailableIdPathForDeleteAPersonalLabel(String id) {
        todoistAPI.deleteSomething(id);
    }

}
