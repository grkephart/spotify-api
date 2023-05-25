/**
 * 
 */
package com.spotify.api.v1.dto;


import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spotify.api.v1.converters.SpotifyAlbumDeserializer;


/**
 * @author gary_kephart
 *
 */
@JsonDeserialize(using = SpotifyAlbumDeserializer.class)
public class SpotifyAlbum extends SpotifyItem
{
  public static final String ALBUM_TYPE       = "album";
  public static final String COMPILATION_TYPE = "compilation";
  public static final String SINGLE_TYPE      = "single";
  private String             albumType;
  private SpotifyArtist[]    artists;
  private SpotifyImage[]     images;
  private boolean            imported;
  private Integer            popularity;
  private String             releaseDate;
  private String             releaseDatePrecision;
  private int                totalTracks;

  /**
   * 
   */
  public SpotifyAlbum()
  {

  }


  /**
   * @param name
   * @param albumType
   * @param artists
   */
  public SpotifyAlbum(String id, String name, String href, String type, String uri,
                      String albumType, SpotifyArtist... artists)
  {
    super(id, name, href, type, uri);
    this.artists = artists;
    this.albumType = albumType;
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
    SpotifyAlbum other = (SpotifyAlbum)obj;
    return Objects.equals(albumType, other.albumType)
           //           && Objects.equals(releaseDate, other.releaseDate)
           //           && Objects.equals(releaseDatePrecision, other.releaseDatePrecision)
           && totalTracks == other.totalTracks;
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
   * @return the artists
   */
  public SpotifyArtist[] getArtists()
  {
    return artists;
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
   * @return the imported
   */
  public boolean isImported()
  {
    return imported;
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
   * @param artists the artists to set
   */
  public void setArtists(
    SpotifyArtist[] artists)
  {
    this.artists = artists;
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
   * @param imported the imported to set
   */
  public void setImported(
    boolean imported)
  {
    this.imported = imported;
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
}
