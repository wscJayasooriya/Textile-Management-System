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
public class OrderDTO extends SuperDTO {

    private int oID;
    private String oDate;
    private String oTime;
    private double amount;
    private List<OrderDetailsDTO> list;
    private PaymentDTO paymentDTO;

    public OrderDTO() {
    }

    public OrderDTO(int oID, String oDate, String oTime, double amount, List<OrderDetailsDTO> list, PaymentDTO paymentDTO) {
        this.oID = oID;
        this.oDate = oDate;
        this.oTime = oTime;
        this.amount = amount;
        this.list = list;
        this.paymentDTO = paymentDTO;
    }

//    public OrderDTO(String oDate, String oTime, double amount, List<OrderDetailsDTO> list, PaymentDTO paymentDTO) {
//        this.oDate = oDate;
//        this.oTime = oTime;
//        this.amount = amount;
//        this.list = list;
//        this.paymentDTO = paymentDTO;
//    }
//
//    public OrderDTO(String oDate, String oTime, double amount, List<OrderDetailsDTO> list) {
//        this.oDate = oDate;
//        this.oTime = oTime;
//        this.amount = amount;
//        this.list = list;
//    }

    /**
     * @return the oID
     */
    public int getoID() {
        return oID;
    }

    /**
     * @param oID the oID to set
     */
    public void setoID(int oID) {
        this.oID = oID;
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
     * @return the list
     */
    public List<OrderDetailsDTO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<OrderDetailsDTO> list) {
        this.list = list;
    }

    /**
     * @return the paymentDTO
     */
    public PaymentDTO getPaymentDTO() {
        return paymentDTO;
    }

    /**
     * @param paymentDTO the paymentDTO to set
     */
    public void setPaymentDTO(PaymentDTO paymentDTO) {
        this.paymentDTO = paymentDTO;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "oID=" + oID + ", oDate=" + oDate + ", oTime=" + oTime + ", amount=" + amount + '}';
    }

}
