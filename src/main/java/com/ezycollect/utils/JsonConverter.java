package com.ezycollect.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonConverter {
  private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

  public static String toJson(Object obj) throws JsonProcessingException {
    return objectMapper.writeValueAsString(obj);
  }

  public static <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
    return objectMapper.readValue(json, clazz);
  }
}
