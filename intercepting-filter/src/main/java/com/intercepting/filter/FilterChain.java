package com.intercepting.filter;


/**
 * Filter Chain carries multiple filters and help to execute them in defined order on target.
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class FilterChain {

private Filter chain;


  /**
   * Adds filter.
 *  @author Suresh Mahto
   */
public void addFilter(Filter filter) {
if (chain == null) {
chain = filter;
    } else {
chain.getLast().setNext(filter);
    }
  }

  /**
   * Execute filter chain.
 *  @author Suresh Mahto
   */
public String execute(Order order) {
if (chain != null) {
return chain.execute(order);
    } else {
return "RUNNING...";
    }
  }
}
