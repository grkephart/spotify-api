package com.spotify.api.v1.converters;


import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.spotify.api.v1.dto.SpotifySimplifiedAlbum;


public class SpotifySimplifiedAlbumDeserializer
    extends SpotifyItemDeserializer<SpotifySimplifiedAlbum>
{

  /**  
   * @param node
   * @return
   * @throws IOException 
   * @throws JacksonException 
   */
  public SpotifySimplifiedAlbum deserialize(
    JsonNode node) throws JacksonException, IOException
  {
    SpotifySimplifiedAlbum spotifyAlbum = new SpotifySimplifiedAlbum();
    JsonNode artistsNode = node.get("artists");
    JsonNode imagesNode = node.get("images");
    JsonNode popularityNode = node.get("popularity");

    if (artistsNode != null)
    {
      spotifyAlbum.setArtists(deserializeSimplifiedArtists(artistsNode));
    }

    if (imagesNode != null)
    {
      spotifyAlbum.setImages(deserializeImages(imagesNode));
    }

    super.deserialize(node, spotifyAlbum);

    spotifyAlbum.setAlbumType(node.get("album_type").asText());
    spotifyAlbum.setPopularity(popularityNode == null ? null : popularityNode.asInt());
    spotifyAlbum.setReleaseDate(node.get("release_date").asText());
    spotifyAlbum.setReleaseDatePrecision(node.get("release_date_precision").asText());
    spotifyAlbum.setTotalTracks(node.get("total_tracks").asInt(0));

    return spotifyAlbum;
  }


  /* (non-Javadoc)
   * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
   */
  @Override
  public SpotifySimplifiedAlbum deserialize(
    JsonParser parser,
    DeserializationContext context) throws IOException, JacksonException
  {
    JsonNode node = parser.getCodec().readTree(parser);

    return deserialize(node);
  }

}
