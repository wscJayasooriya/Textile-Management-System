/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sandun_CJ
 */
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pId;
    private double grossAmount;
    private double cash;
    private double balance;

    public Payment() {
    }

    public Payment(int pId, double grossAmount, double cash, double balance) {
        this.pId = pId;
        this.grossAmount = grossAmount;
        this.cash = cash;
        this.balance = balance;
    }

    public Payment(double grossAmount, double cash, double balance) {
        this.grossAmount = grossAmount;
        this.cash = cash;
        this.balance = balance;
    }

    /**
     * @return the pId
     */
    public int getpId() {
        return pId;
    }

    /**
     * @param pId the pId to set
     */
    public void setpId(int pId) {
        this.pId = pId;
    }

    /**
     * @return the grossAmount
     */
    public double getGrossAmount() {
        return grossAmount;
    }

    /**
     * @param grossAmount the grossAmount to set
     */
    public void setGrossAmount(double grossAmount) {
        this.grossAmount = grossAmount;
    }

    /**
     * @return the cash
     */
    public double getCash() {
        return cash;
    }

    /**
     * @param cash the cash to set
     */
    public void setCash(double cash) {
        this.cash = cash;
    }

    /**
     * @return the change
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param change the change to set
     */
    public void setBalance(double change) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" + "pId=" + pId + ", grossAmount=" + grossAmount + ", cash=" + cash + ", balance=" + balance + '}';
    }
    
    
}
