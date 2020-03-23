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
import com.springrbac.service.UsersService;
import com.springrbac.model.PermissionUsers;
import com.springrbac.service.PermissionService;
import com.springrbac.service.PermissionUsersService;

@Controller
@RequestMapping(value = "/permissionUsers")
public class PermissionUsersController {

    @Autowired
    private PermissionUsersService permissionUsersService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("permissionUsersList");
        List<PermissionUsers> permissionUsersList = permissionUsersService.getAllPermissionUsers();
        model.addObject("permissionUsersList", permissionUsersList);
        return model;
    }

    @RequestMapping(value = "/addPermissionUsers/", method = RequestMethod.GET)
    public ModelAndView addPermissionUsers() {
        ModelAndView model = new ModelAndView("permissionUsersList");
        PermissionUsers permissionUsers = new PermissionUsers();
        model.addObject("permissionUsersForm", permissionUsers);
        model.setViewName("permissionUsersForm");
        return model;
    }

    @RequestMapping(value = "/updatePermissionUsers/{id}", method = RequestMethod.GET)
    public ModelAndView updatePermissionUsers(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("permissionUsersList");
        PermissionUsers permissionUsers = permissionUsersService.getPermissionUsersById(id);
        model.addObject("permissionUsersForm", permissionUsers);
        model.setViewName("permissionUsersForm");
        return model;
    }

    @RequestMapping(value = "/savePermissionUsers", method = RequestMethod.POST)
    public ModelAndView savePermissionUsers(@ModelAttribute("permissionUsersForm") PermissionUsers permissionUsers) {

        try {
            permissionUsersService.saveOrUpdate(permissionUsers);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        return new ModelAndView("redirect:/permissionUsers/list");
    }

    @RequestMapping(value = "/deletePermissionUsers/{id}", method = RequestMethod.GET)
    public ModelAndView deletePermissionUsers(@PathVariable("id") Long id) {
        permissionUsersService.deletePermissionUsers(id);
        return new ModelAndView("redirect:/permissionUsers/list");
    }

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        PermissionUsers permissionUsers = new PermissionUsers();
        map.put("permissionUsers", permissionUsers);
        map.put("permissionUsersList", permissionUsersService.getAllPermissionUsers());
        map.put("usersList", usersService.getAllUsers());
        map.put("permissionList", permissionService.getAllPermission());
        return "permissionUsers";
    }

    @RequestMapping(value = "/permissionUsers.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute PermissionUsers permissionUsers, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        PermissionUsers permission_usersResult = new PermissionUsers();
        PermissionUsers searchedPermissionUsers = new PermissionUsers();

        switch (action.toLowerCase()) {

            case "add":
                permissionUsersService.saveOrUpdate(permissionUsers);
                permission_usersResult = permissionUsers;
                break;
            case "edit":
                if (permissionUsers.getId() != null) {
                    permissionUsersService.saveOrUpdate(permissionUsers);
                    permission_usersResult = permissionUsers;
                }
                break;
            case "delete":
                if (permissionUsers.getId() != null) {
                    System.out.println("delete id : " + permissionUsers.getId());
                    try {
                        permissionUsersService.deletePermissionUsers(permissionUsers.getId());
                        permission_usersResult = new PermissionUsers();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;
            case "search":
                if (permissionUsers.getId() != null) {
                    searchedPermissionUsers = permissionUsersService.getPermissionUsersById(permissionUsers.getId());
                    permission_usersResult = searchedPermissionUsers != null ? searchedPermissionUsers : new PermissionUsers();
                }
                break;
        }

        map.put("permissionUsers", permission_usersResult);
        map.put("permissionUsersList", permissionUsersService.getAllPermissionUsers());
        map.put("usersList", usersService.getAllUsers());
        map.put("permissionList", permissionService.getAllPermission());

        return "permissionUsers";
    }

}
