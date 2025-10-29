package com.chain;

/**
 * OrcKing makes requests that are handled by the chain.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class OrcKing {

private RequestHandler chain;

public OrcKing() {
buildChain();
  }

private void buildChain() {
chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
  }

public void makeRequest(Request req) {
chain.handleRequest(req);
  }

}
