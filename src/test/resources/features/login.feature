
Feature: Login to application

  Scenario: Successful login
    Given I am on the login page
    When I login with username "admin" and password "admin123"
    Then I should see the login page

  Scenario: Select last option from dropdown
    Given I am on the dropdown page
    When I select the last option in the dropdown
    Then The last option should be selected

    