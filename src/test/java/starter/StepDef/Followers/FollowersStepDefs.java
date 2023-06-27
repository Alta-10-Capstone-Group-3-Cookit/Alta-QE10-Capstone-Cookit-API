package starter.StepDef.Followers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Cookit.Followers.Followers;
import starter.Utils.Constants;

import java.io.InputStream;

public class FollowersStepDefs {

    @Steps
    Followers followers;

    @When("Send post follow user")
    public void sendPostFollowUser() {
        SerenityRest.when().post(Constants.USERS + "/follow/" + Followers.idUserToFollow);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate post follow user with valid id json schema")
    public void validatePostFollowUserWithValidIdJsonSchema() {
        InputStream json = getClass().getClassLoader().getResourceAsStream("JSON_Schema/Followers/PostFollowUserPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post follow user with valid {string}")
    public void postFollowUserWithValid(String id) {
        followers.postFollowUserPositive(id);
    }
}
