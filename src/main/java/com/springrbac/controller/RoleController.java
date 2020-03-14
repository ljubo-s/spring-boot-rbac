package com.springrbac.controller;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import com.springrbac.model.Role;
import com.springrbac.service.RoleService;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("roleList");
        List<Role> roleList = roleService.getAllRole();
        model.addObject("roleList", roleList);
        return model;
    }

    @RequestMapping(value = "/addRole/", method = RequestMethod.GET)
    public ModelAndView addRole() {
        ModelAndView model = new ModelAndView("roleList");
        Role role = new Role();
        model.addObject("roleForm", role);
        model.setViewName("roleForm");
        return model;
    }

    @RequestMapping(value = "/updateRole/{id}", method = RequestMethod.GET)
    public ModelAndView updateRole(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("roleList");
        Role role = roleService.getRoleById(id);
        model.addObject("roleForm", role);
        model.setViewName("roleForm");
        return model;
    }

    @RequestMapping(value = "/saveRole", method = RequestMethod.POST)
    public ModelAndView saveRole(@ModelAttribute("roleForm") Role role) {
        
        try {
            roleService.saveOrUpdate(role);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    
        return new ModelAndView("redirect:/role/list");
    }

    @RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.GET)
    public ModelAndView deleteRole(@PathVariable("id") Long id) {
        try {
            roleService.deleteRole(id);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return new ModelAndView("redirect:/role/list");
    }

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        Role role = new Role();
        map.put("role", role);
        map.put("roleList", roleService.getAllRole());
        return "role";
    }

    @RequestMapping(value = "/role.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Role role, BindingResult result, @RequestParam String action, Map<String, Object> map) {

        Role roleResult = new Role();
        Role searchedRole = new Role();

        switch (action.toLowerCase()) {

            case "add":
                roleService.saveOrUpdate(role);
                roleResult = role;
                break;
            case "edit":
                if (role.getId() != null) {
                    roleService.saveOrUpdate(role);
                    roleResult = role;
                }
                break;

            case "delete":
                if (role.getId() != null) {
                    try {
                        roleService.deleteRole(role.getId());
                        roleResult = new Role();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;

            case "search":
                if (role.getId() != null) {
                    searchedRole = roleService.getRoleById(role.getId());
                    roleResult = searchedRole != null ? searchedRole : new Role();
                }
                break;
        }

        map.put("role", roleResult);
        map.put("roleList", roleService.getAllRole());
        return "role";
    }
}
