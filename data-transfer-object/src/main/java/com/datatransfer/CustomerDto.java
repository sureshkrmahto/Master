package com.datatransfer;

/**
 * {@link CustomerDto} is a data transfer object POJO. Instead of sending individual information to
 * client We can send related information together in POJO.
 *
 * <p>Dto will not have any business logic in it.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class CustomerDto {
private final String id;
private final String firstName;
private final String lastName;

  /**
   * Constructor.
   *
   * @param id        customer id
   * @param firstName customer first name
   * @param lastName  customer last name
 *  @author Suresh Mahto
   */
public CustomerDto(String id, String firstName, String lastName) {
this.id = id;
this.firstName = firstName;
this.lastName = lastName;
  }

public String getId() {
return id;
  }

public String getFirstName() {
return firstName;
  }

public String getLastName() {
return lastName;
  }
}
