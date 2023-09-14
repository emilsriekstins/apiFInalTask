package apiTest.helpers;


import apiTest.domain.Folder;
import apiTest.domain.List;
import apiTest.domain.Task;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

public class TestCaseContext {
    @Setter @Getter
    private static Folder folder;
    @Setter @Getter
    private static List list;
    @Setter @Getter
    private static Task task;

    public static void init() {
        folder = null;
        list = null;
        task = null;
    }
}
