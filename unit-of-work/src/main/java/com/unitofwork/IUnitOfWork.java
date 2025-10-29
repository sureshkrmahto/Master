package com.unitofwork;

/**
 * UnitOfWork interface.
 *
 * @param <T> Any generic entity
 *  @author Suresh Mahto
 */
public interface IUnitOfWork<T> {

  /**
   * Any register new operation occurring on UnitOfWork is only going to be performed on commit.
*/
void registerNew(T entity);

  /**
   * Any register modify operation occurring on UnitOfWork is only going to be performed on commit.
*/
void registerModified(T entity);

  /**
   * Any register delete operation occurring on UnitOfWork is only going to be performed on commit.
*/
void registerDeleted(T entity);

  /**
   * All UnitOfWork operations batched together executed in commit only.
*/
void commit();

}