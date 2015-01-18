/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ratpack.sse.internal;

import ratpack.func.Function;
import ratpack.sse.Event;

public class DefaultEvent<T> implements Event<T> {

  private final T item;

  private String id;
  private String event;
  private String data;

  public DefaultEvent(T item) {
    this.item = item;
  }

  public DefaultEvent() {
    this(null);
  }

  @Override
  public T getItem() {
    return item;
  }

  @Override
  public Event<T> id(Function<? super T, String> id) throws Exception {
    id(id.apply(item));
    return this;
  }

  @Override
  public Event<T> id(String id) {
    this.id = id;
    return this;
  }

  @Override
  public Event<T> event(Function<? super T, String> id) throws Exception {
    event(id.apply(item));
    return this;
  }

  @Override
  public Event<T> event(String event) {
    this.event = event;
    return this;
  }

  @Override
  public Event<T> data(Function<? super T, String> id) throws Exception {
    data(id.apply(item));
    return this;
  }

  @Override
  public Event<T> data(String data) {
    this.data = data;
    return this;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getEvent() {
    return event;
  }

  @Override
  public String getData() {
    return data;
  }
}
