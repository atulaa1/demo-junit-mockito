# These code use to demo basics about Junit 4 and Mocking that use Mockito 1.9

## I. Junit
### 1. Demo config and declare Junit  
**Example**: *pom.xml*  
**Example extend**: *MathUtility.java*  
**Example without extend**: *MathUtilityWithoutExtendTest.java*  
### 2. Demo Junit lifecycle  
**Example**: *JunitLifecycle.java*
### 3. Demo Assert and Ignore  
**Example**: *AssertDemo.java*  
**Example**: *CustomerCategorizationTest.java*  
### 4. Demo Parameterized annotation which help run test case with data test  
**Example**: *ParameterizedDemo.java*
### 5. Demo test suites  
**Example**: *LoginTests.java*  
### 6. Demo Rule annotation  
**Example**: *RuleDemo.java*  
**Example**: *RuleDemo2.java*  
### 7. Run test with Coverage  
### 8. Run test with maven command  
    
            mvn compile test  
            mvn clean test
     
## II. Mocking
### 1. Config and declare Mock
**Example**: *CarServiceTest.java*    
### 2. Stub method
- Stub call method  
- Stub returned value  
- Stub throw exception  
- Stub void method  
- Arguments matchers  
**Example**: *StubMethodDemo.java*  
### 3. Verify  
- Verify time of method call
- Verify order of method call  
- Verify argument matching  
- Verify timeout  
**Example**: *VerifyDemo.java*  
# References  
https://www.vogella.com/tutorials/JUnit/article.html  
https://www.vogella.com/tutorials/Mockito/article.html  
https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html  
https://dzone.com/refcardz/mockito?chapter=1  
https://en.wikipedia.org/wiki/List_of_unit_testing_frameworks  
https://github.com/junit-team/junit4/wiki/Rules
