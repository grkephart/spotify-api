/**
 * 
 */
package com.spotify.api.v1.services;


import java.util.List;

import com.spotify.api.v1.dto.SpotifyAlbum;
import com.spotify.api.v1.dto.SpotifyArtist;
import com.spotify.api.v1.dto.SpotifySimplifiedAlbum;
import com.spotify.api.v1.dto.SpotifySimplifiedArtist;
import com.spotify.api.v1.dto.SpotifySimplifiedTrack;
import com.spotify.api.v1.dto.SpotifyTrack;
import com.spotify.api.v1.dto.responses.SpotifyContentResponse;
import com.spotify.api.v1.dto.responses.SpotifySearchResponse;


/**
 * A layer above the Feign Spotify service that takes care of authentication, retries and paging.
 * 
 * @author gary_kephart
 *
 */
public interface SpotifyService
{
  public static final int MAX_LIMIT = 50;

  /**
   * Get Spotify catalog information for a single album.
   * 
   * @param id
   * @param sleepOnRetry TODO
   * @return
   * @throws InterruptedException 
   */
  public SpotifyAlbum getAlbum(
    String id,
    boolean sleepOnRetry) throws Exception;


  /**
   * Get Spotify catalog information about an album's tracks. Optional parameters can be used to limit the number of tracks returned.
   * 
   * @param id The Spotify ID of the album.
   * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
   * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
   * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
   * @param sleepOnRetry TODO
   * @return
   */
  public SpotifyContentResponse<SpotifySimplifiedTrack> getAlbumTracks(
    String id,
    Integer limit,
    String market,
    Integer offset,
    boolean sleepOnRetry) throws Exception;


  /**
   * Get Spotify catalog information about an album's tracks. 
   * 
   * @param id The Spotify ID of the album.
   * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
   * @param sleepOnRetry TODO
   * @return
   * @throws Exception
   */
  List<SpotifySimplifiedTrack> getAlbumTracks(
    String id,
    String market,
    boolean sleepOnRetry) throws Exception;


  /**
   * @param id
   * @param sleepOnRetry TODO
   * @return
   */
  public SpotifyArtist getArtist(
    String id,
    boolean sleepOnRetry) throws Exception;


  /**
   * Get Spotify catalog information about an artist's albums.
   * 
   * @param id The Spotify ID of the artist.
   * @param includeGroups A comma-separated list of keywords that will be used to filter the response. If not supplied, all album types will be returned. Valid values are: album,single,appears_on,compilation. For example: include_groups=album,single.
   * @param limit The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
   * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
   * @param offset The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
   * @param sleepOnRetry TODO
   * @return
   */
  public SpotifyContentResponse<SpotifySimplifiedAlbum> getArtistAlbums(
    String id,
    String includeGroups,
    Integer limit,
    String market,
    Integer offset,
    boolean sleepOnRetry) throws Exception;


  /**
   * Get Spotify catalog information about an artist's albums.
   * 
   * @param id The Spotify ID of the artist.
   * @param includeGroups A comma-separated list of keywords that will be used to filter the response. If not supplied, all album types will be returned. Valid values are: album,single,appears_on,compilation. For example: include_groups=album,single.
   * @param market An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
   * @param sleepOnRetry TODO
   * @return
   * @throws Exception
   */
  List<SpotifySimplifiedAlbum> getArtistAlbums(
    String id,
    String includeGroups,
    String market,
    boolean sleepOnRetry) throws Exception;


  /**
   * Convert a set of SpotifySimplifiedArtist to SpotifyArtist.
   * 
   * @param spotifySimplifiedArtists a set of SpotifySimplifiedArtist. Assuming no more than MAX_LIMIT values.
   * @return the equivalent set of SpotifyArtist, but not necessarily in the same order.
   */
  public SpotifyArtist[] getArtists(
    SpotifySimplifiedArtist[] spotifySimplifiedArtists);


  /**
   * Get Spotify catalog information for a single track identified by its unique Spotify ID.
   * 
   * @param id The Spotify ID for the track.
   * @param sleepOnRetry TODO
   * @return
   */
  public SpotifyTrack getTrack(
    String id,
    boolean sleepOnRetry) throws Exception;


  /**
   * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
   * 
   * @param ids A comma-separated list of the Spotify IDs. For example: ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M. Maximum: 50 IDs.
   * @param market An ISO 3166-1 alpha-2 country code
   * @param sleepOnRetry TODO
   * @return
   * @throws Exception 
   */
  public List<SpotifyTrack> getTracks(
    String ids,
    String market,
    boolean sleepOnRetry) throws Exception;


  /**
   * @param q your search query.
   * @param type a comma-separated list of item types to search across. Search results include hits from all the specified item types. For example: q=abacab&type=album,track returns both albums and tracks matching "abacab".
  Allowed values: "album", "artist", "playlist", "track", "show", "episode", "audiobook"
  Example value:"track,artist"
   * @param includeExternal if include_external=audio is specified it signals that the client can play externally hosted audio content, and marks the content as playable in the response. By default externally hosted audio content is marked as unplayable in the response.
   * @param limit the maximum number of results to return in each item type. >= 0<= 50
  Default value:20
  Example value:10
   * @param market
   * @param offset the index of the first result to return. Use with limit to get the next page of search results. >= 0<= 1000
  Default value:0
  Example value:5
   * @param sleepOnRetry TODO
   * @return
   * @throws Exception 
   */
  public SpotifySearchResponse search(
    String q,
    String type,
    String includeExternal,
    Integer limit,
    String market,
    Integer offset,
    boolean sleepOnRetry) throws Exception;

}
