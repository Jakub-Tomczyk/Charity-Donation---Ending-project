package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DonationService;

@Controller
public class DonationController {
    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    //sum all donations and all bags
    @RequestMapping("/")
    public String sumOfAllBags(Model model){
        model.addAttribute("bags",donationService.sumOfBags());
        model.addAttribute("donations",donationService.findAllWithSize());
        return "index";
    }
}
