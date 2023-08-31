package com.learning.learningspring;

 

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

 

 

import jakarta.validation.Valid;

 

 

@Controller

@RequestMapping("/classroom")

public class ClassroomController {

   

    @Autowired

    private Classroom classroom;

 

    @Autowired

    private StudentDao studentDao;

 

    @GetMapping

    public String classroom(Model model) {

        studentDao.createTable();

        model.addAttribute("students", classroom.getStudents());

        return "classroom";

    }

 

    @PostMapping("/add")

    public String add(@Valid @ModelAttribute Student student,BindingResult result, RedirectAttributes attr) throws DataAccessException, SQLException {

        if (result.hasErrors()) {

            attr.addFlashAttribute("org.springframework.validation.BindingResult.student", result);

            attr.addFlashAttribute("student", student);

            return "redirect:/classroom";

        }

        classroom.add(student);
        studentDao.createStudent(student);
        studentDao.sortScore();

        return "redirect:/classroom";

    }

 

    @PostMapping("/update/{id}")

    public String update(@PathVariable int id, @Valid @ModelAttribute Student student, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {

            attr.addFlashAttribute("org.springframework.validation.BindingResult.student", result);

            attr.addFlashAttribute("student", student);

            return "redirect:/classroom";

        }

        classroom.replace(id, student);

        return "redirect:/classroom";

    }

 

    @PostMapping("/delete/{id}")

    public String delete(@PathVariable int id) {

        classroom.remove(id);

        return "redirect:/classroom";

    }

}