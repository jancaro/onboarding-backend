package com.pichincha.mvc.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/*
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)*/
public class ApplicationProperties {

  Header header;

  /*@Data
  @FieldDefaults(level = PRIVATE)*/
  public class Header {

    String channel;
    String medium;
  }
}
