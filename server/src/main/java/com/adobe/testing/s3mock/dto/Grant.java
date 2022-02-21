package com.adobe.testing.s3mock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Grant")
public class Grant {

  @JsonProperty("Grantee")
  private Grantee grantee;

  @JsonProperty("Permission")
  private Permission permission;


}
