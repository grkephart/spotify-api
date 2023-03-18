/**
 * 
 */
package com.spotify.api.v1.dto.responses;

/**
 * @author gary_kephart
 *
 */
public class SpotifySearchResponse
{
  private SpotifySearchAlbumResponse albums;
  private SpotifySearchArtistResponse artists;
  private SpotifySearchTrackResponse tracks;

  /**
   * @return the albums
   */
  public SpotifySearchAlbumResponse getAlbums()
  {
    return albums;
  }


  /**
   * @return the artists
   */
  public SpotifySearchArtistResponse getArtists()
  {
    return artists;
  }


  /**
   * @return the tracks
   */
  public SpotifySearchTrackResponse getTracks()
  {
    return tracks;
  }


  /**
   * @param albums the albums to set
   */
  public void setAlbums(
    SpotifySearchAlbumResponse albums)
  {
    this.albums = albums;
  }


  /**
   * @param artists the artists to set
   */
  public void setArtists(
    SpotifySearchArtistResponse artists)
  {
    this.artists = artists;
  }


  /**
   * @param tracks the tracks to set
   */
  public void setTracks(
    SpotifySearchTrackResponse tracks)
  {
    this.tracks = tracks;
  }
}
