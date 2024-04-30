package com.example.microfinancepi.services;

import com.example.microfinancepi.entities.Amortization;
import com.example.microfinancepi.entities.RequestLoan;
import com.example.microfinancepi.repositories.AmortizationRepository;
import com.example.microfinancepi.repositories.RequestLoanRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor// inject repo in service
public class AmortizationServiceImpl implements  IAmortizationService{
    AmortizationRepository amortizationRepo;
    RequestLoanRepository requestLoanRepo;

    public List<Amortization> retrieveAllAmortization() { return amortizationRepo.findAll();   }
    public Amortization retrieveAmortization(Long idAmrt) {
        return amortizationRepo.findById(idAmrt).get();
    }
    public Amortization addAmortizationFees(Long requestId, Long fees) {
        RequestLoan requestLoan = requestLoanRepo.findById(requestId).orElseThrow(() -> new IllegalArgumentException("RequestLoan with ID " + requestId + " not found"));

        Float interest = requestLoan.getOfferLoan().getIntRate();
        Float rate = requestLoan.getOfferLoan().getIntRate();

        Long agio = (long) (interest * rate / 2);

        Amortization amortization = new Amortization();
        amortization.setRequestloan(requestLoan);
        amortization.setFrais(fees);
        amortization.setAgio(agio);

        return amortizationRepo.save(amortization);
    }
    public Amortization modifyAmortization (Amortization amrt) {
        return amortizationRepo.save(amrt);
    }
    public void removeAmortization(Long idAmrt) { amortizationRepo.deleteById(idAmrt);    }


/*
    public Long calculateRemainingBalance(Long idAmrt, Long periodsElapsed) {
        Amortization amortization = amortizationRepo.findById(idAmrt).get();

        Long originalAmount = amortization.getStartAmount();
        Long interest = amortization.getIntrest();
        Long annuity = amortization.getAnnuity();
        Long remainingBalance = originalAmount;

         for (long i = 0; i < periodsElapsed; i++) {
            Long interestForPeriod = (remainingBalance * interest) / 100;
            Long principalForPeriod = annuity - interestForPeriod;
            remainingBalance -= principalForPeriod;
        }

        return remainingBalance;
    }

 */



}
