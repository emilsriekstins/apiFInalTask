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
                .header("Content-Type", "application/json")
                .header("Authorization", API_KEY)
                .when()
                .delete("https://api.clickup.com/api/v2/task/" + taskID)
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }

    public static Response checkIfTaskDoesntExist(String taskID) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .when()
                .get("https://api.clickup.com/api/v2/task/" + taskID)
                .then().log().all()
                .statusCode(404)
                .extract().response();
    }

    public static Response deleteList(String listID) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .header("Authorization", API_KEY)
                .when()
                .delete("https://api.clickup.com/api/v2/list/" + listID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteFolder(String folderID) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .when()
                .delete("https://api.clickup.com/api/v2/folder/" + folderID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}
