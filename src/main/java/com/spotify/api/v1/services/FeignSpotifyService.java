/**
 * 
 */
package com.spotify.api.v1.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.spotify.api.v1.dto.SpotifyAlbum;
import com.spotify.api.v1.dto.SpotifyArtist;
import com.spotify.api.v1.dto.SpotifySimplifiedAlbum;
import com.spotify.api.v1.dto.SpotifySimplifiedTrack;
import com.spotify.api.v1.dto.SpotifyTrack;
import com.spotify.api.v1.dto.responses.SpotifyArtistsResponse;
import com.spotify.api.v1.dto.responses.SpotifyContentResponse;
import com.spotify.api.v1.dto.responses.SpotifySearchResponse;
import com.spotify.api.v1.dto.responses.SpotifyTracksResponse;


/**
 * @author gary_kephart
 *
 */
@FeignClient(value = "spotifyService", url = "https://api.spotify.com/v1")
public interface FeignSpotifyService
{
  
  /**
   * @param id
   * @return
   */
  @GetMapping("/albums/{id}")
  public SpotifyAlbum getAlbum(
    @RequestHeader("Authorization") String authorization,
    @PathVariable("id") String id);
  
  /**
   * Get Spotify catalog information about an album's tracks. Optional parameters can be used to limit the number of tracks returned.
   * This is a "simple" track and therefore does not return the album or popularity as part of the track.
   * 
   * @param authorization
   * @param id The Spotify ID of the album.
   * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
   * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
   * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
   * @return
   */
  @GetMapping("/albums/{id}/tracks")
  public SpotifyContentResponse<SpotifySimplifiedTrack> getAlbumTracks(
    @RequestHeader("Authorization") String authorization,
    @PathVariable("id") String id,
    @RequestParam("limit") Integer limit,
    @RequestParam("market") String market,
    @RequestParam("offset") Integer offset);

 
  
  /**
   * @param authorization
   * @param id
   * @return
   */
  @GetMapping("artists/{id}")
  public SpotifyArtist getArtist(
    @RequestHeader("Authorization") String authorization,
    @PathVariable("id") String id);
 
  
  /**
   * @param authorization
   * @param id The Spotify ID of the artist.
   * @param includeGroups A comma-separated list of keywords that will be used to filter the response. If not supplied, all album types will be returned. Valid values are: album,single,appears_on,compilation. For example: include_groups=album,single.
   * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
   * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
   * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
   * @return
   */
  @GetMapping("artists/{id}/albums")
  public SpotifyContentResponse<SpotifySimplifiedAlbum> getArtistAlbums(
    @RequestHeader("Authorization") String authorization,
    @PathVariable("id") String id,
    @RequestParam("include_groups") String includeGroups,
    @RequestParam("limit") Integer limit,
    @RequestParam("market") String market,
    @RequestParam("offset") Integer offset);
  
  
  /**
   * @param authorization
   * @param A comma-separated list of the Spotify IDs for the artists. Maximum: 50 IDs.
   * @return
   */
  @GetMapping("artists")
  public SpotifyArtistsResponse getArtists(
    @RequestHeader("Authorization") String authorization,
    @RequestParam("ids") String ids);
  
  
  /**
   * @param authorization
   * @param id
   * @return
   */
  @GetMapping("tracks/{id}")
  public SpotifyTrack getTrack(
    @RequestHeader("Authorization") String authorization,
    @PathVariable("id") String id);


  /**
   * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
   * 
   * @param authorization
   * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
   * @return
   */
  @GetMapping("tracks")
  public SpotifyTracksResponse getTracks(
    @RequestHeader("Authorization") String authorization,
    @RequestParam("ids") String ids,
    @RequestParam("market") String market);

  /**
   * @param authorization
   * @param q your search query.
   * @param type a comma-separated list of item types to search across. Search results include hits from all the specified item types. For example: q=abacab&type=album,track returns both albums and tracks matching "abacab".
  Allowed values: "album", "artist", "playlist", "track", "show", "episode", "audiobook"
  Example value:"track,artist"
   * @param includeExternal if include_external=audio is specified it signals that the client can play externally hosted audio content, and marks the content as playable in the response. By default externally hosted audio content is marked as unplayable in the response.
   * @param limit the maximum number of results to return in each item type.
  >= 0<= 50
  Default value:20
  Example value:10
   * @param market
   * @param offset the index of the first result to return. Use with limit to get the next page of search results.
  >= 0<= 1000
  Default value:0
  Example value:5
   * @return
   * @throws Exception 
   */
  @GetMapping("search")
  public SpotifySearchResponse search(
    @RequestHeader("Authorization") String authorization,
    @RequestParam("q") String q,
    @RequestParam("type") String type,
    @RequestParam("include_external") String includeExternal,
    @RequestParam("limit") Integer limit,
    @RequestParam("market") String market,
    @RequestParam("offset") Integer offset);

}
