Feature: Compose and send mail through Gmail account

  @tag1
  Scenario: User logs into Gmail account to send an email 
    Given User visits Gmail login page 
    And User will login with email "cucumberselenium20@gmail.com" and password "Selenium@123"
    When User will compose email to the recipient "cucumberselenium20@gmail.com"  
    And With body of the email "Automation QA test for Incubyte" and subject "Incubyte"
    Then Send email
    And Verify the successfull message
    And Verify the email sent in the sent items