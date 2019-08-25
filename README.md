# Podium Website UI Automation Test Suite and Framework
An automated UI test suite and framework for the website https://www.podium.com/ that utilizes TestNG and the PageObject pattern.

# Configuration Notes for Eclipse and IntelliJ
How to import in IntelliJ:
  - Click on File -> Import Project
  - Select "Import project from external model
  - Select Maven and click Finish
  - Click Next and on Select Profiles, keep local selected then click Next again
  - Select your mMaven project to import and click Next
  - Select your Java SDK and click Next
  - Click Finish

How to import in Eclipse:
  - Go to Window -> Show View -> Other...
  - Select the Git dropdown folder and select "Git Repositories" and click Open
  - In the Git Repositories window, select "Add an Existing Git repo" and select your local folder
  - In the Package Explorer, right-click and select "Import" and import it as an existing Maven project
  
How to add TestNG as a run configuration for IntelliJ:
  - Select the "Add Configuration" button at the top menu bar
  - Click on Templates and add TestNG
  - For Test kind, select "Suite" and locate the testng.xml file in podiumuiautomation/src/test/resources
  - Select the Output directory, /podiumuiautomation/test-output
  
  To run test suite, click the green arrow button after following steps above.
  
How to add TestNG as a run configuration for Eclipse:
  - Go to Help -> Install New Software
  - Click on "Add"
  - For Name type in "TestNG"
  - For Site type in "http://beust.com/eclipse/"
  - Click Okay, then select "TestNG" from the list once it's done searching
  - Select only "TestNG" from the list at the top and click Next
  - Accept the Apache License terms and click Okay
  
    A prompt will appear here about installing software that contains unsigned content, just click "Install anyway" and restart your        IDE once it's complete.
  
  - Click on the arrow button beside the green arrow button in top menu and click "Run Configuraitions..."
  - Click on TestNG, then the add new configuration button
  - Name you configuration, select the podiumuiautomation project under "Project"
  - Click on the "Suite" radio button and search for the testng.xml file under src/test/resources/
  - Click Apply, then Run
