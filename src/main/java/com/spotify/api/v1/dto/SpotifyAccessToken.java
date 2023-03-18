/**
 * 
 */
package com.spotify.api.v1.dto;


import java.time.Instant;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spotify.api.v1.converters.SpotifyAccessTokenDeserializer;


/**
 * @author gary_kephart
 *
 */
@JsonDeserialize(using = SpotifyAccessTokenDeserializer.class)
public class SpotifyAccessToken
{
  private String  accessToken;
  private Instant expirationInstant;
  private int     expiresIn;
  private String  tokenType;

  /**
   * @param accessTokenValue
   * @param tokenType
   * @param expiresIn
   */
  public SpotifyAccessToken(String accessTokenValue, String tokenType, int expiresIn)
  {
    Instant now = Instant.now();
    this.expirationInstant = Instant.ofEpochSecond(now.getEpochSecond() + expiresIn);
    this.accessToken = accessTokenValue;
    this.tokenType = tokenType;
    this.expiresIn = expiresIn;
  }


  /**
   * @return the accessToken
   */
  public String getAccessToken()
  {
    return accessToken;
  }


  /**
   * @return the expiresIn
   */
  public int getExpiresIn()
  {
    return expiresIn;
  }


  /**
   * @return the tokenType
   */
  public String getTokenType()
  {
    return tokenType;
  }


  /**
   * @return
   */
  public boolean isExpired()
  {
    Instant now = Instant.now();

    return now.isAfter(this.expirationInstant);
  }


  /**
   * @param access_token the access_token to set
   */
  public void setAccessToken(
    String access_token)
  {
    this.accessToken = access_token;
  }


  /**
   * @param expiresIn the expiresIn to set
   */
  public void setExpiresIn(
    int expiresIn)
  {
    this.expiresIn = expiresIn;
  }


  /**
   * @param tokenType the tokenType to set
   */
  public void setTokenType(
    String tokenType)
  {
    this.tokenType = tokenType;
  }
}
