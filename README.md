# October2022Batch

How to execute multiple browsers (different browsers) parallel in TestNG

Steps:

1. We have seen that we can add 'parallel' attribute to suite tag in testng.xml file to run tests/classes/methods run parallelly.
2. The above method will execute tests parallely and with the browser which we haev started or mentioned in the InitializeDriver method.

   3. Extending aboe features, we need to update 2 places to run mutliple browsers parallely.
       a) Pass the browsername paramter from testng.mxl file to InitializeDriver method 
       b) Now, the browser method will open that browser which is passed as paramter.
       c) This is achieed using TestNG paramters annotation.
       d) And we have to pass these paramters from testng.xml file in different tests.
       e) Create multiple tests with same classes (or different) with multiple paramters passed multiple browser names which would be passed to the InitializeDriver method in the test.
       f) Run tests parallely , so that each test will execute with different browsers passed to the craete driver method.


4. Implemented WebDriverManager class to implement driver management automatically.
    a) Use this feature if you have no restriction in downloading from internet.
    


Refer the code to understand more.


