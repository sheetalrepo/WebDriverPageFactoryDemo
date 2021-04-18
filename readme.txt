_____________________________________________________________________
_____________________________________________________________________

Webdriver + testng + pagefactory project

For Youtube Channel: 
https://www.youtube.com/watch?v=Hlp2uBzxJjQ&t=942s
_____________________________________________________________________

#How to run framework:
Option 1: command line: single/multiple xml can be given
mvn clean test -DsuiteXmlFile=testng.xml
mvn clean test -DsuiteXmlFile=testng_listeners.xml
mvn clean test -DsuiteXmlFile=testng_parallel.xml

mvn clean test -DsuiteXmlFile=testng_listeners.xml -Ddriver=firefox




Option 2: manually from testng.xml

_____________________________________________________________________

#Todo:
1. To automatically handle drivers https://github.com/bonigarcia/webdrivermanager