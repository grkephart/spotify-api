/**
 * 
 */
package com.spotify.api.v1.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import com.spotify.api.v1.dto.SpotifyAccessToken;
import com.spotify.api.v1.services.impl.AuthTokenRequest;

import feign.Headers;


/**
 * @author gary_kephart
 *
 */
@FeignClient(value = "spotifyAccountService", url = "https://accounts.spotify.com")
public interface FeignSpotifyAccountService
{
  public static final String GRANT_TYPE = "client_credentials";

  /**
   * Requests an authorization token.
   * 
   * @param authTokenRequest an object containing grantType (always 'client_credentials'), client_id and client_secret)
   * @return an access token to be used in other requests
   */
  @Headers("Content-Type: application/x-www-form-urlencoded")
  @PostMapping(value = "/api/token", //
      consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE , //
      produces =  MediaType.APPLICATION_JSON_VALUE )
  public SpotifyAccessToken getToken(
    AuthTokenRequest authTokenRequest);

}
