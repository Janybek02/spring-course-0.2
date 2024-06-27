package com.example.course.controller;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/project")
public class FirstController {
    @GetMapping("/index")
    public String hello(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "email", required = false) String email,
                        Model model) {
        model.addAttribute("message", "name: " + name + ", email: " + email);
//        System.out.println("name: " + name + ", email: " + email);
        return "project/index";
    }

    @GetMapping("/calculator")
    public String getCalculator(@RequestParam(value = "a", required = false) int a,
                                @RequestParam(value = "b", required = false) int b,
                                @RequestParam(value = "action", required = false) String action,
                                Model model) {
        double result;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double) b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            default: result = 0;
        }
        model.addAttribute("cal", "calculated:" + " " + result);
        return "project/calculator";

    }
}
