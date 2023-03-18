package com.spotify.api.v1.services.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spotify.api.v1.dto.SpotifyAccessToken;
import com.spotify.api.v1.services.FeignSpotifyAccountService;
import com.spotify.api.v1.services.SpotifyAuthService;


/**
 * @author gary_kephart
 *
 */
@Service
public class SpotifyAuthServiceImpl implements SpotifyAuthService
{
  private static SpotifyAccessToken  accessToken;
  private static Log                 log = LogFactory.getLog(SpotifyAuthServiceImpl.class);
  //  private static final String               REQUEST_BODY = "grant_type=%1$s&client_id=%2$s&client_secret=%3$s";
  //  private static final String               URL          = "https://accounts.spotify.com";
  @Autowired
  private FeignSpotifyAccountService service;
  @Value("${spotify.clientId}")
  private String                     clientId;
  @Value("${spotify.clientSecret}")
  private String                     clientSecret;

  /**
   * 
   */
  public SpotifyAuthServiceImpl()
  {

  }


  /**
   * For unit testing.
   * 
   * @param clientId
   * @param clientSecret
   */
  public SpotifyAuthServiceImpl(FeignSpotifyAccountService service, String clientId,
                                String clientSecret)
  {
    this.service = service;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }


  /**
   * @return
   */
  private SpotifyAccessToken getAccessToken()
  {
    if (accessToken == null || accessToken.isExpired())
    {
      AuthTokenRequest authTokenRequest = new AuthTokenRequest(
          FeignSpotifyAccountService.GRANT_TYPE, this.clientId, this.clientSecret);

      log.info("[getAccessToken] getting new access token because "
               + (accessToken == null ? "token is null" : "token has expired"));

      accessToken = this.service.getToken(authTokenRequest);
    }

    return accessToken;
  }


  /* (non-Javadoc)
   * @see org.drdeesw.reactrax.services.SpotifyAuthService#getSpotifyAuthorization()
   */
  public String getSpotifyAuthorization()
  {
    return "Bearer " + getAccessToken().getAccessToken();
  }

}
