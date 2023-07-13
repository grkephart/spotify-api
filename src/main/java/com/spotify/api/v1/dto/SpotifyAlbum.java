/**
 * 
 */
package com.spotify.api.v1.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spotify.api.v1.converters.SpotifyAlbumDeserializer;


/**
 * @author gary_kephart
 *
 */
@JsonDeserialize(using = SpotifyAlbumDeserializer.class)
public class SpotifyAlbum extends AbstractSpotifyAlbum<SpotifyArtist>
{
//  private SpotifyArtist[] artists;

  /**
   * 
   */
  public SpotifyAlbum()
  {

  }


  /**
   * @param album
   */
  public SpotifyAlbum(SpotifySimplifiedAlbum album)
  {
    super(album.getId(), album.getName(), album.getHref(), album.getType(), album.getUri(),
        album.getAlbumType());
//    this.artists = convert(album.getArtists());
    setArtists(convert(album.getArtists()));
  }


  /**
   * @param name
   * @param albumType
   * @param artists
   */
  public SpotifyAlbum(String id, String name, String href, String type, String uri,
                      String albumType, SpotifyArtist... artists)
  {
    super(id, name, href, type, uri, albumType, artists);
//    this.artists = artists;
  }


  /**
   * @param simplifiedArtists
   * @return
   */
  private SpotifyArtist[] convert(
    SpotifySimplifiedArtist[] simplifiedArtists)
  {
    SpotifyArtist[] artists = new SpotifyArtist[simplifiedArtists.length];
    int index = 0;

    for (SpotifySimplifiedArtist simplifiedArtist : simplifiedArtists)
    {
      artists[index++] = new SpotifyArtist(simplifiedArtist);
    }

    return artists;
  }


//  /**
//   * @return the artists
//   */
//  public SpotifyArtist[] getArtists()
//  {
//    return artists;
//  }
//
//
//  /**
//   * @param artists the artists to set
//   */
//  public void setArtists(
//    SpotifyArtist[] artists)
//  {
//    this.artists = artists;
//  }

}
