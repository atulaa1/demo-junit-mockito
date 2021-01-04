package com.demo.heavenandhell;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitLifecycle {


  @BeforeClass
  public static void runOneTimeBeforeRunAll()
  {
    System.out.println("runOneTimeBeforeRunAll");
  }


  // setup
  @Before
  public void runEachTimeBeforeEachTestCase()
  {
    System.out.println("runBeforeEachTestCase");
  }


  // tearDown
  @After
  public void runEachTimeAfterEachTestCase()
  {
    System.out.println("runAfterEachTestCase");
  }

  @AfterClass
  public static void runOneTimeAfterRunAll()
  {
    System.out.println("runOneTimeAfterRunAll");
  }

  @Test
  public void testSomething()
  {
    System.out.println("Wow");
  }

  @Test
  public void testClick()
  {
    System.out.println("Click Me");
  }
}
