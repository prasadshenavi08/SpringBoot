package com.example.tour.controller;

import com.example.tour.model.Tour;
import com.example.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping
    public String listTours(Model model) {
model.addAttribute("tours", tourService.getAllTours());
        return "tour-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
    	model.addAttribute("tour", new Tour());
        return "tour-form";
    }

    @PostMapping("/save")
    public String saveTour(@ModelAttribute Tour tour, @RequestParam("file") MultipartFile file) throws IOException {
    	tourService.saveTour(tour, file);
        return "redirect:/tours";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Tour tour = tourService.getTourById(id).orElseThrow(() -> new IllegalArgumentException("Invalid tour Id:" + id));
        model.addAttribute("tour", tour);
        return "tour-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTour(@PathVariable Long id) {
tourService.deleteTour(id);
        return "redirect:/tours";
    }
}
