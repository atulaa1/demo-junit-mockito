package com.demo.heavenandhell.suite;


import com.demo.heavenandhell.LoginFailTest;
import com.demo.heavenandhell.LoginSuccessTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    LoginSuccessTest.class,
    LoginFailTest.class
})
public class LoginTests {

}
