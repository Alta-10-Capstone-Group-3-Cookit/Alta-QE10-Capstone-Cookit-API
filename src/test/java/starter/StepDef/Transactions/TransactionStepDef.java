package starter.StepDef.Transactions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Transactions.Transactions;
import starter.Utils.Constants;

import java.io.File;

public class TransactionStepDef {
    @Steps
    Transactions transactions;

    // Post Insert New User's Transaction

    @Given("Get Post insert new user's transaction with valid path and json body")
    public void getPostInsertNewUsersTransactionWithValidPathAndJsonBody(){
        File json = new File(Constants.JSON_SCHEMA_DIR +"/Transactions/PostInsertNewTransactionValidJsonBody.json");
        transactions.postInsertNewUsersTransaction(json);
    }

    @When("Send Post insert new user's transaction")
    public void sendPostInsertNewUsersTransaction() {
        Constants.TRANSACTION_ID = SerenityRest.when().post(Constants.USERS+"/transactions").jsonPath().getString("data.id");
    }

    @And("Validate get post insert new user's transaction with valid path and json body json schema")
    public void validatePostInsertNewUserSTransactionWithValidPathAndJsonBodyJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Transactions/PostInsertNewTransactionPositiveSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get list of user's transaction with valid path")
    public void getListOfUserSTransactionWithValidPath() {
        transactions.getListOfUsersTransaction();
    }

    @When("Send Get list of user's transaction")
    public void sendGetListOfUserSTransaction() {
         SerenityRest.when().get(Constants.USERS+"/transactions");
    }

    @And("Validate get list of user's transaction with valid path json schema")
    public void validateGetListOfUserSTransactionWithValidPathJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Transactions/GetListOfUser'sTransactionPositiveSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update user's status transaction with valid transaction id")
    public void putUpdateUserSStatusTransactionWithValidTransactionId() {
        transactions.PutUpdateUsersStatusTransaction();
    }

    @When("Send Put update user's status transaction")
    public void sendPutUpdateUserSStatusTransaction() {
        SerenityRest.when().put(Constants.USERS+"/transactions/" + Constants.TRANSACTION_ID+"/status");
    }

    @And("And Validate put update user's status transaction with valid transaction id json schema")
    public void andValidatePutUpdateUserSStatusTransactionWithValidTransactionIdJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"/Transactions/PutUpdateOfUser'sStatusTransactionPositiveSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
