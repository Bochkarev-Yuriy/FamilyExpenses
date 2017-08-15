package ru.family.expenses.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/test")
@Controller
public class TestController {

    @GetMapping(value = {"/test"})
    public ModelAndView getTest() {
        return new ModelAndView("testTemplates");
    }
}
