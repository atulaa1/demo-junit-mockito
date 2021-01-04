package com.demo.heavenandhell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.demo.heavenandhell.entity.Car;
import org.junit.Test;

public class AssertDemo {

  private final int EXPENSIVE = 1;
  private final int SECONDHAND = 3;

  @Test
  public void demoAssertMethod()
  {
    CarFactory carFactory = new CarFactory();
    assertNull("Có tạo ô tô ko?", carFactory.makeToyota(3));
    assertNotNull("Tạo đi", carFactory.makeToyota(1));

    // kiểm tra loại ô tô
    Car car1 = new Car(4);
    Car car2 = new Car(1);

//    assertTrue("Xe xịn không?", carFactory.rateCar(car1.getId())== EXPENSIVE);
//    assertFalse("Xe cũ?", carFactory.rateCar(car2.getId())== SECONDHAND);

    // or
//    assertEquals("Xe cũ", SECONDHAND, car2.getId());
    // kiểm tra cùng loại ô tô

    assertEquals("Cùng là 1 xe", car1, car2);

  }


}
