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
                .queryParam("Authorization", API_KEY)
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
                .queryParam("Authorization", API_KEY)
                .body(obj)
                .when()
                .get("https://api.clickup.com/api/v2/folder/" + folderID + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}
