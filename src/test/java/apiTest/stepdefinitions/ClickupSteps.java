package apiTest.stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static apiTest.clients.ClickupClient.createFolder;

public class ClickupSteps {
    @Given("I create clickup folder")
    public void clickUpCall() {
        JSONObject obj = new JSONObject();
        obj.put("name", "Folder name");
        Response resp = createFolder(obj);
    }
}
