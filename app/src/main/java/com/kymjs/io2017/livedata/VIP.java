package com.kymjs.io2017.livedata;

import java.util.Date;

/**
 * Created by kymjs on 7/4/17.
 */
public class VIP {
    private int id;
    private String name;
    private String phoneNumber;
    private String vipTypeName;
    private int times;
    private int duration;
    private double balance;
    private Date startDate;
    private Date endDate;

    private boolean enable;
    private String history;

    public int getId() {
        return id;
    }

    public VIP setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public VIP setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public VIP setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public double getBalance() {
        return balance;
    }

    public VIP setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public VIP setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public VIP setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public int getTimes() {
        return times;
    }

    public VIP setTimes(int times) {
        this.times = times;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public VIP setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public boolean isEnable() {
        return enable;
    }

    public VIP setEnable(boolean enable) {
        this.enable = enable;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public VIP setHistory(String history) {
        this.history = history;
        return this;
    }

}
