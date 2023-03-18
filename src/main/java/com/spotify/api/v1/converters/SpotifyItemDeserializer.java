package com.spotify.api.v1.converters;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.spotify.api.v1.dto.SpotifyArtist;
import com.spotify.api.v1.dto.SpotifyItem;


public abstract class SpotifyItemDeserializer<I extends SpotifyItem> extends JsonDeserializer<I>
{
  /**
   * 
   */
  protected SpotifyItemDeserializer()
  {

  }


  /**
   * @param node
   * @param spotifyItem
   */
  protected void deserialize(
    JsonNode node,
    I spotifyItem)
  {
    spotifyItem.setHref(node.get("href").asText());
    spotifyItem.setId(node.get("id").asText());
    spotifyItem.setName(node.get("name").asText());
    spotifyItem.setType(node.get("type").asText());
    spotifyItem.setUri(node.get("uri").asText());
  }


  protected SpotifyArtist[] deserializeArtists(
    JsonNode artistsNode) throws IOException, JacksonException
  {
    SpotifyArtistDeserializer spotifyArtistDeserializer = new SpotifyArtistDeserializer();
    List<SpotifyArtist> artistList = new ArrayList<SpotifyArtist>();
    SpotifyArtist[] artistArray;
  
    for (final JsonNode artistNode : artistsNode)
    {
      SpotifyArtist spotifyArtist = spotifyArtistDeserializer.deserialize(artistNode);
  
      artistList.add(spotifyArtist);
    }
    
    artistArray = new SpotifyArtist[artistList.size()];
    artistArray = artistList.toArray(artistArray);
    
    return artistArray;
  }
}
