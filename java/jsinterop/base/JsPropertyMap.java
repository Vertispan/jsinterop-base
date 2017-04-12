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

import javaemul.internal.annotations.DoNotAutobox;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/** Provides abstraction of JavaScript objects as property maps. */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public interface JsPropertyMap<T> {

  /** Returns an empty object literal as {@code JsPropertyMap}. */
  @JsOverlay
  static JsPropertyMap<Object> of() {
    return InternalJsUtil.emptyObjectLiteral();
  }

  /** Returns an object literal as {@code JsPropertyMap} that has provided key-value pairs. */
  @JsOverlay
  static JsPropertyMap<Object> of(String k, @DoNotAutobox Object v) {
    JsPropertyMap<Object> map = of();
    map.set(k, v);
    return map;
  }

  /** Returns an object literal as {@code JsPropertyMap} that has provided key-value pairs. */
  @JsOverlay
  static JsPropertyMap<Object> of(
      String k1, @DoNotAutobox Object v1, String k2, @DoNotAutobox Object v2) {
    JsPropertyMap<Object> map = of();
    map.set(k1, v1);
    map.set(k2, v2);
    return map;
  }

  /** Returns an object literal as {@code JsPropertyMap} that has provided key-value pairs. */
  @JsOverlay
  static JsPropertyMap<Object> of(
      String k1,
      @DoNotAutobox Object v1,
      String k2,
      @DoNotAutobox Object v2,
      String k3,
      @DoNotAutobox Object v3) {
    JsPropertyMap<Object> map = of();
    map.set(k1, v1);
    map.set(k2, v2);
    map.set(k3, v3);
    return map;
  }

  /** Returns {@code JsPropertyMap} view of provided object. */
  @JsOverlay
  static JsPropertyMap<Object> of(Object obj) {
    return Js.uncheckedCast(obj);
  }

  @JsOverlay
  @SuppressWarnings("unchecked")
  default T get(String propertyName) {
    return (T) InternalJsUtil.get(this, propertyName);
  }

  @JsOverlay
  default Any getAny(String propertyName) {
    return (Any) InternalJsUtil.get(this, propertyName);
  }

  @JsOverlay
  default boolean has(String propertyName) {
    return InternalJsUtil.has(this, propertyName);
  }

  @JsOverlay
  default void delete(String propertyName) {
    InternalJsUtil.delete(this, propertyName);
  }

  @JsOverlay
  default void set(String propertyName, @DoNotAutobox T value) {
    InternalJsUtil.set(this, propertyName, value);
  }

  @JsOverlay
  default void forEach(JsForEachCallbackFn cb) {
    InternalJsUtil.forEach(this, cb);
  }
}
