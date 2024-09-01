Feature: Search functionality

Scenario: Verfiy search functionality
 Given User launch chrome browser
  When user opens the URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  And User enters Email as "Admin" and Password as "admin123"
  And Click on Login
  When User clicks on PIM option
  Then User should navigate to PIM screen "OrangeHRM"
  When User enters the Name in search field "Employee Job Details"
  And Clicks on Search button
  Then Searched result should get display on the screen
  