package com.iluwatar.typeobject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Hashtable;
import org.junit.jupiter.api.Test;

/**
 * The CellPoolTest class tests the methods in the {@link CellPool} class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class CellPoolTest {

@Test
void assignRandomCandyTypesTest() {
var cp = new CellPool(10);
var ht = new Hashtable<String, Boolean>();
var parentTypes = 0;
for (var i = 0; i < cp.randomCode.length; i++) {
ht.putIfAbsent(cp.randomCode[i].name, true);
if (cp.randomCode[i].name.equals("fruit") || cp.randomCode[i].name.equals("candy")) {
parentTypes++;
      }
    }
assertTrue(ht.size() == 5 && parentTypes == 0);
  }

}
