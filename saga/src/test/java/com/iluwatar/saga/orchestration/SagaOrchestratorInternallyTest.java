package com.iluwatar.saga.orchestration;

import static com.iluwatar.saga.orchestration.Saga.Result;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * test to test orchestration logic
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class SagaOrchestratorInternallyTest {

  private final List<String> records = new ArrayList<>();


/**

 * @author Suresh Mahto

 */
  @Test
  public void executeTest() {
    var sagaOrchestrator = new SagaOrchestrator(newSaga(), serviceDiscovery());
    var result = sagaOrchestrator.execute(1);
    Assert.assertEquals(result, Result.ROLLBACK);
    Assert.assertArrayEquals(
        records.toArray(new String[]{}),
        new String[]{"+1", "+2", "+3", "+4", "-4", "-3", "-2", "-1"});
  }

  private static Saga newSaga() {
    return Saga.create()
        .chapter("1")
        .chapter("2")
        .chapter("3")
        .chapter("4");
  }

  private ServiceDiscoveryService serviceDiscovery() {
    return new ServiceDiscoveryService()
        .discover(new Service1())
        .discover(new Service2())
        .discover(new Service3())
        .discover(new Service4());
  }

  class Service1 extends Service<Integer> {

    @Override
    public String getName() {
      return "1";
    }

    @Override
    public ChapterResult<Integer> process(Integer value) {
      records.add("+1");
      return ChapterResult.success(value);
    }

    @Override
    public ChapterResult<Integer> rollback(Integer value) {
      records.add("-1");
      return ChapterResult.success(value);
    }
  }

  class Service2 extends Service<Integer> {

    @Override
    public String getName() {
      return "2";
    }

    @Override
    public ChapterResult<Integer> process(Integer value) {
      records.add("+2");
      return ChapterResult.success(value);
    }

    @Override
    public ChapterResult<Integer> rollback(Integer value) {
      records.add("-2");
      return ChapterResult.success(value);
    }
  }

  class Service3 extends Service<Integer> {

    @Override
    public String getName() {
      return "3";
    }

    @Override
    public ChapterResult<Integer> process(Integer value) {
      records.add("+3");
      return ChapterResult.success(value);
    }

    @Override
    public ChapterResult<Integer> rollback(Integer value) {
      records.add("-3");
      return ChapterResult.success(value);
    }
  }

/**
 * @author Suresh Mahto
 */
  class Service4 extends Service<Integer> {

    @Override
    public String getName() {
      return "4";
    }

    @Override
    public ChapterResult<Integer> process(Integer value) {
      records.add("+4");
      return ChapterResult.failure(value);
    }

    @Override
    public ChapterResult<Integer> rollback(Integer value) {
      records.add("-4");
      return ChapterResult.success(value);
    }
  }
}