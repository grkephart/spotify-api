/**
 * 
 */
package com.spotify.api.v1.services.impl;


/**
 * @author gary_kephart
 *
 */
public class AuthTokenRequest
{
  private String client_id;
  private String client_secret;
  private String grant_type;
  /**
   * 
   */
  public AuthTokenRequest()
  {
  }


  /**
   * @param grant_type
   * @param client_id
   * @param client_secret
   */
  public AuthTokenRequest(String grant_type, String client_id, String client_secret)
  {
    super();
    this.grant_type = grant_type;
    this.client_id = client_id;
    this.client_secret = client_secret;
  }


  /**
   * @return the client_id
   */
  public String getClient_id()
  {
    return client_id;
  }


  /**
   * @return the client_secret
   */
  public String getClient_secret()
  {
    return client_secret;
  }


  /**
   * @return the grant_type
   */
  public String getGrant_type()
  {
    return grant_type;
  }


  /**
   * @param client_id the client_id to set
   */
  public void setClient_id(
    String client_id)
  {
    this.client_id = client_id;
  }


  /**
   * @param client_secret the client_secret to set
   */
  public void setClient_secret(
    String client_secret)
  {
    this.client_secret = client_secret;
  }


  /**
   * @param grant_type the grant_type to set
   */
  public void setGrant_type(
    String grant_type)
  {
    this.grant_type = grant_type;
  }

}
