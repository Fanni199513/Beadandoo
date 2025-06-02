package com.example.puzzle.controller;

import java.util.List;
import java.util.UUID;

import com.example.puzzle.domain.Jigsaw;
import com.example.puzzle.domain.Manufacturer;
import com.example.puzzle.service.JigsawService;
import com.example.puzzle.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    // GET: List all authors (responds to /authors/list)
    @GetMapping("/list")
    public String getAllManufacturers(Model model) {
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        model.addAttribute("manufacturers", manufacturers);
        return "manufacturers/manufacturers";// Template location in authors directory
    }

    // GET: Show Create Author Page
    @GetMapping("/new")
    public String createManufacturerForm(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturers/create-manufacturer"; // Template for creating authors
    }

    // POST: Save New Author
    @PostMapping
    public String saveManufacturer(@ModelAttribute Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
        return "redirect:/manufacturers/list"; // Redirect to /authors/list after saving
    }

    // GET: Összes gyártó listázása
    @GetMapping("/edit/{id}")
    public String editManufacturerForm(@PathVariable UUID id, Model model) {
        Manufacturer manufacturer = manufacturerService.findById(id);
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturers/edit-manufacturer"; // Template for editing authors
    }

    // POST: Új gyártó létrehozása
    @PostMapping("/edit")
    public String updateManufacturer(@ModelAttribute Manufacturer manufacturer) {
        manufacturerService.edit(manufacturer);
        return "redirect:/manufacturers/list"; // Redirect to /authors/list after updating
    }

    // POST: Gyártó törlése
    @PostMapping("/delete/{id}")
    public String deleteManufacturer(@PathVariable UUID id) {
        manufacturerService.deleteById(id);
        return "redirect:/manufacturers/list"; // Redirect to /authors/list after deleting
    }
}