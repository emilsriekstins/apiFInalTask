package apiTest.stepdefinitions;

import apiTest.helpers.TestCaseContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;

import static apiTest.clients.ClickupClient.createFolder;
import static apiTest.clients.ClickupClient.createList;

public class ClickupSteps {
    @Given("I create clickup folder {string}")
    public void iCreateClickupFloder(String folderName) {
        JSONObject obj = new JSONObject();
        obj.put("name", folderName);
        Response resp = createFolder(obj);
        System.out.println(resp.getBody());
    }

    @Then("I create new list in the folder with list name {string}")
    public void iCreateNewListInTheFolderWithListName(String listName) {
        JSONObject obj = new JSONObject();
        obj.put("name", listName);
        //Response resp = createList(obj, TestCaseContext.getFolder());
    }
}
