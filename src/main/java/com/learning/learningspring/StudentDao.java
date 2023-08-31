package com.learning.learningspring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

 

@Repository

public class StudentDao {
    private final org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;


    @Autowired
    public StudentDao(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

 

    public int createTable() {

        String query = "CREATE TABLE IF NOT EXISTS Students(id int primary key auto_increment, name varchar(255), score int)";

        System.out.println("table created....");

        return jdbcTemplate.update(query);

    }

    public  int createStudent(Student student) throws SQLException,DataAccessException
    {
        System.out.println("adding student");
        String addStudent = "insert into Students(name,score) value (?,?)";

        return jdbcTemplate.update(addStudent, student.getName(), student.getScore());
     }

    public int sortScore() throws SQLException,DataAccessException
     {
        String query = "SELECT id, name, score FROM Students ORDER BY score DESC;";
         return jdbcTemplate.update(query);
    }
     
    


}