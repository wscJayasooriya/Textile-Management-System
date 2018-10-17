/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Sandun_CJ
 */
@Entity
public class Orders {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int oId;
    private String oDate;
    private String oTime;
    private double amount;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetails> detailList;
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    public Orders() {
    }

    public Orders(int oId, String oDate, String oTime,double amount, List<OrderDetails> detailList, Payment payment) {
        this.oId = oId;
        this.oDate = oDate;
        this.oTime = oTime;
        this.amount=amount;
        this.detailList = detailList;
        this.payment = payment;
    }

    public Orders(String oDate, String oTime,double amount, List<OrderDetails> detailList, Payment payment) {
        this.oDate = oDate;
        this.oTime = oTime;
        this.amount=amount;
        this.detailList = detailList;
        this.payment = payment;
    }

    public Orders(String oDate, String oTime,double amount, List<OrderDetails> detailList) {
        this.oDate = oDate;
        this.oTime = oTime;
        this.amount=amount;
        this.detailList = detailList;
    }

    /**
     * @return the oId
     */
    public int getoId() {
        return oId;
    }

    /**
     * @param oId the oId to set
     */
    public void setoId(int oId) {
        this.oId = oId;
    }

    /**
     * @return the oDate
     */
    public String getoDate() {
        return oDate;
    }

    /**
     * @param oDate the oDate to set
     */
    public void setoDate(String oDate) {
        this.oDate = oDate;
    }

    /**
     * @return the oTime
     */
    public String getoTime() {
        return oTime;
    }

    /**
     * @param oTime the oTime to set
     */
    public void setoTime(String oTime) {
        this.oTime = oTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    

    /**
     * @return the detailList
     */
    public List<OrderDetails> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<OrderDetails> detailList) {
        this.detailList = detailList;
    }

    /**
     * @return the payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Orders{" + "oId=" + oId + ", oDate=" + oDate + ", oTime=" + oTime + ", amount=" + amount + '}';
    }

    
    

    
}
