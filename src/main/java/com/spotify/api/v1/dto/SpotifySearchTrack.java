/**
 * 
 */
package com.spotify.api.v1.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spotify.api.v1.converters.SpotifySearchTrackDeserializer;


/**
 * @author gary_kephart
 *
 */
@JsonDeserialize(using = SpotifySearchTrackDeserializer.class)
public class SpotifySearchTrack extends SpotifyItem
{
  private SpotifySimplifiedAlbum album;
  private SpotifyArtist[]        artists;
  private int                    discNumber;
  private int                    duration;
  private Integer                popularity;
  private int                    trackNumber;

  /**
   * 
   */
  public SpotifySearchTrack()
  {

  }


  /**
   * @param name
   * @param artist
   * @param album
   */
  public SpotifySearchTrack(String id, String name, String href, String type, String uri,
                            SpotifySimplifiedAlbum album, SpotifyArtist... artists)
  {
    super(id, name, href, type, uri);
    this.artists = artists;
    this.album = album;
  }


  /**
   * @return the album
   */
  public SpotifySimplifiedAlbum getAlbum()
  {
    return album;
  }


  /**
   * @return
   */
  public String getAlbumArtistIds()
  {
    String[] artistIds = new String[this.artists.length];
    int index = 0;
    
    for (SpotifyArtist artist : this.artists)
    {
      artistIds[index++] = artist.getId();
    }
    
    return String.join(",", artistIds);
  }


  /**
   * @return
   */
  public String getAlbumArtistNames()
  {
    String[] artistNames = new String[this.artists.length];
    int index = 0;
    
    for (SpotifyArtist artist : this.artists)
    {
      artistNames[index++] = artist.getName();
    }
    
    return String.join(",", artistNames);
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
    SpotifySimplifiedAlbum album)
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
