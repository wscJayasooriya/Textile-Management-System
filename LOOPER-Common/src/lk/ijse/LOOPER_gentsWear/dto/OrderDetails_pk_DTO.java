/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.dto;

/**
 *
 * @author Sandun_CJ
 */
public class OrderDetails_pk_DTO extends SuperDTO {

    private int oId;
    private String iCode;

    public OrderDetails_pk_DTO() {
    }

    public OrderDetails_pk_DTO(int oId, String iCode) {
        this.oId = oId;
        this.iCode = iCode;
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
     * @return the iCode
     */
    public String getiCode() {
        return iCode;
    }

    /**
     * @param iCode the iCode to set
     */
    public void setiCode(String iCode) {
        this.iCode = iCode;
    }

    @Override
    public String toString() {
        return "OrderDetails_pk_DTO{" + "oId=" + oId + ", iCode=" + iCode + '}';
    }

}
