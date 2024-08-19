@all
Feature: Register functionality


Background:
Given User navigates to Register Account page


Scenario: User creates an account with mandatory feilds
When User enters the details into below feilds
|firstName |Kshitiz                      |
|lastName  |Gupta                        |
|email     |kshitizgupta.edu124@gmail.com|
|telephone |1234567897                   |
|password  |12345                        |
And User selects privacy policy
And User clicks on Continue button
Then User account should get created successfully



Scenario: User creates an account with all feilds
When User enters the details into below feilds
|firstName |Kshitiz                      |
|lastName  |Gupta                        |
|email     |kshitizgupta.edu175@gmail.com|
|telephone |1234567897                   |
|password  |12345                        |
And User selects yes for Newsletter
And User selects privacy policy
And User clicks on Continue button
Then User account should get created successfully


Scenario Outline: User creates a duplicate account
When User enters the details into below feilds
|firstName |Kshitiz                     |
|lastName  |Gupta                       |
|email     |kshitizgupta.edu13@gmail.com|
|telephone |1234567897                  |
|password  |12345                       |
And User enter duplicate email <email> in email feild
And User selects yes for Newsletter
And User selects privacy policy
And User clicks on Continue button
Then User should get a proper warning about duplicate email
Examples:
|email                       |
|kshitizgupta.edu13@gmail.com|


Scenario: User creates an account without filling any details
When User dont enter any details into feilds
And User clicks on Continue button
Then User should get a proper warning messages for every mandatory feild



 
