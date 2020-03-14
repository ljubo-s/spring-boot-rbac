package com.springrbac.controller;

import java.util.Map;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import com.springrbac.model.UsersRole;
import com.springrbac.service.RoleService;
import com.springrbac.service.UsersService;
import com.springrbac.service.UsersRoleService;

@Controller
@RequestMapping(value = "/usersRole")
public class UsersRoleController {

    @Autowired
    private UsersRoleService usersRoleService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("usersRoleList");
        List<UsersRole> usersRoleList = usersRoleService.getAllUsersRole();
        model.addObject("usersRoleList", usersRoleList);
        return model;
    }

    @RequestMapping(value = "/addUsersRole/", method = RequestMethod.GET)
    public ModelAndView addUsersRole() {
        ModelAndView model = new ModelAndView("usersRoleList");
        UsersRole usersRole = new UsersRole();
        model.addObject("usersRoleForm", usersRole);
        model.setViewName("usersRoleForm");
        return model;
    }

    @RequestMapping(value = "/updateUsersRole/{id}", method = RequestMethod.GET)
    public ModelAndView updateUsersRole(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("usersRoleList");
        UsersRole usersRole = usersRoleService.getUsersRoleById(id);
        model.addObject("usersRoleForm", usersRole);
        model.setViewName("usersRoleForm");
        return model;
    }

    @RequestMapping(value = "/saveUsersRole", method = RequestMethod.POST)
    public ModelAndView saveUsersRole(@ModelAttribute("usersRoleForm") UsersRole usersRole) {

        try {
            usersRoleService.saveOrUpdate(usersRole);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return new ModelAndView("redirect:/usersRole/list");
    }

    @RequestMapping(value = "/deleteUsersRole/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUsersRole(@PathVariable("id") Long id) {

        try {
            usersRoleService.deleteUsersRole(id);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        return new ModelAndView("redirect:/usersRole/list");
    }

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        UsersRole usersRole = new UsersRole();
        map.put("usersRole", usersRole);
        map.put("usersRoleList", usersRoleService.getAllUsersRole());
        map.put("usersList", usersService.getAllUsers());
        map.put("roleList", roleService.getAllRole());
        return "usersRole";
    }

    @RequestMapping(value = "/usersRole.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute UsersRole usersRole, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        UsersRole usersRoleResult = new UsersRole();
        UsersRole searchedUsersRole = new UsersRole();

        switch (action.toLowerCase()) {

            case "add":
                usersRoleService.saveOrUpdate(usersRole);
                usersRoleResult = usersRole;
                break;
            case "edit":
                if (usersRole.getId() != null) {
                    usersRoleService.saveOrUpdate(usersRole);
                    usersRoleResult = usersRole;
                }
                break;
            case "delete":
                if (usersRole.getId() != null) {

                    try {
                        usersRoleService.deleteUsersRole(usersRole.getId());
                        usersRoleResult = new UsersRole();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;
            case "search":
                if (usersRole.getId() != null) {
                    searchedUsersRole = usersRoleService.getUsersRoleById(usersRole.getId());
                    usersRoleResult = searchedUsersRole != null ? searchedUsersRole : new UsersRole();
                }
                break;
        }

        map.put("usersRole", usersRoleResult);
        map.put("usersRoleList", usersRoleService.getAllUsersRole());
        map.put("usersList", usersService.getAllUsers());
        map.put("roleList", roleService.getAllRole());

        return "usersRole";
    }

}
