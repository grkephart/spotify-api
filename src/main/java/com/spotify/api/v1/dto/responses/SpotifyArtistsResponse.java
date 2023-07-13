package com.spotify.api.v1.dto.responses;

import com.spotify.api.v1.dto.SpotifyArtist;

public class SpotifyArtistsResponse
{
  private SpotifyArtist[] artists;

  /**
   * @return the Artists
   */
  public SpotifyArtist[] getArtists()
  {
    return artists;
  }


  /**
   * @param artists the Artists to set
   */
  public void setArtists(
    SpotifyArtist[] artists)
  {
    this.artists = artists;
  }

}
