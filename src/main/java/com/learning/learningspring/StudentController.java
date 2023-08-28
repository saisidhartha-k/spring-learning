package com.learning.learningspring;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class StudentController {
    private List<Student> students = new ArrayList<>();

    @GetMapping("/")
    public String studentForm(Model model) {
        model.addAttribute("newStudent", new Student());
        model.addAttribute("students", students);
        return "students";
    }


    @PostMapping("/add")
    public String addStudent(@ModelAttribute("newStudent") Student student,Model model,HttpServletRequest req) {

    
        
        String name1 = req.getParameter("name");       
        student.name = name1;
        students.add(student);
        model.addAttribute("newStudent", new Student());
        model.addAttribute("students", students);
        sortList();
        return "students";

    }
    private void sortList()
    {
    	students.sort(Comparator.comparingInt(Student::getScore).reversed());
    }
    
    @PostMapping("/delete")
    private String deleteRow(@RequestParam("name") String name)
    {
    	students.removeIf(student -> student.getName().equalsIgnoreCase(name) );
    	return "redirect:/";
    }
    
    @PostMapping("/update")
    private String updateRow(@RequestParam("name") String name, @RequestParam("score") int score)
    {
    	for(Student student : students)
    	{
    		if( student.getName().equalsIgnoreCase(name))
    		{
    			student.setScore(score);
    			sortList();
    		}
    	}
    	return "redirect:/";
    }
}
