package com.learning.learningspring;

 

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

 

 

@Component

public class Classroom {

  private List<Student> students;

  private static int idCounter = 1;

 

  public Classroom() {

    students = new ArrayList<>();

  }

 

  public List<Student> getStudents() {

    return students;

  }



  private void rank() {

    students.sort(Comparator.comparingInt(Student::getScore).reversed());

  }

 

  public void add(Student student) throws DataAccessException, SQLException {

    student.setId(idCounter++);

    students.add(student);

    rank();

  }

 

  public void remove(int id) {

    for (Student s : students) {

        if (s.getId() == id) {

            students.remove(s);

            break;

        }

    }

    //rank();

  }

 

  public void replace(int id, Student current) {

    for (int i = 0; i < students.size(); i++) {

      if (students.get(i).getId() == id) {

        students.get(i).setName(current.getName());

        students.get(i).setScore(current.getScore());

      }

    }

    rank();

  }

 

  public Optional<Student> getById(int id) {

    for (int i = 0; i < students.size(); i++) {

      if (students.get(i).getId() == id)

        return Optional.of(students.get(i));

    }

    return Optional.empty();

  }

}