package com.iluwatar.intercepting.filter;

/**
 * Concrete implementation of filter. This checks for the order field.
 *
 * @author Suresh Mahto
 */
/**
 * @author Suresh Mahto
 */
public class OrderFilter extends AbstractFilter {

  @Override
  public String execute(Order order) {
    var result = super.execute(order);
    var orderItem = order.getOrderItem();
    if (orderItem == null || orderItem.isEmpty()) {
      return result + "Invalid order! ";
    } else {
      return result;
    }
  }
}
