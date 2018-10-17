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
public class GRNDetails_pk_DTO extends SuperDTO{
    private int GRNID;
    private String iCode;

    public GRNDetails_pk_DTO() {
    }

    public GRNDetails_pk_DTO(int GRNID, String iCode) {
        this.GRNID = GRNID;
        this.iCode = iCode;
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
    
    
}
