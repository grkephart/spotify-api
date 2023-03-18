package com.spotify.api.v1.converters;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.spotify.api.v1.dto.SpotifyAccessToken;

public class SpotifyAccessTokenDeserializer extends JsonDeserializer<SpotifyAccessToken>
{

  @Override
  public SpotifyAccessToken deserialize(
    JsonParser parser,
    DeserializationContext context) throws IOException, JacksonException
  {
    JsonNode node = parser.getCodec().readTree(parser);
    String accessToken = node.get("access_token").asText();
    String tokenType = node.get("token_type").asText();
    int expiresIn = node.get("expires_in").asInt();

    return new SpotifyAccessToken(accessToken, tokenType, expiresIn);
  }

}
