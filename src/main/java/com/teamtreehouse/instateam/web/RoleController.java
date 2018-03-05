package com.teamtreehouse.instateam.web;

import com.teamtreehouse.instateam.model.Role;
import com.teamtreehouse.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Index of all roles
    @RequestMapping("/roles")
    public String listOfAllRoles(Model model) {

        List<Role> roles = roleService.fetchAllRoles();
        model.addAttribute("roles", roles);

        if(!model.containsAttribute("role")) {
            model.addAttribute("role", new Role());
        }
        return "roles";
    }

    // Create role
    @RequestMapping(value = "/role/create", method = RequestMethod.POST)
    public String createRole(@Valid Role role, BindingResult result, RedirectAttributes redirectAttributes) {

        if(result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.role", result);
            redirectAttributes.addFlashAttribute("role", role);
            return "redirect:/roles";
        }
        roleService.saveRole(role);
        return "redirect:/roles";
    }
}
