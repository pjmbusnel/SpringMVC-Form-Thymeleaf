package com.pjmb.springmvc.formvalidation.controller;

import com.pjmb.springmvc.formvalidation.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentRegistrationController {

    @Value("${genders}")
    private List<String> genders;

    @InitBinder // convert trim input strings
    public void initBinder(WebDataBinder dataBinder) {
        // trim whitespace for better validation
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/registration")
    public String showStudentRegistrationForm(Model model) {
        model.addAttribute("genders", genders);
        model.addAttribute("student", new Student());
        return "student-registration-form";
    }

    @PostMapping("/processRegistration")
    public String processRegistration(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        // Stay on student-registration-form in case of binding errors

        if (bindingResult.hasErrors()){
            System.out.println("binding Errors");
            bindingResult.getAllErrors().stream().forEach(System.out::println);
        }

        return (bindingResult.hasErrors() ? "student-registration-form" : "student-registration-confirmation");
    }
}







