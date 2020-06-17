package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import pl.coderslab.charity.service.DonationService;

@Controller
public class DonationController {
    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }
}
