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
public class GRNPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int grn_pId;
    private double amount;

    public GRNPayment() {
    }

    public GRNPayment(int grn_pId, double amount) {
        this.grn_pId = grn_pId;
        this.amount = amount;
    }

    public GRNPayment(double amount) {
        this.amount = amount;
    }

    /**
     * @return the grn_pId
     */
    public int getGrn_pId() {
        return grn_pId;
    }

    /**
     * @param grn_pId the grn_pId to set
     */
    public void setGrn_pId(int grn_pId) {
        this.grn_pId = grn_pId;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "GRNPayment{" + "grn_pId=" + grn_pId + ", amount=" + amount + '}';
    }
    
    
}
