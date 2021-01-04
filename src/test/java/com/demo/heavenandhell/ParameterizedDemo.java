package com.demo.heavenandhell;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedDemo {

  // fields used together with @Parameter must be public
  @Parameter(0)
  public int a;
  @Parameter(1)
  public int b;
  @Parameter(2)
  public int result;

  // creates the test data
  @Parameters
  public static Collection<Object[]> data() {
    Object[][] data = new Object[][] { { 1 , 1, 1 }, { 3, 3, 8 }, { 2, 0, 1 } };
    return Arrays.asList(data);
  }


  @Test
  public void testWithDataTest() {
    MathUtility mathUtility = new MathUtility();
    assertEquals("Result", result, mathUtility.multiply(a, b));
  }

}
