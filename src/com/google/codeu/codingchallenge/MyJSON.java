// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.codeu.codingchallenge;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

final class MyJSON implements JSON {

  //holds can hold either a pairing of strings or a string and a JSON object
  Hashtable<String, Object> pairings = new Hashtable<>();

  @Override
  public JSON getObject(String name) {
    if(pairings.containsKey(name) && pairings.get(name) instanceof JSON)
      return (JSON)pairings.get(name);
    return null;
  }

  @Override
  public JSON setObject(String name, JSON value) {
    pairings.put(name,value);
    return this;
  }

  @Override
  public String getString(String name) {
    if(pairings.containsKey(name) && pairings.get(name) instanceof String)
      return (String)pairings.get(name);
    return null;
  }

  @Override
  public JSON setString(String name, String value) {
    pairings.put(name,value);
    return this;
  }

  @Override
  public void getObjects(Collection<String> names) {
    String key;
    Enumeration e = pairings.keys();
    while(e.hasMoreElements()) {
      key = (String)e.nextElement();
      if(pairings.get(key) instanceof JSON)
        names.add(key);

    }

  }

  @Override
  public void getStrings(Collection<String> names) {
    String key;
    Enumeration e = pairings.keys();
    while(e.hasMoreElements()) {
      key = (String)e.nextElement();
      if(pairings.get(key) instanceof String)
        names.add(key);

    }
  }
}
