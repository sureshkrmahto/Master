package com.commander;

import com.commander.employeehandle.EmployeeDatabase;
import com.commander.employeehandle.EmployeeHandle;
import com.commander.exceptions.DatabaseUnavailableException;
import com.commander.exceptions.ItemUnavailableException;
import com.commander.messagingservice.MessagingDatabase;
import com.commander.messagingservice.MessagingService;
import com.commander.paymentservice.PaymentDatabase;
import com.commander.paymentservice.PaymentService;
import com.commander.queue.QueueDatabase;
import com.commander.shippingservice.ShippingDatabase;
import com.commander.shippingservice.ShippingService;

/**
 * AppEmployeeDbFailCases class looks at possible cases when Employee handle service is
 * available/unavailable.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class AppEmployeeDbFailCases {
private final int numOfRetries = 3;
private final long retryDuration = 30000;
private final long queueTime = 240000; //4 mins
private final long queueTaskTime = 60000; //1 min
private final long paymentTime = 120000; //2 mins
private final long messageTime = 150000; //2.5 mins
private final long employeeTime = 240000; //4 mins

void employeeDatabaseUnavailableCase() throws Exception {
var ps = new PaymentService(new PaymentDatabase(), new DatabaseUnavailableException(),
new DatabaseUnavailableException(), new DatabaseUnavailableException(),
new DatabaseUnavailableException(), new DatabaseUnavailableException(),
new DatabaseUnavailableException());
var ss = new ShippingService(new ShippingDatabase());
var ms = new MessagingService(new MessagingDatabase());
var eh = new EmployeeHandle(new EmployeeDatabase(), new DatabaseUnavailableException(),
new DatabaseUnavailableException(), new DatabaseUnavailableException(),
new DatabaseUnavailableException(), new DatabaseUnavailableException(),
new DatabaseUnavailableException());
var qdb =
new QueueDatabase(new DatabaseUnavailableException(), new DatabaseUnavailableException(),
new DatabaseUnavailableException(), new DatabaseUnavailableException(),
new DatabaseUnavailableException(), new DatabaseUnavailableException());
var c = new Commander(eh, ps, ss, ms, qdb, numOfRetries, retryDuration,
queueTime, queueTaskTime, paymentTime, messageTime, employeeTime);
var user = new User("Jim", "ABCD");
var order = new Order(user, "book", 10f);
c.placeOrder(order);
  }

void employeeDbSuccessCase() throws Exception {
var ps = new PaymentService(new PaymentDatabase());
var ss = new ShippingService(new ShippingDatabase(), new ItemUnavailableException());
var ms = new MessagingService(new MessagingDatabase());
var eh = new EmployeeHandle(new EmployeeDatabase(), new DatabaseUnavailableException(),
new DatabaseUnavailableException());
var qdb = new QueueDatabase();
var c = new Commander(eh, ps, ss, ms, qdb, numOfRetries, retryDuration,
queueTime, queueTaskTime, paymentTime, messageTime, employeeTime);
var user = new User("Jim", "ABCD");
var order = new Order(user, "book", 10f);
c.placeOrder(order);
  }

  /**
   * Program entry point.
   *
   * @param args command line args
   */

public static void main(String[] args) throws Exception {
var aefc = new AppEmployeeDbFailCases();
    //aefc.employeeDatabaseUnavailableCase();
aefc.employeeDbSuccessCase();
  }
}
