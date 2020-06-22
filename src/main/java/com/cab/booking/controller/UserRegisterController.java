package com.cab.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cab.booking.entity.User;
import com.cab.booking.service.SecurityService;
import com.cab.booking.service.UserService;
import com.cab.booking.validator.UserValidator;

@Controller
@RequestMapping("/registration")
public class UserRegisterController {
   
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String registration(Model model) {
    	model.addAttribute("userForm", new User());
    	return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String customerRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
       
		return "redirect:/welcome";
    }
    
    
}
