/**
 * 
 */
package com.spotify.api.v1.dto;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * @author gary_kephart
 *
 */
public class SpotifyItem
{
  /**
   * @param <SI>
   * @param spotifyItems
   * @return
   */
  public static <SI extends SpotifyItem> Map<String, SI> toMap(
    SI[] spotifyItems)
  {
    Map<String, SI> spotifyItemIds = new HashMap<>();

    for (SI spotifyItem : spotifyItems)
    {
      spotifyItemIds.put(spotifyItem.getId(), spotifyItem);
    }

    return spotifyItemIds;
  }
  
  
  /**
   * @param <SI>
   * @param spotifyItems
   * @return
   */
  public static <SI extends SpotifyItem> Map<String, SI> toMap(
    Collection<SI> spotifyItems)
  {
    Map<String, SI> spotifyItemIds = new HashMap<>();

    for (SI spotifyItem : spotifyItems)
    {
      spotifyItemIds.put(spotifyItem.getId(), spotifyItem);
    }

    return spotifyItemIds;
  }

  private String  href;
  private String  id;
  private boolean imported;
  private String  name;
  private String  type;
  private String  uri;

  /**
   * 
   */
  public SpotifyItem()
  {

  }


  /**
   * @param id
   */
  public SpotifyItem(String id)
  {
    this.id = id;
  }


  /**
   * @param id
   * @param name
   * @param href
   * @param type
   * @param uri
   */
  public SpotifyItem(String id, String name, String href, String type, String uri)
  {
    this.id = id;
    this.name = name;
    this.href = href;
    this.type = type;
    this.uri = uri;
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
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;

    SpotifyItem other = (SpotifyItem)obj;

    return Objects.equals(href, other.href) //
           && Objects.equals(id, other.id)//
           && Objects.equals(name, other.name) //
           && Objects.equals(type, other.type)//
           && Objects.equals(uri, other.uri);
  }


  /**
   * A link to the Web API endpoint providing full details of the album/artist/track.
   * 
   * @return the href
   */
  public String getHref()
  {
    return href;
  }


  public String getId()
  {
    return this.id;
  }


  /**
   * The name of the album/artist/track. In case of an album takedown, the value may be an empty string.
   * 
   * @return the name
   */
  public String getName()
  {
    return name;
  }


  /**
   * The object type.
   * Allowed value:"album", "artist", "track"
   * 
   * @return the type
   */
  public String getType()
  {
    return type;
  }


  /**
   * The Spotify URI for the album.
   * 
   * @return the uri
   */
  public String getUri()
  {
    return uri;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(href, id, name, type, uri);
    return result;
  }


  /**
   * Useful when importing Spotify items into your system.
   * 
   * @return the imported
   */
  public boolean isImported()
  {
    return imported;
  }


  /**
   * @param href the href to set
   */
  public void setHref(
    String href)
  {
    this.href = href;
  }


  /* (non-Javadoc)
   * @see com.dr_dee_sw.commons.dto.UniqueObject#setId(java.io.Serializable)
   */
  public void setId(
    String id)
  {
    this.id = id;
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
   * @param name the name to set
   */
  public void setName(
    String name)
  {
    this.name = name;
  }


  /**
   * @param type the type to set
   */
  public void setType(
    String type)
  {
    this.type = type;
  }


  /**
   * @param uri the uri to set
   */
  public void setUri(
    String uri)
  {
    this.uri = uri;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    return "{class:" + this.getClass().getSimpleName() + ",id:" + this.id + "}";
  }

}
