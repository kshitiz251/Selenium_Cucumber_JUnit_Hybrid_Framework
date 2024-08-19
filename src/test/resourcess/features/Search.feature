@all
Feature: Search functionality

Background:
Given User opens the Application


Scenario Outline: User searches for a valid product
When User enters valid product <product> into Search box feild
And User clicks on Search button
Then User should get valid product displayed in search result
Examples:
|product |
|HP      |


Scenario Outline: User searches for a invalid product
When User enters invalid product <product> into Search box feild
And User clicks on Search button
Then User should get a message about no product matching
Examples:
|product |
|Honda   |


Scenario: User searches without any product
When User dont enter any product name into Seach box feild
And User clicks on Search button
Then User should get a message about no product matching