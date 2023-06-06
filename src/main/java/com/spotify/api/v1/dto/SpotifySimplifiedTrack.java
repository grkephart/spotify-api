/**
 * 
 */
package com.spotify.api.v1.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spotify.api.v1.converters.SpotifySimplifiedTrackDeserializer;


/**
 * A SpotifySimplifiedTrack is returned when calling getAlbumTracks.
 * A SpotifySimplifiedTrack is the same as a SpotifyTrack except that it has
 * SpotifySimplifiedArtists instead of SpotifyArtists and is missing
 * popularity and album.
 * 
 * @author gary_kephart
 *
 */
@JsonDeserialize(using = SpotifySimplifiedTrackDeserializer.class)
public class SpotifySimplifiedTrack extends SpotifyItem
{
  private SpotifyAlbum              album;      // transient
  private SpotifySimplifiedArtist[] artists;
  private int                       discNumber;
  private int                       duration;
  private int                       trackNumber;

  /**
   * 
   */
  public SpotifySimplifiedTrack()
  {

  }


  /**
   * @param name
   * @param artist
   * @param album
   */
  public SpotifySimplifiedTrack(String id, String name, String href, String type, String uri,
                                SpotifySimplifiedArtist... artists)
  {
    super(id, name, href, type, uri);
    this.artists = artists;
  }


  /**
   * Transient. Is not returned by Spotify call.
   * 
   * @return the album
   */
  public SpotifyAlbum getAlbum()
  {
    return album;
  }


  /**
   * @return the artists
   */
  public SpotifySimplifiedArtist[] getArtists()
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
    SpotifyAlbum spotifyAlbum)
  {
    this.album = spotifyAlbum;
  }


  /**
   * @param artists the artists to set
   */
  public void setArtists(
    SpotifySimplifiedArtist[] artists)
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
   * @param trackNumber the trackNumber to set
   */
  public void setTrackNumber(
    int trackNumber)
  {
    this.trackNumber = trackNumber;
  }
}
