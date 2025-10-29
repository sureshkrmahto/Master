package com.iluwatar.intercepting.filter;

/**
 * Concrete implementation of filter This checks for the deposit code.
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class DepositFilter extends AbstractFilter {

@Override
public String execute(Order order) {
var result = super.execute(order);
var depositNumber = order.getDepositNumber();
if (depositNumber == null || depositNumber.isEmpty()) {
return result + "Invalid deposit number! ";
    } else {
return result;
    }
  }
}
