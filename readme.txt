===============================================================================================================
===============================================================================================================
# WebDriver 4 + Testng + Page Factory Framework + Extent Report + Logger
Prod Bug
Channel: https://www.youtube.com/watch?v=Hlp2uBzxJjQ&t=942s
===============================================================================================================
===============================================================================================================
# Features:
===============================================================================================================
1. POM Page factory
2. Parallel running
3. ThreadLocal
4. Rerun failed cases using IRetryAnalyzer, ITestListener (Listeners)
5. Take Screenshot on Test Failure using ITestListener
6. Reporting - Extent Report
7. Logging


===============================================================================================================
===============================================================================================================
# How to run framework:
===============================================================================================================
Option 1: command line: single/multiple xml can be given
mvn clean test -DsuiteXmlFile=testng.xml
mvn clean test -DsuiteXmlFile=testng_listeners.xml
mvn clean test -DsuiteXmlFile=testng_parallel.xml

#IntelliJ
mvn clean test -DsuiteXmlFile="demo_seq.xml"
mvn clean test -DsuiteXmlFile="testng_listeners.xml"
mvn clean test -DsuiteXmlFile="testng_parallel.xml"
mvn clean test -DsuiteXmlFile="demo_list2.xml" -Ddriver="firefox"


#Logs
/log4j2/log4j2-test-automation.log

Option 2: manually from testng.xml(Right click and run)
No report generated in target folder


#Report:
/target/surefire-reports/index.html
/extent-reports/extent-report.html

Note:
To generate extent report xml should have <listeners> values
Pls note we are using listeners code from utils/listeners package, not from others/listeners

_____________________________________________________________________

//td[text()='UserID']
//input[contains(@name,'abc')]
//div[contains(@class,'footer-visible')])[1]
//input[@id='abc' and @name='xyz'] 
//span[text()='UniqueText']/following::input[1]	
(//button[starts-with(text(),'Add')])[1]       

_____________________________________________________________________

Locating Element on a Page
A.ID
B.Class Name
C.Tag Name
D.Name
E.Link Text
F.Partial Link Text
G.CSS
H.XPATH
I.JAVA Script

_____________________________________________________________________

# Best Practices For Efficient Test Automation
1. Avoid using Thread.sleep
   Use implicit, explicit, fluent waits
2. Name the Test Cases & Test Suites Appropriately  
3. Maximize the Browser Window
4. Choose the Best-Suited Web Locator
5. Create a Browser Compatibility Matrix for Cross Browser Testing
   Check which browser get max traffic 
6. Implement Logging and Reporting
7. Use Design Patterns and Principles i.e. Page Object Model (POM)
   
# Avoid
1. File download
2. Captcha
3. Two-Factor Authentication (2FA)
4. Avoid Test Dependency
5. Performance Testing
6. Try not to automate everything
   Automate which can be maintained and always run 100%
   80-20 rule (Pareto principle)
   
 