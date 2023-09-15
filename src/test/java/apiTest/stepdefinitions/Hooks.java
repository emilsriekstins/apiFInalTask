package apiTest.stepdefinitions;


import apiTest.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Test;

import static apiTest.clients.ClickupClient.*;

// Cleaning up the ...
public class Hooks {
    @Before
    public void beforeHook(Scenario scenario) {
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO HAS STARTED");
    }

    @After
    public void afterHook() {
        deleteList(TestCaseContext.getList().getId());
        deleteFolder(TestCaseContext.getFolder().getId());
        System.out.println("THE SCENARIO HAS ENDED");
    }
}
