Feature: Login

#Scenario: Successful login with valid credentials
  #Given User launch chrome browser
  #When user opens the URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  #And User enters Email as "Admin" and Password as "admin123"
  #And Click on Login
  #Then Page title should be "OrangeHRM"
  #When User clicks on Logout link
  #Then Page title should be "OrangeHRM"
  #And Close the browser
  
  
  Scenario Outline: Successful login with valid credentials DDT
  Given User launch chrome browser
  When user opens the URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  And User enters Email as "<user>" and Password as "<password>"
  And Click on Login
  Then Page title should be "OrangeHRM"
  When User clicks on Logout link
  Then Page title should be "OrangeHRM"
  And Close the browser
  
  Examples:
  |user|password|
  |Admin|admin123|
  #|Admin|admin@123|
  