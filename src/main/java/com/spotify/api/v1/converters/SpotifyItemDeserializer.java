package com.spotify.api.v1.converters;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.spotify.api.v1.dto.SpotifyArtist;
import com.spotify.api.v1.dto.SpotifyImage;
import com.spotify.api.v1.dto.SpotifyItem;
import com.spotify.api.v1.dto.SpotifySimplifiedArtist;


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


  /**
   * @param artistsNode
   * @return
   * @throws IOException
   * @throws JacksonException
   */
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


  /**
   * @param imagesNode
   * @return
   * @throws IOException
   * @throws JacksonException
   */
  protected SpotifyImage[] deserializeImages(
    JsonNode imagesNode) throws IOException, JacksonException
  {
    List<SpotifyImage> imageList = new ArrayList<SpotifyImage>();
    SpotifyImage[] imageArray;
  
    for (final JsonNode imageNode : imagesNode)
    {
      SpotifyImage spotifyImage = new SpotifyImage();
  
      spotifyImage.setHeight(imageNode.get("height").asInt());
      spotifyImage.setUrl(imageNode.get("url").asText());
      spotifyImage.setWidth(imageNode.get("width").asInt());

      imageList.add(spotifyImage);
    }
    
    imageArray = new SpotifyImage[imageList.size()];
    imageArray = imageList.toArray(imageArray);
    
    return imageArray;
  }


  /**
   * @param artistsNode
   * @return
   * @throws IOException
   * @throws JacksonException
   */
  protected SpotifySimplifiedArtist[] deserializeSimplifiedArtists(
    JsonNode artistsNode) throws IOException, JacksonException
  {
    SpotifySimplifiedArtistDeserializer spotifyArtistDeserializer = new SpotifySimplifiedArtistDeserializer();
    List<SpotifySimplifiedArtist> artistList = new ArrayList<SpotifySimplifiedArtist>();
    SpotifySimplifiedArtist[] artistArray;
  
    for (final JsonNode artistNode : artistsNode)
    {
      SpotifySimplifiedArtist spotifyArtist = spotifyArtistDeserializer.deserialize(artistNode);
  
      artistList.add(spotifyArtist);
    }
  
    artistArray = new SpotifySimplifiedArtist[artistList.size()];
    artistArray = artistList.toArray(artistArray);
  
    return artistArray;
  }
}
