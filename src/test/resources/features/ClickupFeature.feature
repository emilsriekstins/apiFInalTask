 Feature: This feature will test Clickup API

   Scenario: I test Clickup API features
     Given I create Clickup folder "New Folder"
     Then I create new list "New List" in the folder
     And I create new task in list
     Then I delete the task previously created
     And I check if the task was deleted

