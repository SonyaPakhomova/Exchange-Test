package com.example.overonix.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "currency_request_rates")
public class Conversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String EUR;
    private String USD;
    private String UAH;
    private String GBP;
    private String AED;
    private String AFN;
    private String AMD;
    private String ANG;
    private String CRC;
    private String EGP;
    private String ETB;
    private String FKP;
}
