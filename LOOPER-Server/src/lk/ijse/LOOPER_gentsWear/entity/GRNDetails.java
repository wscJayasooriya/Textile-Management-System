/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sandun_CJ
 */
@Entity
public class GRNDetails {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(
            @JoinColumn(name = "GRNID", referencedColumnName = "GRNID", insertable = false, updatable = false))
    private GRN grn;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(
            @JoinColumn(name = "iCode", referencedColumnName = "iCode", insertable = false, updatable = false))
    private Item item;
    @EmbeddedId
    private GRNDetails_pk gRNDetails_pk;

    public GRNDetails() {
    }

    public GRNDetails(GRN grn, Item item, GRNDetails_pk gRNDetails_pk) {
        this.grn = grn;
        this.item = item;
        this.gRNDetails_pk = gRNDetails_pk;
    }

    public GRNDetails(GRN grn, Item item) {
        this.grn = grn;
        this.item = item;
    }

    /**
     * @return the grn
     */
    public GRN getGrn() {
        return grn;
    }

    /**
     * @param grn the grn to set
     */
    public void setGrn(GRN grn) {
        this.grn = grn;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the gRNDetails_pk
     */
    public GRNDetails_pk getgRNDetails_pk() {
        return gRNDetails_pk;
    }

    /**
     * @param gRNDetails_pk the gRNDetails_pk to set
     */
    public void setgRNDetails_pk(GRNDetails_pk gRNDetails_pk) {
        this.gRNDetails_pk = gRNDetails_pk;
    }
    
    
}
