package com.iluwatar.ambassador;

/**
 * Interface shared by ({@link RemoteService}) and ({@link ServiceAmbassador}).
 */
interface RemoteServiceInterface {

  long doRemoteFunction(int value);
}
