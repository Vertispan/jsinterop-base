/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package jsinterop.base;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/** Place holder fot ObjectLike interface. Complete implementation will be provided later. */
@JsType(isNative = true, name = "IObject", namespace = JsPackage.GLOBAL)
public interface ObjectLike<T> {
  @JsOverlay
  default T get(String propertyName) {
    return JsObjects.get(this, propertyName);
  }

  @JsOverlay
  default void set(String propertyName, T value) {
    JsObjects.set(this, propertyName, value);
  }
}