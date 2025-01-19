package com.example.demo.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "analizaberzatabela")
@NoArgsConstructor
public class Analiza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private String date;
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
                ", date='" + date + '\'' +
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

    public String getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setSma20(String sma20) {
        this.sma20 = sma20;
    }

    public void setSma50(String sma50) {
        this.sma50 = sma50;
    }

    public void setEma20(String ema20) {
        this.ema20 = ema20;
    }

    public void setEma50(String ema50) {
        this.ema50 = ema50;
    }

    public void setBbmid(String bbmid) {
        this.bbmid = bbmid;
    }

    public void setRsi(String rsi) {
        this.rsi = rsi;
    }

    public void setObv(String obv) {
        this.obv = obv;
    }

    public void setMomentum(String momentum) {
        this.momentum = momentum;
    }

    public void setBuy_signal(String buy_signal) {
        this.buy_signal = buy_signal;
    }

    public void setSell_signal(String sell_signal) {
        this.sell_signal = sell_signal;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public LocalDate getDateAsLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(this.date, formatter);
    }
}
