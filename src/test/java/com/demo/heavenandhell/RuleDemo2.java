package com.demo.heavenandhell;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RuleDemo2 {

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Test
  public void testReceiveException()
  {
    MathUtility mathUtility = new MathUtility();
    thrown.expect(IllegalArgumentException.class);
    mathUtility.divide(1, 0);
  }


}
