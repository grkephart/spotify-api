/**
 * 
 */
package com.spotify.api.v1.dto;


import java.util.Arrays;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spotify.api.v1.converters.SpotifyArtistDeserializer;


/**
 * @author gary_kephart
 *
 */
@JsonDeserialize(using = SpotifyArtistDeserializer.class)
public class SpotifyArtist extends SpotifySimplifiedArtist
{
  private String[]       genres;
  private SpotifyImage[] images;
  private Integer        popularity;

  /**
   * 
   */
  public SpotifyArtist()
  {

  }


  /**
   * @param simplifiedArtist
   */
  public SpotifyArtist(SpotifySimplifiedArtist simplifiedArtist)
  {
    super(simplifiedArtist.getId(), simplifiedArtist.getName(), simplifiedArtist.getHref(),
        simplifiedArtist.getType(), simplifiedArtist.getUri());

    this.popularity = null;
  }


  /**
   * @param id
   */
  public SpotifyArtist(String id)
  {
    super(id);
  }


  /**
   * @param id
   * @param name
   * @param href
   * @param type
   * @param uri
   */
  public SpotifyArtist(String id, String name, String href, String type, String uri)
  {
    super(id, name, href, type, uri);
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
  public Integer getPopularity()
  {
    return popularity;
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
   * @param popularity the popularity to set
   */
  public void setPopularity(
    Integer popularity)
  {
    this.popularity = popularity;
  }
}
