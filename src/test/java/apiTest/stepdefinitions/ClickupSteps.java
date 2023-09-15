package apiTest.stepdefinitions;

import apiTest.domain.Folder;
import apiTest.domain.List;
import apiTest.domain.Task;
import apiTest.helpers.TestCaseContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import org.junit.Test;

import static apiTest.clients.ClickupClient.*;

public class ClickupSteps {
    @Given("I create clickup folder {string}")
    public void iCreateClickupFloder(String folderName) {
        JSONObject obj = new JSONObject();
        obj.put("name", folderName);
        Response response = createFolder(obj);

        // Save folder as object
        Folder folder = response.as(Folder.class);
        TestCaseContext.setFolder(folder);
    }

    @Then("I create new list {string} in the folder")
    public void iCreateNewListInTheFolderWithListName(String listName) {
        JSONObject obj = new JSONObject();
        obj.put("name", listName);
        Response response = createList(obj, TestCaseContext.getFolder().getId());

        // Save list as object
        List list = response.as(List.class);
        // TODO maybe is a better way to get this
        list.setFolderID(TestCaseContext.getFolder().getId());
        TestCaseContext.setList(list);

        Assertions.assertThat(list.getName())
                .as("Test that the list was created with correct name")
                .isEqualTo(listName);

        Assertions.assertThat(list.getFolderID())
                .as("Test that the list was created in the correct folder")
                .isEqualTo(TestCaseContext.getFolder().getId());
    }

    @And("I create new task {string} in list")
    public void iCreateNewTaskInList(String taskName) {
        JSONObject obj = new JSONObject();
        obj.put("name", taskName);
        Response response = createTask(obj, TestCaseContext.getList().getId());

        // Save task as object
        Task task = response.as(Task.class);
        TestCaseContext.setTask(task);

        Assertions.assertThat(task.getName())
                .as("Test that the task was created with correct name")
                .isEqualTo(taskName);
    }

    @Then("I delete the task previously created")
    public void iDeleteTheTaskPreviouslyCreated() {
        deleteTask(TestCaseContext.getTask().getId());
    }

    @And("I check if the task was deleted")
    public void iCheckIfTheTaskWasDeleted() {
        checkIfTaskDoesntExist(TestCaseContext.getTask().getId());
    }
}
