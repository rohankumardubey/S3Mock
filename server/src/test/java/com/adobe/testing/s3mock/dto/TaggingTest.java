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

import static com.adobe.testing.s3mock.dto.DtoTestUtil.deserialize;
import static com.adobe.testing.s3mock.dto.DtoTestUtil.serializeAndAssert;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class TaggingTest {

  @Test
  void testSerialization(TestInfo testInfo) throws IOException {
    Tagging iut = new Tagging();
    iut.setTagSet(Arrays.asList(createTag(0), createTag(1)));
    serializeAndAssert(iut, testInfo);
  }

  @Test
  void testDeserialization(TestInfo testInfo) throws IOException {
    Tagging iut = deserialize(Tagging.class, testInfo);
    assertThat(iut.getTagSet()).hasSize(2);

    Tag tag0 = iut.getTagSet().get(0);
    assertThat(tag0.getKey()).isEqualTo("key0");
    assertThat(tag0.getValue()).isEqualTo("val0");

    Tag tag1 = iut.getTagSet().get(1);
    assertThat(tag1.getKey()).isEqualTo("key1");
    assertThat(tag1.getValue()).isEqualTo("val1");
  }

  private static Tag createTag(int counter) {
    Tag tag = new Tag();
    tag.setKey("key" + counter);
    tag.setValue("val" + counter);
    return tag;
  }
}
