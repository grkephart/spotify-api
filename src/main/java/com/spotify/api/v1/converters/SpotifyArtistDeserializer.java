/**
 * 
 */
package com.spotify.api.v1.converters;


import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.spotify.api.v1.dto.SpotifyArtist;


/**
 * @author gary_kephart
 *
 */
public class SpotifyArtistDeserializer extends SpotifyItemDeserializer<SpotifyArtist>
{

  /* (non-Javadoc)
   * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
   */
  @Override
  public SpotifyArtist deserialize(
    JsonParser parser,
    DeserializationContext arg1) throws IOException, JacksonException
  {
    JsonNode node = parser.getCodec().readTree(parser);

    return deserialize(node);
  }


  /**
   * @param node
   * @return
   * @throws IOException
   * @throws JacksonException
   */
  public SpotifyArtist deserialize(
    JsonNode node) throws IOException, JacksonException
  {
    SpotifyArtist spotifyArtist = new SpotifyArtist();
    JsonNode imagesNode = node.get("images");
    JsonNode popularityNode = node.get("popularity"); // will be null in track search response: track/(simplified)album/(simplified)artists

    super.deserialize(node, spotifyArtist);

    if (imagesNode != null)
    {
      spotifyArtist.setImages(deserializeImages(imagesNode));
    }

    spotifyArtist.setPopularity(popularityNode == null ? null : popularityNode.asInt());

    return spotifyArtist;
  }

}
