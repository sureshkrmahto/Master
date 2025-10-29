package com.chain;

/**
 * OrcOfficer.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class OrcOfficer extends RequestHandler {

public OrcOfficer(RequestHandler handler) {
super(handler);
  }

@Override
public void handleRequest(Request req) {
if (RequestType.TORTURE_PRISONER == req.getRequestType()) {
printHandling(req);
req.markHandled();
    } else {
super.handleRequest(req);
    }
  }

@Override
public String toString() {
return "Orc officer";
  }

}
