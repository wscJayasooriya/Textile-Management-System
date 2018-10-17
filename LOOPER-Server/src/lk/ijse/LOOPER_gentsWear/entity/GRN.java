/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Sandun_CJ
 */
@Entity
public class GRN {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int GRNID;
    private String date;
    private String sup_id;
    private String batch_Id;
    private int qty;
    private double buyingPrice;
    @OneToMany(cascade = CascadeType.ALL)
    private List<GRNDetails> detailList;
    @OneToOne(cascade = CascadeType.ALL)
    private GRNPayment gRNPayment;

    public GRN() {
    }

    public GRN(int GRNID, String date, String sup_id, String batch_Id, int qty, double buyingPrice, List<GRNDetails> detailList, GRNPayment gRNPayment) {
        this.GRNID = GRNID;
        this.date = date;
        this.sup_id = sup_id;
        this.batch_Id = batch_Id;
        this.qty = qty;
        this.buyingPrice = buyingPrice;
        this.detailList = detailList;
        this.gRNPayment = gRNPayment;
    }

    public GRN(String date, String sup_id, String batch_Id, int qty, double buyingPrice, List<GRNDetails> detailList, GRNPayment gRNPayment) {
        this.date = date;
        this.sup_id = sup_id;
        this.batch_Id = batch_Id;
        this.qty = qty;
        this.buyingPrice = buyingPrice;
        this.detailList = detailList;
        this.gRNPayment = gRNPayment;
    }

    public GRN(String date, String sup_id, String batch_Id, int qty, double buyingPrice) {
        this.date = date;
        this.sup_id = sup_id;
        this.batch_Id = batch_Id;
        this.qty = qty;
        this.buyingPrice = buyingPrice;
    }

    @Override
    public String toString() {
        return "GRN{" + "GRNID=" + getGRNID() + ", date=" + getDate() + ", sup_id=" + getSup_id() + ", batch_Id=" + getBatch_Id() + ", qty=" + getQty() + ", buyingPrice=" + getBuyingPrice() + '}';
    }

    /**
     * @return the GRNID
     */
    public int getGRNID() {
        return GRNID;
    }

    /**
     * @param GRNID the GRNID to set
     */
    public void setGRNID(int GRNID) {
        this.GRNID = GRNID;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the sup_id
     */
    public String getSup_id() {
        return sup_id;
    }

    /**
     * @param sup_id the sup_id to set
     */
    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    /**
     * @return the batch_Id
     */
    public String getBatch_Id() {
        return batch_Id;
    }

    /**
     * @param batch_Id the batch_Id to set
     */
    public void setBatch_Id(String batch_Id) {
        this.batch_Id = batch_Id;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the buyingPrice
     */
    public double getBuyingPrice() {
        return buyingPrice;
    }

    /**
     * @param buyingPrice the buyingPrice to set
     */
    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    /**
     * @return the detailList
     */
    public List<GRNDetails> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<GRNDetails> detailList) {
        this.detailList = detailList;
    }

    /**
     * @return the gRNPayment
     */
    public GRNPayment getgRNPayment() {
        return gRNPayment;
    }

    /**
     * @param gRNPayment the gRNPayment to set
     */
    public void setgRNPayment(GRNPayment gRNPayment) {
        this.gRNPayment = gRNPayment;
    }

    
    
}
