package com.iluwatar.datamapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Data Mapper (DM) is a layer of software that separates the in-memory objects from the
 * database. Its responsibility is to transfer data between the two and also to isolate them from
 * each other. With Data Mapper the in-memory objects needn't know even that there's a database
 * present; they need no SQL interface code, and certainly no knowledge of the database schema. (The
 * database schema is always ignorant of the objects that use it.) Since it's a form of Mapper ,
 * Data Mapper itself is even unknown to the domain layer.
 *
 * <p>The below example demonstrates basic CRUD operations: Create, Read, Update, and Delete.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public final class App {

private static final Logger log = LoggerFactory.getLogger(App.class);
private static final String STUDENT_STRING = "App.main(), student : ";


  /**
   * Program entry point.
   *
   * @param args command line args.
 *  @author Suresh Mahto
   */
public static void main(final String... args) {

    /* Create new data mapper for type 'first' */
final var mapper = new StudentDataMapperImpl();

    /* Create new student */
var student = new Student(1, "Adam", 'A');

    /* Add student in respectibe store */
mapper.insert(student);

log.debug(STUDENT_STRING + student + ", is inserted");

    /* Find this student */
final var studentToBeFound = mapper.find(student.getStudentId());

log.debug(STUDENT_STRING + studentToBeFound + ", is searched");

    /* Update existing student object */
student = new Student(student.getStudentId(), "AdamUpdated", 'A');

    /* Update student in respectibe db */
mapper.update(student);

log.debug(STUDENT_STRING + student + ", is updated");
log.debug(STUDENT_STRING + student + ", is going to be deleted");

    /* Delete student in db */
mapper.delete(student);
  }

private App() {
  }
}
