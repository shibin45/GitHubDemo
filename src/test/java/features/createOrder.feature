Feature: call order API to create an order

  Scenario: Verify if order is getting created successfully
    Given  boq payload with 1 sets
    When User calls "boq" payload with "post" methodfrom the client machine
    Then Extract Group Id from the response
    And calls the create Order API
    Then verify if the status code
    And Verify if the order id gets generated
