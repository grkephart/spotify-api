/**
 * 
 */
package com.spotify.api.v1.dto;


import java.util.Objects;


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

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(
    Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SpotifyImage other = (SpotifyImage)obj;
    
    // URL can change. height and width are the only defining properties.
    return height == other.height && width == other.width;
  }


  /**
   * @return the height
   */
  public int getHeight()
  {
    return height;
  }


  /**
   * Just "width x height".
   * 
   * @return
   */
  public String getKey()
  {
    return this.width + "x" + this.height;
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


  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
  {
    return Objects.hash(height, url, width);
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
