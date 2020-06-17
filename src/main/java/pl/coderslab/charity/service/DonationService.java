package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService {
    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Integer sumOfBags() {return this.donationRepository.bagsSum().orElse(0);}

    public Integer findAllWithSize() {return this.donationRepository.findAll().size();}
}
