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

import com.springrbac.model.Permission;
import com.springrbac.service.PermissionService;

@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("permissionList");
        List<Permission> permissionList = permissionService.getAllPermission();
        model.addObject("permissionList", permissionList);
        return model;
    }

    @RequestMapping(value = "/addPermission/", method = RequestMethod.GET)
    public ModelAndView addPermission() {
        ModelAndView model = new ModelAndView("ppermissionlist");
        Permission permission = new Permission();
        model.addObject("permissionForm", permission);
        model.setViewName("permissionForm");
        return model;
    }

    @RequestMapping(value = "/updatePermission/{id}", method = RequestMethod.GET)
    public ModelAndView updatePermission(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("permissionList");
        Permission permission = permissionService.getPermissionById(id);
        model.addObject("permissionForm", permission);
        model.setViewName("permissionForm");
        return model;
    }

    @RequestMapping(value = "/savePermission", method = RequestMethod.POST)
    public ModelAndView savePermission(@ModelAttribute("permissionForm") Permission permission) {
        permissionService.saveOrUpdate(permission);
        return new ModelAndView("redirect:/permission/list");
    }

    @RequestMapping(value = "/deletePermission/{id}", method = RequestMethod.GET)
    public ModelAndView deletePermission(@PathVariable("id") Long id) {
        try {
            permissionService.deletePermission(id);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return new ModelAndView("redirect:/permission/list");
    }

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        Permission permission = new Permission();
        map.put("permission", permission);
        map.put("permissionList", permissionService.getAllPermission());
        return "permission";
    }

    @RequestMapping(value = "/permission.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Permission permission, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Permission permissionResult = new Permission();
        Permission searchedPermission = new Permission();
        switch (action.toLowerCase()) {

            case "add":
                permissionService.saveOrUpdate(permission);
                permissionResult = permission;
                break;
            case "edit":
                if (permission.getId() != null) {
                    permissionService.saveOrUpdate(permission);
                    permissionResult = permission;
                }
                break;
            case "delete":
                if (permission.getId() != null) {
                    try {
                        permissionService.deletePermission(permission.getId());
                        permissionResult = new Permission();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;
            case "search":
                if (permission.getId() != null) {
                    searchedPermission = permissionService.getPermissionById(permission.getId());
                    permissionResult = searchedPermission != null ? searchedPermission : new Permission();
                }

                break;
        }

        map.put("permission", permissionResult);
        map.put("permissionList", permissionService.getAllPermission());
        return "permission";
    }
}
