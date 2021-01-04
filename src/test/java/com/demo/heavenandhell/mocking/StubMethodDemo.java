package com.demo.heavenandhell.mocking;

import static com.demo.heavenandhell.constant.AuthenticationConstant.VALID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyChar;
import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anySet;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.endsWith;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.heavenandhell.MathUtility;
import com.demo.heavenandhell.dao.CarDAO;
import com.demo.heavenandhell.entity.Car;
import com.demo.heavenandhell.service.AuthenticationService;
import com.demo.heavenandhell.service.CarService;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StubMethodDemo {



  @Mock
  private CarDAO carDAO;
  @Mock
  private AuthenticationService authenticationService;
  @InjectMocks
  private CarService carService;


  @Mock
  private MathUtility mathUtility;

  //todo: syntax when then
  @Test
  public void demoStubReturnedValue()
  {
    //Todo stub method
//    when(carDAO.findCarById(1)).thenReturn(new Car(1));
    when(carDAO.findCarById(1)).thenReturn(new Car(1));
    when(carDAO.findCarById(2)).thenReturn(new Car(2));
//    when(carDAO.findCarById(anyInt())).thenReturn(new Car(2));
//    when(carService.getCarInfoV2(anyString(), eq(1))).thenReturn(new Car(3));

    when(authenticationService.checkTokenV2(anyString())).thenReturn(VALID);

    //todo: call method and verify
    Car carResult = carService.getCarInfoV2("V", 3);
    System.out.println(carResult.getId());
  }


  @Test
  public void demoStubReturnedValueMatchingSpecificArgumentValue()
  {
    when(mathUtility.multiply(2,2)).thenReturn(4l);
    when(mathUtility.multiply(anyInt(), eq(0))).thenReturn(0l);
    when(mathUtility.multiply(eq(0), anyInt())).thenReturn(0l);
    when(mathUtility.multiply(AdditionalMatchers.not(eq(0)), AdditionalMatchers.not(eq(0)))).thenReturn(3l);

    Long  result1 = mathUtility.multiply(1,2);
    Long  result2 = mathUtility.multiply(0,789);
    Long  result3 = mathUtility.multiply(123,0);

    assertTrue("Kết quả khác 0?", result1 != 0);
    assertTrue("Kết quả bằng 0?", result2 == 0);
    assertTrue("Kết quả bằng 0?", result3 == 0);

  }

  public void demoSomeKindsOfArgumentMatcher()
  {
    //todo: number data type
    BigDecimal demoNumberArgumentMatcher = new BigDecimal(1);
    when(demoNumberArgumentMatcher.doubleValue()).thenReturn(anyDouble());
    Double.toString(eq(3.9));

    when(demoNumberArgumentMatcher.floatValue()).thenReturn(anyFloat());
    Float.toString(eq(3.9f));

    when(demoNumberArgumentMatcher.intValue()).thenReturn(anyInt());
    when(demoNumberArgumentMatcher.longValue()).thenReturn(anyLong());

    //todo: char, String
    StringBuilder demoStringArgumentMatcher = new StringBuilder();
    when(demoStringArgumentMatcher.append(anyChar())).thenReturn(any(StringBuilder.class));
    when(demoStringArgumentMatcher.append(eq('a'))).thenReturn(any(StringBuilder.class));

    when(demoStringArgumentMatcher.append(anyString())).thenReturn(any(StringBuilder.class));
    when(demoStringArgumentMatcher.append(eq("a"))).thenReturn(any(StringBuilder.class));
    when(demoStringArgumentMatcher.append(endsWith("a"))).thenReturn(any(StringBuilder.class));

    //todo: Collections
    when(Collections.addAll(anyList()));
    when(Collections.addAll(anySet()));
    when(Collections.synchronizedMap(anyMap()));

    //Todo: Object
    when(carService.makeColorful(any(Car.class))).thenReturn(any(Car.class));
    when(carService.makeColorful(isA(Car.class))).thenReturn(any(Car.class));

    //Todo: AdditionalMatchers

  }

  @Test
  public void demoStubThrowException()
  {

    try {
      when(authenticationService.checkToken("E")).thenThrow(new IllegalAccessException("Truy cập trái phép"));
      carService.getCarInfo("E", 3);
    }
    catch (IllegalAccessException ex)
    {
      System.out.println(ex.getMessage());
    }

  }

 /* @Test(expected = IllegalArgumentException.class)
  public void demoStubThrowException2() throws IllegalAccessException {

    try {
      when(authenticationService.checkToken("E")).thenThrow(new IllegalAccessException("Truy cập trái phép"));
      carService.getCarInfo("E", 3);
    }
    catch (IllegalAccessException ex)
    {
      System.out.println(ex.getMessage());
      throw ex;
    }

  }*/

  public void demoStubVoidMethod()
  {
    doNothing().when(mathUtility).printSomething(anyString());
//    when(mathUtility.printSomething(anyString())).thenReturn(Void.class)
  }

}
