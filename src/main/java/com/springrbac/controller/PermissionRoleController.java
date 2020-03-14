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
import com.springrbac.service.PermissionRoleService;
import com.springrbac.service.RoleService;
import com.springrbac.service.PermissionService;
import com.springrbac.model.PermissionRole;

@Controller
@RequestMapping(value = "/permissionRole")
public class PermissionRoleController {

    @Autowired
    private PermissionRoleService permissionRoleService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("permissionRoleList");
        List<PermissionRole> permissionRoleList = permissionRoleService.getAllPermissionRole();
        model.addObject("permissionRoleList", permissionRoleList);
        return model;
    }

    @RequestMapping(value = "/addPermissionRole/", method = RequestMethod.GET)
    public ModelAndView addPermissionRole() {
        ModelAndView model = new ModelAndView("permissionRoleList");
        PermissionRole permissionRole = new PermissionRole();
        model.addObject("permissionRoleForm", permissionRole);
        model.setViewName("permissionRoleForm");
        return model;
    }

    @RequestMapping(value = "/updatePermissionRole/{id}", method = RequestMethod.GET)
    public ModelAndView updatePermissionRole(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("permissionRoleList");
        PermissionRole permissionRole = permissionRoleService.getPermissionRoleById(id);
        model.addObject("permissionRoleForm", permissionRole);
        model.setViewName("permissionRoleForm");
        return model;
    }

    @RequestMapping(value = "/savePermissionRole", method = RequestMethod.POST)
    public ModelAndView savePermissionRole(@ModelAttribute("permissionRoleForm") PermissionRole permissionRole) {
        
        try {
            permissionRoleService.saveOrUpdate(permissionRole);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        
        return new ModelAndView("redirect:/permissionRole/list");
    }

    @RequestMapping(value = "/deletePermissionRole/{id}", method = RequestMethod.GET)
    public ModelAndView deletePermissionRole(@PathVariable("id") Long id) {
        try {
            permissionRoleService.deletePermissionRole(id);
        } catch (final Exception e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return new ModelAndView("redirect:/permissionRole/list");
    }

    @RequestMapping("")
    public String setupForm(Map<String, Object> map) {
        PermissionRole permissionRole = new PermissionRole();
        map.put("permissionRole", permissionRole);
        map.put("permissionRoleList", permissionRoleService.getAllPermissionRole());
        map.put("roleList", roleService.getAllRole());
        map.put("permissionList", permissionService.getAllPermission());
        return "permissionRole";
    }

    @RequestMapping(value = "/permissionRole.form", method = RequestMethod.POST)
    public String doActions(@ModelAttribute PermissionRole permissionRole, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        PermissionRole permission_roleResult = new PermissionRole();
        PermissionRole searchedPermissionRole = new PermissionRole();

        switch (action.toLowerCase()) {

            case "add":
                permissionRoleService.saveOrUpdate(permissionRole);
                permission_roleResult = permissionRole;
                break;
            case "edit":
                if (permissionRole.getId() != null) {
                    permissionRoleService.saveOrUpdate(permissionRole);
                    permission_roleResult = permissionRole;
                }
                break;
            case "delete":
                if (permissionRole.getId() != null) {
                    try {
                        permissionRoleService.deletePermissionRole(permissionRole.getId());
                        permission_roleResult = new PermissionRole();
                    } catch (final Exception e) {
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                break;
            case "search":
                if (permissionRole.getId() != null) {
                    searchedPermissionRole = permissionRoleService.getPermissionRoleById(permissionRole.getId());
                    permission_roleResult = searchedPermissionRole != null ? searchedPermissionRole : new PermissionRole();
                }
                break;
        }

        map.put("permissionRole", permission_roleResult);
        map.put("permissionRoleList", permissionRoleService.getAllPermissionRole());
        map.put("roleList", roleService.getAllRole());
        map.put("permissionList", permissionService.getAllPermission());

        return "permissionRole";
    }

}
