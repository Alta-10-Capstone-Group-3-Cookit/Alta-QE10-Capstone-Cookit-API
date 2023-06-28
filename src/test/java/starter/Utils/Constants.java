package starter.Utils;

public class Constants {
    private static final String BASE_URL = "https://cookit.altapro.online";
    private static final String DIR = System.getProperty("user.dir");

    public static String JSON_SCHEMA_DIR = DIR + "/src/test/resources/JSON_Schema";
    public static String ASSETS_DIR = DIR + "/src/test/resources/assets";
    //    token usertest5
    public static String BEARER_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2OTExMjY4NjQsInJvbGUiOiJVc2VyIiwidXNlcklkIjoyMn0.9klI0SN3GQLhWHG8yuuhsz1nFoQvgsWfhmXrXe6ptiw";

    public static String USERNAME = "usertest5";
    public static String REG_USERNAME = "usertest9";
    public static String EMAIL = "usertest5@example.com";
    public static String REG_EMAIL = "usertest9@example.com";
    public static String PASSWORD = "Asdfg123";
    public static String OUR_USER_ID;
    public static String STEP_ID;
  
    public static String RECIPE_ID = "26";
    public static String IMAGE_ID = "44";

    public static String COMMENT_ID;
    public static String INGREDIENT_ID = "7";
    public static String INGREDIENT_DETAIL_ID = "16";
    public static String CART_ID;
    public static String TRANSACTION_ID;
    public static String TRANSACTION_DETAIL_ID = "9";

    // URL
    public static String REGISTER = BASE_URL + "/register";
    public static String LOGIN = BASE_URL + "/login";
    public static String USERS = BASE_URL + "/users";
    public static String RECIPES = BASE_URL + "/recipes";
}
