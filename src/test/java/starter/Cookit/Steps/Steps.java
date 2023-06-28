package starter.Cookit.Steps;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class Steps {

    @Step("Post insert new recipes step Positive")
    public void postInsertNewRecipesStepPositive(String name){
        Map<String, Object> steps = new HashMap<>();
        steps.put("name", name);

        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(steps);
    }

    @Step("Put Update Recipes Step Positive")
    public void putUpdateRecipesStepPositive(String name){
        Map<String, Object> steps = new HashMap<>();
        steps.put("name", name);

        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(steps);
    }

    @Step("Delete Recipes Step Positive")
    public void deleteRecipesStepPositive(){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.BEARER_TOKEN);
    }
}
