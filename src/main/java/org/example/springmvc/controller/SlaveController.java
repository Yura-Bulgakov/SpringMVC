package org.example.springmvc.controller;

import org.example.springmvc.Service.SlaveService;
import org.example.springmvc.entity.Slave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/slaves")
public class SlaveController {
    private final SlaveService slaveService;

    @Autowired
    public SlaveController(SlaveService slaveService) {
        this.slaveService = slaveService;
    }

    @GetMapping
    public String getAllSlaves(Model model) {
        model.addAttribute("slaves", slaveService.getAllSlaves());
        return "slave/slaves_list";
    }

    @GetMapping("/byMasterId")
    public String getSlavesByMasterId(@RequestParam("masterId") Long masterId, Model model) {
        model.addAttribute("slaves", slaveService.getAllSlavesByMasterId(masterId));
        return "slave/slaves_list";
    }

    @GetMapping("/{id}")
    public String getSlaveById(@PathVariable Long id, Model model) {
        model.addAttribute("slave", slaveService.getSlaveById(id));
        return "slave/slave_info";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("slave", new Slave());
        model.addAttribute("masters", slaveService.getExistingMasters());
        return "slave/slave_create_form";
    }

    @PostMapping("/new")
    public String createSlave(@ModelAttribute Slave slave) {
        slaveService.create(slave);
        return "redirect:/slaves";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("slave", slaveService.getSlaveById(id));
        model.addAttribute("masters", slaveService.getExistingMasters());
        return "slave/slave_edit_form";
    }

    @PatchMapping("/{id}")
    public String editSlave(@PathVariable Long id, @ModelAttribute Slave updatedSlave) {
        updatedSlave.setId(id);
        slaveService.updateSlave(updatedSlave);
        return "redirect:/slaves";
    }

    @DeleteMapping("/{id}")
    public String deleteSlave(@PathVariable Long id) {
        slaveService.deleteSlave(id);
        return "redirect:/slaves";
    }


}
