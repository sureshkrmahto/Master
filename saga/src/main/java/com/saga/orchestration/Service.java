package com.saga.orchestration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common abstraction class representing services. implementing a general contract @see {@link
 * OrchestrationChapter}
 *
 * @param <K> type of incoming param
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class Service<K> implements OrchestrationChapter<K> {
protected static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

@Override
public abstract String getName();


@Override
public ChapterResult<K> process(K value) {
LOGGER.info("The chapter '{}' has been started. "
            + "The data {} has been stored or calculated successfully",
getName(), value);
return ChapterResult.success(value);
  }

@Override
public ChapterResult<K> rollback(K value) {
LOGGER.info("The Rollback for a chapter '{}' has been started. "
            + "The data {} has been rollbacked successfully",
getName(), value);
return ChapterResult.success(value);
  }


}
