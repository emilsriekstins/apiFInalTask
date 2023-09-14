package apiTest.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static apiTest.constants.ProjectConstants.*;

public class ClickupClient {
    public static Response createFolder(JSONObject obj) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/space/" + SPACE_ID + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createList(JSONObject obj, String folderID) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/folder/" + folderID + "/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createTask(JSONObject obj, String listID) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/" + listID + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteTask(String taskID) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                //.body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/" + taskID + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}
