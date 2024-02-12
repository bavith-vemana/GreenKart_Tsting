

@tag
Feature: Purchasing Order

 Background:
  Given opening wesite

 @submitorder
 Scenario Outline:  TestCase for subitting order
  Given login with <UserId> and <Password>
  When Add <product> to kart
  And goto checkout page and submit <product>
  Then "THANKYOU FOR THE ORDER." is displayed
  Examples:
   |        UserId                 |       Password          |    product      |                   
   |vemanabavith111@gmail.com      |   Volcano@112           |  ZARA COAT 3    |  