package com.example.microfinancepi.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AmortizationDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idDetail;
    Long idAmort;//this id is of the table Amortization
    Long periode;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date date;
    Long startAmount;
    Long intrest;
    Long amrt;
    Long annuity;
    Long frais;
    Long agio;

    @ManyToOne
    Amortization amortization;

}
