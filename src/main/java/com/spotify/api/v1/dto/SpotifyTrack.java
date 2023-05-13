/**
 * 
 */
package com.spotify.api.v1.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spotify.api.v1.converters.SpotifyTrackDeserializer;


/**
 * @author gary_kephart
 *
 */
@JsonDeserialize(using = SpotifyTrackDeserializer.class)
public class SpotifyTrack extends SpotifyItem
{
  private SpotifyAlbum    album;
  private SpotifyArtist[] artists;
  private int             discNumber;
  private int             duration;
  private Integer         popularity;
  private int             trackNumber;

  /**
   * 
   */
  public SpotifyTrack()
  {

  }


  /**
   * @param name
   * @param artist
   * @param album
   */
  public SpotifyTrack(String id, String name, String href, String type, String uri, SpotifyAlbum album,
                      SpotifyArtist... artists)
  {
    super(id, name, href, type, uri);
    this.artists =  artists;
    this.album = album;
  }


  /**
   * @return the album
   */
  public SpotifyAlbum getAlbum()
  {
    return album;
  }


  /**
   * @return
   */
  public String getAlbumArtistName()
  {
    String albumArtistName = null;

    if (this.album != null)
    {
      SpotifyArtist[] spotifyArtists = album.getArtists();

      if (spotifyArtists == null || spotifyArtists.length == 0)
        albumArtistName = "none";
      else
      {
        StringBuilder builder = new StringBuilder();
        boolean first = true;

        for (SpotifyArtist spotifyArtist : spotifyArtists)
        {
          if (!first)
            builder.append(",");
          else
            first = false;

          builder.append(spotifyArtist.getName());
        }

        albumArtistName = builder.toString();
      }
    }

    return albumArtistName;
  }


  /**
   * @return the artists
   */
  public SpotifyArtist[] getArtists()
  {
    return artists;
  }


  /**
   * @return the diskNumber
   */
  public int getDiscNumber()
  {
    return discNumber;
  }


  /**
   * @return the duration
   */
  public int getDuration()
  {
    return duration;
  }


  /**
   * @return the popularity
   */
  public Integer getPopularity()
  {
    return popularity;
  }


  /**
   * @return the trackNumber
   */
  public int getTrackNumber()
  {
    return trackNumber;
  }


  /**
   * @param album the album to set
   */
  public void setAlbum(
    SpotifyAlbum album)
  {
    this.album = album;
  }


  /**
   * @param artists the artists to set
   */
  public void setArtists(
    SpotifyArtist[] artists)
  {
    this.artists = artists;
  }


  /**
   * @param discNumber the discNumber to set
   */
  public void setDiscNumber(
    int discNumber)
  {
    this.discNumber = discNumber;
  }


  /**
   * @param duration the duration to set
   */
  public void setDuration(
    int duration)
  {
    this.duration = duration;
  }


  /**
   * @param popularity the popularity to set
   */
  public void setPopularity(
    Integer popularity)
  {
    this.popularity = popularity;
  }


  /**
   * @param trackNumber the trackNumber to set
   */
  public void setTrackNumber(
    int trackNumber)
  {
    this.trackNumber = trackNumber;
  }
}
