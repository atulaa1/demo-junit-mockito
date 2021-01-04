package com.demo.heavenandhell;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class CustomerCategorizationTest {

  @Test
  public void testWithTypeIs1()
  {
    CustomerCategorization categorization = new CustomerCategorization();
    assertEquals("Day la khach hang VIP?", "VIP", categorization.getRankOfCustomer(1));
  }

  @Ignore
  public void testNotComplete() {
    assertEquals(1, 1);
  }

}
