# October2022Batch

What we have done in this branch ?

We will implement to execute suite from maven command line.

1. Add 2 plugins in pom.xml file (surefire plugin and compiler plugin)
    Surefire plugin is responsible to create report and execute test.

2. refresh pom.xml file, and execute below command in command line.

    **mvn clean test  "-Dbrowser=edge"**

    As above you can see, we can pass brosername from command prompt. it will overwrite the browser mentioned in the config file.

    Ensure that respective browser drivers are availble and set in the path variable to execute with different browsers.


3. There are a default testng html report created in target folder.
4. But we also implemented Extent report for a better user experience and detailed information with screenshot for failed tests.

Fixes :
============

1. Issue : The driver was not updted in the local varibale in MyAccountExisting file, but try to use it (go getting driver is null error.)
Soution: Added constructor to MyAccountExisting (step file) to accept the WebDriver from outside and save it in local variable, which is used with other methods (actual step functions)

=--------------

2. Issue : for hooks to work cucumber should know where is the file exist. Hook function was kept in Utitlies package, but this package was not referred in cucumber runner file.
Solution: Moved hooks (method) or TestContext file (or where ever hooks methods available) to steps package, because you are mentioned in test runner file for steps package name, so that it will find the file and searfch for hooks method and execute.

---------------

3 - ChromeDriver version fix: 

    Make it easy - used WebDriverManager for demo purpose, but in realtime, we do not use it.


4. Fix below warning 
""""""""
   Mar 16, 2024 9:22:22 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
      WARNING: Unable to find an exact match for CDP version 122, returning the closest version; found: 121; Please update to a Selenium version that supports CDP version 122
""""""""""

    Solution: add more recent version of selenium or downgrade chrome version, but I skipped as of now, as it is a warning, you try to fix it.



5. Do not keep hook methods (@before or @after) more than one. Check across files, keept it in any one file and only once. 
   Fixed it. it was in Hooks file as well as in TestContext file. (of couse I uncommented Hooks file)

6. Fix error for picco container

""""""
org.picocontainer.injectors.AbstractInjector$UnsatisfiableDependenciesException: 
HHT_Steps.MyAccountExisting has unsatisfied dependency 
'interface org.openqa.selenium.WebDriver' for constructor 
'public HHT_Steps.MyAccountExisting(org.openqa.selenium.WebDriver)' 
from org.picocontainer.DefaultPicoContainer@1cc9cfb2:5<|

""""""

Solution: Implement picco container properly, added comments in the TestContext file to understand what is the fix done.
there are 3 steps:
   Level 1  : Hooks_or_injetor_file
            create controctor to accept TestContext class
            in setup (@before hooks) method, create driver and set the driver to TEstcontxt usig a public method (setWebDriver)
   Level 2: Creaet TestContext class with all variables which would be shared by step files (first most important is WebDriver which shold be shared among steps)
   Level 3: Create step defintions with constructors accepting TestContext file , and set the local webdriver from testContext using getWebDriver public metbod.


7. Still if you get below isues, like could not create browser...
Command: [null, newSession {capabilities=[Capabilities {browserName: chrome, goog:chromeOptions: {args: [], binary: C:\Program Files\Google\Chr..., extensions: []}}]}]

Solution: Use any one method , either 
   1. Set the path variable for chromedriver 
      2. or, use WebDriverManger
      3. or, set the path of chromedriver in the system path in runtime (Preferred)


8. suggestion:
   AS MUCH AS POSSIBLE, AVOID CREATING PUBLIC VARIABLES, STICK TO CREATE PRIVATE VARIABLES AND RESTRICT THE SCROPE TO MINIMUM LEVEL,
      IT IS A GOOD PRACTICE AS IN FUTURE IT WILL AVOID TO CREATE UNNECESSARY CONFUSION AND BUGS


****************** RUN Scenarios Parallely (Method 1 ) - Add object[][] cucumber in test runner file**********************

1. It will run Cucumber Scenarios in paralle in a browser setup (chrome browser)

How to execute it ?
1. Run from IDE -  (execute the cucumber test runner file)
2. From command prompt - execute "mvn test" command


