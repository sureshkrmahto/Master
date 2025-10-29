package com.iluwatar.saga.choreography;


/**
 * Class representing a service to book a hotel.
 

 * @author Suresh Mahto


 */
/**
 * @author Suresh Mahto
 */
public class HotelBookingService extends Service {
  public HotelBookingService(ServiceDiscoveryService service) {
    super(service);
  }

  @Override
  public String getName() {
    return "booking a Hotel";
  }


}
