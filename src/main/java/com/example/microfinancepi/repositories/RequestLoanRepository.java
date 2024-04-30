package com.example.microfinancepi.repositories;

import com.example.microfinancepi.entities.RequestLoan;
import com.example.microfinancepi.entities.StatLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RequestLoanRepository extends JpaRepository<RequestLoan,Long> {
    List<RequestLoan> findByStatus(StatLoan status);
    List<RequestLoan> findAllByAmortizationIsNotNull();



    /*
    List<RequestLoan> findByDatefinBefore(Date date);
  @Query("SELECT r FROM RequestLoan r WHERE r.loanAmnt LIKE %:keyword% OR r.nbrMonth LIKE %:keyword%")
    List<RequestLoan> findByKeyword(String keywords);
    List<RequestLoan> findAllByOrderByFieldAsc(String sortBy);

   */


}
