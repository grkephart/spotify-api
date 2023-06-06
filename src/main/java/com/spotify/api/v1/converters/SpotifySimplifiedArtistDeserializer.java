/**
 * 
 */
package com.spotify.api.v1.converters;


import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.spotify.api.v1.dto.SpotifySimplifiedArtist;


/**
 * @author gary_kephart
 *
 */
public class SpotifySimplifiedArtistDeserializer extends SpotifyItemDeserializer<SpotifySimplifiedArtist>
{

  /* (non-Javadoc)
   * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
   */
  @Override
  public SpotifySimplifiedArtist deserialize(
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
  public SpotifySimplifiedArtist deserialize(
    JsonNode node) throws IOException, JacksonException
  {
    SpotifySimplifiedArtist spotifyArtist = new SpotifySimplifiedArtist();

    super.deserialize(node, spotifyArtist);
 
    return spotifyArtist;
  }

}
