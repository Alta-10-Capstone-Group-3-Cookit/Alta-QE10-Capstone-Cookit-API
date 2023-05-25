package starter.StepDef.labels;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Todoist.TodoistAPI;
import starter.Todoist.TodoistResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostUpdateLabelStepDef {
    @Steps
    TodoistAPI todoistAPI;
    @Given("As an available id path and name was Coffee for update a personal label")
    public void asAnAvailableIdPathAndNameWasForUpdateAPersonalLabel() {
        File json = new File(Constants.LABELS_REQ_BODY_DIR + "postUpdate/UpdateNewNameReqBody.json");
        todoistAPI.postUpdate(Constants.AVAILABLE_ID_PATH, json);
    }

    @When("Send POST request for update a personal label")
    public void sendPOSTRequestForUpdateAPersonalLabel() {
        SerenityRest.when().post(Constants.LABELS_POST_UPDATE_URL + Constants.ID_PATH);
    }

    @And("Validate update a personal label response body JSON schema")
    public void validateUpdateAPersonalLabelResponseBodyJSONSchema() {
        File json = new File(Constants.LABELS_JSON_SCHEMA_DIR + "postUpdate/UpdateNewNameJSONSchema.json");
    }

    @And("Response body name for update a personal label should be {string}")
    public void responseBodyNameForUpdateAPersonalLabelShouldBe(String name) {
        SerenityRest.and().body(TodoistResponses.NAME, equalTo(name));

    }

    @Given("{string} as an unavailable id path and name was Snack for update a personal label")
    public void asAnUnavailableIdPathAndNameWasSnackForUpdateAPersonalLabel(String id) {
        File json = new File(Constants.LABELS_REQ_BODY_DIR + "postUpdate/UpdateNewNameReqBody.json");
        todoistAPI.postUpdate(id, json);
    }

    @Given("{string} as an invalid id path and name was Snack for update a personal label")
    public void asAnInvalidIdPathAndNameWasSnackForUpdateAPersonalLabel(String id) {
        File json = new File(Constants.LABELS_REQ_BODY_DIR + "postUpdate/UpdateNewNameReqBody.json");
        todoistAPI.postUpdate(id, json);
    }

    @Given("An available id path and empty name key for update a personal label")
    public void anAvailableIdPathAndEmptyNameKeyForUpdateAPersonalLabel() {
        File json = new File(Constants.LABELS_REQ_BODY_DIR + "postUpdate/EmptyNameKeyReqBody.json");
        todoistAPI.postUpdate(Constants.AVAILABLE_ID_PATH, json);
    }

    @Given("{string} as invalid key on request body for update a project")
    public void asInvalidKeyOnRequestBodyForUpdateAProject(String key) {
        File json = new File(Constants.LABELS_REQ_BODY_DIR + "postUpdate/InvalidKeyReqBody.json");
        todoistAPI.postCreate(json);
    }
}
