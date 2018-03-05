package com.teamtreehouse.instateam.web;

import com.teamtreehouse.instateam.model.Collaborator;
import com.teamtreehouse.instateam.model.Role;
import com.teamtreehouse.instateam.service.CollaboratorService;
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
public class CollaboratorController {

    @Autowired
    private CollaboratorService collaboratorService;

    @Autowired
    private RoleService roleService;

    // Index of all collaborators
    @RequestMapping("/collaborators")
    public String listOfAllCollaborators(Model model) {

        if(!model.containsAttribute("collaborator")) {
            model.addAttribute("collaborator", new Collaborator());
        }

        List<Collaborator> collaborators = collaboratorService.fetchAllCollaborators();
        model.addAttribute("collaborators", collaborators);

        List<Role> roles = roleService.fetchAllRoles();
        model.addAttribute("roles", roles);
        return "collaborators";
    }

    // Add collaborator
    @RequestMapping(value = "/collaborator/add", method = RequestMethod.POST)
    public String addCollaborator(@Valid Collaborator collaborator, BindingResult result, RedirectAttributes redirectAttributes) {

        if(result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.collaborator", result);
            redirectAttributes.addFlashAttribute("collaborator", collaborator);
            return "redirect:/collaborators";
        }

        collaboratorService.saveCollaborator(collaborator);
        return "redirect:/collaborators";
    }
}
