package com.unitofwork;

/**
 * {@link Student} is an entity.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Student {
private final Integer id;
private final String name;
private final String address;

  /**
   * Constructor.
   *
   * @param id      student unique id
   * @param name    name of student
   * @param address address of student
 *  @author Suresh Mahto
   */
public Student(Integer id, String name, String address) {
this.id = id;
this.name = name;
this.address = address;
  }

public String getName() {
return name;
  }

public Integer getId() {
return id;
  }

public String getAddress() {
return address;
  }
}
