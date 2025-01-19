package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "berza")
@NoArgsConstructor
@Setter
@Getter
public class Kompanija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "data")
    private String data;
    @Column(name = "price")
    private String price;
    @Column(name = "procent_of_total_turnover")
    private String procentOfTotalTurnover;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "bestmkd")
    private String bestmkd;
    @Column(name = "total_turnover")
    private String totalTurnover;

    @Override
    public String toString() {
        return "Kompanija{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", data='" + data + '\'' +
                ", price='" + price + '\'' +
                ", procentOfTotalTurnover='" + procentOfTotalTurnover + '\'' +
                ", quantity='" + quantity + '\'' +
                ", bestmkd='" + bestmkd + '\'' +
                ", totalTurnover='" + totalTurnover + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getData() {
        return data;
    }

    public String getPrice() {
        return price;
    }

    public String getProcentOfTotalTurnover() {
        return procentOfTotalTurnover;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getBestmkd() {
        return bestmkd;
    }

    public String getTotalTurnover() {
        return totalTurnover;
    }
}
