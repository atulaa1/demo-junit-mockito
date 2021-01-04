package com.demo.heavenandhell.mocking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.heavenandhell.dao.CarDAO;
import com.demo.heavenandhell.entity.Car;
import com.demo.heavenandhell.service.AuthenticationService;
import com.demo.heavenandhell.service.CarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

  // same
//  CarDAO carDAO = Mockito.mock(CarDAO.class);
  @Mock
  private CarDAO carDAO;
  @Mock
  private AuthenticationService authenticationService;
  @InjectMocks
  private CarService carService;

  @Before
  public void init() {
    // need to call this if use @Mock
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetCarInfoSuccess()
  {
    when(carDAO.findCarById(anyInt())).thenReturn(new Car());
    when(authenticationService.checkTokenV2(anyString())).thenReturn(3);
//     mock the call of carDao
//    carDAO.findCarById(1);
//    authenticationService.checkTokenV2("V");
//    carDAO.findCarById(1);
    carService.getCarInfoV2("V", 1);


    verify(carDAO, times(1)).findCarById(anyInt());
  }



}
