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
public class Cashier {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int c_id;
    private String c_name;
    private String c_password;

    public Cashier() {
    }

    public Cashier(int c_id, String c_name, String c_password) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_password = c_password;
    }

    public Cashier(String c_name, String c_password) {
        this.c_name = c_name;
        this.c_password = c_password;
    }

    /**
     * @return the c_id
     */
    public int getC_id() {
        return c_id;
    }

    /**
     * @param c_id the c_id to set
     */
    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    /**
     * @return the c_name
     */
    public String getC_name() {
        return c_name;
    }

    /**
     * @param c_name the c_name to set
     */
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    /**
     * @return the c_password
     */
    public String getC_password() {
        return c_password;
    }

    /**
     * @param c_password the c_password to set
     */
    public void setC_password(String c_password) {
        this.c_password = c_password;
    }

    @Override
    public String toString() {
        return "Admin{" + "c_id=" + c_id + ", c_name=" + c_name + ", c_password=" + c_password + '}';
    }
    
    
}
