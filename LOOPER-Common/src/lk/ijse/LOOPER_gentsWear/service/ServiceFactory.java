/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.service;

import java.rmi.Remote;

/**
 *
 * @author Sandun_CJ
 */
public interface ServiceFactory extends Remote{
    
    public enum ServiceTypes{
        ITEM,SUPPLIER,ORDER_DETAILS,ORDERS,PAYMENT,GRN_PAYMENT,GRN_DETAILS,GRN,CASHIER,ADMIN,REPORTS
    }
    
    public SuperService getService(ServiceTypes types)throws Exception;
}
