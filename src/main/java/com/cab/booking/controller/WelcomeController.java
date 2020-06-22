package com.cab.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cab.booking.entity.User;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String registration(Model model) {
    	model.addAttribute("userForm", new User());
    	return "welcome";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String customerRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	model.addAttribute("userForm", new User());
    	return "welcome";
    }
    
    
}
