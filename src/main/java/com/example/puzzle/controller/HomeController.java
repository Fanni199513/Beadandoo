package com.example.puzzle.controller;

import com.example.puzzle.domain.Jigsaw;
import com.example.puzzle.domain.Manufacturer;
import com.example.puzzle.service.JigsawService;
import com.example.puzzle.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private JigsawService jigsawService;

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/")
    public String home(Model model) {
        List<Jigsaw> jigsaws = jigsawService.getAllJigsaws();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        model.addAttribute("jigsaws", jigsaws);
        model.addAttribute("manufacturers", manufacturers);
        return "index";
    }
}
