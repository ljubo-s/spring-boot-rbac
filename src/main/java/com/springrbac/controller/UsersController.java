package com.springrbac.controller;

import java.util.Map;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import com.springrbac.model.Users;
import com.springrbac.service.UsersService;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("usersList");
        List<Users> usersList = usersService.getAllUsers();
        model.addObject("usersList", usersList);
        return model;
    }

    @RequestMapping(value = "/addUsers/", method = RequestMethod.GET)
    public ModelAndView addUsers() {
        ModelAndView model = new ModelAndView("usersList");
        Users users = new Users();
        model.addObject("usersForm", users);
        model.setViewName("usersForm");
        return model;
    }

    @RequestMapping(value = "/updateUsers/{id}", method = RequestMethod.GET)
    public ModelAndView updateUsers(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("usersList");
        Users users = usersService.getUsersById(id);
        model.addObject("usersForm", users);
        model.setViewName("usersForm");
        return model;
    }

    @RequestMapping(value = "/saveUsers", method = RequestMethod.POST)
    public ModelAndView saveUsers(@ModelAttribute("usersForm") Users users) {
        usersService.saveOrUpdate(users);
        return new ModelAndView("redirect:/users/list");
    }

    @RequestMapping(value = "/deleteUsers/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUsers(@PathVariable("id") Long id) {

        try {
            usersService.deleteUsers(id);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        return new ModelAndView("redirect:/users/list");
    }

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        Users users = new Users();
        map.put("users", users);
        map.put("usersList", usersService.getAllUsers());
        
        return "users";
    }

    @RequestMapping(value = "/users.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Users users, BindingResult result, @RequestParam String action, Map<String, Object> map) {

        Users usersResult = new Users();
        Users searchedUsers = new Users();

        switch (action.toLowerCase()) {

            case "add":
                usersService.saveOrUpdate(users);
                usersResult = users;
                break;
            case "edit":
                if (users.getId() != null) {
                    usersService.saveOrUpdate(users);
                    usersResult = users;
                }
                break;
            case "delete":
                if (users.getId() != null) {
                    try {
                        usersService.deleteUsers(users.getId());
                        usersResult = new Users();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;
            case "search":
                if (users.getId() != null) {
                    searchedUsers = usersService.getUsersById(users.getId());
                    usersResult = searchedUsers != null ? searchedUsers : new Users();
                }
                break;
        }

        map.put("users", usersResult);
        map.put("usersList", usersService.getAllUsers());
        return "users";
    }

}
