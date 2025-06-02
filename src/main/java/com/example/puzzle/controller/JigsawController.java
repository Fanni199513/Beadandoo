package com.example.puzzle.controller;

import com.example.puzzle.domain.Jigsaw;
import com.example.puzzle.service.JigsawService;
import com.example.puzzle.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/jigsaws")
public class JigsawController {

    @Autowired
    private JigsawService jigsawService;

    @Autowired
    private ManufacturerService manufacturerService;

    // GET: Kirakók listázása
    @GetMapping("/list")
    public String getAllJigsaws(Model model) {
        List<Jigsaw> jigsaws = jigsawService.getAllJigsaws();
        model.addAttribute("jigsaws", jigsaws);
        return "jigsaws/jigsaws"; // Updated template path (books directory)
    }

    // GET: Új kirakó létrehozása
    @GetMapping("/new")
    public String createJigsawForm(Model model) {
        model.addAttribute("jigsaw", new Jigsaw());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        return "jigsaws/create-jigsaw"; // Updated template path
    }

    // POST: Új kirakó mentése
    @PostMapping
    public String saveJigsaw(@ModelAttribute Jigsaw jigsaw) {
        jigsawService.save(jigsaw);
        return "redirect:/jigsaws/list";
    }

    // GET: Kirakó szerkesztő oldal
    @GetMapping("/edit/{id}")
    public String editJigsawForm(@PathVariable UUID id, Model model) {
        Jigsaw jigsaw = jigsawService.findById(id);
        model.addAttribute("jigsaw", jigsaw);
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        return "jigsaws/edit-jigsaw"; // Updated template path
    }

    // POST: Kirakó frissítése
    @PostMapping("/edit")
    public String updateJigsaw(@ModelAttribute Jigsaw jigsaw) {
        jigsawService.edit(jigsaw);
        return "redirect:/jigsaws/list";
    }

    // POST: Kirakó törlése
    @PostMapping("/delete/{id}")
    public String deleteJigsaw(@PathVariable UUID id) {
        jigsawService.deleteById(id);
        return "redirect:/jigsaws/list";
    }
}
