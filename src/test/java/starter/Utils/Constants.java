package starter.Utils;

public class Constants {
    public static String AVAILABLE_ID_PATH = "";
    public static String ID_PATH = "";
    private static final String BASE_URL = "https://api.todoist.com/rest/v2";
    private static final String DIR = System.getProperty("user.dir");
    public static final String BEARER_TOKEN = "66eb58afb55cef33a1a1d45e59bb0545eec3d86a";

    //    PROJECTS RESOURCES
    public static final String PROJECT_POST_CREATE_URL = BASE_URL + "/projects";
    public static final String PROJECT_POST_UPDATE_URL = BASE_URL + "/projects/";
    public static final String PROJECT_GET_URL = BASE_URL + "/projects/";
    public static final String PROJECT_DELETE_URL = BASE_URL + "/projects/";
    public static final String PROJECT_REQ_BODY_DIR = DIR + "/src/test/resources/JSON/ReqBody/projects/";
    public static final String PROJECT_JSON_SCHEMA_DIR = DIR + "/src/test/resources/JSON/JSONSchema/projects/";


    //    TASKS RESOURCES
    public static final String TASKS_POST_CREATE_URL = BASE_URL + "/tasks";
    public static final String TASKS_POST_UPDATE_URL = BASE_URL + "/tasks/";
    public static final String TASKS_GET_URL = BASE_URL + "/tasks/";
    public static final String TASKS_DELETE_URL = BASE_URL + "/tasks/";
    public static final String TASKS_REQ_BODY_DIR = DIR + "/src/test/resources/JSON/ReqBody/tasks/";
    public static final String TASKS_JSON_SCHEMA_DIR = DIR + "/src/test/resources/JSON/JSONSchema/tasks/";


    //    LABELS RESOURCES
    public static final String LABELS_POST_CREATE_URL = BASE_URL + "/labels";
    public static final String LABELS_POST_UPDATE_URL = BASE_URL + "/labels/";
    public static final String LABELS_GET_URL = BASE_URL + "/labels/";
    public static final String LABELS_DELETE_URL = BASE_URL + "/labels/";
    public static final String LABELS_REQ_BODY_DIR = DIR + "/src/test/resources/JSON/ReqBody/labels/";
    public static final String LABELS_JSON_SCHEMA_DIR = DIR + "/src/test/resources/JSON/JSONSchema/labels/";
}
