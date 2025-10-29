package com.iluwatar.typeobject;

/**
 * The Candy class has a field type, which represents the 'type' of candy. The objects are created
 * by parsing the candy.json file.
 */
public class Candy {

  enum Type {
    CRUSHABLE_CANDY,
    REWARD_FRUIT
  }

  String name;
  Candy parent;
  String parentName;
  private int points;
  private final Type type;

  Candy(String name, String parentName, Type type, int points) {
    this.name = name;
    this.parent = null;
    this.type = type;
    this.points = points;
    this.parentName = parentName;
  }

  int getPoints() {
    return this.points;
  }

  void setPoints(int a) {
    this.points = a;
  }

  Type getType() {
    return this.type;
  }
}
