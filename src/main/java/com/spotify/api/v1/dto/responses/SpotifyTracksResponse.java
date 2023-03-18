package com.spotify.api.v1.dto.responses;

import com.spotify.api.v1.dto.SpotifyTrack;

public class SpotifyTracksResponse
{
  private SpotifyTrack[] tracks;

  /**
   * @return the tracks
   */
  public SpotifyTrack[] getTracks()
  {
    return tracks;
  }


  /**
   * @param tracks the tracks to set
   */
  public void setTracks(
    SpotifyTrack[] tracks)
  {
    this.tracks = tracks;
  }

}
