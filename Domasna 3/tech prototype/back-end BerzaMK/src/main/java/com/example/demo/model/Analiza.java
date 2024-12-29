package com.example.demo.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "analizaberza")
@NoArgsConstructor
public class Analiza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "close")
    private String close;
    @Column(name = "high")
    private String high;
    @Column(name = "low")
    private String low;
    @Column(name = "volume")
    private String volume;
    @Column(name = "sma20")
    private String sma20;
    @Column(name = "sma50")
    private String sma50;
    @Column(name = "ema20")
    private String ema20;
    @Column(name = "ema50")
    private String ema50;
    @Column(name = "bbmid")
    private String bbmid;
    @Column(name = "rsi")
    private String rsi;
    @Column(name = "obv")
    private String obv;
    @Column(name = "momentum")
    private String momentum;
    @Column(name = "buy_signal")
    private String buy_signal;
    @Column(name = "sell_signal")
    private String sell_signal;
    @Column(name = "company_name")
    private String company_name;

    @Override
    public String toString() {
        return "Analiza{" +
                "id=" + id +
                ", close='" + close + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", volume='" + volume + '\'' +
                ", sma20='" + sma20 + '\'' +
                ", sma50='" + sma50 + '\'' +
                ", ema20='" + ema20 + '\'' +
                ", ema50='" + ema50 + '\'' +
                ", bbmid='" + bbmid + '\'' +
                ", rsi='" + rsi + '\'' +
                ", obv='" + obv + '\'' +
                ", momentum='" + momentum + '\'' +
                ", buy_signal='" + buy_signal + '\'' +
                ", sell_signal='" + sell_signal + '\'' +
                ", company_name='" + company_name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getClose() {
        return close;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getVolume() {
        return volume;
    }

    public String getSma20() {
        return sma20;
    }

    public String getSma50() {
        return sma50;
    }

    public String getEma20() {
        return ema20;
    }

    public String getEma50() {
        return ema50;
    }

    public String getBbmid() {
        return bbmid;
    }

    public String getRsi() {
        return rsi;
    }

    public String getObv() {
        return obv;
    }

    public String getMomentum() {
        return momentum;
    }

    public String getBuy_signal() {
        return buy_signal;
    }

    public String getSell_signal() {
        return sell_signal;
    }

    public String getCompany_name() {
        return company_name;
    }
}
