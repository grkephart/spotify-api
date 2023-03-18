/**
 * 
 */
package com.spotify.api.v1.dto;


/**
 * @author gary_kephart
 *
 */
public class SpotifyImage
{
  /**
  *   The image height in pixels.
  */
  private int    height;

  /**
   * The source URL of the image.
   */
  private String url;

  /**
   * The image width in pixels.
   */
  private int    width;

  /**
   * @return the height
   */
  public int getHeight()
  {
    return height;
  }


  /**
   * @return the url
   */
  public String getUrl()
  {
    return url;
  }


  /**
   * @return the width
   */
  public int getWidth()
  {
    return width;
  }


  /**
   * @param height the height to set
   */
  public void setHeight(
    int height)
  {
    this.height = height;
  }


  /**
   * @param url the url to set
   */
  public void setUrl(
    String url)
  {
    this.url = url;
  }


  /**
   * @param width the width to set
   */
  public void setWidth(
    int width)
  {
    this.width = width;
  }
}
