package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


import java.util.List;

@Controller
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    //wyświetlanie wszystkich Kategorii w formularzu.
    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.readAll();
    }

    //wyświetlanie wszystkich Instytucji (Fundacji) w Formularzu.
    @ModelAttribute("institutions")
    public List<Institution> institutionList() {
        return institutionService.readAll();
    }

    // metoda do odsyłania do formularza.
    @GetMapping("/donation")
    public String getDonation(Model model){
        model.addAttribute("donation", new Donation());
        return "form";
    }
    //otrzymywanie i zapisywanie formularza do bazy danych.
    @PostMapping("formConfirmation")
    public String postDonation(@ModelAttribute Donation donation){
        donationService.save(donation);
        return "formConfirmation";
    }
}
