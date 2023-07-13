/**
 * 
 */
package com.spotify.api.v1.dto;

import java.util.Objects;

/**
 * @author gary_kephart
 *
 */
public class AbstractSpotifyAlbum<A extends SpotifySimplifiedArtist> extends SpotifyItem
{

  public static final String ALBUM_TYPE       = "album";
  public static final String COMPILATION_TYPE = "compilation";
  public static final String SINGLE_TYPE      = "single";
  private String             albumType;
  private SpotifyImage[]     images;
  private Integer            popularity;
  private String             releaseDate;
  private String             releaseDatePrecision;
  private int                totalTracks;
  private A[] artists;

  /**
   * 
   */
  public AbstractSpotifyAlbum()
  {
  }


  /**
   * @param id
   */
  public AbstractSpotifyAlbum(String id)
  {
    super(id);
  }


  /**
   * @param id
   * @param name
   * @param href
   * @param type
   * @param uri
   */
  public AbstractSpotifyAlbum(String id, String name, String href, String type, String uri, String albumType, A... artists)
  {
    super(id, name, href, type, uri);
    this.albumType = albumType;
    this.artists = artists;
  }


  /**
   * Values include album, single,compilation
   * 
   * @return the albumType
   */
  public String getAlbumType()
  {
    return albumType;
  }


  /**
   * @return the images
   */
  public SpotifyImage[] getImages()
  {
    return images;
  }


  /**
   * @return the popularity
   */
  public Integer getPopularity()
  {
    return popularity;
  }


  /**
   * The date the album was first released.
   * 
   * @return the releaseDate
   */
  public String getReleaseDate()
  {
    return releaseDate;
  }


  /**
   * The precision with which release_date value is known.
   * Allowed values:"year", "month", "day"
   * 
   * @return the releaseDatePrecision
   */
  public String getReleaseDatePrecision()
  {
    return releaseDatePrecision;
  }


  /**
   * The number of tracks in the album.
   * 
   * @return the totalTracks
   */
  public int getTotalTracks()
  {
    return totalTracks;
  }


  /**
   * @param albumType the albumType to set
   */
  public void setAlbumType(
    String albumType)
  {
    this.albumType = albumType;
  }


  /**
   * @param images the images to set
   */
  public void setImages(
    SpotifyImage[] images)
  {
    this.images = images;
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
   * @param releaseDate the releaseDate to set
   */
  public void setReleaseDate(
    String releaseDate)
  {
    this.releaseDate = releaseDate;
  }


  /**
   * @param releaseDatePrecision the releaseDatePrecision to set
   */
  public void setReleaseDatePrecision(
    String releaseDatePrecision)
  {
    this.releaseDatePrecision = releaseDatePrecision;
  }


  /**
   * @param totalTracks the totalTracks to set
   */
  public void setTotalTracks(
    int totalTracks)
  {
    this.totalTracks = totalTracks;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(
    Object obj)
  {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    AbstractSpotifyAlbum<A> other = (AbstractSpotifyAlbum<A>)obj;
    return Objects.equals(albumType, other.albumType)
           //           && Objects.equals(releaseDate, other.releaseDate)
           //           && Objects.equals(releaseDatePrecision, other.releaseDatePrecision)
           && totalTracks == other.totalTracks;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result
             + Objects.hash(albumType, releaseDate, releaseDatePrecision, totalTracks);
    return result;
  }


  /**
   * @return the artists
   */
  public A[] getArtists()
  {
    return artists;
  }


  /**
   * @param artists the artists to set
   */
  public void setArtists(
    A[] artists)
  {
    this.artists = artists;
  }
}
