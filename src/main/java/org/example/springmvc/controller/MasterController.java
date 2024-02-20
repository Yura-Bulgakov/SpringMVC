package org.example.springmvc.controller;

import org.example.springmvc.Service.MasterService;
import org.example.springmvc.entity.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/masters")
public class MasterController {
    private final MasterService masterService;

    @Autowired
    public MasterController(MasterService masterService) {
        this.masterService = masterService;
    }

    @GetMapping
    public String getAllMasters(Model model) {
        model.addAttribute("masters", masterService.getAllMasters());
        return "master/masters_list";
    }

    @GetMapping("/{id}")
    public String getMasterById(@PathVariable Long id, Model model) {
        model.addAttribute("master", masterService.getMasterById(id));
        return "master/master_info";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("master", new Master());
        model.addAttribute("departments", masterService.getExistingDepartments());
        return "master/master_create_form";
    }

    @PostMapping("/new")
    public String createMaster(@ModelAttribute Master master) {
        masterService.create(master);
        return "redirect:/masters";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("master", masterService.getMasterById(id));
        model.addAttribute("departments", masterService.getExistingDepartments());
        return "master/master_edit_form";
    }


    @PatchMapping("/{id}")
    public String editMaster(@PathVariable Long id, @ModelAttribute("master") Master updatedMaster) {
        updatedMaster.setId(id);
        masterService.updateMaster(updatedMaster);
        return "redirect:/masters";
    }

    @DeleteMapping("/{id}")
    public String deleteMaster(@PathVariable Long id) {
        masterService.deleteMaster(id);
        return "redirect:/masters";
    }
}
