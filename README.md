# LamdaTest
TestNg certification

Step 1: Configure your settings and required capabilites for your test
For running a test we will need your username and access key to map with our cloud infrastrure.

You can find the required credentials here : https://www.lambdatest.com/capabilities-generator

Step 2: Running Tests

We have preinstalled all the required environment for running the tests. You can now execute the tests in the console by the following commands:

To run single test

$ mvn test -P single

To run parallel/multiple test

$ mvn test -P parallel

Step 3: Test Results

Once you have completed running the tests you can find the results at : https://automation.lambdatest.com with the build name TestNG as a prefix.


