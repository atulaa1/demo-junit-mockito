package com.demo.heavenandhell.mocking;

import static com.demo.heavenandhell.constant.AuthenticationConstant.VALID;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
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
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VerifyDemo {


  @Mock
  private CarDAO carDAO;
  @Mock
  private AuthenticationService authenticationService;
  @InjectMocks
  private CarService carService;

  @Before
  public void mockingForAllTestCase()
  {
    //todo: mocking
    when(carDAO.findCarById(1)).thenReturn(new Car(1));
    when(carDAO.findCarById(2)).thenReturn(new Car(2));
    when(carDAO.findCarById(3)).thenReturn(new Car(3));
    when(authenticationService.checkTokenV2(anyString())).thenReturn(VALID);
  }

  @Test
  public void demoVerifyCallOfMethod()
  {
    //todo: call with data test
    carService.getCarInfoV2("V", 2);

    //todo: verify
    verify(carDAO, never()).findCarById(anyInt());
    verify(carDAO, atLeastOnce()).findCarById(anyInt());
    verify(carDAO, atLeast(2)).findCarById(anyInt());
    verify(carDAO, times(2)).findCarById(anyInt());
  }

  @Test
  public void demoCallOrder()
  {
    InOrder inOrder=inOrder(carDAO,authenticationService);

    carService.getCarInfoV2("V", 2);

    inOrder.verify(carDAO).findCarById(anyInt());
    inOrder.verify(authenticationService).checkTokenV2(anyString());
  }

  @Test
  public void demoArgumentMatching()
  {
    int passedArgument = 2;
    carService.getCarInfoV2("V", passedArgument);

    ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
    verify(carDAO).findCarById(captor.capture());
    int idCapturing = captor.getValue();

    assertEquals("Id có bị thay đổi", passedArgument, idCapturing);

  }

  @Test
  public void demoVerifyTimeout()
  {
    carService.getCarInfoV2("V", 1);
    verify(authenticationService, timeout(20)).checkTokenV2(anyString());
  }


}
