/**
 * 
 */
package com.spotify.api.v1.services.impl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spotify.api.v1.dto.SpotifyAlbum;
import com.spotify.api.v1.dto.SpotifyArtist;
import com.spotify.api.v1.dto.SpotifySimplifiedAlbum;
import com.spotify.api.v1.dto.SpotifySimplifiedArtist;
import com.spotify.api.v1.dto.SpotifySimplifiedTrack;
import com.spotify.api.v1.dto.SpotifyTrack;
import com.spotify.api.v1.dto.responses.SpotifyContentResponse;
import com.spotify.api.v1.dto.responses.SpotifySearchResponse;
import com.spotify.api.v1.dto.responses.SpotifyTracksResponse;
import com.spotify.api.v1.services.FeignSpotifyService;
import com.spotify.api.v1.services.SpotifyAuthService;
import com.spotify.api.v1.services.SpotifyService;

import feign.FeignException.Unauthorized;
import feign.RetryableException;


/**
 * @author gary_kephart
 *
 */
@Service("SpotifyServiceImpl")
public class SpotifyServiceImpl implements SpotifyService
{
  private static final String DTF_PATTERN = "MM/dd/yyyy HH:mm:ss.SSS ZZZ";
  private static final Log    log         = LogFactory.getLog(SpotifyServiceImpl.class);
  //  private static final String        URL         = "https://api.spotify.com/v1";

  private DateFormat          df;

  /**
   * The maximum number of attempts at a specific Spotify call.
   */
  @Value("${spotify.maxAttemptsPerCall}")
  private int                 maxAttemptsPerCall;

  @Autowired
  private FeignSpotifyService service;

  /**
   * The amount of time, in ms, to pause the current thread before making a Spotify call.
   */
  @Value("${spotify.sleep}")
  private int                 sleep;

  /**
   * 
   */
  @Autowired
  private SpotifyAuthService  spotifyAuthService;

  /**
   * 
   */
  public SpotifyServiceImpl()
  {
    this.df = new SimpleDateFormat(DTF_PATTERN);
  }


  /**
   * @param spotifyAuthService
   * @param maxAttemptsPerCall
   * @param sleep
   */
  public SpotifyServiceImpl(SpotifyAuthService spotifyAuthService, int maxAttemptsPerCall,
                            int sleep)
  {
    this.df = new SimpleDateFormat(DTF_PATTERN);
    this.spotifyAuthService = spotifyAuthService;
    this.maxAttemptsPerCall = maxAttemptsPerCall;
    this.sleep = sleep;
  }


  /* (non-Javadoc)
   * @see com.spotify.api.v1.services.SpotifyService#getAlbum(java.lang.String)
   */
  @Override
  public SpotifyAlbum getAlbum(
    String id) throws Exception
  {
    String authorization = this.spotifyAuthService.getSpotifyAuthorization();
    SpotifyAlbum response = null;
    int attempts = 0;
    boolean attempting = true;

    if (this.sleep > 0)
      Thread.sleep(this.sleep);

    while (attempting)
    {
      try
      {
        response = this.service.getAlbum(authorization, id);

        attempting = false;
      }
      catch (RetryableException e)
      {
        handleRetryableException(++attempts, e);
      }
      catch (Unauthorized e)
      {
        authorization = handleUnauthorizedException(++attempts, e);
      }
      catch (Exception e)
      {
        log.error("[getAlbum] e=" + e.getClass().getSimpleName(), e);
        throw e;
      }
    }

    return response;
  }


  /* (non-Javadoc)
   * @see org.drdeesw.reactrax.services.RateLimitedSpotifyService#getAlbumTracks(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer)
   */
  @Override
  public SpotifyContentResponse<SpotifySimplifiedTrack> getAlbumTracks(
    String id,
    Integer limit,
    String market,
    Integer offset) throws Exception
  {
    String authorization = this.spotifyAuthService.getSpotifyAuthorization();
    SpotifyContentResponse<SpotifySimplifiedTrack> response = null;
    int attempts = 0;
    boolean attempting = true;

    if (this.sleep > 0)
      Thread.sleep(this.sleep);

    while (attempting)
    {
      try
      {
        response = this.service.getAlbumTracks(authorization, id, limit, market, offset);

        attempting = false;
      }
      catch (RetryableException e)
      {
        handleRetryableException(++attempts, e);
      }
      catch (Unauthorized e)
      {
        authorization = handleUnauthorizedException(++attempts, e);
      }
      catch (Exception e)
      {
        log.error("[getAlbumTracks] e=" + e.getClass().getSimpleName(), e);
        throw e;
      }
    }

    return response;
  }


  /* (non-Javadoc)
   * @see com.spotify.api.v1.services.SpotifyService#getAlbumTracks(java.lang.String, java.lang.String, java.lang.String)
   */
  @Override
  public List<SpotifySimplifiedTrack> getAlbumTracks(
    String id,
    String market) throws Exception
  {
    List<SpotifySimplifiedTrack> albumTracks = new ArrayList<SpotifySimplifiedTrack>();
    int offset = 0;
    Integer limit = SpotifyService.MAX_LIMIT;
    int total = 0;

    do
    {
      SpotifyContentResponse<SpotifySimplifiedTrack> response = getAlbumTracks(id, limit, market, offset);

      albumTracks.addAll(Arrays.asList(response.getItems()));
      total = response.getTotal();

      offset += limit;

    } while (offset < total);

    return albumTracks;
  }


  /* (non-Javadoc)
   * @see org.drdeesw.reactrax.services.RateLimitedSpotifyService#getArtist(java.lang.String, java.lang.String)
   */
  @Override
  public SpotifyArtist getArtist(
    String id) throws Exception
  {
    String authorization = this.spotifyAuthService.getSpotifyAuthorization();
    SpotifyArtist response = null;
    int attempts = 0;
    boolean attempting = true;

    if (this.sleep > 0)
      Thread.sleep(this.sleep);

    while (attempting)
    {
      try
      {
        response = this.service.getArtist(authorization, id);

        attempting = false;
      }
      catch (RetryableException e)
      {
        handleRetryableException(++attempts, e);
      }
      catch (Unauthorized e)
      {
        authorization = handleUnauthorizedException(++attempts, e);
      }
      catch (Exception e)
      {
        log.error("[getArtist] e=" + e.getClass().getSimpleName(), e);
        throw e;
      }
    }

    return response;
  }


  /* (non-Javadoc)
   * @see org.drdeesw.reactrax.services.RateLimitedSpotifyService#getArtistAlbums(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer)
   */
  @Override
  public SpotifyContentResponse<SpotifySimplifiedAlbum> getArtistAlbums(
    String id,
    String includeGroups,
    Integer limit,
    String market,
    Integer offset) throws Exception
  {
    String authorization = this.spotifyAuthService.getSpotifyAuthorization();
    SpotifyContentResponse<SpotifySimplifiedAlbum> response = null;
    int attempts = 0;
    boolean attempting = true;

    if (this.sleep > 0)
      Thread.sleep(this.sleep);

    while (attempting)
    {
      try
      {
        response = this.service.getArtistAlbums(authorization, id, includeGroups, limit, market,
          offset);

        attempting = false;
      }
      catch (RetryableException e)
      {
        handleRetryableException(++attempts, e);
      }
      catch (Unauthorized e)
      {
        authorization = handleUnauthorizedException(++attempts, e);
      }
      catch (Exception e)
      {
        log.error("[getArtistAlbums] e=" + e.getClass().getSimpleName(), e);
        throw e;
      }
    }

    return response;
  }


  /* (non-Javadoc)
   * @see org.drdeesw.reactrax.services.RateLimitedSpotifyService#getArtistAlbums(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer)
   */
  @Override
  public List<SpotifySimplifiedAlbum> getArtistAlbums(
    String id,
    String includeGroups,
    String market) throws Exception
  {
    List<SpotifySimplifiedAlbum> artistAlbums = new ArrayList<SpotifySimplifiedAlbum>();
    int offset = 0;
    Integer limit = SpotifyService.MAX_LIMIT;
    int total = 0;

    do
    {
      SpotifyContentResponse<SpotifySimplifiedAlbum> response = getArtistAlbums(id, includeGroups, limit,
        market, offset);

      artistAlbums.addAll(Arrays.asList(response.getItems()));
      total = response.getTotal();

      offset += limit;

    } while (offset < total);

    return artistAlbums;
  }


  /* (non-Javadoc)
   * @see com.spotify.api.v1.services.SpotifyService#getArtists(com.spotify.api.v1.dto.SpotifySimplifiedArtist[])
   */
  @Override
  public SpotifyArtist[] getArtists(
    SpotifySimplifiedArtist[] spotifySimplifiedArtists)
  {
    String authorization = this.spotifyAuthService.getSpotifyAuthorization();
    Set<String> idSet = new HashSet<String>();
    
    for (SpotifySimplifiedArtist spotifySimplifiedArtist : spotifySimplifiedArtists)
    {
      idSet.add(spotifySimplifiedArtist.getId());
    }
    
    String[] ids = new String[idSet.size()];

    ids = idSet.toArray(ids);
        
    return this.service.getArtists(authorization, String.join(",", ids)).getArtists();
  }


  /* (non-Javadoc)
   * @see org.drdeesw.reactrax.services.RateLimitedSpotifyService#getTrack(java.lang.String, java.lang.String)
   */
  @Override
  public SpotifyTrack getTrack(
    String id) throws Exception
  {
    String authorization = this.spotifyAuthService.getSpotifyAuthorization();
    SpotifyTrack response = null;
    int attempts = 0;
    boolean attempting = true;

    if (this.sleep > 0)
      Thread.sleep(this.sleep);

    while (attempting)
    {
      try
      {
        response = this.service.getTrack(authorization, id);

        attempting = false;
      }
      catch (RetryableException e)
      {
        handleRetryableException(++attempts, e);
      }
      catch (Unauthorized e)
      {
        authorization = handleUnauthorizedException(++attempts, e);
      }
      catch (Exception e)
      {
        log.error("[getTrack] e=" + e.getClass().getSimpleName(), e);
        throw e;
      }
    }

    return response;
  }


  /* (non-Javadoc)
   * @see com.spotify.api.v1.services.SpotifyService#getTracks(java.lang.String, java.lang.String)
   */
  @Override
  public List<SpotifyTrack> getTracks(
    String ids,
    String market) throws Exception
  {
    String authorization = this.spotifyAuthService.getSpotifyAuthorization();
    SpotifyTracksResponse response = null;
    int attempts = 0;
    boolean attempting = true;

    if (this.sleep > 0)
      Thread.sleep(this.sleep);

    while (attempting)
    {
      try
      {
        response = this.service.getTracks(authorization, ids, market);

        attempting = false;
      }
      catch (RetryableException e)
      {
        handleRetryableException(++attempts, e);
      }
      catch (Unauthorized e)
      {
        authorization = handleUnauthorizedException(++attempts, e);
      }
      catch (Exception e)
      {
        log.error("[getTracks] e=" + e.getClass().getSimpleName(), e);
        throw e;
      }
    }

    return response == null ? null : Arrays.asList(response.getTracks());
  }


  /**
   * @param attempts
   * @param e
   * @throws InterruptedException
   */
  private void handleRetryableException(
    int attempts,
    RetryableException e) throws InterruptedException
  {
    if (attempts > this.maxAttemptsPerCall)
    {
      throw e;
    }
    else
    {
      Date retryAfter = e.retryAfter();

      if (retryAfter != null)
      {
        Calendar cal = Calendar.getInstance();
        long nowMs = cal.getTimeInMillis();
        long retryAfterMs = retryAfter.getTime();
        long diffMs = retryAfterMs - nowMs;
        Date now = cal.getTime();

        log.info("[handleRetryableException] retry after " + this.df.format(retryAfter) + " => "
                 + (diffMs / 1000) + " seconds. Now is " + this.df.format(now));

        Thread.sleep(diffMs);
      }
      else
      {
        log.error("[handleRetryableException] no retryAfter.");
        
        throw e;
      }
    }
  }


  /**
   * @param attempts
   * @param e
   * @return
   */
  private String handleUnauthorizedException(
    int attempts,
    Unauthorized e)
  {
    if (attempts > this.maxAttemptsPerCall)
      throw e;
    else
    {
      return this.spotifyAuthService.getSpotifyAuthorization();
    }
  }


  /* (non-Javadoc)
   * @see org.drdeesw.reactrax.services.RateLimitedSpotifyService#search(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer)
   */
  @Override
  public SpotifySearchResponse search(
    String q,
    String type,
    String includeExternal,
    Integer limit,
    String market,
    Integer offset) throws Exception
  {
    String authorization = this.spotifyAuthService.getSpotifyAuthorization();
    SpotifySearchResponse response = null;
    int attempts = 0;
    boolean attempting = true;

    if (this.sleep > 0)
      Thread.sleep(this.sleep);

    while (attempting)
    {
      try
      {
        response = this.service.search(authorization, q, type, null, limit, null, offset);

        attempting = false;
      }
      catch (RetryableException e)
      {
        handleRetryableException(++attempts, e);
      }
      catch (Unauthorized e)
      {
        authorization = handleUnauthorizedException(++attempts, e);
      }
      catch (Exception e)
      {
        log.error("[search] e=" + e.getClass().getSimpleName(), e);
        throw e;
      }
    }

    return response;
  }

}
