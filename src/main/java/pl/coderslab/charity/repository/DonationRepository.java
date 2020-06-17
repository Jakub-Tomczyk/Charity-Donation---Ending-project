package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    public Donation findOneById(Long id);


    @Query("SELECT SUM(quantity) FROM Donation")
    Optional<Integer> bagsSum();

    // metoda, która zwróci mi od razu count wszystkich donacji.
    @Query("SELECT COUNT(quantity) FROM Donation")
    Optional<Integer> donationCount();

}
