package com.spotify.api.v1.converters;


import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.spotify.api.v1.dto.SpotifySimplifiedTrack;


public class SpotifySimplifiedTrackDeserializer extends SpotifyItemDeserializer<SpotifySimplifiedTrack>
{

  /* (non-Javadoc)
   * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
   */
  @Override
  public SpotifySimplifiedTrack deserialize(
    JsonParser parser,
    DeserializationContext context) throws IOException, JacksonException
  {
    JsonNode node = parser.getCodec().readTree(parser);

    return deserialize(node);
  }


  /**
   * @param node
   * @return
   * @throws JacksonException
   * @throws IOException
   */
  protected SpotifySimplifiedTrack deserialize(
    JsonNode node) throws JacksonException, IOException
  {
    SpotifySimplifiedTrack spotifyTrack = new SpotifySimplifiedTrack();
    JsonNode artistsNode = node.get("artists");

    if (artistsNode != null)
    {
      spotifyTrack.setArtists(deserializeSimplifiedArtists(artistsNode));
    }

    super.deserialize(node, spotifyTrack);

    spotifyTrack.setDiscNumber(node.get("disc_number").asInt(1));
    spotifyTrack.setDuration(node.get("duration_ms").asInt(0));
    spotifyTrack.setTrackNumber(node.get("track_number").asInt(0));

    return spotifyTrack;
  }

}
