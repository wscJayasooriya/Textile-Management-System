/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Sandun_CJ
 */
@Embeddable
public class GRNDetails_pk implements Serializable{
    private int GRNID;
    private String iCode;

    public GRNDetails_pk() {
    }

    public GRNDetails_pk(int grn_pId, String iCode) {
        this.GRNID = grn_pId;
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
