Feature:Orders
  @viewOrders
  Scenario Outline: View Order Details
    When admin user launches the URL as "admin"
    And signs in with admin login credentials "sk_behara@hotmail.com" and "test@123"
    Then user should get in to the Admin Panel Page
    And user clicks on Orders
    Then user should get into Orders Page
    When user clicks on View Order of "<Order Date>"
    Then user should View Order Details Page
    Examples:
      |Order Date |
      |	11/05/2024 13:12 |