/**
 * 
 */
package com.spotify.api.v1.dto;


import java.util.Arrays;


/**
 * @author gary_kephart
 *
 */
public class SpotifyArtist extends SpotifyItem
{
  private String[]          genres;
  private SpotifyImage[]    images;
  private boolean           imported;
  private int               popularity;

  /**
   * 
   */
  public SpotifyArtist()
  {

  }


  /**
   * @param that
   * @return
   */
  public boolean equals(
    SpotifyArtist that)
  {
    return super.equals(that)//
           && equalsWithNullCheck(this.popularity, that.popularity)//
           && Arrays.equals(this.genres, that.genres);
  }


  /**
   * @param value1
   * @param value2
   * @return
   */
  public boolean equalsWithNullCheck(
    Object value1,
    Object value2)
  {
    return (value1 == null && value2 == null)
           || (value1 != null && value2 != null && value1.equals(value2));
  }


  /**
   * @return the genres
   */
  public String[] getGenres()
  {
    return genres;
  }


  /**
   * @return the images
   */
  public SpotifyImage[] getImages()
  {
    return images;
  }


  /**
   * @return the popularity
   */
  public int getPopularity()
  {
    return popularity;
  }


  /**
   * @return the imported
   */
  public boolean isImported()
  {
    return imported;
  }


  /**
   * @param genres the genres to set
   */
  public void setGenres(
    String[] genres)
  {
    this.genres = genres;
  }


  /**
   * @param images the images to set
   */
  public void setImages(
    SpotifyImage[] images)
  {
    this.images = images;
  }


  /**
   * @param imported the imported to set
   */
  public void setImported(
    boolean imported)
  {
    this.imported = imported;
  }


  /**
   * @param popularity the popularity to set
   */
  public void setPopularity(
    int popularity)
  {
    this.popularity = popularity;
  }
}
