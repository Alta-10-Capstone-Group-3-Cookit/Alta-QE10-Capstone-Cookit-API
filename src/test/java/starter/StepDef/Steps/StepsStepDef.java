package starter.StepDef.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;

import java.io.File;


public class StepsStepDef {
    @Steps
    starter.Cookit.Steps.Steps steps;

    // Post Insert New Recipes Step
    @Given("Post insert new recipes step with valid recipe id and json body")
    public void postInsertNewRecipesStepWithValidRecipeIdAndJsonBody(){
        steps.postInsertNewRecipesStepPositive("Panaskan minyak");
        SerenityRest.when().post(Constants.RECIPES + "/" + Constants.RECIPE_ID + "/steps");
        steps.postInsertNewRecipesStepPositive("Masukkan Nasi");
    }

    @When("Send Post insert new recipes step")
    public void sendPostInsertNewRecipesStep() {
        Constants.BEARER_TOKEN = SerenityRest.when()
                .post(Constants.RECIPES + "/" + Constants.RECIPE_ID + "/steps")
                .jsonPath().getString("data.id");
    }

    @And("Validate post insert new recipes step with valid recipe id and json body json schema")
    public void validatePostInsertNewRecipesStepWithValidRecipeIdAndJsonBodyJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Steps/PostInsertNewRecipesStepPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Put Update Recipes Step

    @Given("Put update recipes step with valid recipe id and step id and json body")
    public void putUpdateRecipesStepWithValidRecipeIdAndStepIdAndJsonBody() {
        steps.putUpdateRecipesStepPositive("Panaskan Minyak");
    }

    @When("Send Put update recipes step")
    public void sendPutUpdateRecipesStep() {
        SerenityRest.when().put(Constants.RECIPES + "/" + Constants.RECIPE_ID + "/steps" + "/"+ Constants.STEP_ID);
    }

    @And("Validate Put update recipes step with valid recipe id and step id and json body json schema")
    public void validatePutUpdateRecipesStepWithValidRecipeIdAndStepIdAndJsonBodyJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Steps/PutUpdateRecipesStepPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Delete recipes step Id

    @Given("Delete recipes step Id with valid recipe id")
    public void deleteRecipesStepIdWithValidRecipeId() {
        steps.deleteRecipesStepIdPositive();
    }

    @When("Send Delete recipes step Id")
    public void sendDeleteRecipesStepId() {
        SerenityRest.when().delete(Constants.RECIPES + "/" + Constants.RECIPE_ID + "/steps" + "/"+ Constants.STEP_ID);
    }

    @And("Validate delete recipes step Id with valid recipe id json schema")
    public void validateDeleteRecipesStepIdWithValidRecipeIdJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Steps/PutUpdateRecipesStepPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete recipes step with valid recipe id")
    public void deleteRecipesStepWithValidRecipeId() {
        steps.deleteRecipesStepPositive();
    }

    @When("Send Delete recipes step")
    public void sendDeleteRecipesStep() {
        SerenityRest.when().delete(Constants.RECIPES + "/" + Constants.RECIPE_ID + "/steps");
    }

    @And("Validate delete recipes step with valid recipe id json schema")
    public void validateDeleteRecipesStepWithValidRecipeIdJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "/Steps/PutUpdateRecipesStepPositive.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
