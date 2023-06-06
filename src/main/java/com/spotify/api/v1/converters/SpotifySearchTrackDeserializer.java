package com.spotify.api.v1.converters;


import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.spotify.api.v1.dto.SpotifySearchTrack;


public class SpotifySearchTrackDeserializer extends SpotifyItemDeserializer<SpotifySearchTrack>
{

  /* (non-Javadoc)
   * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
   */
  @Override
  public SpotifySearchTrack deserialize(
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
  protected SpotifySearchTrack deserialize(
    JsonNode node) throws JacksonException, IOException
  {
    SpotifySearchTrack spotifySearchTrack = new SpotifySearchTrack();
    SpotifySimplifiedAlbumDeserializer spotifyAlbumDeserializer = new SpotifySimplifiedAlbumDeserializer();
    JsonNode albumNode = node.get("album");
    JsonNode artistsNode = node.get("artists");
    JsonNode popularityNode = node.get("popularity");
    String popularityStr = popularityNode == null ? null : popularityNode.asText();
    Integer popularity = popularityStr == null ? null : Integer.valueOf(popularityStr);

    if (albumNode != null)
    {
      spotifySearchTrack.setAlbum(spotifyAlbumDeserializer.deserialize(albumNode));
    }
    if (artistsNode != null)
    {
      spotifySearchTrack.setArtists(deserializeArtists(artistsNode));
    }

    super.deserialize(node, spotifySearchTrack);

    spotifySearchTrack.setDiscNumber(node.get("disc_number").asInt(1));
    spotifySearchTrack.setDuration(node.get("duration_ms").asInt(0));
    spotifySearchTrack.setPopularity(popularity);
    spotifySearchTrack.setTrackNumber(node.get("track_number").asInt(0));

    return spotifySearchTrack;
  }

}
