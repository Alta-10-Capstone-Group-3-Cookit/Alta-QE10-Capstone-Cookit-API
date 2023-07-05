package starter.StepDef.Transaction_Details;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Transaction_Details.TransactionDetails;
import starter.Cookit.Transaction_Details.TransactionDetailsResponses;
import starter.Utils.Constants;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class TransactionDetailStepDefs {

    @Steps
    TransactionDetails trDetails;

    @Given("valid transaction_detail_id path for get user transaction detail with valid transaction_detail_id path")
    public void validTransaction_detail_idPathForGetUserTransactionDetailWithValidTransaction_detail_idPath() {
        trDetails.getListUserTransactionPositive(Constants.TRANSACTION_ID);
    }

    @When("Send GET request for get user transaction detail with valid transaction_detail_id path")
    public void sendGETRequestForGetUserTransactionDetailWithValidTransaction_detail_idPath() {
        SerenityRest.when().get(Constants.USERS + "/transactions/transaction_detail/{transaction_detail_id}");
    }

    @Then("API response for get user transaction detail with valid transaction_detail_id path should return {int} OK status code")
    public void apiResponseForGetUserTransactionDetailWithValidTransaction_detail_idPathShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate response body JSON Schema for get user transaction detail with valid transaction_detail_id path")
    public void validateResponseBodyJSONSchemaForGetUserTransactionDetailWithValidTransaction_detail_idPath() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Transaction_Details/GetListTransactionDetailPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate response body message key for get user transaction detail with valid transaction_detail_id path should be {string}")
    public void validateResponseBodyMessageKeyForGetUserTransactionDetailWithValidTransaction_detail_idPathShouldBe(String message) {
        SerenityRest.and().body(TransactionDetailsResponses.MESSAGE, equalTo(message));
    }
}
