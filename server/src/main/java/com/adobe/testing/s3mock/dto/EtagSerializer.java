/*
 *  Copyright 2017-2022 Adobe.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.adobe.testing.s3mock.dto;

import static org.apache.commons.lang3.StringUtils.endsWith;
import static org.apache.commons.lang3.StringUtils.startsWith;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**
 * ETag values are wrapped in quotation marks when serialized.
 * Example: {@code <ETag>"etag-value"</ETag>}
 * See https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/ETag
 */
public class EtagSerializer extends JsonSerializer<String> {

  @Override
  public void serialize(String s, JsonGenerator jsonGenerator,
      SerializerProvider serializerProvider) throws IOException {
    String toSerialize = s;
    if (!startsWith(s, "\"") && !endsWith(s, "\"")) {
      toSerialize = String.format("\"%s\"", s);
    }
    jsonGenerator.writeString(toSerialize);
  }
}
