package com.spotify.api.v1.converters;


import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.spotify.api.v1.dto.SpotifyAlbum;


public class SpotifyAlbumDeserializer extends SpotifyItemDeserializer<SpotifyAlbum>
{

  @Override
  public SpotifyAlbum deserialize(
    JsonParser parser,
    DeserializationContext context) throws IOException, JacksonException
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
  public SpotifyAlbum deserialize(
    JsonNode node) throws JacksonException, IOException
  {
    SpotifyAlbum spotifyAlbum = new SpotifyAlbum();
    JsonNode artistsNode = node.get("artists");

    if (artistsNode != null)
    {
      spotifyAlbum.setArtists(deserializeArtists(artistsNode));
    }

    super.deserialize(node, spotifyAlbum);

    spotifyAlbum.setAlbumType(node.get("album_type").asText());
    spotifyAlbum.setReleaseDate(node.get("release_date").asText());
    spotifyAlbum.setReleaseDatePrecision(node.get("release_date_precision").asText());
    spotifyAlbum.setTotalTracks(node.get("total_tracks").asInt(0));

    return spotifyAlbum;
  }

}
