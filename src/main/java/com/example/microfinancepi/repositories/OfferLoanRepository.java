package com.example.microfinancepi.repositories;

import com.example.microfinancepi.entities.OfferLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferLoanRepository extends JpaRepository<OfferLoan,Long> {

    List<OfferLoan> findOffersByMinAmntLessThanEqual(Long searchedAmount);// search
    @Query("SELECT COUNT(o) FROM OfferLoan o WHERE o.status = :status")
    int countByStatus(@Param("status") String status);
    @Query("SELECT COUNT(r) FROM OfferLoan o JOIN o.requestLoans r WHERE o.idOffer = :offerId")
    int countRequestLoansByOfferId(@Param("offerId") Long offerId);




}
