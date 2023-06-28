package starter.StepDef.Admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Admin.Admin;
import starter.Utils.Constants;

import java.io.File;

public class AdminStepDef {
    @Steps
    Admin admin;

    // Get List Verify

    @Given("Get list verify with valid path")
    public void getListVerifyWithValidPath(){
        admin.postLoginAdmin("admin", "admin");
        Constants.BEARER_TOKEN = SerenityRest.when().post(Constants.LOGIN).jsonPath().getString("data.token");
        admin.getListVerify();
    }

    @When("Send get list verify")
    public void sendGetListVerify() {
        SerenityRest.when().get(Constants.USERS+"/listverify");
    }

    @And("Validate get list verify with valid path json schema")
    public void validateGetListVerifyWithValidPathJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Admin/GetListVerifyPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put users approval with valid id and json body")
    public void putUsersApprovalWithValidIdAndJsonBody() {
        admin.postLoginAdmin("admin", "admin");
        Constants.BEARER_TOKEN = SerenityRest.when().post(Constants.LOGIN).jsonPath().getString("data.token");
        admin.putAdminVerify("verify");
    }

    @When("Send put users approval")
    public void sendPutUsersApproval() {
        SerenityRest.when().put(Constants.USERS+"/approval/"+Constants.OUR_USER_ID);
    }

    @And("Validate put users approval with valid id and json body json schema")
    public void validatePutUsersApprovalWithValidIdAndJsonBodyJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Admin/PutUserApproval.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
