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
public class OrderDetails {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(
            @JoinColumn(name = "oId", referencedColumnName = "oId", insertable = false, updatable = false))
    private Orders order;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(
            @JoinColumn(name = "iCode", referencedColumnName = "iCode", insertable = false, updatable = false))
    private Item item;
    @EmbeddedId
    private OrderDetails_pk orderDetails_pk;

    public OrderDetails() {
    }

    public OrderDetails(Orders order, Item item, OrderDetails_pk orderDetails_pk) {
        this.order = order;
        this.item = item;
        this.orderDetails_pk = orderDetails_pk;
    }

    public OrderDetails(Orders order, Item item) {
        this.order = order;
        this.item = item;
    }

    /**
     * @return the order
     */
    public Orders getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Orders order) {
        this.order = order;
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
     * @return the orderDetails_pk
     */
    public OrderDetails_pk getOrderDetails_pk() {
        return orderDetails_pk;
    }

    /**
     * @param orderDetails_pk the orderDetails_pk to set
     */
    public void setOrderDetails_pk(OrderDetails_pk orderDetails_pk) {
        this.orderDetails_pk = orderDetails_pk;
    }
    
    
}
