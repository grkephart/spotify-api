package com.spotify.api.v1.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spotify.api.v1.converters.SpotifySimplifiedArtistDeserializer;

/**
 * A SpotifySimplifiedArtist is returned as part of a SpotifySimplifiedAlbum,
 * which is returned when calling getArtistAlbums or getAlbumTracks or search on tracks.
 * There are no genres, images, or popularity.
 * 
 * @author gary_kephart
 *
 */
@JsonDeserialize(using = SpotifySimplifiedArtistDeserializer.class)
public class SpotifySimplifiedArtist extends SpotifyItem
{

  /**
   * 
   */
  public SpotifySimplifiedArtist()
  {

  }


  /**
   * @param id
   * @param name
   * @param href
   * @param type
   * @param uri
   */
  public SpotifySimplifiedArtist(String id, String name, String href, String type, String uri)
  {
    super(id, name, href, type, uri);
  }


  /**
   * @param id
   */
  public SpotifySimplifiedArtist(String id)
  {
    super(id);
  }


  /**
   * @param that
   * @return
   */
  public boolean equals(
    SpotifySimplifiedArtist that)
  {
    return super.equals(that);
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

}
