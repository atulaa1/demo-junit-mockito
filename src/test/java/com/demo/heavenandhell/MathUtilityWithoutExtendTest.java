package com.demo.heavenandhell;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class MathUtilityWithoutExtendTest {

  @Test
  public void testMultiplyByOne() {
    MathUtility mathUtility = new MathUtility();
    int a = 4;
    assertEquals(a, mathUtility.multiply(1, a));
//    assertEquals("1 nhan 1 bang 1", 2, mathUtility.multiply(1,1));
    assertEquals(2, mathUtility.multiply(1,1));
  }

  public void doSomething() {
    MathUtility mathUtility = new MathUtility();
    int a = 4;
    assertEquals(a, mathUtility.multiply(1, a));
//    assertEquals("1 nhan 1 bang 1", 2, mathUtility.multiply(1,1));
    assertEquals(2, mathUtility.multiply(1,1));
  }

  public void testSomething() {
    System.out.println("It is fake!");
  }


//  @Test
  public void testMultiplyByZero() {
    MathUtility mathUtility = new MathUtility();
    assertEquals("bat ky so nao nhan 0 cung bang 0", 0, mathUtility.multiply(1,0));
  }

}
