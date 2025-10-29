package com.iluwatar.intercepting.filter;

/**
 * Concrete implementation of filter This filter is responsible for checking/filtering the input in
 * the address field.
 *
 * @author Suresh Mahto
 */
/**
 * @author Suresh Mahto
 */
public class AddressFilter extends AbstractFilter {

  @Override
  public String execute(Order order) {
    var result = super.execute(order);
    if (order.getAddress() == null || order.getAddress().isEmpty()) {
      return result + "Invalid address! ";
    } else {
      return result;
    }
  }
}
