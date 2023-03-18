package com.spotify.api.v1.converters;


import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.spotify.api.v1.dto.SpotifyTrack;


public class SpotifyTrackDeserializer extends SpotifyItemDeserializer<SpotifyTrack>
{

  /* (non-Javadoc)
   * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
   */
  @Override
  public SpotifyTrack deserialize(
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
  protected SpotifyTrack deserialize(
    JsonNode node) throws JacksonException, IOException
  {
    SpotifyTrack spotifyTrack = new SpotifyTrack();
    SpotifyAlbumDeserializer spotifyAlbumDeserializer = new SpotifyAlbumDeserializer();
    JsonNode albumNode = node.get("album");
    JsonNode artistsNode = node.get("artists");
    JsonNode popularityNode = node.get("popularity");
    String popularityStr = popularityNode == null ? null : popularityNode.asText();
    Integer popularity = popularityStr == null ? null : Integer.valueOf(popularityStr);

    if (albumNode != null)
    {
      spotifyTrack.setAlbum(spotifyAlbumDeserializer.deserialize(albumNode));
    }
    if (artistsNode != null)
    {
      spotifyTrack.setArtists(deserializeArtists(artistsNode));
    }

    super.deserialize(node, spotifyTrack);

    spotifyTrack.setDiscNumber(node.get("disc_number").asInt(1));
    spotifyTrack.setDuration(node.get("duration_ms").asInt(0));
    spotifyTrack.setPopularity(popularity);
    spotifyTrack.setTrackNumber(node.get("track_number").asInt(0));

    return spotifyTrack;
  }

}
