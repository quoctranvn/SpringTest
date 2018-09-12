Feature: Login Feature
  Verify if user is able to Login in to the site

  Scenario Outline: Login as a authenticated user
    When user navigates to Login Page
    And user enters "<username>" and "<password>"
    Then success message is displayed

  Examples:
      | username | password |
      | blog.cucumber@gmail.com | Cucumber@blog |