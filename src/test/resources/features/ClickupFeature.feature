 Feature: This feature will test clickup API

   Scenario: I test clickup API features
     Given I create clickup folder "New Folder"
     Then I create new list "New List" in the folder
     And I create new task "New Task" in list
     Then I delete the task previously created
     And I check if the task was deleted

