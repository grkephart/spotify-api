/**
 * 
 */
package com.spotify.api.v1.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spotify.api.v1.converters.SpotifySimplifiedAlbumDeserializer;


/**
 * A SpotifySimplifiedAlbum is returned when calling getArtistAlbums or when searching for tracks.
 * A SpotifySimplifiedAlbum is the same as a SpotifyAlbum except that it has
 * SpotifySimplifiedArtists instead of SpotifyArtists.
 * 
 * @author gary_kephart
 *
 */
@JsonDeserialize(using = SpotifySimplifiedAlbumDeserializer.class)
public class SpotifySimplifiedAlbum extends AbstractSpotifyAlbum<SpotifySimplifiedArtist>
{
  //private SpotifySimplifiedArtist[] artists;

  /**
   * 
   */
  public SpotifySimplifiedAlbum()
  {

  }


  /**
   * @param name
   * @param albumType
   * @param artists
   */
  public SpotifySimplifiedAlbum(String id, String name, String href, String type, String uri,
                                String albumType, SpotifySimplifiedArtist... artists)
  {
    super(id, name, href, type, uri, albumType, artists);
//    this.artists = artists;
  }



//  /**
//   * @return the artists
//   */
//  public SpotifySimplifiedArtist[] getArtists()
//  {
//    return artists;
//  }
//
//
//  /**
//   * @param artists the artists to set
//   */
//  public void setArtists(
//    SpotifySimplifiedArtist[] artists)
//  {
//    this.artists = artists;
//  }
}
