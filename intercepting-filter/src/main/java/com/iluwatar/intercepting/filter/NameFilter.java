package com.iluwatar.intercepting.filter;

/**
 * Concrete implementation of filter. This filter checks if the input in the Name field is valid.
 * (alphanumeric)
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class NameFilter extends AbstractFilter {

@Override
public String execute(Order order) {
var result = super.execute(order);
var name = order.getName();
if (name == null || name.isEmpty() || name.matches(".*[^\\w|\\s]+.*")) {
return result + "Invalid name! ";
    } else {
return result;
    }
  }
}
