package com.iluwatar.chain;

/**
 * OrcCommander.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class OrcCommander extends RequestHandler {

  public OrcCommander(RequestHandler handler) {
    super(handler);
  }

  @Override
  public void handleRequest(Request req) {
    if (RequestType.DEFEND_CASTLE == req.getRequestType()) {
      printHandling(req);
      req.markHandled();
    } else {
      super.handleRequest(req);
    }
  }

  @Override
  public String toString() {
    return "Orc commander";
  }
}
