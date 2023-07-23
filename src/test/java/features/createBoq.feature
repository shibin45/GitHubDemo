Feature: To validate if the group id is getting created 

   Scenario: Verify if the BOQ api for cerebro is giving a successful response
   
   Given  boq payload with 5 sets
   When User calls "boq" pay  load with "post" methodfrom the client machine
   Then verify if the reponse has given success code
   And verify if group id is returned successfully
   	 