package com.iluwatar.unitofwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link StudentRepository} Student database repository. supports unit of work for student data.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class StudentRepository implements IUnitOfWork<Student> {
private static final Logger LOGGER = LoggerFactory.getLogger(StudentRepository.class);

private final Map<String, List<Student>> context;
private final StudentDatabase studentDatabase;

  /**
   * Constructor.
   *
   * @param context         set of operations to be perform during commit.
   * @param studentDatabase Database for student records.
 *  @author Suresh Mahto
   */
public StudentRepository(Map<String, List<Student>> context, StudentDatabase studentDatabase) {
this.context = context;
this.studentDatabase = studentDatabase;
  }

@Override
public void registerNew(Student student) {
LOGGER.info("Registering {} for insert in context.", student.getName());
register(student, UnitActions.INSERT.getActionValue());
  }

@Override
public void registerModified(Student student) {
LOGGER.info("Registering {} for modify in context.", student.getName());
register(student, UnitActions.MODIFY.getActionValue());

  }

@Override
public void registerDeleted(Student student) {
LOGGER.info("Registering {} for delete in context.", student.getName());
register(student, UnitActions.DELETE.getActionValue());
  }

private void register(Student student, String operation) {
var studentsToOperate = context.get(operation);
if (studentsToOperate == null) {
studentsToOperate = new ArrayList<>();
    }
studentsToOperate.add(student);
context.put(operation, studentsToOperate);
  }

  /**
   * All UnitOfWork operations are batched and executed together on commit only.
 *  @author Suresh Mahto
   */
  @Override
public void commit() {
if (context == null || context.size() == 0) {
return;
    }
LOGGER.info("Commit started");
if (context.containsKey(UnitActions.INSERT.getActionValue())) {
commitInsert();
    }

if (context.containsKey(UnitActions.MODIFY.getActionValue())) {
commitModify();
    }
if (context.containsKey(UnitActions.DELETE.getActionValue())) {
commitDelete();
    }
LOGGER.info("Commit finished.");
  }

private void commitInsert() {
var studentsToBeInserted = context.get(UnitActions.INSERT.getActionValue());
for (var student : studentsToBeInserted) {
LOGGER.info("Saving {} to database.", student.getName());
studentDatabase.insert(student);
    }
  }

private void commitModify() {
var modifiedStudents = context.get(UnitActions.MODIFY.getActionValue());
for (var student : modifiedStudents) {
LOGGER.info("Modifying {} to database.", student.getName());
studentDatabase.modify(student);
    }
  }

private void commitDelete() {
var deletedStudents = context.get(UnitActions.DELETE.getActionValue());
for (var student : deletedStudents) {
LOGGER.info("Deleting {} to database.", student.getName());
studentDatabase.delete(student);
    }
  }
}
