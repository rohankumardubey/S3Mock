package com.adobe.testing.s3mock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;

@JsonRootName("AccessControlPolicy")
public class AccessControlPolicy {
  @JsonProperty("Owner")
  private Owner owner;

  @JsonProperty("AccessControlList")
  private List<Grant> accessControlList;

}
