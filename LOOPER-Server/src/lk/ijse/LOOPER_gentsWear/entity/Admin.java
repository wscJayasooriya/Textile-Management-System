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
public class Admin {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int a_id;
    private String a_name;
    private String a_password;

    public Admin() {
    }

    public Admin(int a_id, String a_name, String a_password) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_password = a_password;
    }

    /**
     * @return the a_id
     */
    public int getA_id() {
        return a_id;
    }

    /**
     * @param a_id the a_id to set
     */
    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    /**
     * @return the a_name
     */
    public String getA_name() {
        return a_name;
    }

    /**
     * @param a_name the a_name to set
     */
    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    /**
     * @return the a_password
     */
    public String getA_password() {
        return a_password;
    }

    /**
     * @param a_password the a_password to set
     */
    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    @Override
    public String toString() {
        return "Admin{" + "a_id=" + a_id + ", a_name=" + a_name + ", a_password=" + a_password + '}';
    }

    
}
