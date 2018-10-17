/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.dto;

import java.util.List;

/**
 *
 * @author Sandun_CJ
 */
public class GRNDTO extends SuperDTO{
    private int GRNID;
    private String date;
    private String sup_id;
    private String batch_Id;
    private int qty;
    private double buyingPrice;
    private List<GRNDetailsDTO> list;
    private GRNPaymentDTO gRNPaymentDTO;

    public GRNDTO() {
    }

    public GRNDTO(int GRNID, String date, String sup_id, String batch_Id, int qty, double buyingPrice, List<GRNDetailsDTO> list, GRNPaymentDTO gRNPaymentDTO) {
        this.GRNID = GRNID;
        this.date = date;
        this.sup_id = sup_id;
        this.batch_Id = batch_Id;
        this.qty = qty;
        this.buyingPrice = buyingPrice;
        this.list = list;
        this.gRNPaymentDTO = gRNPaymentDTO;
    }

    public GRNDTO(String date, String sup_id, String batch_Id, int qty, double buyingPrice, List<GRNDetailsDTO> list, GRNPaymentDTO gRNPaymentDTO) {
        this.date = date;
        this.sup_id = sup_id;
        this.batch_Id = batch_Id;
        this.qty = qty;
        this.buyingPrice = buyingPrice;
        this.list = list;
        this.gRNPaymentDTO = gRNPaymentDTO;
    }

    public GRNDTO(String date, String sup_id, String batch_Id, int qty, double buyingPrice) {
        this.date = date;
        this.sup_id = sup_id;
        this.batch_Id = batch_Id;
        this.qty = qty;
        this.buyingPrice = buyingPrice;
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
     * @return the list
     */
    public List<GRNDetailsDTO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<GRNDetailsDTO> list) {
        this.list = list;
    }

    /**
     * @return the gRNPaymentDTO
     */
    public GRNPaymentDTO getgRNPaymentDTO() {
        return gRNPaymentDTO;
    }

    /**
     * @param gRNPaymentDTO the gRNPaymentDTO to set
     */
    public void setgRNPaymentDTO(GRNPaymentDTO gRNPaymentDTO) {
        this.gRNPaymentDTO = gRNPaymentDTO;
    }

    @Override
    public String toString() {
        return "GRNDTO{" + "GRNID=" + GRNID + ", date=" + date + ", sup_id=" + sup_id + ", batch_Id=" + batch_Id + ", qty=" + qty + ", buyingPrice=" + buyingPrice + '}';
    }
    
    
    
    
    
}
