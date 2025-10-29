package com.iluwatar.intercepting.filter;

/**
 * Concrete implementation of filter This filter checks for the contact field in which it checks if
 * the input consist of numbers and it also checks if the input follows the length constraint (11
 * digits).
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class ContactFilter extends AbstractFilter {

@Override
public String execute(Order order) {
var result = super.execute(order);
var contactNumber = order.getContactNumber();
if (contactNumber == null || contactNumber.isEmpty()
        || contactNumber.matches(".*[^\\d]+.*")
        || contactNumber.length() != 11) {
return result + "Invalid contact number! ";
    } else {
return result;
    }
  }
}
