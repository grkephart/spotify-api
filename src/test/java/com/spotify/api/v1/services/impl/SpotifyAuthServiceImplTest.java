/**
 * 
 */
package com.spotify.api.v1.services.impl;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author gary_kephart
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource(value = "classpath:application.properties")
@EnableFeignClients(basePackages = { "com.spotify.api.v1" })
public class SpotifyAuthServiceImplTest
{

  @Autowired
  private SpotifyAuthServiceImpl service;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception
  {
 
  }


  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception
  {
  }


  /**
   * Test method for {@link com.spotify.api.v1.services.impl.SpotifyAuthServiceImpl#getSpotifyAuthorization()}.
   */
  @Ignore
  @Test
  public void testGetSpotifyAuthorization()
  {
    // Arrange (setup pre-conditions
    
    // Act (execute method under test)
    String token = service.getSpotifyAuthorization();

    // Assert (verify post-conditions
    Assert.assertEquals(null, token);
  }

}
