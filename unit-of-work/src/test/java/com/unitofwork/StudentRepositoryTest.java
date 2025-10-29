package com.unitofwork;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * tests {@link StudentRepository}
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentRepositoryTest {
private final Student student1 = new Student(1, "Ram", "street 9, cupertino");
private final Student student2 = new Student(1, "Sham", "Z bridge, pune");

private Map<String, List<Student>> context;
@Mock
private StudentDatabase studentDatabase;
private StudentRepository studentRepository;

@Before
public void setUp() {
context = new HashMap<>();
studentRepository = new StudentRepository(context, studentDatabase);
  }

@Test
public void shouldSaveNewStudentWithoutWritingToDb() {
studentRepository.registerNew(student1);
studentRepository.registerNew(student2);

assertEquals(2, context.get(UnitActions.INSERT.getActionValue()).size());
verifyNoMoreInteractions(studentDatabase);
  }

@Test
public void shouldSaveDeletedStudentWithoutWritingToDb() {
studentRepository.registerDeleted(student1);
studentRepository.registerDeleted(student2);

assertEquals(2, context.get(UnitActions.DELETE.getActionValue()).size());
verifyNoMoreInteractions(studentDatabase);
  }

@Test
public void shouldSaveModifiedStudentWithoutWritingToDb() {
studentRepository.registerModified(student1);
studentRepository.registerModified(student2);

assertEquals(2, context.get(UnitActions.MODIFY.getActionValue()).size());
verifyNoMoreInteractions(studentDatabase);
  }

@Test
public void shouldSaveAllLocalChangesToDb() {
context.put(UnitActions.INSERT.getActionValue(), List.of(student1));
context.put(UnitActions.MODIFY.getActionValue(), List.of(student1));
context.put(UnitActions.DELETE.getActionValue(), List.of(student1));

studentRepository.commit();

verify(studentDatabase, times(1)).insert(student1);
verify(studentDatabase, times(1)).modify(student1);
verify(studentDatabase, times(1)).delete(student1);
  }

@Test
public void shouldNotWriteToDbIfContextIsNull() {
var studentRepository = new StudentRepository(null, studentDatabase);

studentRepository.commit();

verifyNoMoreInteractions(studentDatabase);
  }

@Test
public void shouldNotWriteToDbIfNothingToCommit() {
var studentRepository = new StudentRepository(new HashMap<>(), studentDatabase);

studentRepository.commit();

verifyZeroInteractions(studentDatabase);
  }

@Test
public void shouldNotInsertToDbIfNoRegisteredStudentsToBeCommitted() {
context.put(UnitActions.MODIFY.getActionValue(), List.of(student1));
context.put(UnitActions.DELETE.getActionValue(), List.of(student1));

studentRepository.commit();

verify(studentDatabase, never()).insert(student1);
  }

@Test
public void shouldNotModifyToDbIfNotRegisteredStudentsToBeCommitted() {
context.put(UnitActions.INSERT.getActionValue(), List.of(student1));
context.put(UnitActions.DELETE.getActionValue(), List.of(student1));

studentRepository.commit();

verify(studentDatabase, never()).modify(student1);
  }

@Test
public void shouldNotDeleteFromDbIfNotRegisteredStudentsToBeCommitted() {
context.put(UnitActions.INSERT.getActionValue(), List.of(student1));
context.put(UnitActions.MODIFY.getActionValue(), List.of(student1));

studentRepository.commit();

verify(studentDatabase, never()).delete(student1);
  }
}